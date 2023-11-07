package com.kr.ark.application.manage.code.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kr.ark.application.manage.code.service.CodeService;
import com.kr.ark.application.manage.code.vo.CodeGrpVO;
import com.kr.ark.application.manage.code.vo.CodeVO;
import com.kr.ark.common.model.ResponseMessage;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/code")
@RequiredArgsConstructor
public class ApiCodeController {

	private final CodeService codeService;

	@PostMapping("/selectCodeGrpList")
	public ResponseEntity<?> selectCodeGrpList(HttpServletRequest request, @RequestBody CodeGrpVO input) {
		ResponseMessage response = codeService.selectCodeGrpList(input);
		return ResponseEntity.ok(response);
	}

	@PostMapping("/selectCodeList")
	public ResponseEntity<?> selectCodeList(HttpServletRequest request, @RequestBody CodeVO input) {
		ResponseMessage response = codeService.selectCodeList(input);
		return ResponseEntity.ok(response);
	}
}
