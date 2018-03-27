package com.timeline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.timeline.service.UserFocusService;
import com.timeline.support.common.ControllerException;
import com.timeline.support.common.ErrorType;
import com.timeline.support.utils.LogUtil;
import com.timeline.support.utils.NumberUtil;

import java.util.HashMap;
import java.util.Map;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description = "user focus related api")
@RestController
@RequestMapping("focus")
public class UserFocusController {

  @Autowired
  private UserFocusService userFocusService;

  @ApiOperation(httpMethod = "POST", value = "focus on subject", response = Map.class)
  @RequestMapping(value = "subject/on", method = RequestMethod.POST)
  Object focusSubject(@RequestParam("subjectID") Integer subjectID,
      @RequestParam("userID") Integer userID) throws Exception {
    if (!NumberUtil.isPositiveAndValid(subjectID) || !NumberUtil.isPositiveAndValid(userID)) {
      LogUtil.appLog.info(LogUtil.getMsg("wrong input for: subjectID=" + subjectID + ", userID=" + userID));
      throw new ControllerException(ErrorType.INVALID_INPUT_PARAM);
    }

    Map<String, Boolean> addResult = new HashMap<>();
    addResult.put("result", userFocusService.focusSubject(userID, subjectID));
    return addResult;
  }

  @ApiOperation(httpMethod = "POST", value = "unfocus on subject", response = Map.class)
  @RequestMapping(value = "subject/off", method = RequestMethod.POST)
  Object unFocusSubject(@RequestParam("subjectID") Integer subjectID,
      @RequestParam("userID") Integer userID) throws Exception {
    if (!NumberUtil.isPositiveAndValid(subjectID) || !NumberUtil.isPositiveAndValid(userID)) {
      LogUtil.appLog.info(LogUtil.getMsg("wrong input for: subjectID=" + subjectID + ", userID=" + userID));
      throw new ControllerException(ErrorType.INVALID_INPUT_PARAM);
    }

    Map<String, Boolean> deleteResult = new HashMap<>();
    deleteResult.put("result", userFocusService.unFocusSubject(userID, subjectID));
    return deleteResult;
  }

  @ApiOperation(httpMethod = "GET", value = "is already focused on subject", response = Map.class)
  @RequestMapping(value = "subject", method = RequestMethod.GET)
  Object isFocusSubject(@RequestParam("subjectID") Integer subjectID,
      @RequestParam("userID") Integer userID) throws Exception {
    if (!NumberUtil.isPositiveAndValid(subjectID) || !NumberUtil.isPositiveAndValid(userID)) {
      LogUtil.appLog.info(LogUtil.getMsg("wrong input for: subjectID=" + subjectID + ", userID=" + userID));
      throw new ControllerException(ErrorType.INVALID_INPUT_PARAM);
    }

    Map<String, Boolean> addResult = new HashMap<>();
    addResult.put("result", userFocusService.isFocusSubject(userID, subjectID));
    return addResult;
  }
}
