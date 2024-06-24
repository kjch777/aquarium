package com.camel.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.camel.project.dto.RegisterForm;
import com.camel.project.mapper.RegisterFormMapper;

@Service
public class RegisterFormService {
	
	@Autowired
	private RegisterFormMapper registerFormMapper;
	
	public void insertMember(RegisterForm registerForm) {
		registerFormMapper.insertMember(registerForm);
	}
	
	public RegisterForm getId(String memberId) {
		
		return registerFormMapper.getId(memberId);
	}
}
