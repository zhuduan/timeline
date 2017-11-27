package com.timeline.service.impl;

import com.github.pagehelper.PageHelper;
import com.timeline.model.DTO.DetailDTO;
import com.timeline.model.PO.Detail;
import com.timeline.repository.DetailDAO;
import com.timeline.service.DetailService;
import com.timeline.util.ConvertUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


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

    @Override
    public DetailDTO getDetailByID(Integer detailID) {
        Detail detail = detailDAO.getDetailByID(detailID);
	    return ConvertUtils.convert(detail, DetailDTO.class);
    }
}
