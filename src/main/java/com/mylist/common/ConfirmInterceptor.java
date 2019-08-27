package com.mylist.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ConfirmInterceptor extends HandlerInterceptorAdapter {
	 @Override
	    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
	        HttpSession session = request.getSession();
	        Object obj = session.getAttribute("login");
	         
	        if ( obj == null ){
	            response.sendRedirect(request.getContextPath() + "/login");
	            return false; // 더이상 컨트롤러 요청으로 가지 않도록 false로 반환함
	        }
	        
	        return true;
	    }
}
