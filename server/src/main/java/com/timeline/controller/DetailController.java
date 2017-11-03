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

import static com.timeline.common.CommonConfig.PAGE_SIZE;

@RestController()
@RequestMapping(value = "detail")
public class DetailController {

	@Autowired
	private DetailService detailService;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	private List<DetailDTO> getDetailListBySubjectID(@RequestParam("subjectID") Integer subjectID,
													 @RequestParam("pageNum") Integer pageNum,
													 @RequestParam(name="pageSize", required = false) Integer pageSize) throws Exception {
		if (subjectID == null || subjectID <= 0 || pageNum ==null || pageNum<0) {
			// TODO:
			// 1. should add logs here
			throw new ControllerException(ErrorType.INVALID_INPUT_PARAM);
		}
		if ( pageSize==null ){
			pageSize = PAGE_SIZE;
		}
		return detailService.getDetailsBySubjectID(subjectID, pageNum, pageSize);
	}
}
