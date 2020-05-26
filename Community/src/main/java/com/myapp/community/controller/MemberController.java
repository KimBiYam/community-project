package com.myapp.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myapp.community.service.MemberService;
import com.myapp.community.vo.MemberVO;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	@Autowired
	MemberService service;

	// LoginFailureHandler 에서 이동을 하려면 GET,POST방식 모두 선언 해둬야 함		
	@RequestMapping(value = "/login", method = { RequestMethod.GET, RequestMethod.POST })
	public void login() {

	}

	@GetMapping("/join")
	public void join() {

	}

	@PostMapping("/join")
	public String join(MemberVO member) {
		member.setAuth("ROLE_MEMBER");
		service.memberJoin(member);
		return "redirect:/";
	}

}
