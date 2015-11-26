package penchit.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import penchit.Constants;
import penchit.exception.ApplicationException;
import penchit.vo.GroupVO;
import penchit.vo.ResponseObject;

@Controller
@RequestMapping("/")
public class MainController {
	
	@RequestMapping(value = "/admin/mainScreen.html",method = RequestMethod.GET)
    public ModelAndView getMainPage() {
        return new ModelAndView("mainPage");
    }
	@RequestMapping(value="/loadMainPage", method = RequestMethod.GET)  
	public @ResponseBody ResponseObject loadMainPage() throws ApplicationException { 
		ResponseObject responseObject = new ResponseObject();
		try {
			
			
		} catch (Exception e) {
			responseObject.setStatus(Constants.FAILURE);
			throw new ApplicationException();
		}
		return responseObject;  
	}

}
