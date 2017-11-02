package com.timeline.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.timeline.model.PO.Detail;

public interface DetailService {

	List<Detail> getDetailsBySubjectID(Pageable pageable, Integer subjectID);
}
