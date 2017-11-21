package com.timeline.service;

import java.util.List;

import com.timeline.model.PO.Subject;

public interface SearchService {
	/***
	 * 
	 * 后续用solr或者elasticsearch
	 * */
	List<Subject> searchSubjects(String key, Integer pageNum);
}
