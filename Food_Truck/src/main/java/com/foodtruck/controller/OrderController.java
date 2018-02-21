package com.foodtruck.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.foodtruck.service.DeliveryDetailService;
import com.foodtruck.service.FoodTruckService;
import com.foodtruck.service.MemberService;
import com.foodtruck.service.OrderDetailService;
import com.foodtruck.service.OrderService;
import com.foodtruck.service.ProductService;
import com.foodtruck.service.ReviewService;
import com.foodtruck.vo.DeliveryDetailVO;
import com.foodtruck.vo.FoodTruckVO;
import com.foodtruck.vo.MemberVO;
import com.foodtruck.vo.OrderDetailVO;
import com.foodtruck.vo.OrderVO;
import com.foodtruck.vo.ProductVO;
import com.foodtruck.vo.ReviewVO;


@Controller
public class OrderController {
	@Autowired
	ProductService Pservice;
	
	@Autowired
	OrderService Oservice;
	
	@Autowired
	OrderDetailService orderdetailService;
	 
	@Autowired
	ReviewService reviewService;
	
	@Autowired
	FoodTruckService fService;
	
	@Autowired
	DeliveryDetailService ddservice;
	
	@Autowired
	MemberService mService;	
	
	
	@RequestMapping("/order")
	public String order(HttpSession session,@RequestParam("licenseNo") String licenseNo,HttpServletRequest request,
						@RequestParam("ftruckNo") String ftruckNo) throws Exception {
		String memId = (String) session.getAttribute("memberId");
		if (memId == null) {
			List<ProductVO> Plist = Pservice.getProductList(ftruckNo);
			request.setAttribute("ftruckDlvYn", "N");
			request.setAttribute("list", Plist);
		} else {
			List<ProductVO> Plist = Pservice.getProductList(ftruckNo);
			FoodTruckVO vo = fService.getFoodTruck(ftruckNo);
			String ftruckDlvYn = vo.getFtruckDlvYn();
			
			int mileage = mService.getMember(memId).getMileage();	//사용자가 가지고있는 마일리지
			request.setAttribute("mileage", mileage);
			
			request.setAttribute("ftruckDlvYn", ftruckDlvYn);
			request.setAttribute("list", Plist);
		}
		
		return "nav/order";
	}
	
	//비회원 주문번호 + 전화번호로 주문내역 보기 
	@RequestMapping("/nonMemberOrderDetail")
	public String nonMemberOrderDetail(HttpServletRequest request) {
		String ordNo = request.getParameter("ordNo");
		String ordTel = request.getParameter("ordTel");
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ordNo", ordNo);
		map.put("ordTel", ordTel);
		
		List<OrderVO> list = (List<OrderVO>) Oservice.getNonmemberInfo(map);
		request.setAttribute("nonList", list);
		request.setAttribute("ordNo", list.get(0).getOrdNo());
		request.setAttribute("ordName", list.get(0).getOrdName());
		request.setAttribute("ordTel", list.get(0).getOrdTel());
		request.setAttribute("ordDate", list.get(0).getOrdDate());
		request.setAttribute("ordReq", list.get(0).getOrdReq());
		request.setAttribute("sumPrice", list.get(0).getSumPrice());
		request.setAttribute("cookStat", list.get(0).getCookStat());
		request.setAttribute("ordDlyYn", list.get(0).getOrdDlyYn());
		return "nav/nonMemberOrderDetail";
	}

	// 사용자 주문내역 조회
	@RequestMapping("/memberOrderInfo")
	public String memberOrderInfo(HttpSession session,HttpServletRequest request) {
		MemberVO vo = (MemberVO)session.getAttribute("member");
		List<OrderVO> list = Oservice.getMemberOrderList(vo.getMemberId());
		request.setAttribute("list", list);
		
		MemberVO mvo = (MemberVO)session.getAttribute("member");
		String memId = mvo.getMemberId(); 
		
		List<ReviewVO> reviewList = reviewService.getFoodTrcukName(memId);
		request.setAttribute("reviewList", reviewList);
		Oservice.dlvTimeUpdate(memId); // 사용자가 배달시간? 알림온거 확인하면 변경
		
		return "member/memberOrderInfo";
	}
	
	
	// 주문 -> 예약 & 예약 디테일 (& 배달 디테일)
	@RequestMapping("/orderRegit")
	public String wishInsert(HttpSession session, HttpServletRequest request,
										@RequestParam("ordName") String ordName, 
										@RequestParam("ordTel") String ordTel, 
										@RequestParam("ordReq") String ordReq, 
										@RequestParam("licenseNo") String licenseNo, 
										@RequestParam("prodNo") List<String> prodNo, 
										@RequestParam("prodName") List<String> prodName,
										@RequestParam("ordQty") List<Integer> ordQty,
										@RequestParam("ordPrice") List<Integer> ordPrice,
										@RequestParam("sumPrice") int sumPrice,
										@RequestParam("ordDlyYn") String ordDlyYn,
										@RequestParam("payment") int payment,
										@RequestParam(value="ordRsvDate1" ,required=false) String ordRsvDate1,
			                            @RequestParam(value="ordRsvDate2" ,required=false) String ordRsvDate2,
			                            @RequestParam(value="dlvAddr1",required=false) String dlvAddr1,
			                            @RequestParam(value="dlvAddr2",required=false) String dlvAddr2) {
		
		Map<String,Object> orderMap = new HashMap<String, Object>();
		Map<String,Object> orderdetailMap = new HashMap<String, Object>();
		Map<String,Object> orderInfoList = new HashMap<String, Object>();	
		Map<String,Object> memberMap = new HashMap<String, Object>();
		
		//예약내역이면
		if(ordDlyYn.equals("N")) {
			String ordRsvDate="";
			Date date = new Date();
			SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.HOUR, Integer.parseInt(ordRsvDate1));
			cal.add(Calendar.MINUTE, Integer.parseInt(ordRsvDate2));
			ordRsvDate = sdformat.format(cal.getTime()); 
			orderMap.put("ordRsvDate", ordRsvDate);
		} else {
			orderMap.put("ordRsvDate", "");
		}
		
		String memId = (String)session.getAttribute("memberId");
		// 회원 & 비회원
		if(memId != null) {
			orderMap.put("memId", memId);
			int mileage = (int)(sumPrice * 5 * 0.01);	// 주문 총 가격 의 5% 마일리지로 적립
			int getmileage = mService.getMember(memId).getMileage(); // 회원의 마일리지 확인
			if(getmileage != 0) {	// 마일리지가 있으면 기존 마일리지 + 적립 마일리지
				mileage += getmileage;
			}
			memberMap.put("memId", memId);
			memberMap.put("mileage", mileage);
			mService.updateMileage(memberMap);	// 마일리지 수정				
		}else {
			orderMap.put("memId", "");
		}		
		// order 테이블에 들어갈껑!
		if(ordName != null) {
			orderMap.put("ordName", ordName);
			orderMap.put("ordTel", ordTel);
			orderMap.put("ordReq", ordReq);
			orderMap.put("licenseNo", licenseNo);
			orderMap.put("sumPrice", sumPrice);
			orderMap.put("ordDlyYn", ordDlyYn);
			orderMap.put("payment", payment);
				
		}
		
		Oservice.insertOrder(orderMap); 
		
		String ordNo = String.valueOf(orderMap.get("ordNo"));
		
		for(int i = 0 ; i < prodNo.size() ; i++) {
			// orderdetail 테이블
			orderdetailMap.put("prodNo", prodNo.get(i));
			orderdetailMap.put("ordQty", ordQty.get(i));
			orderdetailMap.put("ordPrice", ordPrice.get(i));
				
			if(ordQty.get(i) != 0) {
				System.out.println(ordNo);
				orderdetailMap.put("ordNo", ordNo);
				orderdetailService.insertOrderDetail(orderdetailMap);
			}
		}
			
		orderInfoList.put("ordNo", ordNo);
		orderInfoList.put("licenseNo", licenseNo);
		List<OrderDetailVO> orderInfolist = orderdetailService.getOrderInfoList(ordNo);
		request.setAttribute("dlvAddr", "none");
		request.setAttribute("ordNo", orderInfolist.get(0).getOrdNo());
		request.setAttribute("ordName", orderInfolist.get(0).getOrdName());
		request.setAttribute("ordTel", orderInfolist.get(0).getOrdTel());
		request.setAttribute("ordDate", orderInfolist.get(0).getOrdDate());
		request.setAttribute("ordReq", orderInfolist.get(0).getOrdReq());
		request.setAttribute("sumPrice", orderInfolist.get(0).getSumPrice());
			
		// 다수의 값들
		request.setAttribute("orderInfolist", orderInfolist);	
		System.out.println("진입이당!");
			
		//배달상세내역 insert
		if("Y".equals(ordDlyYn)) {
			String dlvAddr="";
			dlvAddr+=dlvAddr1;
			dlvAddr+="  "+dlvAddr2;
				
			DeliveryDetailVO vo= new DeliveryDetailVO();
			vo.setDlvAddr(dlvAddr);
			vo.setOrdNo(ordNo);
			vo.setDlvState(0);
			ddservice.insertDeliveryDetail(vo);
			System.out.println("진입이당!8");
			request.setAttribute("dlvAddr", dlvAddr);
			request.setAttribute("ordNo", orderInfolist.get(0).getOrdNo());
			request.setAttribute("ordName", orderInfolist.get(0).getOrdName());
			request.setAttribute("ordTel", orderInfolist.get(0).getOrdTel());
			request.setAttribute("ordDate", orderInfolist.get(0).getOrdDate());
			request.setAttribute("ordReq", orderInfolist.get(0).getOrdReq());
			request.setAttribute("sumPrice", orderInfolist.get(0).getSumPrice());
			request.setAttribute("orderInfolist", orderInfolist);	
		}
		
		return "nav/orderChk";
	}
	
	// 판매자 입장 / 상태 변경하기 (대기 / 조리 / 완료)
	@RequestMapping("/cookStatChange")
	@ResponseBody
	public ModelAndView cookStatChanage(Model model, @RequestParam("cookStat") int cookStat, @RequestParam("ordNo") String ordNo, @RequestParam(value="dlever",required=false) String dlever,@RequestParam(value="dlvDate",required=false) String dlvDate) {
		//배달정보
		System.out.println("상태봐꾸기 집입");
		ModelAndView mv = new ModelAndView(new MappingJackson2JsonView());
		if(dlever!=null) {
			System.out.println("진입");
			// 디비에 넣으러가잠!
			HashMap<String, Object> map = new HashMap<>();
	
			map.put("cookStat", cookStat);
			map.put("ordNo", ordNo);
			map.put("dlvDate",dlvDate);
			//배달시간 update
			
			mv.addObject("time", ddservice.dlyTimeUpdate(map));
			mv.addObject("cookStatChange", ddservice.dlecookStatChange(map));
		}else {
			System.out.println("상태 바꾸러 왔담 : " + "주문 번호" + ordNo + "변경할 상태 값 : " + cookStat);
		
			// 디비에 넣으러가잠!
			HashMap<String, Object> map = new HashMap<>();
			map.put("cookStat", cookStat);
			map.put("ordNo", ordNo);
			   
			mv.addObject("cookStatChange", Oservice.cookSataChange(map));
			   	
		}
		
		return mv;
		
	}
	
	@ResponseBody
	@RequestMapping("/updateOrderCountRsv")
	public List<OrderVO> updateOrderCountRsv(HttpSession session) {
		String memId = (String)session.getAttribute("memberId");
		return Oservice.getNewCountRsv(memId);	// 판매자가 확인하지않은 새로운 예약 주문 갯수 및 정보
	}
	
	@ResponseBody
	@RequestMapping("/updateOrderCountDlv")
	public List<OrderVO> updateOrderCountDlv(HttpSession session) {
		String memId = (String)session.getAttribute("memberId");
		return Oservice.getNewCountDlv(memId);	// 판매자가 확인하지 않은 새로운 배달 주문 갯수 및 정보
	}	
	
	@ResponseBody
	@RequestMapping("/dlvTimeSend")
	public OrderVO dlvTimeSend(HttpSession session) {
		OrderVO vo = new OrderVO();
		String memId = (String)session.getAttribute("memberId");
		List<OrderVO> list = Oservice.ordStatFind(memId);
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getCookStat() == 1) {
				vo = Oservice.dlvTimeSend(memId);
			}
		}
		return vo;
	}
	
	// 주문 취소 하기
	@RequestMapping("/orderCancel")
	public String deleteOrder(HttpSession session, HttpServletRequest request, 
			   							@RequestParam("ordNo") String ordNo,
			   							@RequestParam("ordDlyYn") String ordDlyYn) {
		
		System.out.println("주문 번호 확인 : " + ordNo + " /  배달 여부 확인  " + ordDlyYn);
	    String memId = (String) session.getAttribute("memberId");
	      
	    // 배달 내역 삭제할 때
	    if("Y".equals(ordDlyYn)) {
	    	ddservice.deleteDeliveryDetail(ordNo);
	    }
	    
	    orderdetailService.deleteOrderDetail(ordNo);
	     
	    Oservice.deleteOrder(ordNo);
	    System.out.println("삭제 완료");
	         
	    if(memId != null) {
	    	return "redirect:/memberOrderInfo";
	    } else {
	    	request.setAttribute("msg", "주문이 취소 되었습니다.");
		    request.setAttribute("addr", "loginform");
		    return "comm/msg";
	   }
	 }
}
