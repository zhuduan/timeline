package com.timeline.service.impl;

import com.github.pagehelper.PageHelper;
import com.timeline.model.DTO.UserFocusDTO;
import com.timeline.model.PO.UserFocus;
import com.timeline.repository.UserFocusDAO;
import com.timeline.service.UserFocusService;
import com.timeline.util.ConvertUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserFocusServiceImpl implements UserFocusService {

    @Autowired
    private UserFocusDAO userFocusDAO;

    @Override
    public List<UserFocusDTO> getFocusListByUID(Integer userID, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<UserFocus> focusList = userFocusDAO.getFocusListByUID(userID);
        return ConvertUtils.convert(focusList, UserFocusDTO.class);
    }
}
