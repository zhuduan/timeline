package com.timeline.repository;

public interface UserDAO {

    final static String TABLE = "user";

    final static String ALL_COLUMNS = "ID, Name, PicUrl, Role, Authority, Email, Phone, "
            + " WechatAccount, WeiboAccount, GoogleAccount, IsValid, CreateTime, UpdateTime";

    
}
