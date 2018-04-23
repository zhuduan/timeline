package com.timeline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.timeline.service.UserFocusService;
import com.timeline.support.annotation.UserLogin;
import com.timeline.support.common.ControllerException;
import com.timeline.support.common.ErrorType;
import com.timeline.support.http.HttpKeys;
import com.timeline.support.utils.LogUtil;
import com.timeline.support.utils.NumberUtil;

import java.util.Map;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description = "user focus related api")
@RestController
@RequestMapping("focus")
public class UserFocusController {

  @Autowired
  private UserFocusService userFocusService;

  @UserLogin
  @RequestMapping(value = "subject/on", method = RequestMethod.POST)
  @ApiOperation(httpMethod = "POST", value = "focus on subject", response = Map.class)
  public Object focusSubject( @RequestAttribute(HttpKeys.X_USER_ID) Integer userID,
                              @RequestParam("subjectID" ) Integer subjectID) throws Exception {

    if (!NumberUtil.isPositiveAndValid(subjectID) || !NumberUtil.isPositiveAndValid(userID)) {
      LogUtil.appLog.info(LogUtil.getMsg("wrong input for: subjectID=" + subjectID + ", userID=" + userID));
      throw new ControllerException(ErrorType.INVALID_INPUT_PARAM);
    }

    return userFocusService.focusSubject(userID, subjectID);
  }

  @UserLogin
  @RequestMapping(value = "subject/off", method = RequestMethod.POST)
  @ApiOperation(httpMethod = "POST", value = "unfocus on subject", response = Map.class)
  Object unFocusSubject( @RequestParam("subjectID") Integer subjectID,
                         @RequestAttribute(HttpKeys.X_USER_ID) Integer userID ) throws Exception {

    if (!NumberUtil.isPositiveAndValid(subjectID) || !NumberUtil.isPositiveAndValid(userID)) {
      LogUtil.appLog.info(LogUtil.getMsg("wrong input for: subjectID=" + subjectID + ", userID=" + userID));
      throw new ControllerException(ErrorType.INVALID_INPUT_PARAM);
    }

    return userFocusService.unFocusSubject(userID, subjectID);
  }

  @UserLogin
  @ApiOperation(httpMethod = "GET", value = "is already focused on subject", response = Map.class)
  @RequestMapping(value = "subject", method = RequestMethod.GET)
  Object isFocusSubject( @RequestAttribute(HttpKeys.X_USER_ID) Integer userID,
                         @RequestParam("subjectID") Integer subjectID ) throws Exception {

    if (!NumberUtil.isPositiveAndValid(subjectID) || !NumberUtil.isPositiveAndValid(userID)) {
      LogUtil.appLog.info(LogUtil.getMsg("wrong input for: subjectID=" + subjectID + ", userID=" + userID));
      throw new ControllerException(ErrorType.INVALID_INPUT_PARAM);
    }

    return userFocusService.isFocusSubject(userID, subjectID);
  }
}
