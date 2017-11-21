package com.timeline.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.google.common.base.Strings;
import com.timeline.common.CommonConfig;
import com.timeline.model.PO.Subject;
import com.timeline.repository.SubjectDAO;
import com.timeline.service.SearchService;

@Service
public class SearchServiceImpl implements SearchService{

	@Autowired
	private SubjectDAO subjectDAO;
	
	
	@Override
	public List<Subject> searchSubjects(String key, Integer pageNum) {
		
		if(Strings.isNullOrEmpty(key.trim()) || pageNum <= 0) {
			
			return null;
		}
		
		//拦截最近的一次SQL执行
		PageHelper.startPage(pageNum, CommonConfig.PAGE_SIZE);  
		
		key = "%" + key + "%";
		return subjectDAO.searchSubjects(key);
	}

}
