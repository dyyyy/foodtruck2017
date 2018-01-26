package com.foodtruck.controller;

import java.util.HashMap;

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
import com.foodtruck.service.OrderService;
import com.foodtruck.service.SellerService;
import com.foodtruck.vo.FoodTruckVO;
import com.foodtruck.vo.MInquiryVO;
import com.foodtruck.vo.MemberVO;
import com.foodtruck.vo.OrderVO;

@Controller
public class SellerController {

	@Autowired
	OrderService orderService;	
	
	@Autowired
	FoodTruckService foodTruckService;
	
	@Autowired
	MemberService mservice;
	@Autowired
	SellerService sservice;
	
	// ������ �޴� - �Ǹ���  ��������
	@RequestMapping("/sellerCalendar")
	public String sellerCalendar() {
		return "seller/calendar";
	}
	
	// ������ �޴� - ��Ʈ
	@RequestMapping("/sellerChart")
	public String sellerChart() {
		return "seller/chart";
	}
	
	// �Ǹ��� �޴� - �Ǹ��� ��� ?
	@RequestMapping("/sellerMain")
	public String sellerMain(@RequestParam("licenseNo")String licenseNo,HttpServletRequest request, Model model, HttpSession session) {
		
		MemberVO mvo = (MemberVO)session.getAttribute("member");
		OrderVO ovo = (OrderVO) session.getAttribute("licenseNo");
		
		model.addAttribute("order1", orderService.getLicense(mvo.getMemberId()));
		
		return "seller/main";
	}
	
	@RequestMapping("/test")
	public String sellerTest(HttpServletRequest request, Model model) {
		System.out.println(request.getParameter("licenseNo"));
		
		return "seller/main";
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
