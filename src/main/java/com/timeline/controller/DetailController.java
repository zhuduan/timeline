package com.timeline.controller;

import com.timeline.Common.ErrorType;
import com.timeline.Common.ControllerException;
import com.timeline.model.DTO.DetailDTO;
import com.timeline.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping(value="detail")
public class DetailController {

    @Autowired
    private DetailService detailService;

    @RequestMapping(value="list", method= RequestMethod.GET)
    private List<DetailDTO> getDetailListBySubjectID(@PageableDefault(value = 20, sort = { "id" }, direction = Sort.Direction.DESC) Pageable pageable,
                                                     @RequestParam(value = "subjectID",required = true) Integer subjectID) throws Exception{
        if ( subjectID==null || subjectID<=0 || pageable==null ){
            //TODO:
            //      1. should add logs here
            //      2. should add common exception controller
            throw new ControllerException(ErrorType.INVALID_INPUT_PARAM);
        }

        return detailService.getDetailsBySubjectID(pageable, subjectID);
    }
}
