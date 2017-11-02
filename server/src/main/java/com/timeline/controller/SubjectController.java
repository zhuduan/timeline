package com.timeline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.timeline.model.PO.Subject;
import com.timeline.service.SubjectService;

@RestController
@RequestMapping("subject")
@ResponseBody
public class SubjectController {

	@Autowired
	private SubjectService subjectService;
	
	@RequestMapping(value="{subjectID}", method=RequestMethod.GET)
	public Subject getSubject(Integer subjectID) {
		
		return subjectService.getSubject(subjectID);
	}
}
