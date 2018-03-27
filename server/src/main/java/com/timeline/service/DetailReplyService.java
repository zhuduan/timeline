package com.timeline.service;

import com.timeline.model.DTO.DetailReplyDTO;
import com.timeline.support.common.ServiceException;

import java.util.List;
import java.util.Map;

public interface DetailReplyService {

  List<DetailReplyDTO> getReplyByDetailID(Integer detailID, Integer pageNum, Integer pageSize);

  List<Map<String, Object>> getReplyWithUserByDetailID(Integer detailID, Integer pageNum, Integer pageSize);

  Boolean addReply(Integer detailID, String title, String content, Integer authorID, Integer userID)
      throws ServiceException;

  Boolean deleteReply(Integer relyID, Integer userID) throws ServiceException;

  Boolean updateReply(Integer relyID, String title, String content, Integer userID) throws ServiceException;
}
