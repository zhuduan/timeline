package com.timeline.service;

import com.timeline.model.DTO.UserFocusDTO;

import java.util.List;

public interface UserFocusService {

    List<UserFocusDTO> getFocusListByUID(Integer UID, Integer pageNum, Integer pageSize);

}
