package com.timeline.service;

import com.timeline.model.DTO.DetailDTO;
import com.timeline.repository.DetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DetailService {

    @Autowired
    private DetailRepository detailRepository;

    /***
     *
     * @param subjectID
     * @return detailDTOs or EmptyList if no such detail under subject
     */
    public List<DetailDTO> getDetailsBySubjectID(Integer subjectID){
        if ( subjectID==null || subjectID==0 ){
            return new ArrayList<>();
        }

        List<DetailDTO> detailDTOs = new ArrayList<>();
//      TODO: mapper the class
        //TODO: add pagingAndSort
//      detailRepository.findBySubjectID(subjectID);
        return detailDTOs;
    }
}
