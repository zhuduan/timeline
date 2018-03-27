package com.timeline.repository;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.jdbc.SQL;

import com.timeline.model.PO.UserFocus;
import com.timeline.support.utils.mybatis.mapper.BaseSql;

import java.util.List;

public interface UserFocusDAO {

  final static String TABLE = "userfocus";

  final static String ALL_COLUMNS = "ID, UserID, SubjectID, IsValid, CreateTime, UpdateTime";

  @SelectProvider(type = UserFocusSQL.class, method = UserFocusSQL.METHOD_SELECT_BY_COLUMN)
  List<UserFocus> getFocusListByUID(@Param("UserID") Integer userID, @Param("IsValid") Integer isValid);

  @UpdateProvider(type = UserFocusSQL.class, method = "insertFocusRelation")
  Integer focusSubject(@Param("UserID") Integer userID, @Param("SubjectID") Integer subjectID);

  @UpdateProvider(type = UserFocusSQL.class, method = "deleteFocusRelation")
  Integer unFocusSubject(@Param("UserID") Integer userID, @Param("SubjectID") Integer subjectID);

  @SelectProvider(type = UserFocusSQL.class, method = UserFocusSQL.METHOD_SELECT_BY_COLUMN)
  UserFocus isFocusedSubject(@Param("UserID") Integer userID, @Param("SubjectID") Integer subjectID,
      @Param("IsValid") Integer isValid);

  static class UserFocusSQL extends BaseSql {

    public UserFocusSQL() {
      super(TABLE, ALL_COLUMNS);
    }

    public String insertFocusRelation() {
      // Notice: if passed param here is a String, should escape the string to avoid sql injection
      //         the userID and subjectID here are unique index
      String sqlStr = " INSERT INTO " + TABLE + " (UserID, SubjectID, IsValid) "
          + " VALUES( #{UserID}, #{SubjectID}, 1) "
          + " ON DUPLICATE KEY UPDATE IsValid = 1 ";
      return sqlStr;
    }

    public String deleteFocusRelation() {
      SQL sql = new SQL();
      sql.UPDATE(getTable())
         .SET("IsValid=0")
         .WHERE("UserID=#{UserID}  AND SubjectID=#{SubjectID}");
      return sql.toString();
    }
  }
}
