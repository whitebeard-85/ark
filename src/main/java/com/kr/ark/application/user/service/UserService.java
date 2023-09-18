package com.kr.ark.application.user.service;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kr.ark.application.user.mapper.UserMapper;
import com.kr.ark.application.user.vo.UserVO;
import com.kr.ark.common.model.ResponseMessage;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserMapper userMapper;
	private final PasswordEncoder passwordEncoder;

	public ResponseMessage selectUser(UserVO input) {
		UserVO userVo = userMapper.selectUser(input);
		return ResponseMessage.ok(userVo, "조회되었습니다.");
	}

	public ResponseMessage insertUser(UserVO input) {
		input.setPwd(passwordEncoder.encode(input.getPwd()));
		int result = userMapper.insertUser(input);

		if(result > 0) {
			return ResponseMessage.ok(result, "등록되었습니다.");
		}else {
			return ResponseMessage.of(result, HttpStatus.INTERNAL_SERVER_ERROR ,"등록에 실패했습니다.");
		}
	}
}
