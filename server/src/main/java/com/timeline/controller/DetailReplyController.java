package com.timeline.controller;

import static com.timeline.support.common.CommonConfig.PAGE_SIZE;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.timeline.service.DetailReplyService;
import com.timeline.support.common.ControllerException;
import com.timeline.support.common.ErrorType;
import com.timeline.support.utils.LogUtil;
import com.timeline.support.utils.NumberUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

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
    return detailReplyService.getReplyWithUserByDetailID(detailID, pageNum, pageSize);
  }

  @ApiOperation(httpMethod = "POST", value = "add new reply", response = Map.class)
  @RequestMapping(value = "info/new", method = RequestMethod.POST)
  public Object addReply( @RequestParam("detailID") Integer detailID,
                          @RequestParam("title") String title,
                          @RequestParam("content") String content,
                          @RequestParam("authorID") Integer authorID,
                          @RequestParam("userID") Integer userID) throws Exception {

    if (!NumberUtil.isPositiveAndValid(detailID)
        || !NumberUtil.isPositiveAndValid(authorID)
        || !NumberUtil.isPositiveAndValid(userID)) {
      LogUtil.appLog.info(LogUtil.getMsg("wrong input for: detailID="
          + detailID + ", authorID=" + authorID + ", userID=" + userID));
      throw new ControllerException(ErrorType.INVALID_INPUT_PARAM);
    }
    if (StringUtils.isEmpty(title) || StringUtils.isEmpty(content)) {
      LogUtil.appLog.info(LogUtil.getMsg("wrong input for: title=" + title + ", content=" + content));
      throw new ControllerException(ErrorType.INVALID_INPUT_PARAM);
    }

    Map<String, Boolean> addResult = new HashMap<>();
    addResult.put("result", detailReplyService.addReply(detailID, title, content, authorID, userID));
    return addResult;
  }

  @ApiOperation(httpMethod = "PUT", value = "modify exist reply", response = Map.class)
  @RequestMapping(value = "info/modify", method = RequestMethod.PUT)
  public Object modifyReply(@RequestParam("replyID") Integer replyID,
      @RequestParam("title") String title,
      @RequestParam("content") String content,
      @RequestParam("userID") Integer userID) throws Exception {
    if (!NumberUtil.isPositiveAndValid(replyID) || !NumberUtil.isPositiveAndValid(userID)) {
      LogUtil.appLog.info(LogUtil.getMsg("wrong input for: replyID=" + replyID + ", userID=" + userID));
      throw new ControllerException(ErrorType.INVALID_INPUT_PARAM);
    }

    Map<String, Boolean> modifyResult = new HashMap<>();
    modifyResult.put("result", detailReplyService.updateReply(replyID, title, content, userID));
    return modifyResult;
  }

  @ApiOperation(httpMethod = "DELETE", value = "delete exist reply", response = Map.class)
  @RequestMapping(value = "info/delete", method = RequestMethod.DELETE)
  public Object deleteReply( @RequestParam("replyID") Integer replyID,
                             @RequestParam("userID") Integer userID ) throws Exception {

    if (!NumberUtil.isPositiveAndValid(replyID) || !NumberUtil.isPositiveAndValid(userID)) {
      LogUtil.appLog.info(LogUtil.getMsg("wrong input for: replyID=" + replyID + ", userID=" + userID));
      throw new ControllerException(ErrorType.INVALID_INPUT_PARAM);
    }

    Map<String, Boolean> deleteResult = new HashMap<>();
    deleteResult.put("result", detailReplyService.deleteReply(replyID, userID));
    return deleteResult;
  }
}
