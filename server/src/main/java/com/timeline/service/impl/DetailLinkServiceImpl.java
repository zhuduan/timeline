package com.timeline.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.timeline.model.DTO.DetailLinkDTO;
import com.timeline.model.PO.DetailLink;
import com.timeline.repository.DetailLinkDAO;
import com.timeline.service.DetailLinkService;
import com.timeline.support.utils.ConvertUtils;

import java.util.List;

@Service
public class DetailLinkServiceImpl implements DetailLinkService {

  @Autowired
  private DetailLinkDAO detailLinkDAO;

  @Override
  public List<DetailLinkDTO> getLinksByIDAndLanguage(Integer detailID, Integer languageID, Integer pageNum,
      Integer pageSize) {
    PageHelper.startPage(pageNum, pageSize);
    List<DetailLink> detailLinks = detailLinkDAO.getListByIDAndLanguage(detailID, languageID);
    return ConvertUtils.convert(detailLinks, DetailLinkDTO.class);
  }
}
