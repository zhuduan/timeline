package com.timeline.service;

import com.timeline.model.DTO.DetailReplyDTO;

import java.util.List;

public interface DetailReplyService {

    List<DetailReplyDTO> getDetailReplyByDetailID(Integer detailID, Integer pageNum, Integer pageSize);
}
