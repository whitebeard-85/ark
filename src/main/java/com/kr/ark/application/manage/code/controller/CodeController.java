package com.kr.ark.application.manage.code.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kr.ark.common.util.CommonUtils;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/code")
public class CodeController {

	@GetMapping("/list")
	public String main(HttpServletRequest request, Model model) {
		return CommonUtils.viewPathResolve("manage/code/list");
	}
}
