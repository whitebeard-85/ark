package com.kr.ark.common.config;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.session.HttpSessionEventPublisher;

import jakarta.servlet.DispatcherType;
import jakarta.servlet.http.HttpSessionEvent;

@Configuration
public class SecurityConfig {

	@Bean
	PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}

	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable().cors().disable();
        http.httpBasic().disable();

        http.authorizeHttpRequests(request -> request
//        		.anyRequest().permitAll()
                .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
                .requestMatchers("/assets/**", "/api/**", "/login", "/signup", "/error").permitAll()
                .requestMatchers("/","/main","/code/**").authenticated()
        )
        .formLogin(login -> login
                .loginPage("/login")	// [A] 커스텀 로그인 페이지 지정
                .loginProcessingUrl("/login-process")	// [B] submit 받을 url
                .usernameParameter("userid")	// [C] submit할 아이디
                .passwordParameter("pw")	// [D] submit할 비밀번호
                .defaultSuccessUrl("/main", true)
                .failureHandler(new CustomAuthFailureHandler())
                .permitAll()
        )
        .logout(withDefaults());

        return http.build();
    }

	@Bean
	public ServletListenerRegistrationBean<HttpSessionEventPublisher> httpSessionEventPublisher() {
        return new ServletListenerRegistrationBean<HttpSessionEventPublisher>(new HttpSessionEventPublisher() {
            @Override
            public void sessionCreated(HttpSessionEvent event) {
                super.sessionCreated(event);
            }

            @Override
            public void sessionDestroyed(HttpSessionEvent event) {
                super.sessionDestroyed(event);
            }

            @Override
            public void sessionIdChanged(HttpSessionEvent event, String oldSessionId) {
                super.sessionIdChanged(event, oldSessionId);
            }
        });
    }
}
