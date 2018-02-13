package com.foodtruck.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.swing.plaf.synth.SynthSplitPaneUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.foodtruck.service.DeliveryDetailService;
import com.foodtruck.service.OrderDetailService;
import com.foodtruck.service.OrderService;
import com.foodtruck.service.SellerService;
import com.foodtruck.vo.MemberVO;

@Controller
public class OrderDetailController {

	@Autowired
	private OrderDetailService orderDetailService;

	@Autowired
	private SellerService sellerService;

	@Autowired
	private DeliveryDetailService dservice;

	// 배달상세내역보기
	@RequestMapping("/DeliveryDetail")
	public String DeliveryDetail(Model model, HttpSession session) {
		System.out.println("진입");
		MemberVO mvo = (MemberVO) session.getAttribute("member");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ordDate", null);
		map.put("memId", mvo.getMemberId());
		map.put("licenseNo", null);
		String memId = mvo.getMemberId();
		System.out.println("몰라아아아" + memId);
		if (mvo != null) {

			model.addAttribute("ORD_DLV_YN", "Y");
			model.addAttribute("dleverDetailList", dservice.getDeliveryDetailList(map));
			model.addAttribute("licenseList", sellerService.getLicense(memId));

		} else {
			return "home";
		}

		return "nav/deliveryDetails";
	}

	/* 예약내역 이름변경하기 */
	@RequestMapping("/orderDetail")
	public String orderDetailPage(Model model, HttpSession session) {

		MemberVO mvo = (MemberVO) session.getAttribute("member");
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("ordDate", null);
		map.put("memId", mvo.getMemberId());
		map.put("licenseNo", null);

		String memId = mvo.getMemberId();

		if (mvo != null) {
			model.addAttribute("orderDetailList", orderDetailService.getOrderDetailList(map));
			model.addAttribute("licenseList", sellerService.getLicense(memId));

		} else {
			return "home";
		}
		// 주문 상세 리스트
		return "nav/orderDetail";
	}

	@RequestMapping("/orderDetail2")
	@ResponseBody
	public ModelAndView calandLicenseNoChagneList(Model model, HttpSession session,
			@RequestParam("ordDate") String ordDate, @RequestParam("licenseNo") String licenseNo) {

		System.out.println(ordDate);
		MemberVO mvo = (MemberVO) session.getAttribute("member");
		String memId = mvo.getMemberId();

		ModelAndView mv = new ModelAndView(new MappingJackson2JsonView());

		HashMap<String, Object> map = new HashMap<>();
		map.put("memId", memId);
		map.put("ordDate", ordDate);
		map.put("licenseNo", licenseNo);

		if (mvo != null) {
			System.out.println("쓔바아아아아유ㅠㅠㅠㅠ넘어가라겅 ㅠㅠㅠㅠ");
			mv.addObject("orderDetailList", orderDetailService.getOrderDetailList(map));
		}

		return mv;
	}
}
