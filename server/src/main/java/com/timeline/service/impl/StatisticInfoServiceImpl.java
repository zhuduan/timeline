package com.timeline.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.timeline.model.PO.StatisticInfo;
import com.timeline.repository.StatisticInfoDAO;
import com.timeline.service.StatisticInfoService;

import java.util.Date;

@Service
public class StatisticInfoServiceImpl implements StatisticInfoService {

  @Autowired
  private StatisticInfoDAO statisticInfoDAO;

  @Override
  public Integer saveInfo(String requestUrl, Integer requestUserID, String requestIP) {
    StatisticInfo statisticInfo = new StatisticInfo();
    statisticInfo.setRequestUrl(requestUrl);
    statisticInfo.setRequestUserId(requestUserID);
    statisticInfo.setRequestIP(requestIP);
    statisticInfo.setRequestDateTime(new Date());

    return statisticInfoDAO.saveInfo(statisticInfo);
  }
}
