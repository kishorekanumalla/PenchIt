package penchit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import penchit.AdminHelper;
import penchit.exception.ApplicationException;
import penchit.model.CourseGroup;
import penchit.repository.CourseGroupRepository;
import penchit.vo.CourseGroupVO;



@Service
public class AdminService {
	
	@Autowired
	public CourseGroupRepository courseGroupRepository;

   public List<CourseGroupVO> findAllGroups() throws ApplicationException {
	   List<CourseGroupVO> courseGroupVO = null;
	try {
		List<CourseGroup> courseGroup  = (List<CourseGroup>)courseGroupRepository.findAll();
		courseGroupVO = AdminHelper.convertCourseGroupListDTOToVO(courseGroup);
	} catch (Exception e) {
		throw new ApplicationException();
	}
      return courseGroupVO;
   }
   public CourseGroupVO findGroupByName(String groupName) throws ApplicationException {
	   CourseGroupVO courseGroupVO = null;
	try {
		List<CourseGroup> courseGroup  = (List<CourseGroup>)courseGroupRepository.findByName(groupName);
		if (!CollectionUtils.isEmpty(courseGroup)) {
			courseGroupVO = AdminHelper.convertCourseGroupListDTOToVO(courseGroup).get(0);
		}
	} catch (Exception e) {
		throw new ApplicationException(e);
	}
      return courseGroupVO;
   }
   public CourseGroup saveGroup(CourseGroupVO courseGroupVO) throws ApplicationException {
	   CourseGroup courseGroup = null;
	try {
		courseGroup = AdminHelper.convertCourseGroupVOToDTO(courseGroupVO);
		courseGroup = courseGroupRepository.save(courseGroup);
	} catch (Exception e) {
		throw new ApplicationException();
	}
	   return courseGroup;
	}
   public CourseGroup deleteGroup(Integer groupId) throws ApplicationException {
	   CourseGroup courseGroup = null;
	try {
		courseGroupRepository.delete(groupId);
	} catch (Exception e) {
		throw new ApplicationException();
	}
	   return courseGroup;
	}
}
