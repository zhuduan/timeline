package com.timeline.service;

import java.util.ArrayList;
import java.util.List;

import com.timeline.model.DTO.DetailDTO;
import com.timeline.util.ConvertUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.timeline.model.PO.Detail;
import com.timeline.repository.DetailDAO;

@Service
public class DetailServiceImpl implements DetailService{

    @Autowired
    private DetailDAO detailDAO;

    /***
     *
     * @param subjectID
     * @return detailDTOs or EmptyList if no such detail under subject
     */
	public List<DetailDTO> getDetailsBySubjectID(Integer subjectID){
        List<Detail> details = detailDAO.getDetailBySubjectID(subjectID);
        return ConvertUtils.convert(details, DetailDTO.class);
    }
}
