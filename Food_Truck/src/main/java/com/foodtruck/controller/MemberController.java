package com.foodtruck.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.foodtruck.service.MemberService;
import com.foodtruck.vo.MInquiryVO;

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
}
