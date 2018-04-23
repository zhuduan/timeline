package com.timeline.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.jdbc.SQL;

import com.timeline.model.PO.UserFocus;
import com.timeline.support.utils.mybatis.mapper.BaseSql;

import java.util.List;

public interface UserFocusDAO {

  String TABLE = "userfocus";

  String ALL_COLUMNS = "ID, UserID, SubjectID, IsValid, CreateTime, UpdateTime";

  @SelectProvider(type = UserFocusSQL.class, method = UserFocusSQL.METHOD_SELECT_BY_COLUMN)
  List<UserFocus> getFocusListByUID(@Param("UserID") Integer userID, @Param("IsValid") Integer isValid);

  @SelectProvider(type = UserFocusSQL.class, method = UserFocusSQL.METHOD_SELECT_BY_COLUMN)
  UserFocus isFocusedSubject( @Param("UserID") Integer userID,
                              @Param("SubjectID") Integer subjectID,
                              @Param("IsValid") Integer isValid );

  @Insert(" insert into " + TABLE + " (  userID, subjectID, isValid, createTime, updateTime  ) "
        + " values(#{userID}, #{subjectID}, #{isValid}, now(), now()) "
        + " on duplicate key update "
        + " `userID` = values(`userID`),"
        + " `subjectID` = values(`subjectID`),"
        + " `isValid` = values(`isValid`),"
        + " `updateTime` = values(`updateTime`)")
  Integer focusSubject( @Param("userID") Integer userID,
                        @Param("subjectID") Integer subjectID,
                        @Param("isValid" ) Integer isValid);

  class UserFocusSQL extends BaseSql {

    public UserFocusSQL() {
      super(TABLE, ALL_COLUMNS);
    }
  }
}
