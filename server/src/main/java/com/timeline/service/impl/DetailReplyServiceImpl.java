package com.timeline.service.impl;

import com.github.pagehelper.PageHelper;
import com.timeline.model.DTO.DetailReplyDTO;
import com.timeline.model.PO.DetailReply;
import com.timeline.repository.DetailReplyDAO;
import com.timeline.service.DetailReplyService;
import com.timeline.util.ConvertUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailReplyServiceImpl implements DetailReplyService {

    @Autowired
    private DetailReplyDAO detailReplyDAO;

    @Override
    public List<DetailReplyDTO> getReplyByDetailID(Integer detailID, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<DetailReply> detailReplyList = detailReplyDAO.getDetailReplyByDetailID(detailID);
        return ConvertUtils.convert(detailReplyList, DetailReplyDTO.class);
    }

    @Override
    public Boolean addReply(Integer detailID, String title, String content, Integer authorID) {
        DetailReply reply = new DetailReply(detailID, title, content, authorID);
        Integer addNum = detailReplyDAO.saveInfo(reply);
        return addNum>0;
    }

    @Override
    public Boolean deleteReply(Integer relyID) {
        return null;
    }

    @Override
    public Boolean updateReply(Integer relyID, String title, String content) {
        return null;
    }
}
