package com.timeline.service.impl;

import com.github.pagehelper.PageHelper;
import com.timeline.common.CommonConfig;
import com.timeline.model.DTO.DetailDTO;
import com.timeline.model.DTO.SubjectDTO;
import com.timeline.model.DTO.UserFocusDTO;
import com.timeline.model.PO.Subject;
import com.timeline.repository.SubjectDAO;
import com.timeline.service.DetailService;
import com.timeline.service.SubjectService;
import com.timeline.service.UserFocusService;
import com.timeline.util.ConvertUtils;
import com.timeline.util.NumberUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	private SubjectDAO subjectDAO;
	
	@Autowired
	private DetailService detailService;

	@Autowired
	private UserFocusService userFocusService;
	
	@Override
	public SubjectDTO getSubject(Integer id) {
		
		if(id == null || id <= 0) {
			
			return null;
		}
		
		Subject subject = subjectDAO.getSubjectByID(id);
		SubjectDTO subjectDTO = ConvertUtils.convert(subject,SubjectDTO.class);
		
		//查询出全部时间线返回（时间线一般可能就在10以内，或10-20，暂时可以不考虑分页）
		List<DetailDTO> details = detailService.getDetailsBySubjectID(id, 1, CommonConfig.PAGE_SIZE_ALL);
		subjectDTO.setDetails(details);
		return subjectDTO;
	}

	@Override
	public List<SubjectDTO> getSubjectListByDefault(Integer pageNum, Integer pageSize) {
		// TODO: 根据首页推荐规则，来构建默认列表
		List<Subject> subjects = subjectDAO.getSubjectByValid(CommonConfig.DATA_VALID);
		return ConvertUtils.convert(subjects, SubjectDTO.class);
	}

	@Override
	public List<SubjectDTO> getSubjectListByIDs(List<Integer> idList, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Subject> subjects = subjectDAO.getSubjectBySubjectIDs(idList);
		return ConvertUtils.convert(subjects, SubjectDTO.class);
	}

	@Override
	public List<SubjectDTO> getSubjectListByUserFocus(Integer userID, Integer pageNum, Integer pageSize) {
		// 1. get user focused on Subject ID List
		List<UserFocusDTO> focusList = userFocusService.getFocusListByUID(userID, pageNum, pageSize);

		// 2. then get subject list by IDs
		List<Integer> subjectIDs = new ArrayList<>();
		focusList.stream().filter( userFocusDTO -> NumberUtil.isPositiveAndValid(userFocusDTO.getSubjectID()) )
				.forEach( (userFocusDTO) -> subjectIDs.add(userFocusDTO.getSubjectID()) );
		List<Subject> focusSubjects = new ArrayList<>();
		if ( subjectIDs.size()>0 ){
			focusSubjects = subjectDAO.getSubjectBySubjectIDs(subjectIDs);
		}
		return ConvertUtils.convert(focusSubjects, SubjectDTO.class);
	}

}
