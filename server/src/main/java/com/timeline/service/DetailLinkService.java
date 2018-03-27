package com.timeline.service;

import com.timeline.model.DTO.DetailLinkDTO;

import java.util.List;

public interface DetailLinkService {

  List<DetailLinkDTO> getLinksByIDAndLanguage(Integer detailID, Integer languageID, Integer pageNum, Integer pageSize);
}
