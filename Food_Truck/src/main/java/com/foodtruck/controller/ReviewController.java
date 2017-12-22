package com.foodtruck.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.foodtruck.service.FoodTruckService;

@Controller
public class ReviewController {
	@Autowired
	private FoodTruckService fservice;
	
	// FoodTrcuk List
	@RequestMapping("/")
	public String menuBoarPage(Model model)throws Exception {
		
		return  "";
	}
}
