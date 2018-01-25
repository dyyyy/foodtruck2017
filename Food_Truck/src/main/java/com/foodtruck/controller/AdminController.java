package com.foodtruck.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.foodtruck.service.AdminService;
import com.foodtruck.service.FestivalService;
import com.foodtruck.service.FoodTruckService;
import com.foodtruck.service.MemberService;
import com.foodtruck.service.SellerService;
import com.foodtruck.vo.FestivalVO;
import com.foodtruck.vo.FoodTruckVO;
import com.foodtruck.vo.LicenseVO;
import com.foodtruck.vo.MInquiryVO;
import com.foodtruck.vo.MinquiryReplyVO;
import com.sun.javafx.collections.MappingChange.Map;

@Controller
public class AdminController {
	@Autowired
	private FoodTruckService fservice;
	@Autowired
	private FestivalService feservice;
	@Autowired
	private MemberService mservice;
	@Autowired
	private AdminService aservice;
	@Autowired
	private SellerService sservice;

	// ������ �޴� - ��������
	@RequestMapping("/stute")
	public String stute(@RequestParam("pageNo") int pageNo, HttpServletRequest request) throws Exception {
		int NpageNo = 1;
		if (pageNo != 1) {
			NpageNo = (pageNo - 1) * 10 + 1;
		}

		List<FoodTruckVO> list = fservice.getFoodTruckList(NpageNo);
		int count = fservice.getCountTruck();
		request.setAttribute("pageNo", pageNo);
		request.setAttribute("list", list);
		request.setAttribute("pagecount", count);// �� ������ ��
		return "admin/stute";
	}

	// 판매자 Q&A
	@RequestMapping("/sellerQnA")
	public String sellerQnA(HttpServletRequest request, @RequestParam("pageNo") int pageNo) {
		int NpageNo = 1;
		if (pageNo != 1) {
			NpageNo = (pageNo - 1) * 10 + 1;
		}
		List<MInquiryVO> list = sservice.getSinquiryList(NpageNo);
		int count = sservice.getSinquiryListcount();
		request.setAttribute("pagecount", count);
		request.setAttribute("list", list);
		return "admin/sellerQnA";
	}

	// 일반회원 Q&A
	@RequestMapping("/memberQnA")
	public String memberQnA(HttpServletRequest request, @RequestParam("pageNo") int pageNo) {
		int NpageNo = 1;
		if (pageNo != 1) {
			NpageNo = (pageNo - 1) * 10 + 1;
		}
		List<MInquiryVO> list = mservice.getMinquiryList(NpageNo);
		int count = mservice.getMinquiryListcount();
		request.setAttribute("pagecount", count);
		request.setAttribute("list", list);
		return "admin/memberQnA";
	}

	@RequestMapping("/festival")
	public String festival(@RequestParam("pageNo") int pageNo, HttpServletRequest request) throws Exception {
		int NpageNo = 1;
		if (pageNo != 1) {
			NpageNo = (pageNo - 1) * 10 + 1;
		}
		List<FestivalVO> list = feservice.getFestivalList2(NpageNo);
		int count = feservice.getcountFestival();
		request.setAttribute("pageNo", pageNo);
		request.setAttribute("list", list);
		request.setAttribute("pagecount", count);// �� ������ ��
		return "admin/festival";
	}

	@RequestMapping("/admin")
	public String admin() {
		return "admin/main";
	}

	@RequestMapping("/foodtruck")
	public String foodtruck(HttpServletRequest request,@RequestParam("pageNo") int pageNo) {
		int NpageNo = 1;
		if (pageNo != 1) {
			NpageNo = (pageNo - 1) * 10 + 1;
		}
		List<LicenseVO> list=aservice.getRequestList(NpageNo);
		int count = aservice.getRequestCount();
		request.setAttribute("list", list);
		request.setAttribute("pagecount", count);
		return "admin/foodturck";
	}


	@RequestMapping("/MQnAdetail")
	@ResponseBody
	public HashMap MQnAdetail(@RequestParam("qno") int qno) {
		MInquiryVO vo = mservice.getinfo(qno);
		HashMap map = new HashMap();
		map.put("id", vo.getMemId());
		map.put("content", vo.getQaScContent());
		map.put("title", vo.getQaScTitle());
		map.put("qno", qno);
		return map;
	}
	//ㅇㅇ
	// 1:1 일반회원 댓글달기
	@RequestMapping("/MinquryReply")
	@ResponseBody
	public int MinquryReply(@RequestParam("email") String email, @RequestParam("reply") String reply,
			@RequestParam("qno") int qno) throws InterruptedException {
		int finish = 0;
		MinquiryReplyVO vo = new MinquiryReplyVO();
		vo.setMemId(email);
		vo.setReplyScContent(reply);
		vo.setQaScNo(qno);
		aservice.insertMinquryReply(vo);
		finish = mservice.updateMinquiry(qno);
		return finish;

	}

}
