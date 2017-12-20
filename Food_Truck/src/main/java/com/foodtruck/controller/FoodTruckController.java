package com.foodtruck.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.foodtruck.service.FoodTruckService;

@Controller
public class FoodTruckController {

	@Autowired
	private FoodTruckService fservice;
	
	// FoodTrcuk List
	@RequestMapping("/menuBoard")
	public String menuBoarPage(Model model)throws Exception {
		model.addAttribute("list", fservice.getFoodTruckList());
		return  "foodtruck/menuBoard";
	}
	
	// Korean Food
	@RequestMapping("/korFood")
	public String korFoodPage(Model model)throws Exception {
		model.addAttribute("list", fservice.getCategoryList(1));
		return "foodtruck/korFood";
	}
	
	// Chinese Food
	@RequestMapping("/chiFood")
	public String chiFoodPage(Model model)throws Exception {
		model.addAttribute("list", fservice.getCategoryList(2));
		return "foodtruck/chiFood";
	}
	
	// Western Food
	@RequestMapping("/westFood")
	public String westFoodPage(Model model)throws Exception {
		model.addAttribute("list", fservice.getCategoryList(3));
		return "foodtruck/westFood";
	}
	
	// Japanese Food
	@RequestMapping("/jpFood")
	public String jpFoodPage(Model model)throws Exception {
		model.addAttribute("list", fservice.getCategoryList(4));
		return "foodtruck/jpFood";
	}
	
	// 상세정보
	@RequestMapping("/read")
	public String foodinfo(@RequestParam("licenseNo")String licenseNo,Model model)throws Exception {
		model.addAttribute("one",fservice.getFoodTruck(licenseNo));
		return "foodtruck/detail";
	}
}
