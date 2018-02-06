package com.foodtruck.controller;

import java.io.File;
import java.io.IOException;

import java.util.HashMap;

import java.util.List;


import java.util.Iterator;
import java.util.List;
import java.util.Map;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.foodtruck.service.FoodTruckService;
import com.foodtruck.service.MemberService;


import com.foodtruck.service.OrderService;

import com.foodtruck.service.ProductService;

import com.foodtruck.service.SellerService;
import com.foodtruck.vo.FoodTruckVO;
import com.foodtruck.vo.LicenseVO;
import com.foodtruck.vo.MInquiryVO;
import com.foodtruck.vo.MemberVO;




import com.foodtruck.vo.OrderVO;

import com.foodtruck.vo.ProductVO;
import com.foodtruck.vo.SellerVO;

@Controller
public class SellerController {
	
	@Autowired
	FoodTruckService foodTruckService;

	@Autowired

	MemberService mservice;
	@Autowired
	SellerService sservice;

	@Autowired
	private ProductService productService;
	
	@Autowired
	FoodTruckService fservice;
	

	// 판매자 캘린더
	@RequestMapping("/sellerCalendar")
	public String sellerCalendar(HttpSession session, HttpServletRequest request, Model model,
			@RequestParam(value = "licenseNo", required = false) String licenseNo) {
		MemberVO mvo = (MemberVO) session.getAttribute("member");
		if(mvo != null) {

			if (!sservice.getLicense(mvo.getMemberId()).isEmpty()) {
				String num = licenseNo;
				model.addAttribute("licenseNo", num);
				return "seller/calendar";
			} else {
				return "seller/insertFoodTruck";
			}
		} else {
			return "sign/login";
		}
	}

	// 판매자 차트
	@RequestMapping("/sellerChart")
	public String sellerChart(HttpSession session, Model model,
			@RequestParam(value = "licenseNo", required = false) String licenseNo) {
		MemberVO mvo = (MemberVO) session.getAttribute("member");
		if(mvo != null) {
			if (!sservice.getLicense(mvo.getMemberId()).isEmpty()) {

				String num = licenseNo;
				model.addAttribute("licenseNo", num);
				return "seller/chart";
			} else {
				return "seller/insertFoodTruck";
			}
		}
		else return "sign/login"; 
	}

	// �Ǹ��� �޴� - �Ǹ��� ��� ?
 

	@RequestMapping("/sellerInfo")
	public String sellerInfo(@RequestParam(value="licenseNo" , required=false)String licenseNo,HttpServletRequest request,HttpSession session,Model model) throws Exception {
		MemberVO mvo = (MemberVO) session.getAttribute("member");
		List<SellerVO> list = sservice.getLicense(mvo.getMemberId());
		String num=list.get(0).getLicenseNo();
		FoodTruckVO vo= new FoodTruckVO();
		vo=fservice.getFoodTruck2(licenseNo);
		if(vo.getFtruckAddr()==null) {
			vo.setFtruckAddr(vo.getFtruckAddr2());
		}
		request.setAttribute("vo", vo);
		model.addAttribute("licenseNo", num);
		return "seller/Info";
	}
	//새좌표 업데이트
	@RequestMapping("/updatePosition")
	@ResponseBody
	public int updatePosition (FoodTruckVO vo) throws Exception {
		int num=fservice.updateTruckPosition(vo);
		return num;
	}
	@RequestMapping("/sellerMain")
	public String sellerMain(@RequestParam(value="licenseNo",required=false)String licenseNo,HttpServletRequest request, Model model, HttpSession session) {	
		MemberVO mvo = (MemberVO)session.getAttribute("member");
		if(mvo != null) {
			if(licenseNo == null) {
				List<SellerVO> list=sservice.getLicense2(mvo.getMemberId());
				int count=list.size();
				if(count==0) {
					return "seller/null";
				}else {
					return "seller/ing";
				}			
			}else {
				List<SellerVO> list =sservice.getLicense(mvo.getMemberId());
					request.getSession().setAttribute("member", mvo);
					String num= licenseNo;
	
					model.addAttribute("licenseNo", num); // 사업자번호 하나
					model.addAttribute("license", list); // 사업자번호 여러개
					model.addAttribute("todayOrder", sservice.getTodayOrderList(num));
					model.addAttribute("todayDlv", sservice.getTodayDlvList(num));
//					model.addAttribute("order", sservice.getOrderList(num));
//					model.addAttribute("img", sservice.getFoodTruckList(num));
					model.addAttribute("payment", sservice.getTodayPayment(num));
					
					return "seller/main";  
			} 
		} else return "sign/login";

		
	}

	@RequestMapping("/insertFoodTruckForm")
	public String insertFoodTruckForm() {
		return "seller/insertFoodTruck";
	}

	@RequestMapping("/sellerProduct")
	public String sellerProduct(@RequestParam(value = "licenseNo") String licenseNo, HttpServletRequest request,
			Model model, HttpSession session) {
		MemberVO mvo = (MemberVO) session.getAttribute("member");
		if(mvo != null) {

			List<SellerVO> list = sservice.getLicense(mvo.getMemberId());
			List<ProductVO> list2 = productService.getProductList(licenseNo);
			request.setAttribute("list", list);
			request.setAttribute("licenseNo", licenseNo);
			request.setAttribute("list2", list2);

			return "seller/sellerProduct";
		} else return "sign/login";
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
	public int insertFoodTruck(Model model, HttpSession session, HttpServletRequest request, FoodTruckVO fvo
			) throws Exception, IOException {

		MemberVO mvo = (MemberVO) session.getAttribute("member");
		
		//License 테이블 insert
		LicenseVO lvo=new LicenseVO();
		lvo.setLicenseNo(fvo.getLicenseNo());
		lvo.setMemId(mvo.getMemberId());		
		sservice.insertLicense(lvo);
		
		//Foodtruck 테이블 insert
		fvo.setLicenseNo(lvo.getLicenseNo());
		fvo.setFtruckTel(mvo.getMemberTel());
		int num=sservice.insertFoodTruck(fvo);

		return num;
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
		MemberVO mvo = (MemberVO) session.getAttribute("member");
		if (!sservice.getLicense(mvo.getMemberId()).isEmpty()) {
			model.addAttribute("license", sservice.getLicense(mvo.getMemberId()));
			model.addAttribute("product", sservice.getProductList(request.getParameter("licenseNo")));
			return "seller/productMng";
		} else {
			return "seller/insertFoodTruck";
		}
	}

	@RequestMapping("/foodTruckMng")
	public String foodTruckMng(Model model, HttpServletRequest request, HttpSession session) {
		MemberVO mvo = (MemberVO) session.getAttribute("member");

		if (!sservice.getLicense(mvo.getMemberId()).isEmpty()) {
			model.addAttribute("foodtruck", sservice.getLicense(mvo.getMemberId()));
			return "seller/foodTruckMng";
		} else {
			return "seller/insertFoodTruck";
		}

	}

	// 판매자 1:1문의
	@RequestMapping("sellerinquriy")
	public String sellerinquriy(MInquiryVO vo) {
		String result = "N";
		vo.setQaScStat(result);
		System.out.println(vo.getLicenseNo());
		mservice.insertInquiry2(vo);
		return "home";
	}

	// 판매자 licenseNo로 푸드트럭 정보 가져오기
	@RequestMapping("/asd")
	@ResponseBody
	public HashMap foodtruckInfo(@RequestParam("licenseNo") String licenseNo) {
		HashMap map = new HashMap();
		FoodTruckVO vo = sservice.getFoodtruckDtail(licenseNo);
		if (vo.getFtruckAddr() == null) {
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
		String com = "";
		com += "<script type=\"text/javascript\">";
		com += "var geocoder = new daum.maps.services.Geocoder();\r\n" + "geocoder.addressSearch('" + vo.getFtruckAddr()
				+ "', function(result, status) {\r\n" + "     if (status === daum.maps.services.Status.OK) {\r\n"
				+ "        var coords = new daum.maps.LatLng(result[0].y, result[0].x);\r\n"
				+ "        var marker = new daum.maps.Marker({\r\n" + "            map: map,\r\n"
				+ "            position: coords\r\n" + "        });\r\n"
				+ "        var infowindow = new daum.maps.InfoWindow({\r\n"
				+ "            content: '<div style=\"width:150px;text-align:center;padding:6px 0;\">"
				+ vo.getFtruckName() + "</div>'\r\n" + "        });\r\n" + "        infowindow.open(map, marker);\r\n"
				+ "        map.setCenter(coords);\r\n" + "    } \r\n" + "});";
		com += "</script>";
		map.put("com", com);
		String info = "";

		return map;
	}

}
