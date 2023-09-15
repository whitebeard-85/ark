package com.kr.ark.common.interceptor;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class HeaderInterceptor implements HandlerInterceptor{
	
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession(false);
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		System.out.println("HeaderInterceptor >>>>>>> " + principal);
		
		if(principal != null && !"anonymousUser".equals(principal)) {
			UserDetails userDetails = (UserDetails)principal;
			
			String username = userDetails.getUsername();
			String password = userDetails.getPassword();
			String role = userDetails.getAuthorities().toString();
			
			request.setAttribute("username", username);
			request.setAttribute("role", role);
		}
		
		return true;
	}
}
