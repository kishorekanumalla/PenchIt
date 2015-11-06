package penchit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import penchit.model.Role;
import penchit.model.User;
import penchit.service.UserService;
import penchit.utils.CommonUtils;

@Controller
@RequestMapping("/")
public class LoginController {
	
	@Autowired
	private UserService userService;

    @RequestMapping(value = "/admin/login", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
    public ModelAndView doGet() {
        return new ModelAndView("adminLogin");
    }
    @RequestMapping(value = "/admin/home",method = RequestMethod.GET)
    public ModelAndView getHomePage() {
        return new ModelAndView("adminHomePage");
    }
    @RequestMapping(value = "/admin/accessDenied",method = RequestMethod.GET)
    public ModelAndView invokeAdminAccessDenied() {
        return new ModelAndView("adminAccessDeniedPage");
    }
    
}
