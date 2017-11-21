package com.timeline.service;

import java.util.List;

import com.timeline.model.DTO.SubjectDTO;

public interface SubjectService {

	SubjectDTO getSubject(Integer id);

	List<SubjectDTO> getSubjectListByDefault(Integer pageNum, Integer pageSize);

	List<SubjectDTO> getSubjectListByIDs(List<Integer> idList, Integer pageNum, Integer pageSize);

	List<SubjectDTO> getSubjectListByUserFocus(Integer userID, Integer pageNum, Integer pageSize);
}
