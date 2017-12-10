package com.timeline.controller;

import com.timeline.common.ControllerException;
import com.timeline.common.ErrorType;
import com.timeline.model.DTO.DetailReplyDTO;
import com.timeline.service.DetailReplyService;
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

@Api(description = "detail reply interface")
@RestController()
@RequestMapping(value = "detail/reply")
public class DetailReplyController {

    @Autowired
    private DetailReplyService detailReplyService;

    @ApiOperation(httpMethod = "GET", value = "get detail replies list by detailID", response = List.class)
    @RequestMapping(value = "list", method = RequestMethod.GET)
    private List<DetailReplyDTO> getRepliesByDetailID(@RequestParam("detailID") Integer detailID,
                                                      @RequestParam("pageNum") Integer pageNum,
                                                      @RequestParam(name="pageSize", required = false) Integer pageSize) throws Exception {
        if ( !NumberUtil.isPositiveAndValid(detailID)
                || !NumberUtil.isPositiveAndValid(pageNum) ) {
            LogUtil.appLog.info(LogUtil.getMsg("wrong input for: detailID="+detailID+", pageNum="+pageNum));
            throw new ControllerException(ErrorType.INVALID_INPUT_PARAM);
        }
        if ( pageSize==null ){
            pageSize = PAGE_SIZE;
        }
        return detailReplyService.getReplyByDetailID(detailID, pageNum, pageSize);
    }
}
