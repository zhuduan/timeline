package com.timeline.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.timeline.model.DTO.UserFocusDTO;
import com.timeline.model.PO.UserFocus;
import com.timeline.repository.UserFocusDAO;
import com.timeline.service.UserFocusService;
import com.timeline.service.UserService;
import com.timeline.support.common.CommonConfig;
import com.timeline.support.common.EnumAction;
import com.timeline.support.common.ErrorType;
import com.timeline.support.common.ServiceException;
import com.timeline.support.utils.ConvertUtils;
import com.timeline.support.utils.LogUtil;
import com.timeline.support.utils.NumberUtil;

import java.util.List;

@Service
public class UserFocusServiceImpl implements UserFocusService {

  @Autowired
  private UserFocusDAO userFocusDAO;

  @Autowired
  private UserService userService;

  @Override
  public List<UserFocusDTO> getFocusListByUID(Integer userID, Integer pageNum, Integer pageSize) {
    PageHelper.startPage(pageNum, pageSize);
    List<UserFocus> focusList = userFocusDAO.getFocusListByUID(userID, CommonConfig.DATA_VALID);
    return ConvertUtils.convert(focusList, UserFocusDTO.class);
  }

  @Override
  public Boolean focusSubject(Integer userID, Integer subjectID) throws ServiceException {
    if (!userService.isAuthorised(userID, EnumAction.FOCUS_SUBJECT)) {
      LogUtil.svcLog.info(LogUtil.getMsg("no authority to focus: userID=" + userID));
      throw new ServiceException(ErrorType.INVALID_INPUT_PARAM);
    }
    return (userFocusDAO.focusSubject(userID, subjectID) >= 0);
  }

  @Override
  public Boolean unFocusSubject(Integer userID, Integer subjectID) throws ServiceException {
    if (!userService.isAuthorised(userID, EnumAction.FOCUS_SUBJECT)) {
      LogUtil.svcLog.info(LogUtil.getMsg("no authority to unfocus: userID=" + userID));
      throw new ServiceException(ErrorType.INVALID_INPUT_PARAM);
    }
    return (userFocusDAO.unFocusSubject(userID, subjectID) >= 0);
  }

  @Override
  public Boolean isFocusSubject(Integer userID, Integer subjectID) {
    UserFocus userFocus = userFocusDAO.isFocusedSubject(userID, subjectID, CommonConfig.DATA_VALID);
    return (userFocus != null && NumberUtil.isPositiveAndValid(userFocus.getId()));
  }
}
