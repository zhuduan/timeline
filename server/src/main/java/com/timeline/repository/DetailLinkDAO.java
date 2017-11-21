package com.timeline.repository;

import com.timeline.model.PO.DetailLink;
import com.timeline.util.mybatis.mapper.BaseSql;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

public interface DetailLinkDAO {

    final static String TABLE = "detaillink";

    final static String ALL_COLUMNS = "ID, DetailID, Language, Title, Content, PicUrl, PicDes, SourceName, SourceLink, "
            + "Weight, Status, IsValid, CreateTime, UpdateTime";

    @SelectProvider(type = DetailLinkSQL.class, method = DetailLinkSQL.METHOD_SELECT_BY_COLUMN)
    List<DetailLink> getListByIDAndLanguage(@Param("DetailID") Integer detailID, @Param("Language") Integer lan);

    static class DetailLinkSQL extends BaseSql {
        public DetailLinkSQL() {
            super(TABLE, ALL_COLUMNS);
        }
    }
}
