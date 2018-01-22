package com.foodtruck.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	
	// 1:1 일반회원 문의
	@RequestMapping("/inquiry")
	public String inquiryPage() {
		return "nav/memberinquiry";
	}
	//1:1 판매자회원 문의
	@RequestMapping("/inquiry2")
	public String inquiryPage2() {
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
