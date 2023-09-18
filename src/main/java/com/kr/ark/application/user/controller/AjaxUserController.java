package com.kr.ark.application.user.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kr.ark.application.user.service.UserService;
import com.kr.ark.application.user.vo.UserVO;
import com.kr.ark.common.model.ResponseMessage;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/ajax/user")
@RequiredArgsConstructor
public class AjaxUserController {

	private final UserService userService;

	@PostMapping("/selectUser")
	public ResponseEntity<?> selectUser(HttpServletRequest request, @RequestBody UserVO input) {
		log.info("selectUser >>>>>>>>> " + input.toString());
		ResponseMessage response = userService.selectUser(input);
		return ResponseEntity.ok(response);
	}

	@PostMapping("/insertUser")
	public ResponseEntity<?> insertUser(HttpServletRequest request, @RequestBody UserVO input) throws Exception {
		log.info("insertUser >>>>>>>>> " + input.toString());
		ResponseMessage response = userService.insertUser(input);
		return ResponseEntity.ok(response);
	}
}
