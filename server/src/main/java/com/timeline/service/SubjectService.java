package com.timeline.service;

import com.timeline.model.DTO.SubjectDTO;

import java.util.List;

public interface SubjectService {

  SubjectDTO getSubject(Integer id);

  List<SubjectDTO> getSubjectListByDefault(Integer pageNum, Integer pageSize);

  List<SubjectDTO> getSubjectListByIDs(List<Integer> idList, Integer pageNum, Integer pageSize);

  List<SubjectDTO> getSubjectListByUserFocus(Integer userID, Integer pageNum, Integer pageSize);
}
