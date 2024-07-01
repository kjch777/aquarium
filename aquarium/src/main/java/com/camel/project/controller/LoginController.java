package com.camel.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.camel.project.dto.Member;
import com.camel.project.service.LoginService;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	@GetMapping("/login")
	public String showLogin(Model model) {
		model.addAttribute("m", new Member());
		return "login";
	}
	
	@PostMapping("/login")
	public String getLogin(Model model,
							@RequestParam("memberId") String memberId,
							@RequestParam("memberPw") String memberPw,
							HttpSession session) {
		Member member = loginService.getLogin(memberId, memberPw);
		
		if(member != null) {
			session.setAttribute("loginSession", member);
			return "redirect:/";
			//return "index";
		} else {
			model.addAttribute("e", "이치하는 아이디 비밀번호가 없습니다");
			model.addAttribute("m", new Member());
			return "login";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session /*SessionStatus status 시간지나면 자동로그아웃*/) {
		session.invalidate(); //로그인 없던일 만들기
		return "redirect:/";
	}
}
