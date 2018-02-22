package com.foodtruck.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.foodtruck.service.MemberService;
import com.foodtruck.vo.MInquiryVO;
import com.foodtruck.vo.MemberVO;
import com.foodtruck.vo.MinquiryReplyVO;

@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	//1:1문의하기
	@RequestMapping("memberinquriy")
	public String memberinquriy(MInquiryVO vo) {	
		
		memberService.insertInquiry(vo);
		return "home";

	}

	// 회원으로 로그인 했을 때 나의주문 -> 나의 설정
	@RequestMapping("/memberInfo")
	public String memberInfo(HttpSession session, HttpServletRequest request) {
		
		String memId = (String) session.getAttribute("memberId");
		MemberVO vo = memberService.getMember(memId);
		
		request.setAttribute("memberInfo", vo);
		return "member/memberInfo";
	}
	
	// 수정 클릭 했을 때, 암호입력(true / false 결과)
	@RequestMapping("/memberInfoUpdateGet")
	public String memberInfoUpdate(HttpSession session,HttpServletRequest request) {
		
		String memId = (String) session.getAttribute("memberId");
		MemberVO vo = memberService.getMember(memId);
		request.setAttribute("memberInfo", vo);
		return "member/memberInfoUpdate";
	}
	
	// 회원 수정 폼 -> 수정 완료
	@RequestMapping("/memberInfoUpdate")
	public String memberInfoUpdate(MemberVO vo) {
		memberService.updateMember(vo);
		return "redirect:/memberInfo";
	}
	
	// *********************************************************** 사용자 문의 내역 리스트
	@RequestMapping("/memberQaInfoList") 
	public String memberQaInfoList(HttpSession session,HttpServletRequest request) {
		
		MemberVO vo = (MemberVO)session.getAttribute("member");
		request.setAttribute("qalist",memberService.getMemberQaInfoList(vo.getMemberId()));
		
		return "member/memberQaInfoList";
	}
	
	// *********************************************************** 사용자 문의 내역 상세보기 
	@RequestMapping("/memberQaInfo")
	public String memberQaInfo(HttpServletRequest request) {
		
		int qaScNo = Integer.parseInt(request.getParameter("qaScNo"));
		MInquiryVO vo = memberService.getMemberQaInfo(qaScNo);
		request.setAttribute("qaInfo", vo);
		MinquiryReplyVO vo2 = memberService.getMemberQaReply(qaScNo);
		request.setAttribute("qaReply", vo2);
		
		return "member/memberQaInfo";
	}	
	
}
