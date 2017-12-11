package com.timeline.controller;

import com.timeline.common.ControllerException;
import com.timeline.common.ErrorType;
import com.timeline.model.DTO.DetailReplyDTO;
import com.timeline.service.DetailReplyService;
import com.timeline.util.LogUtil;
import com.timeline.util.NumberUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.timeline.common.CommonConfig.PAGE_SIZE;

@Api(description = "detail reply interface")
@RestController()
@RequestMapping(value = "detail/reply")
public class DetailReplyController {

    @Autowired
    private DetailReplyService detailReplyService;

    @ApiOperation(httpMethod = "GET", value = "get detail replies list by detailID", response = List.class)
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public List<DetailReplyDTO> getRepliesByDetailID(@RequestParam("detailID") Integer detailID,
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

    @ApiOperation(httpMethod = "POST", value = "add new reply", response = Map.class)
    @RequestMapping(value = "info/new", method = RequestMethod.POST)
    public Map<String,Boolean> addReply(@RequestParam("detailID") Integer detailID,
                                         @RequestParam("title") String title,
                                         @RequestParam("content") String content,
                                         @RequestParam("authorID") Integer authorID) throws Exception{
        if ( !NumberUtil.isPositiveAndValid(detailID) || !NumberUtil.isPositiveAndValid(authorID) ){
            LogUtil.appLog.info(LogUtil.getMsg("wrong input for: detailID="+detailID+", authorID="+authorID));
            throw new ControllerException(ErrorType.INVALID_INPUT_PARAM);
        }
        if ( StringUtils.isEmpty(title) || StringUtils.isEmpty(content) ){
            LogUtil.appLog.info(LogUtil.getMsg("wrong input for: title="+title+", content="+content));
            throw new ControllerException(ErrorType.INVALID_INPUT_PARAM);
        }

        Map<String, Boolean> addResult = new HashMap<>();
        addResult.put("result", detailReplyService.addReply(detailID,title,content,authorID));
        return addResult;
    }

    @ApiOperation(httpMethod = "PUT", value = "modify exist reply", response = Map.class)
    @RequestMapping(value = "info/modify", method = RequestMethod.PUT)
    public Map<String,Boolean> modifyReply(@RequestParam("replyID") Integer replyID,
                                           @RequestParam("title") String title,
                                           @RequestParam("content") String content) throws Exception{
        if ( !NumberUtil.isPositiveAndValid(replyID) ){
            LogUtil.appLog.info(LogUtil.getMsg("wrong input for: replyID="+replyID));
            throw new ControllerException(ErrorType.INVALID_INPUT_PARAM);
        }

        Map<String, Boolean> modifyResult = new HashMap<>();
        modifyResult.put("result", detailReplyService.updateReply(replyID, title, content));
        return modifyResult;
    }
}
