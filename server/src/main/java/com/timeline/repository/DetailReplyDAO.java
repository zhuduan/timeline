package com.timeline.repository;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.timeline.model.PO.DetailReply;
import com.timeline.support.utils.mybatis.mapper.BaseSql;

import java.util.List;

public interface DetailReplyDAO {

    final static String TABLE = "detailreply";

    final static String ALL_COLUMNS = "ID, DetailID, Title, Content, AuthorID, ToReplyID, IsValid, CreateTime, UpdateTime";

    @SelectProvider(type = DetailReplySQL.class, method = DetailReplySQL.METHOD_SELECT_BY_COLUMN)
    List<DetailReply> getAllReplyByDetailID(@Param("DetailID") Integer detailID);

    @Select("   SELECT " + ALL_COLUMNS
            + " FROM " + TABLE
            + " WHERE DetailID = #{detailID} AND ToReplyID=0 AND IsValid>0 ")
    List<DetailReply> getMainReplyByDetailID(@Param("detailID") Integer detailID);

    @Select("   SELECT " + ALL_COLUMNS
            + " FROM " + TABLE
            + " WHERE DetailID = #{detailID} AND ToReplyID=#{toReplyID} AND IsValid>0 ")
    List<DetailReply> getSubReplyByDetailID(@Param("detailID") Integer detailID, @Param("toReplyID") Integer toReplyID);

    @Select("   SELECT COUNT(id) "
            + " FROM " + TABLE
            + " WHERE DetailID = #{detailID} AND ToReplyID=0 AND IsValid>0 ")
    Integer getTotalCount(@Param("detailID") Integer detailID);

    @InsertProvider(type = DetailReplySQL.class, method = DetailReplySQL.METHOD_INSERT)
    Integer saveInfo(DetailReply detailReply);

    @UpdateProvider(type = DetailReplySQL.class, method = DetailReplySQL.METHOD_UPDATE_BY_KEY)
    Integer updateInfo(DetailReply detailReply);

    @Delete("  DELETE FROM " + TABLE 
            +" WHERE id=#{replyID} OR ToReplyID=#{replyID} ")
    Integer deleteInfo(Integer replyID);

    static class DetailReplySQL extends BaseSql {
        public DetailReplySQL() {
            super(TABLE, ALL_COLUMNS);
        }
    }
}
