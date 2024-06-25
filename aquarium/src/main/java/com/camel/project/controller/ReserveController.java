package com.camel.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.camel.project.dto.Reserve;
import com.camel.project.service.ReserveService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ReserveController {
	
	@GetMapping("/program")
	public String program() {
		return"program";
	}
	
	@GetMapping("/usageguide")
	public String usageguide() {
		return "usageguide";
	}
	
	@GetMapping("/reserveConfirm")
	public String reserveConfirm() {
		return "reservConfirm";
	}

	@GetMapping("/reserve")
	public String reserveForm(String program, Model model) {
		// DB에 값이 들어갈 수 있도록 빈공간 만들어주기
		model.addAttribute("program", program); // url 파라미터로 받은 프로그램 정보 전달 
		model.addAttribute("reserve", new Reserve());
		return "reserv";// reserv.html 파일을 가리킴 
	}
	
	@Autowired
	private ReserveService reserveService;
	
	@PostMapping("/reserve")
	public String insertReserve(Reserve reserve, Model model) {
		reserve.setMemberId("reserveId"); // 임시
		reserve.setReservCancle("N");
        reserve.setReservExprt("N");
        log.info("reserve 값 :" + reserve);
		reserveService.insertReserve(reserve);
		
		return "reservConfirm"; //예약 완료 페이지로 이동
	}
	
	@GetMapping("/reserveConfirmCheck")
	/*
	public String getAllReserve(Model model, @@RequestParam String memberId) {
		List<Reserve> reserve = reserveService.getAllReserve(memberId);
	*/
	public String getAllReserve(Model model) {
		List<Reserve> reserve = reserveService.getAllReserve();
		log.info("DB에 저장된 reserve 모두 보기 : " + reserve);
		model.addAttribute("reservList", reserve);
		return "reservConfirm";
	}

}
