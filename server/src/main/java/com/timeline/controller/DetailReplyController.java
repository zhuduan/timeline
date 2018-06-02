package com.timeline.controller;

import com.timeline.model.DTO.DetailReplyDTO;
import com.timeline.service.DetailReplyService;
import com.timeline.support.annotation.UserLogin;
import com.timeline.support.common.ControllerException;
import com.timeline.support.common.ErrorType;
import com.timeline.support.http.HttpKeys;
import com.timeline.support.utils.LogUtil;
import com.timeline.support.utils.NumberUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.timeline.support.common.CommonConfig.PAGE_SIZE;

@Api(description = "detail reply interface")
@RestController()
@RequestMapping(value = "detail/reply")
public class DetailReplyController {

    @Autowired
    private DetailReplyService detailReplyService;

    @ApiOperation(httpMethod = "GET", value = "get detail replies list by detailID", response = List.class)
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public Object getRepliesByDetailID(@RequestParam("detailID") Integer detailID,
                                       @RequestParam("pageNum") Integer pageNum,
                                       @RequestParam(name = "pageSize", required = false) Integer pageSize) throws Exception {
        if (!NumberUtil.isPositiveAndValid(detailID)
                || !NumberUtil.isPositiveAndValid(pageNum)) {
            LogUtil.appLog.info(LogUtil.getMsg("wrong input for: detailID=" + detailID + ", pageNum=" + pageNum));
            throw new ControllerException(ErrorType.INVALID_INPUT_PARAM);
        }
        if (pageSize == null) {
            pageSize = PAGE_SIZE;
        }
        return detailReplyService.getReplyWithUserInfoByDetailID(detailID, pageNum, pageSize);
    }

    @ApiOperation(httpMethod = "GET", value = "get the total count of reply list", response = Integer.class)
    @RequestMapping(value = "count/total", method = RequestMethod.GET)
    public Object getTotalCount(@RequestParam("detailID") Integer detailID) throws Exception {
        if ( !NumberUtil.isPositiveAndValid(detailID) ) {
            LogUtil.appLog.info(LogUtil.getMsg("wrong input for: detailID=" + detailID));
            throw new ControllerException(ErrorType.INVALID_INPUT_PARAM);
        }
        Map<String, Integer> countResult = new HashMap<>();
        countResult.put("total", detailReplyService.getTotalCount(detailID));
        return countResult;
    }

    @UserLogin
    @ApiOperation(httpMethod = "POST", value = "add new reply", response = Map.class)
    @RequestMapping(value = "info/new", method = RequestMethod.POST)
    public Object addReply( @RequestAttribute(HttpKeys.X_USER_ID) Long userID,
                            @RequestBody DetailReplyDTO detailReplyDTO ) throws Exception {

        detailReplyDTO.setAuthorID(userID.intValue());
        detailReplyDTO.validate();
        Map<String, Boolean> addResult = new HashMap<>();
        addResult.put("result", detailReplyService.addReply(detailReplyDTO.getDetailID(), detailReplyDTO.getTitle(),
                detailReplyDTO.getContent(), detailReplyDTO.getAuthorID(), detailReplyDTO.getToReplyID()));
        return addResult;
    }

    @ApiOperation(httpMethod = "PUT", value = "modify exist reply", response = Map.class)
    @RequestMapping(value = "info/modify", method = RequestMethod.PUT)
    public Object modifyReply(@RequestBody DetailReplyDTO detailReplyDTO) throws Exception {
        Integer replyID = detailReplyDTO.getID();
        Integer authorID = detailReplyDTO.getAuthorID();
        String title = detailReplyDTO.getTitle();
        String content = detailReplyDTO.getContent();
        
        if (!NumberUtil.isPositiveAndValid(replyID) || !NumberUtil.isPositiveAndValid(authorID)) {
            LogUtil.appLog.info(LogUtil.getMsg("wrong input for: replyID=" + replyID + ", authorID=" + authorID));
            throw new ControllerException(ErrorType.INVALID_INPUT_PARAM);
        }

        Map<String, Boolean> modifyResult = new HashMap<>();
        modifyResult.put("result", detailReplyService.updateReply(replyID, title, content, authorID));
        return modifyResult;
    }

    @ApiOperation(httpMethod = "DELETE", value = "delete exist reply", response = Map.class)
    @RequestMapping(value = "info/delete", method = RequestMethod.DELETE)
    public Object deleteReply(@RequestBody DetailReplyDTO detailReplyDTO) throws Exception {
        Integer replyID = detailReplyDTO.getID();
        Integer authorID = detailReplyDTO.getAuthorID();
        
        if (!NumberUtil.isPositiveAndValid(replyID) || !NumberUtil.isPositiveAndValid(authorID)) {
            LogUtil.appLog.info(LogUtil.getMsg("wrong input for: replyID=" + replyID + ", userID=" + authorID));
            throw new ControllerException(ErrorType.INVALID_INPUT_PARAM);
        }

        Map<String, Boolean> deleteResult = new HashMap<>();
        deleteResult.put("result", detailReplyService.deleteReply(replyID, authorID));
        return deleteResult;
    }
}
