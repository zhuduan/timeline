package com.timeline.service;

import com.timeline.model.DTO.DetailDTO;

import java.util.List;

public interface DetailService {

  List<DetailDTO> getDetailsBySubjectID(Integer subjectID, Integer pageNum, Integer pageSize);

  DetailDTO getDetailByID(Integer detailID);
}
