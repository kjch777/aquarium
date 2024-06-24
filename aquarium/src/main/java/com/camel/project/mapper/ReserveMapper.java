package com.camel.project.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.camel.project.dto.Reserve;

import lombok.extern.slf4j.Slf4j;

@Mapper
public interface ReserveMapper {
	// 예약정보 DB에 삽입
	void insertReserve(Reserve reserve);
	
}
