package com.timeline.repository;

import com.timeline.model.PO.Subject;
import org.apache.ibatis.jdbc.SQL;

public class SubjectSqlProvider {

    public String insertSelective(Subject record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("subject");
        
        if (record.getID() != null) {
            sql.VALUES("ID", "#{ID,jdbcType=INTEGER}");
        }
        
        if (record.getTitle() != null) {
            sql.VALUES("Title", "#{title,jdbcType=VARCHAR}");
        }
        
        if (record.getPicUrl() != null) {
            sql.VALUES("PicUrl", "#{picUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getPicDes() != null) {
            sql.VALUES("PicDes", "#{picDes,jdbcType=VARCHAR}");
        }
        
        if (record.getAuthorID() != null) {
            sql.VALUES("AuthorID", "#{authorID,jdbcType=INTEGER}");
        }
        
        if (record.getContributorIDs() != null) {
            sql.VALUES("ContributorIDs", "#{contributorIDs,jdbcType=VARCHAR}");
        }
        
        if (record.getCategory() != null) {
            sql.VALUES("Category", "#{category,jdbcType=VARCHAR}");
        }
        
        if (record.getTags() != null) {
            sql.VALUES("Tags", "#{tags,jdbcType=VARCHAR}");
        }
        
        if (record.getStartTime() != null) {
            sql.VALUES("StartTime", "#{startTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEndTime() != null) {
            sql.VALUES("EndTime", "#{endTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLanguage() != null) {
            sql.VALUES("`Language`", "#{language,jdbcType=INTEGER}");
        }
        
        if (record.getRelatedSubjectIDs() != null) {
            sql.VALUES("RelatedSubjectIDs", "#{relatedSubjectIDs,jdbcType=VARCHAR}");
        }
        
        if (record.getIsValid() != null) {
            sql.VALUES("IsValid", "#{isValid,jdbcType=TINYINT}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("CreateTime", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.VALUES("UpdateTime", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getContent() != null) {
            sql.VALUES("Content", "#{content,jdbcType=LONGVARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Subject record) {
        SQL sql = new SQL();
        sql.UPDATE("subject");
        
        if (record.getTitle() != null) {
            sql.SET("Title = #{title,jdbcType=VARCHAR}");
        }
        
        if (record.getPicUrl() != null) {
            sql.SET("PicUrl = #{picUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getPicDes() != null) {
            sql.SET("PicDes = #{picDes,jdbcType=VARCHAR}");
        }
        
        if (record.getAuthorID() != null) {
            sql.SET("AuthorID = #{authorID,jdbcType=INTEGER}");
        }
        
        if (record.getContributorIDs() != null) {
            sql.SET("ContributorIDs = #{contributorIDs,jdbcType=VARCHAR}");
        }
        
        if (record.getCategory() != null) {
            sql.SET("Category = #{category,jdbcType=VARCHAR}");
        }
        
        if (record.getTags() != null) {
            sql.SET("Tags = #{tags,jdbcType=VARCHAR}");
        }
        
        if (record.getStartTime() != null) {
            sql.SET("StartTime = #{startTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEndTime() != null) {
            sql.SET("EndTime = #{endTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLanguage() != null) {
            sql.SET("`Language` = #{language,jdbcType=INTEGER}");
        }
        
        if (record.getRelatedSubjectIDs() != null) {
            sql.SET("RelatedSubjectIDs = #{relatedSubjectIDs,jdbcType=VARCHAR}");
        }
        
        if (record.getIsValid() != null) {
            sql.SET("IsValid = #{isValid,jdbcType=TINYINT}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("CreateTime = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("UpdateTime = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getContent() != null) {
            sql.SET("Content = #{content,jdbcType=LONGVARCHAR}");
        }
        
        sql.WHERE("ID = #{ID,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}