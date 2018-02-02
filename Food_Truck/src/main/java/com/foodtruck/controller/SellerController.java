package com.foodtruck.controller;

import java.io.IOException;

import java.util.HashMap;

import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.foodtruck.service.FoodTruckService;
import com.foodtruck.service.MemberService;

import com.foodtruck.service.ProductService;


import com.foodtruck.service.SellerService;
import com.foodtruck.vo.FoodTruckVO;
import com.foodtruck.vo.LicenseVO;
import com.foodtruck.vo.MInquiryVO;
import com.foodtruck.vo.MemberVO;

import com.foodtruck.vo.ProductVO;
import com.foodtruck.vo.SellerVO;


@Controller
public class SellerController {
	//ArrayList<SellerVO> list = new ArrayList<SellerVO>();
	@Autowired
	FoodTruckService foodTruckService;
	
	@Autowired

	MemberService mservice;
	@Autowired
	SellerService sservice;
	

	@Autowired
	private ProductService productService;


	// 판매자 캘린더
	@RequestMapping("/sellerCalendar")
	public String sellerCalendar(HttpSession session, HttpServletRequest request,Model model,@RequestParam(value = "licenseNo" ,required =false)String licenseNo) {
		MemberVO mvo = (MemberVO)session.getAttribute("member");
		if(!sservice.getLicense(mvo.getMemberId()).isEmpty()) {
			String num= licenseNo;
			model.addAttribute("licenseNo", num);
			return "seller/calendar";
		} else {
			return "seller/null";
		}
	}
	
	// 판매자 차트
	@RequestMapping("/sellerChart")
	public String sellerChart(HttpSession session,Model model,@RequestParam(value = "licenseNo" ,required =false)String licenseNo) {
		MemberVO mvo = (MemberVO)session.getAttribute("member");
		if(!sservice.getLicense(mvo.getMemberId()).isEmpty()) {
			
			String num= licenseNo;
			model.addAttribute("licenseNo", num);
			return "seller/chart";
		} else {
			return "seller/null";
		}
	}
	

	
	// �Ǹ��� �޴� - �Ǹ��� ��� ?


	@RequestMapping("/sellerMain")
	public String sellerMain(@RequestParam(value="licenseNo",required=false)String licenseNo,HttpServletRequest request, Model model, HttpSession session) {	
		MemberVO mvo = (MemberVO)session.getAttribute("member");
		if(licenseNo==null) {
			
		
			return "seller/null";
		}else {
			List<SellerVO> list =sservice.getLicense(mvo.getMemberId());
			String num= licenseNo;
			
			
			
			System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa : " + request.getAttribute("licenseNo"));
			System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa : " + list);
			System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa : " + num);
			System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa : " + request.getParameter("licenseNo"));
			System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa : " + licenseNo);
			model.addAttribute("licenseNo", num); // 사업자번호의 index가 0인 값
			model.addAttribute("license",list); // 사업자번호 리스트
			model.addAttribute("todayOrder", sservice.getTodayOrderList(num));
			model.addAttribute("todayDlv", sservice.getTodayDlvList(num));
			model.addAttribute("order", sservice.getOrderList(num));
			model.addAttribute("img", sservice.getFoodTruckList(num));
			
			return "seller/main";
		}
			
		
	}
	
	

	@RequestMapping("/insertFoodTruckForm")
	public String insertFoodTruckForm() {
		return "seller/insertFoodTruck";
	}
	
	@RequestMapping("/sellerProduct")
	public String sellerProduct(@RequestParam(value = "licenseNo")String licenseNo,HttpServletRequest request,Model model,HttpSession session) {
		MemberVO mvo = (MemberVO)session.getAttribute("member");
		List<SellerVO> list =sservice.getLicense(mvo.getMemberId());
		List<ProductVO> list2 =productService.getProductList(licenseNo);
		request.setAttribute("list", list);
		request.setAttribute("licenseNo", licenseNo);
		request.setAttribute("list2", list2);
		
		
		return "seller/sellerProduct";
	}
	
	
	@RequestMapping("/modal")
	@ResponseBody
	public HashMap modal(@RequestParam("licenseNo") String licenseNo) {
		HashMap map = new HashMap();
		map.put("licenseNo", licenseNo);
		
		return map;
	}

	// 푸드트럭 등록
	@ResponseBody

	@RequestMapping("/insertFoodTruck")
	public String insertFoodTruck(Model model, HttpSession session,  HttpServletRequest request, FoodTruckVO fvo, LicenseVO lvo) throws Exception, IOException {
	    
		MemberVO mvo = (MemberVO)session.getAttribute("member");
		
		String category[] = request.getParameterValues("category");
		String ftruckDlvYn[] = request.getParameterValues("ftruckDlvYn");
		String ftruckRsvYn[] = request.getParameterValues("ftruckRsvYn");
		String ftruckState[] = request.getParameterValues("ftruckState");
		String licenseNo = request.getParameter("licenseNo");
		
		for(String c : category) {
			switch(c) {
			case "1" : fvo.setCategory(1); break;
			case "2" : fvo.setCategory(2); break;
			case "3" : fvo.setCategory(3); break;
			case "4" : fvo.setCategory(4); break;
			}
		}
		
		for(String dlv : ftruckDlvYn) {
			switch(dlv) {
			case "Y" : fvo.setFtruckDlvYn("Y"); break;
			case "N" : fvo.setFtruckDlvYn("N"); break;
			}
		}
		
		for(String rsv : ftruckRsvYn) {
			switch(rsv) {
			case "Y" : fvo.setFtruckRsvYn("Y"); break;
			case "N" : fvo.setFtruckRsvYn("N"); break;
			}
		}
		
		for(String state : ftruckState) {
			switch(state) {
			case "Y" : fvo.setFtruckState("Y"); break;
			case "N" : fvo.setFtruckState("N"); break;
			}
		}
		
		lvo.setMemId(mvo.getMemberId());
		lvo.setLicenseNo(licenseNo);
		sservice.insertLicense(lvo);
		sservice.insertFoodTruck(fvo);
		
		return "seller/main";
	}
	    
	   

	@RequestMapping("/detailFoodTruckForm")
	public String detailFoodTruckForm() {
		return "seller/detailFoodTruck";
	}
	
	@ResponseBody
	@RequestMapping("/licenseNoCheck")
	public FoodTruckVO licenseNoCheck(HttpServletRequest request) {
		String licenseNo = request.getParameter("licenseNo");

		return sservice.getFoodTruck(licenseNo);
	}
	
	
	@RequestMapping("/productMng")
	public String productMng(HttpSession session, HttpServletRequest request, Model model) {
		MemberVO mvo = (MemberVO)session.getAttribute("member");
		if(!sservice.getLicense(mvo.getMemberId()).isEmpty()) {
			model.addAttribute("license", sservice.getLicense(mvo.getMemberId()));
			model.addAttribute("product", sservice.getProductList(request.getParameter("licenseNo")));
			return "seller/productMng";
		} else {
			return "seller/null";
		}
	}
	
	
	@RequestMapping("/foodTruckMng")
	public String foodTruckMng(Model model, HttpServletRequest request, HttpSession session) {
		MemberVO mvo = (MemberVO)session.getAttribute("member");
		
		if(!sservice.getLicense(mvo.getMemberId()).isEmpty()) {
			model.addAttribute("foodtruck", sservice.getLicense(mvo.getMemberId()));
			return "seller/foodTruckMng";
		} else {
			return "seller/null";
		}
		
		
	}
	

	//판매자 1:1문의
	@RequestMapping("sellerinquriy")
	public String sellerinquriy(MInquiryVO vo) {	
		String result="N";
		vo.setQaScStat(result);
		System.out.println(vo.getLicenseNo());
		mservice.insertInquiry2(vo);
		return "home";
	}
	//판매자 licenseNo로 푸드트럭 정보 가져오기
	@RequestMapping("/asd")
	@ResponseBody
	public HashMap foodtruckInfo(@RequestParam("licenseNo") String licenseNo) {
		HashMap map = new HashMap();
		FoodTruckVO vo = sservice.getFoodtruckDtail(licenseNo);
		if(vo.getFtruckAddr()==null) {
			vo.setFtruckAddr(vo.getFtruckAddr2());
		}
		map.put("name", vo.getFtruckName());
		map.put("addr", vo.getFtruckAddr());
		map.put("img", vo.getFtruckImg());
		map.put("intro", vo.getFtruckIntro());
		map.put("tel", vo.getFtruckTel());
		map.put("dliver", vo.getFtruckDlvYn());
		map.put("reserve", vo.getFtruckRsvYn());
		map.put("category", vo.getCategory());
		String com="";
		com+="<script type=\"text/javascript\">";
		com+="var geocoder = new daum.maps.services.Geocoder();\r\n" + 
				"geocoder.addressSearch('"+vo.getFtruckAddr()+"', function(result, status) {\r\n" + 
				"     if (status === daum.maps.services.Status.OK) {\r\n" + 
				"        var coords = new daum.maps.LatLng(result[0].y, result[0].x);\r\n" + 
				"        var marker = new daum.maps.Marker({\r\n" + 
				"            map: map,\r\n" + 
				"            position: coords\r\n" + 
				"        });\r\n" + 
				"        var infowindow = new daum.maps.InfoWindow({\r\n" + 
				"            content: '<div style=\"width:150px;text-align:center;padding:6px 0;\">"+vo.getFtruckName()+"</div>'\r\n" + 
				"        });\r\n" + 
				"        infowindow.open(map, marker);\r\n" + 
				"        map.setCenter(coords);\r\n" + 
				"    } \r\n" + 
				"});";
		com+="</script>";
		map.put("com", com);
		String info="";
		
		return map;
	}

}
