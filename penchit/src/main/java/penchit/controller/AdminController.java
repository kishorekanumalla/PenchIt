package penchit.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import penchit.Constants;
import penchit.exception.ApplicationException;
import penchit.model.CourseGroup;
import penchit.service.AdminService;
import penchit.vo.CourseGroupVO;
import penchit.vo.ResponseObject;

@Controller
@RequestMapping("/")
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	private Logger logger = Logger.getLogger(AdminController.class);
	
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
			List<CourseGroupVO> groups = adminService.findAllGroups();
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
    public @ResponseBody ResponseObject saveCourseGroup(@RequestBody CourseGroupVO courseGroupVO) throws ApplicationException {  
		ResponseObject responseObject = new ResponseObject();
		try {
			CourseGroupVO groups = adminService.findGroupByName(courseGroupVO.getGroupName());
			if (groups != null && groups.getGroupId() != null) {
				courseGroupVO.setGroupId(groups.getGroupId());
			}
			CourseGroup courseGroup = adminService.saveGroup(courseGroupVO);
			if (courseGroup != null && courseGroup.getId() != null) {
				List<CourseGroupVO> groupList = adminService.findAllGroups();
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
			CourseGroupVO groups = adminService.findGroupByName(groupName);
			if (groups != null) {
				Integer groupId = groups.getGroupId();
				if (groupId != null){
					adminService.deleteGroup(groupId);
					List<CourseGroupVO> groupList = adminService.findAllGroups();
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

}
