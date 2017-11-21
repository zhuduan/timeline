package com.timeline.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.jdbc.SQL;

import com.timeline.model.PO.Subject;
import com.timeline.util.mybatis.mapper.BaseSql;

public interface SubjectDAO {
   
	 final static String TABLE = "subject";
	 
	 final static String ALL_COLUMNS = "ID,Title,Content,PicUrl,PicDes,AuthorID,ContributorIDs,Category,Tags,StartTime,EndTime,Language,RelatedSubjectIDs,IsValid,CreateTime,UpdateTime";
	 
	 @SelectProvider(type = SubjectSQL.class, method = SubjectSQL.METHOD_GET_BY_KEY)
	 Subject getSubjectByID(Integer id);

	 @SelectProvider(type = SubjectSQL.class, method = SubjectSQL.METHOD_SELECT_BY_COLUMN)
	 List<Subject> getSubjectByValid(@Param("isValid")Integer isValid);

	 @SelectProvider(type = SubjectSQL.class, method = SubjectSQL.METHOD_SELECT_BY_KEYS)
	 List<Subject> getSubjectBySubjectIDs(List<Integer> subjectIDs);
	 
	 @SelectProvider(type = SubjectSQL.class, method = "searchSubjectsSQL")
	 List<Subject> searchSubjects(@Param("title") String title);
	 
	 static class SubjectSQL extends BaseSql {
		 
		public SubjectSQL() {
			super(TABLE, ALL_COLUMNS);
		}
		
		public String searchSubjectsSQL() {
			
			SQL sql = new SQL();
			sql.SELECT(getQueryList())
			   .FROM(getTable())
			   .WHERE("Title like #{title}");
			
			return sql.toString();
		}
	 }
}