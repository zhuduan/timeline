package com.timeline.Common.mybatis;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.commons.collections4.map.CaseInsensitiveMap;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author wenlongchen
 * @since Jun 23, 2016
 */
public class Util {

  private static final Logger logger = LoggerFactory.getLogger(Util.class);

  private static final ThreadLocal<SimpleDateFormat> simpleDateFormatThreadLocal =
      new ThreadLocal<SimpleDateFormat>();

  public static final char SYMBOL_UNDERLINE = '_';
  public static final char SYMBOL_POINT = '.';
  public static final char SYMBOL_COMMA = ',';
  private static final Pattern isBlankPattern = Pattern.compile("^\\s*$");

  /**
   * <pre>
   * 验证某个字符串是否为null或空字符串
   * </pre>
   * 
   * @param str
   * @return
   */
  public static final boolean isBlank(String str) {
    return str == null || (isBlankPattern.matcher(str).find());
  }

  /**
   * <pre>
   * 将下划线、点等风格映射为java属性命名风格
   * 目前仅支持下划线、点
   * </pre>
   */
  public static final String toJavaStyle(String name) {
    if (!isBlank(name)) {
      char[] ns = name.trim().toCharArray();
      char[] temp = new char[ns.length];
      char c;
      int j = 0;
      boolean prevIsUnderline = false;
      for (int i = 0, len = ns.length; i < len; i++) {
        c = ns[i];
        if (c == SYMBOL_UNDERLINE || c == SYMBOL_POINT) {
          prevIsUnderline = (j != 0);
        } else {
          temp[j++] = prevIsUnderline ? Character.toUpperCase(c) : Character.toLowerCase(c);
          prevIsUnderline = false;
        }
      }
      return String.valueOf(temp).trim();
    }
    return name;
  }

  /**
   * <pre>
   * 将已分隔符分割的字符串转换为java风格并映射到map集合中
   * 键为分割的每一个原始字符 值为转换后的字符
   * </pre>
   * 
   * @param str
   * @param delimiter
   * @return {column:property}
   */
  public static final Map<String, String> mapperJavaStyle(String str, String delimiter) {
    Map<String, String> map = new HashMap<String, String>();
    if (!isBlank(str)) {
      String[] strings = str.split(delimiter);
      for (String temp : strings) {
        map.put(temp, toJavaStyle(temp));
      }
    }
    return map;
  }

  /**
   * <pre>
   * 将已分隔符分割的字符串转换为java风格并映射到CaseInsensitiveMap集合中
   * 键为分割的每一个原始字符 值为转换后的字符
   * </pre>
   *
   * @param str
   * @param delimiter
   * @return {column:property}
   */
  @SuppressWarnings({"unchecked", "rawtypes"})
  public static final Map<String, String> mapperJavaStyleToCaseInsensitiveMap(String str,
      String delimiter) {
    CaseInsensitiveMap map = new CaseInsensitiveMap();
    if (!isBlank(str)) {
      String[] strings = str.split(delimiter);
      for (String temp : strings) {
        map.put(temp.trim(), toJavaStyle(temp));
      }
    }
    return map;
  }
  
  /**
   * <pre>
   * 将一个map转换为不区分大小写的map
   * </pre>
   * @param map
   * @return
   */
  @SuppressWarnings({"unchecked", "rawtypes"})
  public static final <T> Map<String,T> convertToCaseInsensitiveMap(Map<String,T> map){
    CaseInsensitiveMap insensitiveMap=new CaseInsensitiveMap();
    if(map!=null){
      insensitiveMap.putAll(map);
    }
    return insensitiveMap;
  }

  /**
   * <pre>
   * 判断某个数字num的二进制表示的第place位是否为1；
   * 位置从0开始
   * </pre>
   * 
   * @param num
   * @param place
   * @return
   */
  public static final boolean isBitSet(Long num, int place) {
    return num != null && (((num >> place) & 1) == 1);
  }


  /**
   * <pre>
   * 格式化日期
   * 形如：yyyy-MM-dd hh:mm:ss
   * </pre>
   * 
   * @param calendar
   * @return
   */
  public static final String formatDate(Calendar calendar) {
    return getDateFormat().format(calendar.getTime());
  }

  /**
   * <pre>
   * 判定一个对象是否为八种基础类型
   * 或者是否为字符序列
   * </pre>
   * 
   * @param object
   * @return
   */
  public static final boolean isPrimitive(Object object) {
    Class<? extends Object> clazz = object.getClass();
    return Number.class.isAssignableFrom(clazz) || Boolean.class.isAssignableFrom(clazz)
        || Character.class.isAssignableFrom(clazz) || CharSequence.class.isAssignableFrom(clazz);
  }

  public static final Long dateToTime(String datetime) {
    try {
      if (StringUtils.isBlank(datetime))
        return null;
      return getDateFormat().parse(datetime).getTime();
    } catch (ParseException e) {
      logger.error(e.getMessage(), e);
      return null;
    }
  }



  private static final SimpleDateFormat getDateFormat() {
    SimpleDateFormat simpleDateFormat = simpleDateFormatThreadLocal.get();
    if (simpleDateFormat == null) {
      simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      simpleDateFormatThreadLocal.set(simpleDateFormat);
    }
    return simpleDateFormat;
  }

  public static final <V> V getOrDefault(Map<? extends Object, V> map, Object key, V defaultValue,
                                         Class<V> valueClaz) {
    V value = map.get(key);
    return (value == null ? defaultValue : value);
  }
}

