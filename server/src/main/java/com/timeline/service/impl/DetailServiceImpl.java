package com.timeline.service.impl;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.timeline.model.DTO.DetailDTO;
import com.timeline.service.DetailService;
import com.timeline.util.ConvertUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.timeline.model.PO.Detail;
import com.timeline.repository.DetailDAO;


@Service
public class DetailServiceImpl implements DetailService {

    @Autowired
    private DetailDAO detailDAO;

    /***
     *
     * @param subjectID
     * @return detailDTOs or EmptyList if no such detail under subject
     */
	public List<DetailDTO> getDetailsBySubjectID(Integer subjectID, Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<Detail> details = detailDAO.getDetailBySubjectID(subjectID);
        return ConvertUtils.convert(details, DetailDTO.class);
    }
}
