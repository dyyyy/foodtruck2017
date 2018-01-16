package com.foodtruck.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.foodtruck.service.MemberService;
import com.foodtruck.service.ProductService;
import com.foodtruck.vo.MemberVO;
import com.foodtruck.vo.ProductVO;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private MemberService memberService;
	
	// ��ǰ ��� �ϴ� ������ �̵�
	@RequestMapping("/insertProductForm")
	public String insertProductForm(Model model, HttpSession session) {
		
		MemberVO mvo = (MemberVO)session.getAttribute("member");
		
		String selId = mvo.getMemberId(); 
		
		// ����� ��ȣ 
		model.addAttribute("list", memberService.getLicenseNo(selId));
		
		return "nav/productInsert";
	}
	
	// ��ǰ ���
	@RequestMapping("/insertProduct")
	public String insertProduct(ProductVO vo) {
		
		productService.insertProduct(vo);
		System.out.println("��ǰ ��� ����!");
		System.out.println(vo.getFtruckNo());
		return "home";
	}
}
