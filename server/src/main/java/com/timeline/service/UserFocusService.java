package com.timeline.service;

import com.timeline.model.DTO.UserFocusDTO;
import com.timeline.support.common.ServiceException;

import java.util.List;

public interface UserFocusService {

  List<UserFocusDTO> getFocusListByUID(Integer UID, Integer pageNum, Integer pageSize);

  Boolean focusSubject(Integer userID, Integer subjectID) throws ServiceException;

  Boolean unFocusSubject(Integer userID, Integer subjectID) throws ServiceException;

  Boolean isFocusSubject(Integer userID, Integer subjectID);
}
