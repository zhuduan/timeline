package com.timeline.service;

import com.timeline.common.ServiceException;
import com.timeline.model.DTO.UserFocusDTO;

import java.util.List;

public interface UserFocusService {

    List<UserFocusDTO> getFocusListByUID(Integer UID, Integer pageNum, Integer pageSize);
    
    Boolean focusSubject(Integer userID, Integer subjectID) throws ServiceException;
    
    Boolean unFocusSubject(Integer userID, Integer subjectID) throws ServiceException;
    
    Boolean isFocusSubject(Integer userID, Integer subjectID);
}
