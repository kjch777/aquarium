package com.camel.project.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.camel.project.dto.RegisterForm;

@Mapper
public interface RegisterFormMapper {

	public void insertMember(RegisterForm registerForm);
	RegisterForm getId(@Param("memberId") String memberId);
}
