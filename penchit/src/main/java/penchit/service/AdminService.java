package penchit.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import penchit.AdminHelper;
import penchit.exception.ApplicationException;
import penchit.model.ContactInfo;
import penchit.model.Course;
import penchit.model.Group;
import penchit.repository.ContactInfoRepository;
import penchit.repository.CourseRepository;
import penchit.repository.GroupRepository;
import penchit.vo.ContactInfoVO;
import penchit.vo.CourseVO;
import penchit.vo.GroupVO;



@Service
public class AdminService {
	
	@Autowired
	public GroupRepository groupRepository;
	@Autowired
	public ContactInfoRepository contactInfoRepository;
	
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
   public List<CourseVO> findCoursesByGroupName(String groupName) throws ApplicationException {
	   List<CourseVO> courseVOList = null;
	try {
		List<Group> courseGroup  = (List<Group>)groupRepository.findByName(groupName);
		if (!CollectionUtils.isEmpty(courseGroup)) {
			Group group = courseGroup.get(0);
			List<Course> courses = courseRepository.findCoursesByGroupId(group.getId());
			courseVOList = AdminHelper.convertCourseListDTOToVO(courses);
		}
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
   public void deleteGroup(Integer groupId) throws ApplicationException {
		try {
			groupRepository.delete(groupId);
		} catch (Exception e) {
			throw new ApplicationException();
		}
	}
   public Course saveCourse(CourseVO courseVO) throws ApplicationException {
	   Course course = null;
	   String groupName = courseVO.getGroupName();
	   Set<Group> groups = new HashSet<Group>();
	try {
		List<Group> group  = (List<Group>)groupRepository.findByName(groupName);
		course = AdminHelper.convertCourseVOToDTO(courseVO);
		groups.addAll(group);
		course.setGroups(groups);
		course = courseRepository.save(course);
	} catch (Exception e) {
		throw new ApplicationException();
	}
	   return course;
	}
   public CourseVO findCourseById(Integer courseId) throws ApplicationException {
	   CourseVO courseVO = null;
	try {
		Course course  = (Course)courseRepository.findOne(courseId);
		if (course != null) {
			courseVO = AdminHelper.convertCourseDTOToVO(course);
		}
	} catch (Exception e) {
		throw new ApplicationException(e);
	}
      return courseVO;
   }
   public CourseVO findCourseByName(String courseName) throws ApplicationException {
	   CourseVO courseVO = null;
	try {
		List<Course> course  = (List<Course>)courseRepository.findByName(courseName);
		if (!CollectionUtils.isEmpty(course)) {
			courseVO = AdminHelper.convertCourseListDTOToVO(course).get(0);
		}
	} catch (Exception e) {
		throw new ApplicationException(e);
	}
      return courseVO;
   }
   public void deleteCourse(Integer courseId) throws ApplicationException {
		try {
			courseRepository.delete(courseId);
		} catch (Exception e) {
			throw new ApplicationException();
		}
	}
   public ContactInfoVO findContactInfo() throws ApplicationException {
	   ContactInfoVO contactInfoVO = null;
	try {
		List<ContactInfo> contactInfoList  = (List<ContactInfo>)contactInfoRepository.findAll();
		if (!CollectionUtils.isEmpty(contactInfoList)) {
			contactInfoVO = AdminHelper.convertContactDTOToVO(contactInfoList.get(0));
		}
	} catch (Exception e) {
		throw new ApplicationException();
	}
      return contactInfoVO;
   }
   public ContactInfo saveContactinfo(ContactInfoVO contactInfoVO) throws ApplicationException {
	   ContactInfo contactInfo = null;
	try {
		contactInfo = AdminHelper.convertContactVOToDTO(contactInfoVO);
		contactInfo = contactInfoRepository.save(contactInfo);
	} catch (Exception e) {
		throw new ApplicationException();
	}
	   return contactInfo;
	}
}
