package com.timeline.repository;

import com.timeline.model.PO.StatisticInfo;
import com.timeline.util.mybatis.mapper.BaseSql;
import org.apache.ibatis.annotations.InsertProvider;

public interface StatisticInfoDAO {

    final static String TABLE = "statisticinfo";

    final static String ALL_COLUMNS = "ID, RequestUrl, RequestUserID, RequestIP, RequestDateTime";

    @InsertProvider(type = StatisticInfoSQL.class, method = StatisticInfoSQL.METHOD_INSERT)
    Integer saveInfo(StatisticInfo statisticInfo);

    static class StatisticInfoSQL extends BaseSql {

        public StatisticInfoSQL() {
            super(TABLE, ALL_COLUMNS);
        }

    }
}
