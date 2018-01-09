package com.timeline.service.impl;

import com.github.pagehelper.PageHelper;
import com.timeline.common.CommonConfig;
import com.timeline.model.DTO.UserFocusDTO;
import com.timeline.model.PO.UserFocus;
import com.timeline.repository.UserFocusDAO;
import com.timeline.service.UserFocusService;
import com.timeline.util.ConvertUtils;
import com.timeline.util.NumberUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserFocusServiceImpl implements UserFocusService {

    @Autowired
    private UserFocusDAO userFocusDAO;

    @Override
    public List<UserFocusDTO> getFocusListByUID(Integer userID, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<UserFocus> focusList = userFocusDAO.getFocusListByUID(userID, CommonConfig.DATA_VALID);
        return ConvertUtils.convert(focusList, UserFocusDTO.class);
    }

    @Override
    public Boolean focusSubject(Integer userID, Integer subjectID) {
        return ( userFocusDAO.focusSubject(userID, subjectID) >= 0 );
    }

    @Override
    public Boolean unFocusSubject(Integer userID, Integer subjectID) {
        return ( userFocusDAO.unFocusSubject(userID, subjectID) >= 0 );
    }

    @Override
    public Boolean isFocusSubject(Integer userID, Integer subjectID) {
        UserFocus userFocus = userFocusDAO.isFocusedSubject(userID, subjectID, CommonConfig.DATA_VALID);
        return ( userFocus!=null && NumberUtil.isPositiveAndValid(userFocus.getId()));
    }
}
