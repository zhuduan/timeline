package com.timeline.controller;

import com.timeline.common.ControllerException;
import com.timeline.common.ErrorType;
import com.timeline.common.ResponseUtils;
import com.timeline.service.UserFocusService;
import com.timeline.util.LogUtil;
import com.timeline.util.NumberUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@Api(description = "user focus related api")
@RestController
@RequestMapping("focus")
@ResponseBody
public class UserFocusController {
    
    @Autowired
    private UserFocusService userFocusService;
    
    
    @ApiOperation(httpMethod = "POST", value = "focus on subject", response = Map.class)
    @RequestMapping(value = "subject/on", method = RequestMethod.POST)
    public Map<String,Object> focusSubject(@RequestParam("subjectID") Integer subjectID,
                                             @RequestParam("userID") Integer userID) throws Exception{
        if ( !NumberUtil.isPositiveAndValid(subjectID) || !NumberUtil.isPositiveAndValid(userID) ){
            LogUtil.appLog.info(LogUtil.getMsg("wrong input for: subjectID=" + subjectID + ", userID=" + userID));
            throw new ControllerException(ErrorType.INVALID_INPUT_PARAM);
        }
       
        Map<String, Boolean> addResult = new HashMap<>();
        addResult.put("result", userFocusService.focusSubject(userID, subjectID));
        return ResponseUtils.toSuccess(addResult);
    }

    
    @ApiOperation(httpMethod = "POST", value = "unfocus on subject", response = Map.class)
    @RequestMapping(value = "subject/off", method = RequestMethod.POST)
    public Map<String,Object> unFocusSubject(@RequestParam("subjectID") Integer subjectID,
                                             @RequestParam("userID") Integer userID) throws Exception{
        if ( !NumberUtil.isPositiveAndValid(subjectID) || !NumberUtil.isPositiveAndValid(userID) ){
            LogUtil.appLog.info(LogUtil.getMsg("wrong input for: subjectID=" + subjectID + ", userID=" + userID));
            throw new ControllerException(ErrorType.INVALID_INPUT_PARAM);
        }

        Map<String, Boolean> deleteResult = new HashMap<>();
        deleteResult.put("result", userFocusService.unFocusSubject(userID, subjectID));
        return ResponseUtils.toSuccess(deleteResult);
    }

    
    @ApiOperation(httpMethod = "GET", value = "is already focused on subject", response = Map.class)
    @RequestMapping(value = "subject/off", method = RequestMethod.GET)
    public Map<String,Object> isFocusSubject(@RequestParam("subjectID") Integer subjectID,
                                             @RequestParam("userID") Integer userID) throws Exception{
        if ( !NumberUtil.isPositiveAndValid(subjectID) || !NumberUtil.isPositiveAndValid(userID) ){
            LogUtil.appLog.info(LogUtil.getMsg("wrong input for: subjectID=" + subjectID + ", userID=" + userID));
            throw new ControllerException(ErrorType.INVALID_INPUT_PARAM);
        }

        Map<String, Boolean> addResult = new HashMap<>();
        addResult.put("result", userFocusService.isFocusSubject(userID, subjectID));
        return ResponseUtils.toSuccess(addResult);
    }
}
