package com.timeline.controller;

import static com.timeline.common.CommonConfig.PAGE_SIZE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.timeline.common.ControllerException;
import com.timeline.common.ErrorType;
import com.timeline.model.DTO.SubjectDTO;
import com.timeline.service.SubjectService;
import com.timeline.util.LogUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description = "subject related interface")
@RestController
@RequestMapping("subject")
@ResponseBody
public class SubjectController {

	@Autowired
	private SubjectService subjectService;

	@ApiOperation(httpMethod = "GET", value = "get definite subject by ID", response = List.class)
	@RequestMapping(value="info", method=RequestMethod.GET)
	public SubjectDTO getSubjectInfo(@RequestParam("subjectID") Integer subjectID) throws ControllerException {
		if ( subjectID==null || subjectID<=0 ){
			LogUtil.appLog.info(LogUtil.getMsg("wrong input for: subjectID="+subjectID));
			throw new ControllerException(ErrorType.INVALID_INPUT_PARAM);
		}
		return subjectService.getSubject(subjectID);
	}

	@ApiOperation(httpMethod = "GET", value = "get subject list by subject ID List", response = List.class)
	@RequestMapping(value="list", method=RequestMethod.GET)
	public List<SubjectDTO> getSubjectList(@RequestParam("pageNum") Integer pageNum,
										   @RequestParam(name="pageSize", required = false) Integer pageSize) throws ControllerException {
		if ( pageNum ==null || pageNum<0) {
			LogUtil.appLog.info(LogUtil.getMsg("wrong input for: pageNum="+pageNum));
			throw new ControllerException(ErrorType.INVALID_INPUT_PARAM);
		}
		if ( pageSize==null ){
			pageSize = PAGE_SIZE;
		}
		return subjectService.getSubjectListByDefault(pageNum, pageSize);
	}

	@ApiOperation(httpMethod = "GET", value = "get subject list which user focus on", response = List.class)
	@RequestMapping(value="list/focus", method=RequestMethod.GET)
	public List<SubjectDTO> getFocusSubjectList(@RequestParam("userID") Integer userID,
												@RequestParam("pageNum") Integer pageNum,
											    @RequestParam(name="pageSize", required = false) Integer pageSize) throws ControllerException {
		if ( userID==null || userID<=0 ){
			LogUtil.appLog.info(LogUtil.getMsg("wrong input for: userID="+userID));
			throw new ControllerException(ErrorType.INVALID_INPUT_PARAM);
		}
		if ( pageNum ==null || pageNum<0) {
			LogUtil.appLog.info(LogUtil.getMsg("wrong input for: pageNum="+pageNum));
			throw new ControllerException(ErrorType.INVALID_INPUT_PARAM);
		}
		if ( pageSize==null ){
			pageSize = PAGE_SIZE;
		}

//		return subjectService.getSubject(subjectID);
		return null;
	}



}
