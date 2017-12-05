package com.timeline.repository;

import com.timeline.model.PO.DetailReply;
import com.timeline.util.mybatis.mapper.BaseSql;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

public interface DetailReplyDAO {

    final static String TABLE = "detailreply";

    final static String ALL_COLUMNS = "ID, DetailID, Title, Content, AuthorID, IsValid, CreateTime, UpdateTime";

    @SelectProvider(type = DetailReplySQL.class, method = DetailReplySQL.METHOD_SELECT_BY_COLUMN)
    List<DetailReply> getDetailReplyByDetailID(@Param("DetailID")Integer detailID);

    static class DetailReplySQL extends BaseSql {
        public DetailReplySQL() {
            super(TABLE, ALL_COLUMNS);
        }
    }
}
