package com.kr.ark.application;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kr.ark.common.util.CommonUtils;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MainController {

	@GetMapping("/main")
	public String main(HttpServletRequest request, Model model) {
		return CommonUtils.viewPathResolve("main");
	}

	@GetMapping("/login")
	public String login(HttpServletRequest request, Model model, @RequestParam(value = "error", required = false) String error, @RequestParam(value = "exception", required = false) String exception) {
		model.addAttribute("error", error);
		model.addAttribute("exception", exception);
		return CommonUtils.viewPathResolve("login/login");
	}

	@GetMapping("/signup")
	public String signup(HttpServletRequest request, Model model) {
		return CommonUtils.viewPathResolve("login/signup");
	}
}
