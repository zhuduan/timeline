package com.timeline.service;

import java.util.List;

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
	public List<Detail> getDetailsBySubjectID(Pageable pageable, Integer subjectID){
		
        List<Detail> details = detailDAO.getDetailBySubjectID(subjectID);
        return details;
    }
}
