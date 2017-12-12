package com.timeline.service.impl;

import com.github.pagehelper.PageHelper;
import com.timeline.common.EnumAction;
import com.timeline.common.ErrorType;
import com.timeline.common.ServiceException;
import com.timeline.model.DTO.DetailReplyDTO;
import com.timeline.model.PO.DetailReply;
import com.timeline.repository.DetailReplyDAO;
import com.timeline.service.DetailReplyService;
import com.timeline.service.UserService;
import com.timeline.util.ConvertUtils;
import com.timeline.util.LogUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        List<DetailReply> detailReplyList = detailReplyDAO.getDetailReplyByDetailID(detailID);
        return ConvertUtils.convert(detailReplyList, DetailReplyDTO.class);
    }

    @Override
    public Boolean addReply(Integer detailID, String title, String content, Integer authorID, Integer userID) throws ServiceException{
        if ( authorID!=userID ){
            LogUtil.svcLog.info(LogUtil.getMsg("can not use other's name to add reply: authorID="
                    + authorID + ", userID=" + userID));
            throw new ServiceException(ErrorType.INVALID_INPUT_PARAM);
        }
        if ( !userService.isAuthorised(userID, EnumAction.REPLY_ADD) ){
            LogUtil.svcLog.info(LogUtil.getMsg("no authority to add reply: userID=" + userID));
            throw new ServiceException(ErrorType.INVALID_INPUT_PARAM);
        }
        DetailReply reply = new DetailReply(detailID, title, content, authorID);
        Integer addNum = detailReplyDAO.saveInfo(reply);
        return addNum>0;
    }

    @Override
    public Boolean deleteReply(Integer replyID, Integer userID) throws ServiceException {
        if ( !userService.isAuthorised(userID, EnumAction.REPLY_DELETE) ){
            LogUtil.svcLog.info(LogUtil.getMsg("no authority to delete reply: userID=" + userID));
            throw new ServiceException(ErrorType.INVALID_INPUT_PARAM);
        }

        Integer delNum = detailReplyDAO.deleteInfo(replyID);
        return delNum>0;
    }

    @Override
    public Boolean updateReply(Integer replyID, String title, String content, Integer userID) throws ServiceException {
        if ( !userService.isAuthorised(userID, EnumAction.REPLY_UPDATE) ){
            LogUtil.svcLog.info(LogUtil.getMsg("no authority to update reply: userID=" + userID));
            throw new ServiceException(ErrorType.INVALID_INPUT_PARAM);
        }

        title = StringUtils.isEmpty(title) ? null : title;
        content = StringUtils.isEmpty(content) ? null : title;

        // TODO: check if here can be simplified
        Map<String, Object> updatedInfo = new HashMap<>();
        updatedInfo.put("ID", replyID);
        updatedInfo.put("Title", title);
        updatedInfo.put("Content", content);
        Integer modifyNum = detailReplyDAO.updateInfo(updatedInfo);
        return modifyNum>0;
    }
}
