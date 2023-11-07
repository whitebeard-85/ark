package com.kr.ark.common.interceptor;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.kr.ark.application.user.mapper.UserMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class HeaderInterceptor implements HandlerInterceptor{

	private final UserMapper userMapper;

	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if(principal != null && !"anonymousUser".equals(principal)) {
			UserDetails userDetails = (UserDetails)principal;
			String username = userDetails.getUsername();
			String password = userDetails.getPassword();
			String role = userDetails.getAuthorities().toString();

			request.setAttribute("username", username);
			request.setAttribute("role", role);

			System.out.println("HeaderInterceptor username >>>>>>> " + username);
			System.out.println("HeaderInterceptor role >>>>>>> " + role);
		}

		return true;
	}
}
