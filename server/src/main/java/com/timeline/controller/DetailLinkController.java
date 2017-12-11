package com.timeline.controller;

import com.timeline.common.ControllerException;
import com.timeline.common.EnumLanguage;
import com.timeline.common.ErrorType;
import com.timeline.model.DTO.DetailLinkDTO;
import com.timeline.service.DetailLinkService;
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

import static com.timeline.common.CommonConfig.PAGE_SIZE;

@Api(description = "get detail links")
@RestController()
@RequestMapping(value = "detail/link")
public class DetailLinkController {

    @Autowired
    private DetailLinkService detailLinkService;

    @ApiOperation(httpMethod = "GET", value = "get detail link list by detailID and language", response = List.class)
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public List<DetailLinkDTO> getLinksByIDAndLanguage(@RequestParam("detailID") Integer detailID,
                                                        @RequestParam("languageID") Integer languageID,
                                                        @RequestParam("pageNum") Integer pageNum,
                                                        @RequestParam(name="pageSize", required = false) Integer pageSize) throws Exception {
        if ( !NumberUtil.isPositiveAndValid(detailID)
                || !NumberUtil.isPositiveAndValid(languageID)
                || !NumberUtil.isPositiveAndValid(pageNum) ) {
            LogUtil.appLog.info(LogUtil.getMsg("wrong input for: detailID="+detailID
                    +", languageID="+languageID+", pageNum="+pageNum));
            throw new ControllerException(ErrorType.INVALID_INPUT_PARAM);
        }
        if ( !EnumLanguage.isValid(languageID) ){
            LogUtil.appLog.info(LogUtil.getMsg("not valid: languageID="+languageID));
            throw new ControllerException(ErrorType.INVALID_INPUT_PARAM);
        }
        if ( pageSize==null ){
            pageSize = PAGE_SIZE;
        }
        return detailLinkService.getLinksByIDAndLanguage(detailID, languageID, pageNum, pageSize);
    }
}
