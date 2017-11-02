package com.timeline.controller;

import java.util.List;

import com.timeline.model.DTO.DetailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.timeline.common.ControllerException;
import com.timeline.common.ErrorType;
import com.timeline.model.PO.Detail;
import com.timeline.service.DetailService;

@RestController()
@RequestMapping(value = "detail")
public class DetailController {

	@Autowired
	private DetailService detailService;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	private List<DetailDTO> getDetailListBySubjectID(@RequestParam(value = "subjectID") Integer subjectID)
			throws Exception {
		
		if (subjectID == null || subjectID <= 0 ) {
			// TODO:
			// 1. should add logs here
			throw new ControllerException(ErrorType.INVALID_INPUT_PARAM);
		}

		return detailService.getDetailsBySubjectID(subjectID);
	}
}
