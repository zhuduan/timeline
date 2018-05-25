package com.timeline.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.timeline.model.DTO.DetailReplyDTO;
import com.timeline.model.DTO.UserDTO;
import com.timeline.model.PO.DetailReply;
import com.timeline.repository.DetailReplyDAO;
import com.timeline.service.DetailReplyService;
import com.timeline.service.UserService;
import com.timeline.support.common.EnumAction;
import com.timeline.support.common.ErrorType;
import com.timeline.support.common.ServiceException;
import com.timeline.support.utils.ConvertUtils;
import com.timeline.support.utils.LogUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DetailReplyServiceImpl implements DetailReplyService {

    @Autowired
    private DetailReplyDAO detailReplyDAO;

    @Autowired
    private UserService userService;

    @Override
    public List<DetailReplyDTO> getReplyByDetailID(Integer detailID, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<DetailReply> detailReplyList = detailReplyDAO.getMainReplyByDetailID(detailID);
        return ConvertUtils.convert(detailReplyList, DetailReplyDTO.class);
    }

    @Override
    public List<DetailReplyDTO> getReplyWithUserInfoByDetailID(Integer detailID, Integer pageNum, Integer pageSize) {
        List<DetailReplyDTO> replyList = getReplyByDetailID(detailID, pageNum, pageSize);
        replyList.forEach((reply) -> {
            reply.setSubReplies(getSubReply(reply.getDetailID(), reply.getID()));
            reply.setUser(ConvertUtils.convert(userService.getUserByID(reply.getAuthorID()), UserDTO.class));
        });
        return replyList;
    }

    @Override
    public Boolean addReply(Integer detailID, String title, String content, Integer authorID, Integer toReplyID)
            throws ServiceException {

        // todo: may change to the aspect authority check
        if (!userService.isAuthorised(authorID, EnumAction.REPLY_ADD)) {
            LogUtil.svcLog.info(LogUtil.getMsg("no authority to add reply: userID=" + authorID));
            throw new ServiceException(ErrorType.INVALID_INPUT_PARAM);
        }

        DetailReply reply = new DetailReply(detailID, title, content, authorID, toReplyID);
        Integer addNum = detailReplyDAO.saveInfo(reply);
        return addNum > 0;
    }

    @Override
    public Boolean deleteReply(Integer replyID, Integer userID) throws ServiceException {
        if (!userService.isAuthorised(userID, EnumAction.REPLY_DELETE)) {
            LogUtil.svcLog.info(LogUtil.getMsg("no authority to delete reply: userID=" + userID));
            throw new ServiceException(ErrorType.INVALID_INPUT_PARAM);
        }

        Integer delNum = detailReplyDAO.deleteInfo(replyID);
        return delNum > 0;
    }

    @Override
    public Boolean updateReply(Integer replyID, String title, String content, Integer userID) throws ServiceException {
        if (!userService.isAuthorised(userID, EnumAction.REPLY_UPDATE)) {
            LogUtil.svcLog.info(LogUtil.getMsg("no authority to update reply: userID=" + userID));
            throw new ServiceException(ErrorType.INVALID_INPUT_PARAM);
        }

        title = StringUtils.isEmpty(title) ? null : title;
        content = StringUtils.isEmpty(content) ? null : content;

        DetailReply reply = new DetailReply(null, title, content, null);
        reply.setId(replyID);
        Integer modifyNum = detailReplyDAO.updateInfo(reply);
        return modifyNum > 0;
    }

    private List<DetailReplyDTO> getSubReply(Integer detailID, Integer toReplyID) {
        List<DetailReplyDTO> detailReplyList = ConvertUtils.convert(
                detailReplyDAO.getSubReplyByDetailID(detailID, toReplyID), DetailReplyDTO.class);
        detailReplyList.forEach((reply) -> {
            reply.setSubReplies(getSubReply(reply.getDetailID(), reply.getID()));
            reply.setUser(ConvertUtils.convert(userService.getUserByID(reply.getAuthorID()), UserDTO.class));
        });
        return detailReplyList;
    }
}
