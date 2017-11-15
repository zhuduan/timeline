package com.timeline.repository;

public interface DetailLinkDAO {

    final static String TABLE = "detaillink";

    final static String ALL_COLUMNS = "ID, DetailID_Language, Title, Content, PicUrl, PicDes, SourceName, SourceLink, "
            + "Weight, Status, IsValid, CreateTime, UpdateTime";


}
