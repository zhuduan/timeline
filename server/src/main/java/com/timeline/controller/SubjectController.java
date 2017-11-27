package com.timeline.controller;

import com.google.common.base.Strings;
import com.timeline.common.ControllerException;
import com.timeline.common.ErrorType;
import com.timeline.model.DTO.SubjectDTO;
import com.timeline.service.SearchService;
import com.timeline.service.SubjectService;
import com.timeline.util.ConvertUtils;
import com.timeline.util.LogUtil;
import com.timeline.util.NumberUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.timeline.common.CommonConfig.PAGE_SIZE;

@Api(description = "subject related interface")
@RestController
@RequestMapping("subject")
@ResponseBody
public class SubjectController {

	@Autowired
	private SubjectService subjectService;
	
	@Autowired
	private SearchService searchService;

	@ApiOperation(httpMethod = "GET", value = "get definite subject by ID", response = List.class)
	@RequestMapping(value="info", method=RequestMethod.GET)
	public SubjectDTO getSubjectInfo(@RequestParam("subjectID") Integer subjectID) throws ControllerException {
		if ( !NumberUtil.isPositiveAndValid(subjectID) ){
			LogUtil.appLog.info(LogUtil.getMsg("wrong input for: subjectID="+subjectID));
			throw new ControllerException(ErrorType.INVALID_INPUT_PARAM);
		}
		return subjectService.getSubject(subjectID);
	}

	@ApiOperation(httpMethod = "GET", value = "get subject list by subject ID List", response = List.class)
	@RequestMapping(value="list", method=RequestMethod.GET)
	public List<SubjectDTO> getSubjectList(@RequestParam("pageNum") Integer pageNum,
										   @RequestParam(name="pageSize", required = false) Integer pageSize) throws ControllerException {
		if ( !NumberUtil.isPositiveAndValid(pageNum) ) {
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
		if ( !NumberUtil.isPositiveAndValid(userID) ){
			LogUtil.appLog.info(LogUtil.getMsg("wrong input for: userID="+userID));
			throw new ControllerException(ErrorType.INVALID_INPUT_PARAM);
		}
		if ( !NumberUtil.isPositiveAndValid(pageNum) ) {
			LogUtil.appLog.info(LogUtil.getMsg("wrong input for: pageNum="+pageNum));
			throw new ControllerException(ErrorType.INVALID_INPUT_PARAM);
		}
		if ( pageSize==null ){
			pageSize = PAGE_SIZE;
		}

		return subjectService.getSubjectListByUserFocus(userID, pageNum, pageSize);
	}

	@RequestMapping(value = "search", method = { RequestMethod.GET, RequestMethod.POST })
	public List<SubjectDTO> searchSubject(@RequestParam("key")String key, 
										  @RequestParam("pageNum") int pageNum) {
		
		if(Strings.isNullOrEmpty(key.trim()) || pageNum <= 0 || pageNum > 10) {
			
			return null;
		}
		
		return ConvertUtils.convert(searchService.searchSubjects(key, pageNum), SubjectDTO.class);
	}

}
