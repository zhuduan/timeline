package com.timeline.repository;

import com.timeline.model.PO.DetailLink;
import com.timeline.model.PO.UserFocus;
import com.timeline.util.mybatis.mapper.BaseSql;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

public interface UserFocusDAO {

    final static String TABLE = "userfocus";

    final static String ALL_COLUMNS = "ID, UserID, SubjectID, IsValid, CreateTime, UpdateTime";

    @SelectProvider(type = UserFocusSQL.class, method = UserFocusSQL.METHOD_SELECT_BY_COLUMN)
    List<UserFocus> getFocusListByUID(@Param("UserID") Integer userID);

    static class UserFocusSQL extends BaseSql {
        public UserFocusSQL() {
            super(TABLE, ALL_COLUMNS);
        }
    }
    
}
