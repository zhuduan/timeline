package com.timeline.repository;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import com.timeline.model.PO.User;
import com.timeline.util.mybatis.mapper.BaseSql;

public interface UserDAO {

    final static String TABLE = "user";

    final static String ALL_COLUMNS = "ID, Name, PicUrl, Role, Authority, Email, Phone, Password, "
            + " WechatAccount, WeiboAccount, GoogleAccount, IsValid, CreateTime, UpdateTime";
    
    @SelectProvider(type = UserSQL.class, method = UserSQL.METHOD_GET_BY_KEY)
    User getUserByID(@Param("id")Long id);
    
    @SelectProvider(type = UserSQL.class, method = UserSQL.METHOD_SELECT_BY_COLUMN)
    User getUserByName(@Param("name")String name);
    
    @InsertProvider(type = UserSQL.class, method = UserSQL.METHOD_INSERT)
    int insertUser(User user);
    
    static class UserSQL extends BaseSql{

		public UserSQL() {
			
			super(TABLE, ALL_COLUMNS);
		}
    	
    }
    
}
