package com.timeline.controller;

import com.timeline.common.EnumLanguage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Api(description = "common info can request from this class")
@RestController()
@RequestMapping(value = "common")
public class CommonController {

    @ApiOperation(httpMethod = "GET", value = "get all support language and its ID", response = Map.class)
    @RequestMapping(value = "language", method = RequestMethod.GET)
    private Map<String, Integer> getAllSupportLanguage() throws Exception{
        Map<String,Integer> languageStrIDMap = new HashMap<>();
        for( EnumLanguage language : EnumLanguage.values() ){
           languageStrIDMap.put(language.name(), language.getLanguageID());
       }
       return languageStrIDMap;
    }
}
