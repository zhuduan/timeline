package com.timeline.service;

import com.timeline.model.DTO.DetailReplyDTO;
import com.timeline.support.common.ServiceException;

import java.util.List;
import java.util.Map;

public interface DetailReplyService {

  List<DetailReplyDTO> getReplyByDetailID(Integer detailID, Integer pageNum, Integer pageSize);

  List<DetailReplyDTO> getReplyWithUserInfoByDetailID(Integer detailID, Integer pageNum, Integer pageSize);

  Boolean addReply(Integer detailID, String title, String content, Integer authorID, Integer toReplyID) throws ServiceException;

  Boolean deleteReply(Integer relyID, Integer authorID) throws ServiceException;

  Boolean updateReply(Integer relyID, String title, String content, Integer authorID) throws ServiceException;

  Integer getTotalCount(Integer detailID);
}
