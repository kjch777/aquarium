package com.camel.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.camel.project.dto.Member;
import com.camel.project.mapper.LoginMapper;

@Service
public class LoginService {

	@Autowired
	private LoginMapper loginMapper;
	
	public Member getLogin(String member_id, String member_pw) {
		return loginMapper.getLogin(member_id, member_pw);
	}
}
