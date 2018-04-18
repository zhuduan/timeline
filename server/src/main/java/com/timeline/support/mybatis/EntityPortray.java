package com.timeline.support.mybatis;

import org.apache.ibatis.jdbc.SQL;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EntityPortray {

  private Class<?> entityClass;
  private String tableName;
  private Map<String, ColumnProp> columnMap = new HashMap<>(); // fieldName -> prop
  private List<ColumnProp> pkList;

  private String pkConditionSql;
  private String pkConditionWithParamSql;

  private String selectResultSql;

  // basic sql
  private String insertSql;
  private String updateSql;

  public EntityPortray(Class<?> entity) {
    this.entityClass = entity;
    Table table = entity.getAnnotation(Table.class);
    if (table == null) { // 未指明则由entity的 className 转换。
      this.tableName = PoMapperTool.camelToUnderline(entity.getSimpleName());
    } else {
      this.tableName = table.name();
    }
    parse();
  }

  public Collection<ColumnProp> getColumns() {
    return columnMap.values();
  }

  public Class<?> getEntityClass() {
    return entityClass;
  }

  public void setEntityClass(final Class<?> entityClass) {
    this.entityClass = entityClass;
  }

  public String getTableName() {
    return tableName;
  }

  public void setTableName(final String tableName) {
    this.tableName = tableName;
  }

  public Map<String, ColumnProp> getColumnMap() {
    return columnMap;
  }

  public void setColumnMap(final Map<String, ColumnProp> columnMap) {
    this.columnMap = columnMap;
  }

  public List<ColumnProp> getPkList() {
    return pkList;
  }

  public void setPkList(final List<ColumnProp> pkList) {
    this.pkList = pkList;
  }

  public String getPkConditionSql() {
    return pkConditionSql;
  }

  public void setPkConditionSql(final String pkConditionSql) {
    this.pkConditionSql = pkConditionSql;
  }

  public String getPkConditionWithParamSql() {
    return pkConditionWithParamSql;
  }

  public void setPkConditionWithParamSql(final String pkConditionWithParamSql) {
    this.pkConditionWithParamSql = pkConditionWithParamSql;
  }

  public String getSelectResultSql() {
    return selectResultSql;
  }

  public void setSelectResultSql(final String selectResultSql) {
    this.selectResultSql = selectResultSql;
  }

  public String getInsertSql() {
    return insertSql;
  }

  public void setInsertSql(final String insertSql) {
    this.insertSql = insertSql;
  }

  public String getUpdateSql() {
    return updateSql;
  }

  public void setUpdateSql(final String updateSql) {
    this.updateSql = updateSql;
  }

  public class ColumnProp {
    private Field field;
    private Boolean isPrimaryKey;
    private String columnName;

    private String selectStr;
    private String defineStr;
    private String settingStr;

    ColumnProp(final Field field) {
      this.field = field;
      this.isPrimaryKey = field.getAnnotation(Id.class) != null;
      Column column = field.getAnnotation(Column.class);
      if (column == null) {
        this.columnName = PoMapperTool.camelToUnderline(field.getName());
        this.selectStr = columnName;
      } else {
        this.columnName = column.name();
        this.selectStr = String.format("%s as %s", columnName, field.getName());
      }
      this.defineStr = String.format("#{%s}", field.getName());
      this.settingStr = String.format("%s = %s", columnName, defineStr);
    }

    public String getFieldName() {
      return field.getName();
    }

    public boolean isNull(Object obj) {
      field.setAccessible(true);
      try {
        return field.get(obj) == null;
      } catch (IllegalAccessException e) {
        throw new RuntimeException(e);
      }
    }

    public Field getField() {
      return field;
    }

    public void setField(final Field field) {
      this.field = field;
    }

    public Boolean getIsPrimaryKey() {
      return isPrimaryKey;
    }

    public void setIsPrimaryKey(final Boolean primaryKey) {
      isPrimaryKey = primaryKey;
    }

    public String getColumnName() {
      return columnName;
    }

    public void setColumnName(final String columnName) {
      this.columnName = columnName;
    }

    public String getSelectStr() {
      return selectStr;
    }

    public void setSelectStr(final String selectStr) {
      this.selectStr = selectStr;
    }

    public String getDefineStr() {
      return defineStr;
    }

    public void setDefineStr(final String defineStr) {
      this.defineStr = defineStr;
    }

    public String getSettingStr() {
      return settingStr;
    }

    public void setSettingStr(final String settingStr) {
      this.settingStr = settingStr;
    }
  }

  private void parse() {
    List<Field> fields = findFields(entityClass);

    pkList = new ArrayList<>();
    SQL insert = new SQL().INSERT_INTO(tableName);
    SQL update = new SQL().UPDATE(tableName);
    for (Field field : fields) {
      if (Modifier.isStatic(field.getModifiers())
          || Modifier.isFinal(field.getModifiers())
          || field.getAnnotation(Transient.class) != null) {
        continue;
      }
      ColumnProp prop = new ColumnProp(field);
      columnMap.put(field.getName(), prop);

      if (prop.getIsPrimaryKey()) {
        // IDs
        pkList.add(prop);
      } else {
        // SQL
        update.SET(prop.getSettingStr()); // update 不包括主键
      }
      // SQL
      insert.VALUES(prop.getColumnName(), prop.getDefineStr());
    }
    if (pkList.isEmpty()) {
     /* log.error("Entity must have at least one @Id!");
      throw new CommonException(ErrorKey.COMMON_ERROR);*/
    }
    pkConditionSql = pkList.stream().map(ColumnProp::getSettingStr)
                           .collect(Collectors.joining(" AND "));
    if (pkList.size() == 1) {
      ColumnProp pkColumn = pkList.get(0);
      pkConditionWithParamSql = String.format(" %s = #{pk} ", pkColumn.getColumnName());
    } else {
      pkConditionWithParamSql = pkList.stream().map(v ->
          String.format(" %s = #{pk.%s} ", v.getColumnName(), v.getField().getName()))
                                      .collect(Collectors.joining(" AND "));
    }
    insertSql = insert.toString();
    updateSql = update.WHERE(pkConditionSql).toString();
    selectResultSql = getColumns().stream().map(ColumnProp::getSelectStr).collect(Collectors.joining(" , "));
  }

  private List<Field> findFields(Class<?> clazz) {
    List<Field> fields = Stream.of(clazz.getDeclaredFields())
                               .collect(Collectors.toList());
    Class<?> superClass = clazz.getSuperclass(); // for PK
    if (superClass != null) {
      fields.addAll(findFields(superClass));
    }
    return fields;
  }
}
