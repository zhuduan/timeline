package com.timeline.service.impl;

import com.github.pagehelper.PageHelper;
import com.timeline.model.DTO.SubjectDTO;
import com.timeline.model.PO.Detail;
import com.timeline.service.SubjectService;
import com.timeline.util.ConvertUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.timeline.model.PO.Subject;
import com.timeline.repository.SubjectDAO;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	private SubjectDAO subjectDAO;
	
	@Override
	public SubjectDTO getSubject(Integer id) {
		return ConvertUtils.convert(subjectDAO.getSubjectByID(id),SubjectDTO.class);
	}

	@Override
	public List<SubjectDTO> getSubjectListByIDs(List<Integer> idList, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Subject> subjects = subjectDAO.getDetailBySubjectIDs(idList);
		return ConvertUtils.convert(subjects, SubjectDTO.class);
	}

	@Override
	public List<SubjectDTO> getSubjectListByUserFocus(Integer userID, Integer pageNum, Integer pageSize) {
		//TODO:
		// 1. get user focused on Subject ID List
		// 2. then get subject list by IDs
		return null;
	}

}
