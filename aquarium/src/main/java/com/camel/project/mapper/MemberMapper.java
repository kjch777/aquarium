package com.camel.project.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.camel.project.dto.Member;

@Mapper
public interface MemberMapper {
	
	//회원 정보 삽입
	public void insertMember(Member member);
	
	//아이디 중복 검사
	public int countById(@Param("memberId") String memberId);
	
	//임시 로그인
	Member getLogin(@Param("memberId") String memberId,
			@Param("memberPw") String memberPw);
	
	//회원 정보 수정
	void updateMember(Member member);
}
