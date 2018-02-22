package com.foodtruck.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.foodtruck.service.MemberService;
import com.foodtruck.service.OrderService;
import com.foodtruck.service.SellerService;
import com.foodtruck.vo.LicenseVO;
import com.foodtruck.vo.MInquiryVO;
import com.foodtruck.vo.MemberVO;
import com.foodtruck.vo.MinquiryReplyVO;
import com.foodtruck.vo.OrderVO;

@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	@Autowired
	SellerService sellerService;
	@Autowired
	OrderService orderService;
	
	// 1:1 문의 페이지 이동
	@RequestMapping("/inquiryPage")
	public String inquiryPage(HttpSession session,HttpServletRequest request) {
		MemberVO m = (MemberVO)session.getAttribute("member");
		String gubun = (String)session.getAttribute("memberGubun");
		String id=m.getMemberId();
		if(gubun.equals("2")) {
			LicenseVO vo=new LicenseVO();
			vo.setMemId(id);
			List<LicenseVO> list=sellerService.getInfo(vo);
			request.setAttribute("list", list);
		}else {
			List<OrderVO> list = orderService.getOrdNo(id);		// 사용자가 주문한 정보 ordNo만 쓸거
			request.setAttribute("list", list);
		}
		request.setAttribute("id", id);
		return "member/inquiry";
	}	
	
	//1:1문의하기
	@RequestMapping("/inquriy")
	public String memberinquriy(MInquiryVO vo,HttpSession session,HttpServletRequest request) {	
		
		String gubun = (String)session.getAttribute("memberGubun");
		if(gubun == "2") {
			memberService.insertInquiry2(vo);
		} else {
			memberService.insertInquiry(vo);
		}
		return "redirect:/";
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
	
	// 관심있는 푸드트럭 5개 까지 보여주고 / 바로 주문할 수 있또로로오오오옥!
	@RequestMapping("/favoriteFoodtruck")
	public String favoriteFoodtruckPage(HttpSession session, HttpServletRequest request) {
		
		String memId = (String) session.getAttribute("memberId");
		List<OrderVO> list = orderService.getFavoriteFoodtruck(memId);

		request.setAttribute("list", list);
			
		return "nav/favoriteFoodtruck";
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
