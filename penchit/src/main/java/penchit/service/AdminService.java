package penchit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import penchit.AdminHelper;
import penchit.exception.ApplicationException;
import penchit.model.Course;
import penchit.model.Group;
import penchit.repository.CourseRepository;
import penchit.repository.GroupRepository;
import penchit.vo.CourseVO;
import penchit.vo.GroupVO;



@Service
public class AdminService {
	
	@Autowired
	public GroupRepository groupRepository;
	
	@Autowired
	public CourseRepository courseRepository;

   public List<CourseVO> findAllCourses() throws ApplicationException {
	   List<CourseVO> courseVOList = null;
	try {
		List<Course> courseList  = (List<Course>)courseRepository.findAll();
		courseVOList = AdminHelper.convertCourseListDTOToVO(courseList);
	} catch (Exception e) {
		throw new ApplicationException();
	}
      return courseVOList;
   }
   public List<GroupVO> findAllGroups() throws ApplicationException {
	   List<GroupVO> courseGroupVO = null;
	try {
		List<Group> courseGroup  = (List<Group>)groupRepository.findAll();
		courseGroupVO = AdminHelper.convertGroupListDTOToVO(courseGroup);
	} catch (Exception e) {
		throw new ApplicationException();
	}
      return courseGroupVO;
   }
   public GroupVO findGroupByName(String groupName) throws ApplicationException {
	   GroupVO courseGroupVO = null;
	try {
		List<Group> courseGroup  = (List<Group>)groupRepository.findByName(groupName);
		if (!CollectionUtils.isEmpty(courseGroup)) {
			courseGroupVO = AdminHelper.convertGroupListDTOToVO(courseGroup).get(0);
		}
	} catch (Exception e) {
		throw new ApplicationException(e);
	}
      return courseGroupVO;
   }
   public Group saveGroup(GroupVO courseGroupVO) throws ApplicationException {
	   Group courseGroup = null;
	try {
		courseGroup = AdminHelper.convertGroupVOToDTO(courseGroupVO);
		courseGroup = groupRepository.save(courseGroup);
	} catch (Exception e) {
		throw new ApplicationException();
	}
	   return courseGroup;
	}
   public Group deleteGroup(Integer groupId) throws ApplicationException {
	   Group courseGroup = null;
	try {
		groupRepository.delete(groupId);
	} catch (Exception e) {
		throw new ApplicationException();
	}
	   return courseGroup;
	}
}
