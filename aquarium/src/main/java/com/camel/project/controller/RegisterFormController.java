package com.camel.project.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.camel.project.dto.RegisterForm;
import com.camel.project.service.RegisterFormService;

import jakarta.servlet.http.HttpSession;

@Controller
public class RegisterFormController {
	
	@GetMapping("/")
	public String RegisterForm(Model model) {
		model.addAttribute("register", new RegisterForm());
		
		return "Main";
	}
	
	@Autowired
	private RegisterFormService registerFormService;
	
	@PostMapping("/registerForm")
	public String insertMember(RegisterForm registerForm, Model model) {
		
		registerFormService.insertMember(registerForm);
		return "registerForm";
	}

/*	@PostMapping("")
	public String getId(
			Model model,
			@RequestParam("memberId") String memberId,
			HttpSession session
			) {
		RegisterForm rf = registerFormService.getId(memberId);
		if(rf != null) {
			session.setAttribute("duplicationsession", rf);
			model.addAttribute("message","사용할 수 없는 아이디입니다.");
			return "redirect:/";
		}
		else {
			model.addAttribute("message","사용 가능한 아이디입니다.");
			return "redirect:/";
		}
	}*/
}
