package com.timeline.repository;

import org.apache.ibatis.annotations.SelectProvider;

import com.timeline.Common.mybatis.mapper.BaseSql;
import com.timeline.model.PO.Subject;

public interface SubjectDAO {
   
	 final static String TABLE = "subject";
	 
	 final static String ALL_COLUMNS = "ID,Title,Content,PicUrl,PicDes,AuthorID,ContributorIDs,Category,Tags,StartTime,EndTime,Language,RelatedSubjectIDs,IsValid,CreateTime,UpdateTime";
	 
	 @SelectProvider(type = SubjectSQL.class, method = SubjectSQL.METHOD_GET_BY_KEY)
	 Subject getSubjectByID(Integer id);
	 
	 static class SubjectSQL extends BaseSql {

		public SubjectSQL() {
			super(TABLE, ALL_COLUMNS);
		}
		 
	 }
}