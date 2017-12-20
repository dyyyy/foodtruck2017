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
	
	
	// 力前 殿废
	@RequestMapping("/insertProduct")
	public String insertProduct(ProductVO vo) {
		
		productService.insertProduct(vo);
		System.out.println("力前 殿废 己傍!");
		
		return "loginChk";
		
	}
}
