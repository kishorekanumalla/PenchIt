package penchit.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import penchit.model.User;
import penchit.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");
        if(user == null){
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            String email = auth.getName();
            if (email.equalsIgnoreCase("anonymousUser")) {
            	response.sendRedirect("accessDenied");
            }
            user = userService.findByEmail(email);
            session.setAttribute("user", user);
        }else {
        	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        	if (auth != null) {
        		String email = auth.getName();
        		String currentUserEmail = user.getEmail();
        		if (!email.equalsIgnoreCase(currentUserEmail)) {
        			response.sendRedirect("adminAccessDeniedPage");
        		}
        	}
        	
        }
        

        return super.preHandle(request, response, handler);
    }
}
