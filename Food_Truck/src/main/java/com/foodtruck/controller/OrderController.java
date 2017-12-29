package com.foodtruck.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.foodtruck.service.ProductService;
import com.foodtruck.vo.ProductVO;


@Controller
public class OrderController {
	@Autowired
	ProductService Pservice;
	
	@RequestMapping("/order")
	public String order(HttpSession session,@RequestParam("licenseNo") String licenseNo,HttpServletRequest request) {
		System.out.println("¡¯¿‘");
		System.out.println(licenseNo);
		List<ProductVO> Plist = Pservice.getProductList(licenseNo);

		request.setAttribute("list",Plist);
		return "nav/order";
	}
}
