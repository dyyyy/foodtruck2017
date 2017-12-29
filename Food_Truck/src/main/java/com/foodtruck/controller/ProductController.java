package com.foodtruck.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.foodtruck.service.MemberService;
import com.foodtruck.service.ProductService;
import com.foodtruck.vo.ProductVO;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private MemberService memberService;
	
	// 제품 등록 하는 폼으로 이동
	@RequestMapping("insertProductForm")
	public String insertProductForm(Model model, HttpSession session) {
		
		String selId = (String)session.getAttribute("userId");
		
		// 사업자 번호 
		model.addAttribute("list", memberService.getLicenseNo(selId));
		
		return "nav/productInsert";
	}
	
	// 제품 등록
	@RequestMapping("/insertProduct")
	public String insertProduct(ProductVO vo) {
		
		productService.insertProduct(vo);
		System.out.println("제품 등록 성공!");
		System.out.println(vo.getLicenseNo());
		return "loginChk";
	}
}
