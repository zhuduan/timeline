package com.timeline.service.impl;

import com.timeline.model.PO.StatisticInfo;
import com.timeline.repository.StatisticInfoDAO;
import com.timeline.service.StatisticInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class StatisticInfoServiceImpl implements StatisticInfoService {

    @Autowired
    private StatisticInfoDAO statisticInfoDAO;

    @Override
    public Integer saveInfo(String requestUrl, Integer requestUserID, String requestIP) {
        StatisticInfo statisticInfo = new StatisticInfo();
        statisticInfo.setRequestUrl(requestUrl);
        statisticInfo.setRequestUserID(requestUserID);
        statisticInfo.setRequestIP(requestIP);
        statisticInfo.setRequestDateTime(new Date());

        return statisticInfoDAO.saveInfo(statisticInfo);
    }
}
