package com.kr.ark.application.controller.common;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kr.ark.common.util.CommonUtils;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class IndexController {
	
	@GetMapping("/index")
	public String main(HttpServletRequest request, Model model) {
		return CommonUtils.viewPathResolve("index");
	}
}
