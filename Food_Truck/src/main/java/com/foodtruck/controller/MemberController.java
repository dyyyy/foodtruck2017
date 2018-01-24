package com.foodtruck.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.foodtruck.service.MemberService;
import com.foodtruck.vo.MInquiryVO;
import com.foodtruck.vo.MemberVO;

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
}
