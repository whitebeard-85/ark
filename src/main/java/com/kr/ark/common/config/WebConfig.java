package com.kr.ark.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.kr.ark.common.interceptor.HeaderInterceptor;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer{

	private final HeaderInterceptor headerInterceptor;

	@Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(headerInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/assets/**", "/api/**", "/login", "/signup", "/error");
    }
}
