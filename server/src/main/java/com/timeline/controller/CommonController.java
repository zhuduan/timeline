package com.timeline.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.timeline.support.common.EnumLanguage;
import com.timeline.support.common.EnumStatus;

import java.util.HashMap;
import java.util.Map;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description = "common info can request from this class")
@RestController()
@RequestMapping(value = "common")
public class CommonController {

  @ApiOperation(httpMethod = "GET", value = "get all support language and its ID", response = Map.class)
  @RequestMapping(value = "language", method = RequestMethod.GET)
  public Object getAllSupportLanguage() {
    Map<String, Integer> languageStrIDMap = new HashMap<>();
    for (EnumLanguage language : EnumLanguage.values()) {
      languageStrIDMap.put(language.name(), language.getLanguageID());
    }
    return languageStrIDMap;
  }

  @ApiOperation(httpMethod = "GET", value = "get all support status and its ID", response = Map.class)
  @RequestMapping(value = "status", method = RequestMethod.GET)
  public Object getAllSupportStatus() {
    Map<String, Integer> statusStrIDMap = new HashMap<>();
    for (EnumStatus status : EnumStatus.values()) {
      statusStrIDMap.put(status.name(), status.getStatusID());
    }
    return statusStrIDMap;
  }
}
