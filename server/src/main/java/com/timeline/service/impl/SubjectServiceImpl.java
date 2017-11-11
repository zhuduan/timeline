package com.timeline.service.impl;

import com.timeline.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.timeline.model.PO.Subject;
import com.timeline.repository.SubjectDAO;

@Service
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	private SubjectDAO subjectDAO;
	
	@Override
	public Subject getSubject(Integer id) {

		return subjectDAO.getSubjectByID(id);
	}

}
