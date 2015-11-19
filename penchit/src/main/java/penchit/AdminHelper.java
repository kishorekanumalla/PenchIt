package penchit;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import penchit.exception.ApplicationException;
import penchit.model.Course;
import penchit.model.Group;
import penchit.vo.CourseVO;
import penchit.vo.GroupVO;

public class AdminHelper {
	
	
	public static Group convertGroupVOToDTO(GroupVO courseGroupVO) throws ApplicationException {
		Group group;
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		try {
			group = new Group();
			group.setName(courseGroupVO.getGroupName());
			group.setDivisions(courseGroupVO.getDivision());
			group.setId(courseGroupVO.getGroupId());
			group.setCreatedBy(user.getUsername());
			group.setCreatedDate(new Date());
			group.setUpdatedBy(user.getUsername());
			group.setUpdatedDate(new Date());
		} catch (Exception e) {
			throw new ApplicationException();	
		}
		return group;
	}
	public static List<GroupVO> convertGroupListDTOToVO(List<Group> group)throws ApplicationException {
		List<GroupVO> groupVOList;
		try {
			groupVOList = new ArrayList<GroupVO>();
			for (Group cGroup:group){
				GroupVO groupVO = new GroupVO();
				groupVO.setGroupName(cGroup.getName());
				groupVO.setDivision(cGroup.getDivisions());
				groupVO.setGroupId(cGroup.getId());
				groupVOList.add(groupVO);
			}
		} catch (Exception e) {
			throw new ApplicationException();	
		}
		return groupVOList;
	}
	public static GroupVO convertGroupDTOToVO(Group courseGroup) throws ApplicationException {
			GroupVO groupVO;
			try {
				groupVO = new GroupVO();
				groupVO.setGroupName(courseGroup.getName());
				groupVO.setDivision(courseGroup.getDivisions());
				groupVO.setGroupId(courseGroup.getId());
			} catch (Exception e) {
				throw new ApplicationException();	
			}
		return groupVO;
	}
	public static List<CourseVO> convertCourseListDTOToVO(List<Course> courseList) throws ApplicationException {
		List<CourseVO> courseListVO = new ArrayList<CourseVO>();
		try {
			for (Course course:courseList){
				CourseVO courseVO = new CourseVO();
				courseVO.setCourseId(course.getId());
				courseVO.setCourseDesc(course.getDescription());
				courseVO.setCourseLogo(course.getLogo());
				courseVO.setCourseName(course.getName());
				courseVO.setCoursePrice(course.getPrice());
				courseVO.setCourseLogoName(course.getLogoName());
				courseVO.setVersion(course.getVersion());
				courseVO.setCourseSyllabus(course.getSyllabus());
				courseListVO.add(courseVO);
			}
		} catch (Exception e) {
			throw new ApplicationException();	
		}
	return courseListVO;
}
	public static CourseVO convertCourseDTOToVO(Course course) throws ApplicationException {
		CourseVO courseVO = new CourseVO();
		try {
			courseVO.setCourseId(course.getId());
			courseVO.setCourseDesc(course.getDescription());
			courseVO.setCourseLogo(course.getLogo());
			courseVO.setCourseName(course.getName());
			courseVO.setCoursePrice(course.getPrice());
			courseVO.setCourseLogoName(course.getLogoName());
			courseVO.setVersion(course.getVersion());
			courseVO.setCourseSyllabus(course.getSyllabus());
		} catch (Exception e) {
			throw new ApplicationException();	
		}
	return courseVO;
}
	public static Course convertCourseVOToDTO(CourseVO courseVO) throws ApplicationException {
		Course course = new Course();
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		try {
			course.setName(courseVO.getCourseName());
			course.setSyllabus(courseVO.getCourseSyllabus());
			course.setDescription(courseVO.getCourseDesc());
			course.setPrice(courseVO.getCoursePrice());
			course.setLogo(courseVO.getCourseLogo());
			course.setLogoName(courseVO.getCourseLogoName());
			course.setVersion(courseVO.getVersion());
			course.setCreatedBy(user.getUsername());
			course.setCreatedDate(new Date());
			course.setUpdatedBy(user.getUsername());
			course.setUpdatedDate(new Date());
		} catch (Exception e) {
			throw new ApplicationException();	
		}
	return course;
}
}
