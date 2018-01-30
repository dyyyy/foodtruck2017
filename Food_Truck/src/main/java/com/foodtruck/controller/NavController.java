package com.foodtruck.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.foodtruck.service.SellerService;
import com.foodtruck.vo.LicenseVO;
import com.foodtruck.vo.MemberVO;

@Controller
public class NavController {
	
/*
	// ��������
	@RequestMapping("/noticeBoard")
	public String noticeBoardPage() {
		return "nav/noticeBoard";
	}
*/

	
/*	
	// �̺�Ʈ
	@RequestMapping("/eventBoard")
	public String eventBoardPage() {
		return "nav/eventBoard";
	}
*/
	@Autowired
	SellerService sservice;
	
	// 1:1 일반회원 문의
	@RequestMapping("/inquiry")
	public String inquiryPage(HttpSession session,HttpServletRequest request) {
		MemberVO m = (MemberVO)session.getAttribute("member");
		String id=m.getMemberId();
		request.setAttribute("id", id);
		return "nav/memberinquiry";
	}
	
	//1:1 판매자회원 문의
	@RequestMapping("/inquiry2")
	public String inquiryPage2(HttpSession session,HttpServletRequest request) {
		MemberVO m = (MemberVO)session.getAttribute("member");
		String id=m.getMemberId();
		LicenseVO vo=new LicenseVO();
		vo.setMemId(id);
		List<LicenseVO> list=sservice.getInfo(vo);
		request.setAttribute("id", id);
		request.setAttribute("list", list);
		return "nav/sellerinquiry";
	}
	

	// ������ �޴� - ȸ������
	@RequestMapping("/adminMember")
	public String adminMemberPage() {
		return "nav/adminMember";
	}

	// ������ �޴� - �Ǹ��� ����
	@RequestMapping("/adminSeller")
	public String adminSellerPage() {
		return "nav/adminSeller";
	}

	// �Ǹ��� �޴� - ��ǰ ���
	@RequestMapping("/productInsert")
	public String productInsertPage() {
		return "nav/productInsert";
	}

	// �Ǹ��� �޴� - ��� ����
	@RequestMapping("/deliveryDetails")
	public String deliveryDetailsPage() {
		return "nav/deliveryDetails";
	}

	// ������ �޴� - ��ü �ֹ� ����
	@RequestMapping("/orderList")
	public String orderListPage() {
		return "nav/orderList";
	}

	// ������ �޴� - ���� Ǫ��Ʈ��
	@RequestMapping("/favoritFoodtruck")
	public String favoritFoodtruckPage() {
		return "nav/favoritFoodtruck";
	}

	// ������ �޴� - ���� ����
	@RequestMapping("/myWriting")
	public String myWritingPage() {
		return "nav/myWriting";
	}

	// ������ �޴� - ���� ����
	@RequestMapping("/mySetting")
	public String mySettingPage() {
		return "nav/mySetting";
	}
}
