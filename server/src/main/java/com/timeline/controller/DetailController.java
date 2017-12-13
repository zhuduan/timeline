package com.timeline.controller;

import com.timeline.common.ControllerException;
import com.timeline.common.ErrorType;
import com.timeline.common.ResponseUtils;
import com.timeline.model.DTO.DetailDTO;
import com.timeline.service.DetailService;
import com.timeline.util.LogUtil;
import com.timeline.util.NumberUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import static com.timeline.common.CommonConfig.PAGE_SIZE;

@Api(description = "detail related interface")
@RestController()
@RequestMapping(value = "detail")
public class DetailController {

	@Autowired
	private DetailService detailService;

	@ApiOperation(httpMethod = "GET", value = "get detail list in subject", response = List.class)
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public Map<String, Object> getDetailListBySubjectID(@RequestParam("subjectID") Integer subjectID,
														@RequestParam("pageNum") Integer pageNum,
														@RequestParam(name="pageSize", required = false) Integer pageSize) throws Exception {
		if ( !NumberUtil.isPositiveAndValid(subjectID) || !NumberUtil.isPositiveAndValid(pageNum) ) {
			LogUtil.appLog.info(LogUtil.getMsg("wrong input for: subjectID="+subjectID+", pageNum="+pageNum));
			throw new ControllerException(ErrorType.INVALID_INPUT_PARAM);
		}
		if ( pageSize==null ){
			pageSize = PAGE_SIZE;
		}
		return ResponseUtils.toSuccess(detailService.getDetailsBySubjectID(subjectID, pageNum, pageSize));
	}

	@ApiOperation(httpMethod = "GET", value = "get definite detail by ID", response = List.class)
	@RequestMapping(value = "info", method = RequestMethod.GET)
	public Map<String, Object> getDetailByID(@RequestParam("detailID") Integer detailID) throws Exception{
		if ( !NumberUtil.isPositiveAndValid(detailID) ){
			LogUtil.appLog.info(LogUtil.getMsg("wrong input for: detailID="+detailID));
			throw new ControllerException(ErrorType.INVALID_INPUT_PARAM);
		}
		return ResponseUtils.toSuccess(detailService.getDetailByID(detailID));
	}
}
