package penchit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


import penchit.repository.UserRepository;
import penchit.utils.CommonUtils;


public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
    private UserService userService;
	
	private Logger logger = Logger.getLogger(CustomUserDetailsService.class);
	
	
	@Override  
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {  
		
		logger.info("Enter CustomUserDetailsService:loadUserByUsername");
		
		User user = null;
  
		penchit.model.User userInfo = userService.findByEmail(userEmail);
  
        List authList = getAuthorities(userInfo.getRole().toString());  
        
		try {
			user = new User(userInfo.getEmail(), CommonUtils.decrypt(userInfo.getPassword()), authList);
		} catch (Exception e) {
			logger.error("Exception in reading user info");
		}  
		
		logger.info("End CustomUserDetailsService:loadUserByUsername");
  
        return user;  
    }  
  
    private List getAuthorities(String role) {  
        List authList = new ArrayList();  
        authList.add(new SimpleGrantedAuthority("ROLE_USER"));  
  
        //you can also add different roles here  
        //for example, the user is also an admin of the site, then you can add ROLE_ADMIN  
        //so that he can view pages that are ROLE_ADMIN specific  
        if (role != null && role.trim().length() > 0) {  
            if (role.equals("ROLE_ADMIN")) {  
                authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));  
            }  
        }  
  
        return authList;  
    }  

}
