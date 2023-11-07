package com.kr.ark.application;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kr.ark.application.user.mapper.UserMapper;
import com.kr.ark.application.user.vo.UserVO;
import com.kr.ark.common.util.CommonUtils;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MainController {

	private final UserMapper userMapper;

	@GetMapping("/main")
	public String main(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession(false);
		UserVO input = new UserVO();
		input.setLookupType("usrId");
		input.setUsrId(request.getAttribute("username").toString());
		UserVO userVo = userMapper.selectUser(input);

		if(userVo != null) {
			session.setAttribute("usrId", userVo.getUsrId());
			session.setAttribute("actvNm", userVo.getActvNm());
			session.setAttribute("roleNm", userVo.getRoleCd());
		}

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
