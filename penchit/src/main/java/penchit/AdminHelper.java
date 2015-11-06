package penchit;

import java.util.ArrayList;
import java.util.List;

import penchit.exception.ApplicationException;
import penchit.model.CourseGroup;
import penchit.vo.CourseGroupVO;

public class AdminHelper {
	
	
	public static CourseGroup convertCourseGroupVOToDTO(CourseGroupVO courseGroupVO) throws ApplicationException {
		CourseGroup courseGroup;
		try {
			courseGroup = new CourseGroup();
			courseGroup.setName(courseGroupVO.getGroupName());
			courseGroup.setDivisions(courseGroupVO.getDivision());
			courseGroup.setId(courseGroupVO.getGroupId());
		} catch (Exception e) {
			throw new ApplicationException();	
		}
		return courseGroup;
	}
	public static List<CourseGroupVO> convertCourseGroupListDTOToVO(List<CourseGroup> courseGroup)throws ApplicationException {
		List<CourseGroupVO> courseGroupVOList;
		try {
			courseGroupVOList = new ArrayList<CourseGroupVO>();
			for (CourseGroup cGroup:courseGroup){
				CourseGroupVO courseGroupVO = new CourseGroupVO();
				courseGroupVO.setGroupName(cGroup.getName());
				courseGroupVO.setDivision(cGroup.getDivisions());
				courseGroupVO.setGroupId(cGroup.getId());
				courseGroupVOList.add(courseGroupVO);
			}
		} catch (Exception e) {
			throw new ApplicationException();	
		}
		return courseGroupVOList;
	}
	public static CourseGroupVO convertCourseGroupDTOToVO(CourseGroup courseGroup) throws ApplicationException {
			CourseGroupVO courseGroupVO;
			try {
				courseGroupVO = new CourseGroupVO();
				courseGroupVO.setGroupName(courseGroup.getName());
				courseGroupVO.setDivision(courseGroup.getDivisions());
				courseGroupVO.setGroupId(courseGroup.getId());
			} catch (Exception e) {
				throw new ApplicationException();	
			}
		return courseGroupVO;
	}
}
