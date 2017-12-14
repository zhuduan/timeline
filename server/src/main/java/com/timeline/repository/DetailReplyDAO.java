package com.timeline.repository;

import com.timeline.model.PO.DetailReply;
import com.timeline.model.PO.StatisticInfo;
import com.timeline.util.mybatis.mapper.BaseSql;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface DetailReplyDAO {

    final static String TABLE = "detailreply";

    final static String ALL_COLUMNS = "ID, DetailID, Title, Content, AuthorID, IsValid, CreateTime, UpdateTime";

    @SelectProvider(type = DetailReplySQL.class, method = DetailReplySQL.METHOD_SELECT_BY_COLUMN)
    List<DetailReply> getDetailReplyByDetailID(@Param("DetailID")Integer detailID);

    @InsertProvider(type = DetailReplySQL.class, method = DetailReplySQL.METHOD_INSERT)
    Integer saveInfo(DetailReply detailReply);

    @UpdateProvider(type = DetailReplySQL.class, method = DetailReplySQL.METHOD_UPDATE_BY_KEY)
    Integer updateInfo(DetailReply detailReply);

    @DeleteProvider(type = DetailReplySQL.class, method = DetailReplySQL.METHOD_DEL_BY_KEY)
    Integer deleteInfo(Integer replyID);

    static class DetailReplySQL extends BaseSql {
        public DetailReplySQL() {
            super(TABLE, ALL_COLUMNS);
        }
    }
}
