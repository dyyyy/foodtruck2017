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
		System.out.println("진입");
		int NpageNo = 1;
		if (pageNo != 1) {
			NpageNo = (pageNo - 1) * 10 + 1;
		}

		List<FoodTruckVO> list = fservice.getFoodTruckList(NpageNo);
		String stat="운영중";
		String stat2="마감";
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getFtruckState().equals("Y")) {
				list.get(i).setFtruckState(stat);
			}else {
				list.get(i).setFtruckState(stat2);
			}
			
			if(list.get(i).getFtruckAddr()==null) {
				list.get(i).setFtruckAddr(list.get(i).getFtruckAddr2());
			}
			
			
		}
		int count = fservice.getCountTruck();
		request.setAttribute("pageNo", pageNo);
		request.setAttribute("list", list);
		request.setAttribute("pagecount", count);// �� ������ ��
		return "admin/stute";
	}
	//운영중 푸드트럭
	@RequestMapping("/run")
	public String run(@RequestParam("pageNo") int pageNo, HttpServletRequest request) throws Exception {
		int NpageNo = 1;
		if (pageNo != 1) {
			NpageNo = (pageNo - 1) * 10 + 1;
		}
		List<FoodTruckVO> list=fservice.getRunFoodTruckList(NpageNo);
		String stat="운영중";
		String stat2="마감";
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getFtruckState().equals("Y")) {
				list.get(i).setFtruckState(stat);
			}else {
				list.get(i).setFtruckState(stat2);
			}
		}
		int count=fservice.getRunCountTruck();
		request.setAttribute("pageNo", pageNo);
		request.setAttribute("list", list);
		request.setAttribute("pagecount", count);
		return "admin/runstute";
	}
	//마감중 푸드트럭
	@RequestMapping("/end")
	public String end(@RequestParam("pageNo") int pageNo, HttpServletRequest request)throws Exception{
		int NpageNo = 1;
		if (pageNo != 1) {
			NpageNo = (pageNo - 1) * 10 + 1;
		}
		List<FoodTruckVO> list=fservice.getEndFoodTruckList(NpageNo);
		String stat="운영중";
		String stat2="마감";
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getFtruckState().equals("Y")) {
				list.get(i).setFtruckState(stat);
			}else {
				list.get(i).setFtruckState(stat2);
			}
		}
		int count=fservice.getEndCountTruck();
		request.setAttribute("pageNo", pageNo);
		request.setAttribute("list", list);
		request.setAttribute("pagecount", count);
		return"admin/endstute";
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
		request.setAttribute("pageNo", pageNo);
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
		request.setAttribute("pageNo", pageNo);
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
	public String foodtruck(HttpServletRequest request, @RequestParam("pageNo") int pageNo) {
		int NpageNo = 1;
		if (pageNo != 1) {
			NpageNo = (pageNo - 1) * 10 + 1;
		}
		List<LicenseVO> list = aservice.getRequestList(NpageNo);
		int count = aservice.getRequestCount();
		request.setAttribute("list", list);
		request.setAttribute("pagecount", count);
		request.setAttribute("pageNo", pageNo);
		return "admin/foodturck";
	}
	@RequestMapping("/getTruck")
	@ResponseBody
	public HashMap getTruck(@RequestParam("ftruckNo") String ftruckNo) throws Exception {
		HashMap map = new HashMap();
		FoodTruckVO vo= fservice.getFoodTruck(ftruckNo);
		if(vo.getFtruckAddr()==null) {
			vo.setFtruckAddr(vo.getFtruckAddr2());
		}
		String category="";
		if (vo.getCategory() == 1) {
			category = "한식";
		} else if (vo.getCategory() == 2) {
			category = "중식";
		} else if (vo.getCategory() == 3) {
			category = "양식";
		} else if (vo.getCategory() == 4) {
			category = "일식";
		}
		String Content = "";
		Content += "<script type=\"text/javascript\">"
				+ "								var geocoder = new daum.maps.services.Geocoder();\r\n"
				+ "								\r\n" + "								geocoder.addressSearch('"
				+ vo.getFtruckAddr() + "', function(result, status) {\r\n" + "\r\n"
				+ "								    // 정상적으로 검색이 완료됐으면 \r\n"
				+ "								     if (status === daum.maps.services.Status.OK) {\r\n" + "\r\n"
				+ "								        var coords = new daum.maps.LatLng(result[0].y, result[0].x);\r\n"
				+ "\r\n" + "								        // 결과값으로 받은 위치를 마커로 표시합니다\r\n"
				+ "								        var marker = new daum.maps.Marker({\r\n"
				+ "								            map: map,\r\n"
				+ "								            position: coords\r\n"
				+ "								        });\r\n" + "\r\n"
				+ "								        // 인포윈도우로 장소에 대한 설명을 표시합니다\r\n"
				+ "								        var infowindow = new daum.maps.InfoWindow({\r\n"
				+ "								            content: '<div style=\"width:150px;text-align:center;padding:6px 0;\">"
				+ vo.getFtruckName() + "</div>'\r\n" + "								        });\r\n"
				+ "								        infowindow.open(map, marker);\r\n" + "\r\n"
				+ "								        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다\r\n"
				+ "								        map.setCenter(coords);\r\n"
				+ "								    } \r\n" + "								});\r\n"
				+ "								\r\n" + "							</script>		";
		String table = "";
		table += "<table border=1 class=\"table table-striped table-bordered\">\r\n" + 
				"					<tr>\r\n" + 
				"						<td rowspan=2 style=\"width: 100px;\">대표이미지</td>\r\n" + 
				"						<td rowspan=2 colspan=3><img  src=\"/resources/img/"+vo.getFtruckImg()+"\" style=\"width: 420px;height: 200px;\"></td>\r\n" + 
				"					</tr>\r\n" + 
				"					<tr></tr>\r\n" + 
				"					<tr>\r\n" + 
				"						<td>상호명</td>\r\n" + 
				"						<td colspan=3>"+vo.getFtruckName()+"</td>\r\n" + 
				"					</tr>\r\n" + 
				"					<tr>\r\n" + 
				"						<td>사업자번호</td>\r\n" + 
				"						<td colspan=3>"+vo.getLicenseNo()+"</td>\r\n" + 
				"					</tr>\r\n" + 
				"					<tr>\r\n" + 
				"						<td>주소</td>\r\n" + 
				"						<td colspan=3>"+vo.getFtruckAddr()+"</td>\r\n" + 
				"					</tr>\r\n" + 
				"					<tr>\r\n" + 
				"						<td rowspan=3>소개글</td>\r\n" + 
				"						<td rowspan=3 colspan=3>"+vo.getFtruckIntro()+"</td>\r\n" + 
				"					</tr>\r\n" + 
				"					<tr></tr>\r\n" + 
				"					<tr></tr>\r\n" + 
				"					<tr>\r\n" + 
				"						<td>카테고리</td>\r\n" + 
				"						<td colspan=3>"+category+"</td>\r\n" + 
				"					</tr>\r\n" + 
				"					<tr>\r\n" + 
				"						<td>예약</td>\r\n" + 
				"						<td colspan=3>"+vo.getFtruckRsvYn()+"</td>\r\n" + 
				"					</tr>\r\n" + 
				"					<tr>\r\n" + 
				"						<td>배달</td>\r\n" + 
				"						<td colspan=3>"+vo.getFtruckDlvYn()+"</td>\r\n" + 
				"					</tr>\r\n" + 
				"				</table>";
		map.put("content", Content);
		map.put("table", table);
		return map;
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

	// ㅇㅇ
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

	@RequestMapping("/approvalList")
	@ResponseBody
	public HashMap approvalList(@RequestParam("licenseNo") String licenseNo) throws Exception {
		String category = "";
		HashMap map = new HashMap();
		FoodTruckVO vo = fservice.getFoodTruck2(licenseNo);
		if (vo.getFtruckAddr() == null) {
			vo.setFtruckAddr(vo.getFtruckAddr2());
		}
		if (vo.getCategory() == 1) {
			category = "한식";
		} else if (vo.getCategory() == 2) {
			category = "중식";
		} else if (vo.getCategory() == 3) {
			category = "양식";
		} else if (vo.getCategory() == 4) {
			category = "일식";
		}
		String Content = "";
		Content += "<script type=\"text/javascript\">"
				+ "								var geocoder = new daum.maps.services.Geocoder();\r\n"
				+ "								\r\n" + "								geocoder.addressSearch('"
				+ vo.getFtruckAddr() + "', function(result, status) {\r\n" + "\r\n"
				+ "								    // 정상적으로 검색이 완료됐으면 \r\n"
				+ "								     if (status === daum.maps.services.Status.OK) {\r\n" + "\r\n"
				+ "								        var coords = new daum.maps.LatLng(result[0].y, result[0].x);\r\n"
				+ "\r\n" + "								        // 결과값으로 받은 위치를 마커로 표시합니다\r\n"
				+ "								        var marker = new daum.maps.Marker({\r\n"
				+ "								            map: map,\r\n"
				+ "								            position: coords\r\n"
				+ "								        });\r\n" + "\r\n"
				+ "								        // 인포윈도우로 장소에 대한 설명을 표시합니다\r\n"
				+ "								        var infowindow = new daum.maps.InfoWindow({\r\n"
				+ "								            content: '<div style=\"width:150px;text-align:center;padding:6px 0;\">"
				+ vo.getFtruckName() + "</div>'\r\n" + "								        });\r\n"
				+ "								        infowindow.open(map, marker);\r\n" + "\r\n"
				+ "								        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다\r\n"
				+ "								        map.setCenter(coords);\r\n"
				+ "								    } \r\n" + "								});\r\n"
				+ "								\r\n" + "							</script>		";

		String table = "";
		table += "<table border=1 class=\"table table-striped table-bordered\">\r\n" + 
				"					<tr>\r\n" + 
				"						<td rowspan=2 style=\"width: 100px;\">대표이미지</td>\r\n" + 
				"						<td rowspan=2 colspan=3><img  src=\"/resources/img/"+vo.getFtruckImg()+"\" style=\"width: 420px;height: 200px;\"></td>\r\n" + 
				"					</tr>\r\n" + 
				"					<tr></tr>\r\n" + 
				"					<tr>\r\n" + 
				"						<td>상호명</td>\r\n" + 
				"						<td colspan=3>"+vo.getFtruckName()+"</td>\r\n" + 
				"					</tr>\r\n" + 
				"					<tr>\r\n" + 
				"						<td>사업자번호</td>\r\n" + 
				"						<td colspan=3>"+vo.getLicenseNo()+"</td>\r\n" + 
				"					</tr>\r\n" + 
				"					<tr>\r\n" + 
				"						<td>주소</td>\r\n" + 
				"						<td colspan=3>"+vo.getFtruckAddr()+"</td>\r\n" + 
				"					</tr>\r\n" + 
				"					<tr>\r\n" + 
				"						<td rowspan=3>소개글</td>\r\n" + 
				"						<td rowspan=3 colspan=3>"+vo.getFtruckIntro()+"</td>\r\n" + 
				"					</tr>\r\n" + 
				"					<tr></tr>\r\n" + 
				"					<tr></tr>\r\n" + 
				"					<tr>\r\n" + 
				"						<td>카테고리</td>\r\n" + 
				"						<td colspan=3>"+category+"</td>\r\n" + 
				"					</tr>\r\n" + 
				"					<tr>\r\n" + 
				"						<td>예약</td>\r\n" + 
				"						<td colspan=3>"+vo.getFtruckRsvYn()+"</td>\r\n" + 
				"					</tr>\r\n" + 
				"					<tr>\r\n" + 
				"						<td>배달</td>\r\n" + 
				"						<td colspan=3>"+vo.getFtruckDlvYn()+"</td>\r\n" + 
				"					</tr>\r\n" + 
				"				</table>";
		map.put("content", Content);
		map.put("table", table);
		map.put("licenseNo", vo.getLicenseNo());
		return map;
	}
	@RequestMapping("/approval")
	@ResponseBody
	public int approval(@RequestParam("licenseNo") String licenseNo) throws Exception {
		int num=0;
		String app="Y";
		LicenseVO vo= new LicenseVO();
		vo.setAppStat(app);
		vo.setLicenseNo(licenseNo);		
		num=aservice.appFoodtruck(vo);
		return num;
	}
	
	

}
