package com.camel.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.camel.project.dto.RegisterForm;
import com.camel.project.service.RegisterFormService;

@Controller
public class RegisterFormController {

	@GetMapping("/")
	public String RegisterForm(Model model) {
		model.addAttribute("register", new RegisterForm());
		
		return "registerForm";
	}
	
	@Autowired
	private RegisterFormService registerFormService;
	
	@PostMapping("/registeringForm")
	public String insertMember(RegisterForm registerForm, Model model) {
		
		registerFormService.insertMember(registerForm);
		return "registerForm";
	}
}
