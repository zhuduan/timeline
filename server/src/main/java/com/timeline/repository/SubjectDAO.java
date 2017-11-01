package com.timeline.repository;

import com.timeline.model.PO.Subject;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface SubjectDAO {
    @Insert({
        "insert into subject (ID, Title, ",
        "PicUrl, PicDes, ",
        "AuthorID, ContributorIDs, ",
        "Category, Tags, ",
        "StartTime, EndTime, ",
        "`Language`, RelatedSubjectIDs, ",
        "IsValid, CreateTime, ",
        "UpdateTime, Content)",
        "values (#{ID,jdbcType=INTEGER}, #{title,jdbcType=VARCHAR}, ",
        "#{picUrl,jdbcType=VARCHAR}, #{picDes,jdbcType=VARCHAR}, ",
        "#{authorID,jdbcType=INTEGER}, #{contributorIDs,jdbcType=VARCHAR}, ",
        "#{category,jdbcType=VARCHAR}, #{tags,jdbcType=VARCHAR}, ",
        "#{startTime,jdbcType=TIMESTAMP}, #{endTime,jdbcType=TIMESTAMP}, ",
        "#{language,jdbcType=INTEGER}, #{relatedSubjectIDs,jdbcType=VARCHAR}, ",
        "#{isValid,jdbcType=TINYINT}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{content,jdbcType=LONGVARCHAR})"
    })
    int insert(Subject record);

    @InsertProvider(type=SubjectSqlProvider.class, method="insertSelective")
    int insertSelective(Subject record);

    @Select({
        "select",
        "ID, Title, PicUrl, PicDes, AuthorID, ContributorIDs, Category, Tags, StartTime, ",
        "EndTime, `Language`, RelatedSubjectIDs, IsValid, CreateTime, UpdateTime, Content",
        "from subject",
        "where ID = #{ID,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="ID", property="ID", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="Title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="PicUrl", property="picUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="PicDes", property="picDes", jdbcType=JdbcType.VARCHAR),
        @Result(column="AuthorID", property="authorID", jdbcType=JdbcType.INTEGER),
        @Result(column="ContributorIDs", property="contributorIDs", jdbcType=JdbcType.VARCHAR),
        @Result(column="Category", property="category", jdbcType=JdbcType.VARCHAR),
        @Result(column="Tags", property="tags", jdbcType=JdbcType.VARCHAR),
        @Result(column="StartTime", property="startTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="EndTime", property="endTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="Language", property="language", jdbcType=JdbcType.INTEGER),
        @Result(column="RelatedSubjectIDs", property="relatedSubjectIDs", jdbcType=JdbcType.VARCHAR),
        @Result(column="IsValid", property="isValid", jdbcType=JdbcType.TINYINT),
        @Result(column="CreateTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UpdateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="Content", property="content", jdbcType=JdbcType.LONGVARCHAR)
    })
    Subject selectByPrimaryKey(Integer ID);

    @UpdateProvider(type=SubjectSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Subject record);

    @Update({
        "update subject",
        "set Title = #{title,jdbcType=VARCHAR},",
          "PicUrl = #{picUrl,jdbcType=VARCHAR},",
          "PicDes = #{picDes,jdbcType=VARCHAR},",
          "AuthorID = #{authorID,jdbcType=INTEGER},",
          "ContributorIDs = #{contributorIDs,jdbcType=VARCHAR},",
          "Category = #{category,jdbcType=VARCHAR},",
          "Tags = #{tags,jdbcType=VARCHAR},",
          "StartTime = #{startTime,jdbcType=TIMESTAMP},",
          "EndTime = #{endTime,jdbcType=TIMESTAMP},",
          "`Language` = #{language,jdbcType=INTEGER},",
          "RelatedSubjectIDs = #{relatedSubjectIDs,jdbcType=VARCHAR},",
          "IsValid = #{isValid,jdbcType=TINYINT},",
          "CreateTime = #{createTime,jdbcType=TIMESTAMP},",
          "UpdateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "Content = #{content,jdbcType=LONGVARCHAR}",
        "where ID = #{ID,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(Subject record);

    @Update({
        "update subject",
        "set Title = #{title,jdbcType=VARCHAR},",
          "PicUrl = #{picUrl,jdbcType=VARCHAR},",
          "PicDes = #{picDes,jdbcType=VARCHAR},",
          "AuthorID = #{authorID,jdbcType=INTEGER},",
          "ContributorIDs = #{contributorIDs,jdbcType=VARCHAR},",
          "Category = #{category,jdbcType=VARCHAR},",
          "Tags = #{tags,jdbcType=VARCHAR},",
          "StartTime = #{startTime,jdbcType=TIMESTAMP},",
          "EndTime = #{endTime,jdbcType=TIMESTAMP},",
          "`Language` = #{language,jdbcType=INTEGER},",
          "RelatedSubjectIDs = #{relatedSubjectIDs,jdbcType=VARCHAR},",
          "IsValid = #{isValid,jdbcType=TINYINT},",
          "CreateTime = #{createTime,jdbcType=TIMESTAMP},",
          "UpdateTime = #{updateTime,jdbcType=TIMESTAMP}",
        "where ID = #{ID,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Subject record);
}