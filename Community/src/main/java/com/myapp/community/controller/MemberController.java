package com.myapp.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myapp.community.service.MemberService;
import com.myapp.community.vo.MemberVO;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	@Autowired
	MemberService service;

	@GetMapping("/login")
	public void login() {

	}
	
	@GetMapping("/join")
	public void join() {
		
	}
	
	@PostMapping("/join")
	public String join(MemberVO member) {
		service.memberJoin(member);
		return "redirect:/";
	}

}
