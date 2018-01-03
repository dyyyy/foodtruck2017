package com.foodtruck.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReviewController {

	// FoodTrcuk List
	@RequestMapping("/")
	public String menuBoarPage(Model model) throws Exception {

		return "";
	}
}
