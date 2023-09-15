package com.kr.ark.common.config;

import java.util.Optional;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.kr.ark.application.mapper.user.UserMapper;
import com.kr.ark.application.vo.UserVO;
import com.kr.ark.common.enums.Role;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

	private final UserMapper userMapper;

	@Override
    public UserDetails loadUserByUsername(String insertedUserId) throws UsernameNotFoundException {
		UserVO input = new UserVO();
		input.setLookupType("id");
		input.setId(insertedUserId);
		Optional<UserVO> findOne = Optional.ofNullable(userMapper.selectUser(input));
		UserVO userVo = findOne.orElseThrow(() -> new UsernameNotFoundException("없는 회원입니다 ㅠ"));

        return User.builder()
                .username(userVo.getId())
                .password(userVo.getPassword())
                .roles(Role.MEMBER.toString())
                .build();
    }
}
