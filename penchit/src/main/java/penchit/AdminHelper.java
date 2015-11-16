package penchit;

import java.util.ArrayList;
import java.util.List;

import penchit.exception.ApplicationException;
import penchit.model.Course;
import penchit.model.Group;
import penchit.vo.CourseVO;
import penchit.vo.GroupVO;

public class AdminHelper {
	
	
	public static Group convertGroupVOToDTO(GroupVO courseGroupVO) throws ApplicationException {
		Group group;
		try {
			group = new Group();
			group.setName(courseGroupVO.getGroupName());
			group.setDivisions(courseGroupVO.getDivision());
			group.setId(courseGroupVO.getGroupId());
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
				List<GroupVO> groupVO = convertGroupListDTOToVO(new ArrayList<Group>(course.getGroups()));
				courseVO.setGroupVOList(groupVO);
				courseVO.setVersion(course.getVersion());
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
			List<GroupVO> groupVO = convertGroupListDTOToVO(new ArrayList<Group>(course.getGroups()));
			courseVO.setGroupVOList(groupVO);
			courseVO.setVersion(course.getVersion());
		} catch (Exception e) {
			throw new ApplicationException();	
		}
	return courseVO;
}
}
