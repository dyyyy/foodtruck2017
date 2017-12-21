package com.foodtruck.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.foodtruck.service.ProductService;
import com.foodtruck.vo.ProductVO;

@Controller
public class ProductController {
	
	
	@Autowired
	private ProductService productService;
	
	
	
	//이거이거이거이거이거이거이찾아보라고뭐가내껀데?내꺼라거
	// 제품 등록
	@RequestMapping("/insertProduct")
	public String insertProduct(ProductVO vo) {
		
		productService.insertProduct(vo);
		System.out.println("제품 등록 성공!");
		
		return "loginChk";
		
	}
}
