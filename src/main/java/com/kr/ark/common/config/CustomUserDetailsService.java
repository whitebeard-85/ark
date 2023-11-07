package com.kr.ark.common.config;

import java.util.Optional;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.kr.ark.application.user.mapper.UserMapper;
import com.kr.ark.application.user.vo.UserVO;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

	private final UserMapper userMapper;

	@Override
    public UserDetails loadUserByUsername(String insertedUserId) throws UsernameNotFoundException {
		UserVO input = new UserVO();
		input.setLookupType("usrId");
		input.setUsrId(insertedUserId);
		Optional<UserVO> findOne = Optional.ofNullable(userMapper.selectUser(input));
		UserVO userVo = findOne.orElseThrow(() -> new UsernameNotFoundException("없는 회원입니다 ㅠ"));

        return User.builder()
                .username(userVo.getUsrId())
                .password(userVo.getPwd())
                .roles(userVo.getRoleCd())
                .build();
    }
}
