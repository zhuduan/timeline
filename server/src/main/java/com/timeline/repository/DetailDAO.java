package com.timeline.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import com.timeline.util.mybatis.mapper.BaseSql;
import com.timeline.model.PO.Detail;

public interface DetailDAO {

	 final static String TABLE = "detail";
	 
	 final static String ALL_COLUMNS = "ID," + 
	 								   "SubjectID," + 
	 								   "Title," + 
	 								   "Content," + 
	 								   "PicUrl," + 
	 								   "PicDes," + 
	 								   "AuthorID," + 
	 								   "ContributorIDs," + 
	 								   "OccurrenceTime," + 
	 								   "Language," + 
	 								   "ReplyCount," + 
	 								   "LikeCount," + 
	 								   "IsValid," + 
	 								   "CreateTime," + 
	 								   "UpdateTime";
	 
	 @SelectProvider(type = DetailSQL.class, method = DetailSQL.METHOD_GET_BY_KEY)
	 Detail getDetailByID(Integer id);
	 
	 @SelectProvider(type = DetailSQL.class, method = DetailSQL.METHOD_SELECT_BY_COLUMN)
	 List<Detail> getDetailBySubjectID(@Param("subjectID")Integer subjectID);
	 
	 static class DetailSQL extends BaseSql {

		public DetailSQL() {
			super(TABLE, ALL_COLUMNS);
		}
		 
	 }
}
