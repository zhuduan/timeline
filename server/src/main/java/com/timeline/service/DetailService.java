package com.timeline.service;

import com.timeline.model.DTO.DetailDTO;
import com.timeline.model.PO.Detail;
import com.timeline.repository.DetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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
    public List<DetailDTO> getDetailsBySubjectID(Pageable pageable, Integer subjectID){
        List<DetailDTO> detailDTOs = new ArrayList<>();
        List<Detail> details = detailRepository.findBysubjectID(pageable, subjectID);
        details.forEach( (po) -> {
            if ( po!=null ) detailDTOs.add(new DetailDTO(po));
        });
        return detailDTOs;
    }
}
