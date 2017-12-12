package com.timeline.service;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.timeline.common.ServiceException;
import com.timeline.model.DTO.DetailReplyDTO;

import java.util.List;

public interface DetailReplyService {

    List<DetailReplyDTO> getReplyByDetailID(Integer detailID, Integer pageNum, Integer pageSize);

    Boolean addReply(Integer detailID, String title, String content, Integer authorID, Integer userID) throws ServiceException;

    Boolean deleteReply(Integer relyID, Integer userID) throws ServiceException;

    Boolean updateReply(Integer relyID, String title, String content, Integer userID) throws ServiceException;
}
