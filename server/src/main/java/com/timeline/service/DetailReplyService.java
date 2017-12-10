package com.timeline.service;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.timeline.model.DTO.DetailReplyDTO;

import java.util.List;

public interface DetailReplyService {

    List<DetailReplyDTO> getReplyByDetailID(Integer detailID, Integer pageNum, Integer pageSize);

    Boolean addReply(Integer detailID, String title, String content, Integer authorID);

    Boolean deleteReply(Integer relyID);

    Boolean updateReply(Integer relyID, String title, String content);
}
