package com.mylist.common;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import com.mylist.service.UserService;
import com.mylist.vo.UserVO;

public class RememberInterceptor extends HandlerInterceptorAdapter {
	@Inject
	UserService userService;
	
	 @Override
	    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
	        HttpSession session = request.getSession();
	        Object obj = session.getAttribute("login");
	        
	        Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
	        
	        if ( obj == null ){
	        	if(loginCookie != null) {
	        		UserVO vo = userService.getUser(loginCookie.getValue());
	        		session.setAttribute("login", vo);
	        	}
	        }
	        
	        return true;
	    }
}
