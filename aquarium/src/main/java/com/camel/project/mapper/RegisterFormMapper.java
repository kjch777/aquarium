package com.camel.project.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.camel.project.dto.RegisterForm;

@Mapper
public interface RegisterFormMapper {

	public void insertMember(RegisterForm registerForm);
}
