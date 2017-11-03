package com.timeline.service;

import java.util.List;

import com.timeline.model.DTO.DetailDTO;

public interface DetailService {

	List<DetailDTO> getDetailsBySubjectID(Integer subjectID, Integer pageNum, Integer pageSize);
}
