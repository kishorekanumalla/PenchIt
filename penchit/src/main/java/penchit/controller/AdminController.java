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
import penchit.model.ContactInfo;
import penchit.model.Course;
import penchit.model.Group;
import penchit.service.AdminService;
import penchit.vo.ContactInfoVO;
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
	@RequestMapping(value = "/admin/contact.html",method = RequestMethod.GET)
    public ModelAndView getContactPage() {
        return new ModelAndView("adminContactPage");
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
    public @ResponseBody ResponseObject saveCourseLogo(@RequestBody CourseVO courseVO) throws ApplicationException, IOException {  
		ResponseObject responseObject = new ResponseObject();
		try {
			 CourseVO tempCourse = adminService.findCourseByName(courseVO.getCourseName());
			 if (tempCourse != null && tempCourse.getCourseId() != null) {
				 courseVO.setCourseId(tempCourse.getCourseId());
				 courseVO.setCourseLogo(tempCourse.getCourseLogo());
				 courseVO.setCourseLogoName(tempCourse.getCourseLogoName());
			 }
			 Course course = adminService.saveCourse(courseVO);
			 if (course != null && course.getId() != null) {
				 List<CourseVO> courses = adminService.findCoursesByGroupName(courseVO.getGroupName());
			     responseObject.setResult(courses);
				 responseObject.setStatus(Constants.SUCCESS);
			  } else {
					responseObject.setStatus(Constants.FAILURE);
			  }
				
			
		} catch (Exception e) {
			responseObject.setStatus(Constants.FAILURE);
			throw new ApplicationException(e);
		}
        return responseObject;
    }
	
	@RequestMapping(value = "/saveCourseLogo", method = RequestMethod.POST)
    public @ResponseBody ResponseObject saveCourseLogo(@RequestParam("file") MultipartFile file, @RequestParam("courseId") Integer courseId, @RequestParam("groupName") String groupName) throws ApplicationException, IOException {  
		ResponseObject responseObject = new ResponseObject();
		try {
			 CourseVO tempCourse = adminService.findCourseById(courseId);
			 if (tempCourse != null && tempCourse.getCourseId() != null) {
				 tempCourse.setGroupName(groupName);
				 tempCourse.setCourseLogo(file.getBytes());
				 Course course = adminService.saveCourse(tempCourse);
				 if (course != null && course.getId() != null) {
					List<CourseVO> courses = adminService.findCoursesByGroupName(groupName);
					responseObject.setResult(courses);
					responseObject.setStatus(Constants.SUCCESS);
				 } else {
					responseObject.setStatus(Constants.FAILURE);
				 }
			 }
		} catch (Exception e) {
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
	@RequestMapping(value="/deleteCourse", method = RequestMethod.GET)  
	public @ResponseBody ResponseObject deleteCourse(@RequestParam Integer courseId,@RequestParam String groupName) throws ApplicationException { 
		ResponseObject responseObject = new ResponseObject();
		try {
			if (courseId != null){
				adminService.deleteCourse(courseId);
				List<CourseVO> courseList = adminService.findCoursesByGroupName(groupName);
				responseObject.setResult(courseList);
				responseObject.setStatus(Constants.SUCCESS);
		    } else {
				responseObject.setStatus(Constants.FAILURE);
			}
			
		} catch (ApplicationException e) {
			responseObject.setStatus(Constants.FAILURE);
			throw new ApplicationException();
		}
		return responseObject;  
	}
	@RequestMapping(value="/loadContactInfo", method = RequestMethod.GET)  
	public @ResponseBody ResponseObject loadContactInfo() throws ApplicationException { 
		ResponseObject responseObject = new ResponseObject();
		try {
			ContactInfoVO contactInfoVO = adminService.findContactInfo();
			if (contactInfoVO != null) {
				responseObject.setResult(contactInfoVO);
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
	@RequestMapping(value = "/saveContact", method = RequestMethod.POST)
    public @ResponseBody ResponseObject saveContactInfo(@RequestBody ContactInfoVO contactInfoVO) throws ApplicationException {  
		ResponseObject responseObject = new ResponseObject();
		try {
			ContactInfo contactInfo = adminService.saveContactinfo(contactInfoVO);
			responseObject.setResult(contactInfo);
			responseObject.setStatus(Constants.SUCCESS);
		} catch (ApplicationException e) {
			responseObject.setStatus(Constants.FAILURE);
			throw new ApplicationException(e);
		}
        return responseObject;
    }
}
