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
	MemberService mservice;
	//1:1문의하기
	@RequestMapping("memberinquriy")
	public String memberinquriy(MInquiryVO vo) {	
		String result="N";
		vo.setQaScStat(result);
		mservice.insertInquiry(vo);
		return "home";
	}
	
	@RequestMapping("/memberInfo")
	public String memberInfo(HttpSession session,HttpServletRequest request) {
		MemberVO vo = (MemberVO)session.getAttribute("member");
		MemberVO vo2 = mservice.getMember(vo.getMemberId()); 
		request.setAttribute("memberInfo", vo2);
		return "member/memberInfo";
	}
	
	@RequestMapping("/memberInfoUpdateGet")
	public String memberInfoUpdate(HttpSession session,HttpServletRequest request) {
		MemberVO vo = (MemberVO)session.getAttribute("member");
		MemberVO vo2 = mservice.getMember(vo.getMemberId());
		request.setAttribute("memberInfo", vo2);
		return "member/memberInfoUpdate";
	}
	
	@RequestMapping("/memberInfoUpdate")
	public String memberInfoUpdate(MemberVO vo) {
		mservice.updateMember(vo);
		return "redirect:/memberInfo";
	}
	
	// 사용자 문의 내역 리스트
	@RequestMapping("/memberQaInfoList") 
	public String memberQaInfoList(HttpSession session,HttpServletRequest request) {
		
		MemberVO vo = (MemberVO)session.getAttribute("member");
		request.setAttribute("qalist",mservice.getMemberQaInfoList(vo.getMemberId()));
		
		return "member/memberQaInfoList";
	}
	
	// 사용자 문의 내역 상세보기 
	@RequestMapping("/memberQaInfo")
	public String memberQaInfo(HttpServletRequest request) {
		
		int qaScNo = Integer.parseInt(request.getParameter("qaScNo"));
		MInquiryVO vo = mservice.getMemberQaInfo(qaScNo);
		request.setAttribute("qaInfo", vo);
		MinquiryReplyVO vo2 = mservice.getMemberQaReply(qaScNo);
		request.setAttribute("qaReply", vo2);
		
		return "member/memberQaInfo";
	}	
}
