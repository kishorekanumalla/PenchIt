package penchit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import penchit.Constants;
import penchit.exception.ApplicationException;
import penchit.service.AdminService;
import penchit.vo.CourseVO;
import penchit.vo.GroupVO;
import penchit.vo.ResponseObject;

@Controller
@RequestMapping("/")
public class MainController {
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value = "/admin/mainScreen.html",method = RequestMethod.GET)
    public ModelAndView getMainPage() {
        return new ModelAndView("mainPage");
    }
	@RequestMapping(value="/loadMainPage", method = RequestMethod.GET)  
	public @ResponseBody ResponseObject loadMainPage() throws ApplicationException { 
		ResponseObject responseObject = new ResponseObject();
		try {
			List<GroupVO> groupVOList = adminService.findAllGroups();
			for(GroupVO groupVO :groupVOList) {
				System.out.println("Group Name >>>>>>"+groupVO.getGroupName());
				System.out.println("Division >>>>>>"+groupVO.getDivision());
				if (groupVO.getCourses() != null) {
					for(CourseVO  courseVO: groupVO.getCourses()){
						System.out.println("courses >>>>>>>>>>>>>" + courseVO.getCourseName());
					}
				}
			}
			
		} catch (Exception e) {
			responseObject.setStatus(Constants.FAILURE);
			throw new ApplicationException();
		}
		return responseObject;  
	}

}
