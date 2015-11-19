package penchit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import penchit.Constants;
import penchit.exception.ApplicationException;
import penchit.model.Course;
import penchit.model.Group;
import penchit.service.AdminService;
import penchit.vo.CourseVO;
import penchit.vo.GroupVO;
import penchit.vo.ResponseObject;

@Controller
@RequestMapping("/")
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	
	@RequestMapping(value = "/admin/groups.html",method = RequestMethod.GET)
    public ModelAndView getGroupsPage() {
        return new ModelAndView("adminGroupsPage");
    }
	@RequestMapping(value = "/admin/courses.html",method = RequestMethod.GET)
    public ModelAndView getCoursePage() {
        return new ModelAndView("adminCoursePage");
    }
	@RequestMapping(value="/loadAll", method = RequestMethod.GET)  
	public @ResponseBody ResponseObject getAllGroups() throws ApplicationException { 
		ResponseObject responseObject = new ResponseObject();
		try {
			List<GroupVO> groups = adminService.findAllGroups();
			if (!CollectionUtils.isEmpty(groups)) {
				responseObject.setResult(groups);
				responseObject.setStatus(Constants.SUCCESS);
			}else {
				responseObject.setStatus(Constants.EMPTY);
			}
			
		} catch (ApplicationException e) {
			responseObject.setStatus(Constants.FAILURE);
			throw new ApplicationException();
		}
		return responseObject;  
	}
	@RequestMapping(value = "/saveGroup", method = RequestMethod.POST)
    public @ResponseBody ResponseObject saveGroup(@RequestBody GroupVO courseGroupVO) throws ApplicationException {  
		ResponseObject responseObject = new ResponseObject();
		try {
			GroupVO groups = adminService.findGroupByName(courseGroupVO.getGroupName());
			if (groups != null && groups.getGroupId() != null) {
				courseGroupVO.setGroupId(groups.getGroupId());
			}
			Group courseGroup = adminService.saveGroup(courseGroupVO);
			if (courseGroup != null && courseGroup.getId() != null) {
				List<GroupVO> groupList = adminService.findAllGroups();
				responseObject.setResult(groupList);
				responseObject.setStatus(Constants.SUCCESS);
			}else {
				responseObject.setStatus(Constants.FAILURE);
			}
		} catch (ApplicationException e) {
			responseObject.setStatus(Constants.FAILURE);
			throw new ApplicationException(e);
		}
        return responseObject;
    }
	@RequestMapping(value="/deleteGroup", method = RequestMethod.GET)  
	public @ResponseBody ResponseObject deleteGroup(@RequestParam String groupName) throws ApplicationException { 
		ResponseObject responseObject = new ResponseObject();
		try {
			GroupVO groups = adminService.findGroupByName(groupName);
			if (groups != null) {
				Integer groupId = groups.getGroupId();
				if (groupId != null){
					adminService.deleteGroup(groupId);
					List<GroupVO> groupList = adminService.findAllGroups();
					responseObject.setResult(groupList);
					responseObject.setStatus(Constants.SUCCESS);
				}
			}else {
				responseObject.setStatus(Constants.FAILURE);
			}
			
		} catch (ApplicationException e) {
			responseObject.setStatus(Constants.FAILURE);
			throw new ApplicationException();
		}
		return responseObject;  
	}
	@RequestMapping(value="/loadAllCourses", method = RequestMethod.GET)  
	public @ResponseBody ResponseObject getAllCourses() throws ApplicationException { 
		ResponseObject responseObject = new ResponseObject();
		try {
			List<CourseVO> courses = adminService.findAllCourses();
			if (!CollectionUtils.isEmpty(courses)) {
				responseObject.setResult(courses);
				responseObject.setStatus(Constants.SUCCESS);
			}else {
				responseObject.setStatus(Constants.EMPTY);
			}
			
		} catch (ApplicationException e) {
			responseObject.setStatus(Constants.FAILURE);
			throw new ApplicationException();
		}
		return responseObject;  
	}
	@RequestMapping(value="/loadCoursesByGroupName", method = RequestMethod.POST)  
	public @ResponseBody ResponseObject getCoursesByGroupName(@RequestParam("groupName") String groupName) throws ApplicationException { 
		ResponseObject responseObject = new ResponseObject();
		try {
			List<CourseVO> courses = adminService.findCoursesByGroupName(groupName);
			if (!CollectionUtils.isEmpty(courses)) {
				responseObject.setResult(courses);
				responseObject.setStatus(Constants.SUCCESS);
			}else {
				responseObject.setStatus(Constants.EMPTY);
			}
			
		} catch (ApplicationException e) {
			responseObject.setStatus(Constants.FAILURE);
			throw new ApplicationException();
		}
		return responseObject;  
	}
	
	@RequestMapping(value = "/saveCourse", method = RequestMethod.POST)
    public @ResponseBody ResponseObject saveCourse(HttpServletRequest request) throws ApplicationException, IOException {  
		ResponseObject responseObject = new ResponseObject();
		
		 MultipartHttpServletRequest mRequest;
		 
	        
		try {
			 mRequest = (MultipartHttpServletRequest) request;
			 String courseName = mRequest.getParameter("courseName");
			 String courseDesc = mRequest.getParameter("courseDesc");
			 String courseSyllabus = mRequest.getParameter("courseSyllabus");
			 String coursePrice = mRequest.getParameter("coursePrice");
			 String courseVersion = mRequest.getParameter("version");
			 String courseLogoName = mRequest.getParameter("courseLogoName");
			 String groupName = mRequest.getParameter("groupName");
			 
			 CourseVO courseVO = new CourseVO();
			 courseVO.setCourseName(courseName);
			 courseVO.setCourseDesc(courseDesc);
			 courseVO.setCourseLogoName(courseLogoName);
			 courseVO.setCoursePrice(Integer.parseInt(coursePrice));
			 courseVO.setVersion(courseVersion);
			 courseVO.setGroupName(groupName);
			 courseVO.setCourseSyllabus(courseSyllabus);
			 MultipartFile mFile = mRequest.getFile("file");
			 courseVO.setCourseLogo(mFile.getBytes());
			 CourseVO tempCourse = adminService.findCourseByName(courseName);
			 if (tempCourse != null && tempCourse.getCourseId() != null) {
				courseVO.setCourseId(tempCourse.getCourseId());
			 }
			 Course course = adminService.saveCourse(courseVO);
			 if (course != null && course.getId() != null) {
					List<CourseVO> courses = adminService.findAllCourses();
					responseObject.setResult(courses);
					responseObject.setStatus(Constants.SUCCESS);
			  } else {
					responseObject.setStatus(Constants.FAILURE);
			  }
				
			
		} catch (ApplicationException e) {
			responseObject.setStatus(Constants.FAILURE);
			throw new ApplicationException(e);
		}
        return responseObject;
    }
	@RequestMapping(value = "/displayImage")
    public @ResponseBody ResponseObject getImage(@RequestParam("courseId") String courseId) throws IOException, NumberFormatException, ApplicationException {
		ResponseObject responseObject = new ResponseObject();
        CourseVO courseVO;
		try {
			courseVO = adminService.findCourseById(Integer.parseInt(courseId));
			responseObject.setStatus(Constants.SUCCESS);
			responseObject.setResult(courseVO.getCourseLogo());
		} catch (ApplicationException e) {
			responseObject.setStatus(Constants.FAILURE);
			throw new ApplicationException(e);
		}
       
        return responseObject;
    }
}
