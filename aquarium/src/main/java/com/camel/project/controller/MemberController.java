package com.camel.project.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.camel.project.dto.Member;
import com.camel.project.service.MemberService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MemberController {
	
	//메인 페이지 이동
    @GetMapping("/")
    public String mainPage() {
        return "main"; // main.html 등의 뷰 이름을 반환
    }
	
    //회원가입 페이지 이동
	@GetMapping("/registerForm")
	public String RegisterForm(Model model) {
		model.addAttribute("register", new Member());		
		return "registerForm";
	}
	
	@Autowired
	private MemberService memberService;
	
	//회원가입 페이지 폼 조종
	@PostMapping("/registerForm")
	public String insertMember(Member member, Model model) {
		
		memberService.insertMember(member);
		return "redirect:/";
	}
	
	//이메일인증
	@ResponseBody
	@PostMapping("/mail")
	public String mailSend(String mail) {
		int number = memberService.sendMail(mail);
		String num = "" + number; //랜덤으로 생성된 숫자 가져오기
		
		//내가 전달받은 숫자가 맞는지 확인용으로 가져옴
		return num;
	}
	
	//아이디 중복 검사
    @PostMapping("/checkId")
    @ResponseBody
    public ResponseEntity<Boolean> checkId(@RequestParam("memberId") String memberId) {
        boolean result = false;

        // 입력된 memberId가 비어있는지 검사
        if (memberId.trim().isEmpty()) {
        	result = false;
        } 
        else {
            // memberId가 비어있지 않으면 서비스 계층에서 중복 여부를 확인
            if (memberService.checkId(memberId)) {
                // 중복된 아이디인 경우
                result = false;
            } 
            else {
                // 중복되지 않은 경우
               result = true;
            }
        }

        // ResponseEntity를 사용하여 결과를 반환
        return ResponseEntity.ok(result);
    }
    
    //임시 로그인 페이지 이동
	@GetMapping("/login")
	public String showLogin(Model model) {
		model.addAttribute("member", new Member());
		return "login";
	}
	
	//임시 로그인
	@PostMapping("/login")
	public String getLogin(Model model,
			     @RequestParam("memberId") String memberId,
			     @RequestParam("memberPw") String memberPw,
			     HttpSession session) {
		
		Member member = memberService.getLogin(memberId, memberPw);
		
		if(member != null) {
			session.setAttribute("loginSession", member);
			return "redirect:/";
			
		} else { 
			model.addAttribute("e", "일치하는 회원 정보가 없습니다.");
			model.addAttribute("member", new Member());
			return "login";
		}
	}
	
    //회원 정보 수정 이동
    @GetMapping("/MyInfo")
    public String myInfoPage(HttpSession session, Model model) {
    	Member member = (Member) session.getAttribute("loginSession");
		if(member == null) {
			return "redirect:/";
		}
		model.addAttribute("updateProfile", member);
		return "MyInfo";
    }
    
    //회원 정보 수정
    @PostMapping("/updateProfile")
    public String updateMember(HttpSession session, Member updateMember) {
    	Member member = (Member) session.getAttribute("loginSession");
    	
		if(member == null) {
			return "redirect:/";
		}
		
		updateMember.setMemberNo(member.getMemberNo());
		memberService.updateMember(updateMember);
		session.setAttribute("loginSession", updateMember);
		return "redirect:/MyInfo";
    }

}