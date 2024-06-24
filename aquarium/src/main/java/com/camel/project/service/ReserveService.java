package com.camel.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.camel.project.dto.Reserve;
import com.camel.project.mapper.ReserveMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ReserveService {
	@Autowired
	private ReserveMapper reserveMapper;
	
	// 예약정보를 DB에 삽입
	public void insertReserve(Reserve reserve) {
		log.info("reserve 값 :" + reserve);
		reserveMapper.insertReserve(reserve);
	}
}
