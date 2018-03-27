package com.timeline.controller;

import static com.timeline.support.common.CommonConfig.PAGE_SIZE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Strings;
import com.timeline.model.DTO.SubjectDTO;
import com.timeline.service.SearchService;
import com.timeline.service.SubjectService;
import com.timeline.support.common.ControllerException;
import com.timeline.support.common.ErrorType;
import com.timeline.support.utils.ConvertUtils;
import com.timeline.support.utils.LogUtil;
import com.timeline.support.utils.NumberUtil;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

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
  @RequestMapping(value = "info", method = RequestMethod.GET)
  public Object getSubjectInfo(@RequestParam("subjectID") Integer subjectID) throws ControllerException {
    if (!NumberUtil.isPositiveAndValid(subjectID)) {
      LogUtil.appLog.info(LogUtil.getMsg("wrong input for: subjectID=" + subjectID));
      throw new ControllerException(ErrorType.INVALID_INPUT_PARAM);
    }
    return subjectService.getSubject(subjectID);
  }

  @ApiOperation(httpMethod = "GET", value = "get subject list by subject ID List", response = List.class)
  @RequestMapping(value = "list", method = RequestMethod.GET)
  public Object getSubjectList(@RequestParam("pageNum") Integer pageNum,
      @RequestParam(name = "pageSize", required = false) Integer pageSize) throws ControllerException {
    if (!NumberUtil.isPositiveAndValid(pageNum)) {
      LogUtil.appLog.info(LogUtil.getMsg("wrong input for: pageNum=" + pageNum));
      throw new ControllerException(ErrorType.INVALID_INPUT_PARAM);
    }
    if (pageSize == null) {
      pageSize = PAGE_SIZE;
    }
    return subjectService.getSubjectListByDefault(pageNum, pageSize);
  }

  @ApiOperation(httpMethod = "GET", value = "get subject list which user focus on", response = List.class)
  @RequestMapping(value = "list/focus", method = RequestMethod.GET)
  public Object getFocusSubjectList(@RequestParam("userID") Integer userID,
      @RequestParam("pageNum") Integer pageNum,
      @RequestParam(name = "pageSize", required = false) Integer pageSize) throws ControllerException {
    if (!NumberUtil.isPositiveAndValid(userID)) {
      LogUtil.appLog.info(LogUtil.getMsg("wrong input for: userID=" + userID));
      throw new ControllerException(ErrorType.INVALID_INPUT_PARAM);
    }
    if (!NumberUtil.isPositiveAndValid(pageNum)) {
      LogUtil.appLog.info(LogUtil.getMsg("wrong input for: pageNum=" + pageNum));
      throw new ControllerException(ErrorType.INVALID_INPUT_PARAM);
    }
    if (pageSize == null) {
      pageSize = PAGE_SIZE;
    }

    return subjectService.getSubjectListByUserFocus(userID, pageNum, pageSize);
  }

  @RequestMapping(value = "search", method = {RequestMethod.GET, RequestMethod.POST})
  public Object searchSubject(@RequestParam("key") String key, @RequestParam("pageNum") int pageNum) {

    if (Strings.isNullOrEmpty(key.trim()) || pageNum <= 0 || pageNum > 10) {

      return null;
    }

    return ConvertUtils.convert(searchService.searchSubjects(key, pageNum), SubjectDTO.class);
  }

  @PostMapping(value = "")
  public SubjectDTO createSubject() {

    return null;
  }
}
