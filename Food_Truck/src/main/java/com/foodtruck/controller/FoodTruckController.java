package com.foodtruck.controller;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.foodtruck.service.FoodTruckService;
import com.foodtruck.service.ProductService;
import com.foodtruck.service.ReviewService;
import com.foodtruck.vo.FestivalVO;
import com.foodtruck.vo.FoodTruckVO;
import com.foodtruck.vo.PageVO;
import com.foodtruck.vo.ProductVO;
import com.foodtruck.vo.ReviewVO;

@Controller
public class FoodTruckController {
	// dd
	@Autowired
	private FoodTruckService fservice;
	@Autowired
	private ReviewService rservice;
	@Autowired
	private ProductService pservice;

	// FoodTrcuk List
	@RequestMapping("/menuBoard")
	public String menuBoarPage(Model model, @RequestParam("pageNo") int pageNo, HttpServletRequest request)
			throws Exception {
		int NpageNo = 0;
		if (pageNo == 1) {
			pageNo = 1;
		} else {
			NpageNo = (pageNo - 1) * 10 + 1;
		}
		List<FoodTruckVO> list = fservice.getFoodTruckList(NpageNo);//rownum된 푸드트럭 리스트
		;
		int pagecount = fservice.getCountTruck();// //총 푸드트럭 개수
		System.out.println("페이지 번호" + pageNo);
		request.setAttribute("pageNo", pageNo);
		request.setAttribute("list", list);
		request.setAttribute("pagecount", pagecount);//총 페이지 수
		return "foodtruck/menuBoard";
	}

	// FoodTruck List2
	@RequestMapping("/menuBoard2")
	public String menuBoardPage2(Model model,@RequestParam("pageNo") int pageNo,HttpServletRequest request)throws Exception {
		int NpageNo=0;
		if(pageNo==1) {
			pageNo=1;
		}else {
			NpageNo=(pageNo-1)*10+1;
		}
		List<FoodTruckVO> list =fservice.getFoodTruckList(NpageNo);//rownum된 푸드트럭 리스트
		;
		 int pagecount=fservice.getCountTruck();//총 푸드트럭 개수
		 System.out.println("페이지 번호"+pageNo);
		 request.setAttribute("pageNo", pageNo);
		 request.setAttribute("list",list);
	     request.setAttribute("pagecount", pagecount);//총 페이지 수
	     
		return "foodtruck/menuBoard2";
	}
	
	// CategoryFood
	@RequestMapping("/CategoryFood")
	public String korFoodPage(Model model,@RequestParam("pageNo") int pageNo,HttpServletRequest request,@RequestParam("category") int category) throws Exception {
		PageVO vo =new PageVO();
		vo.setCategory(category);
		int NpageNo=0;
		if(pageNo==1) {
			pageNo=1;
			vo.setPageNo(pageNo);	
		}else {
			NpageNo=(pageNo-1)*10+1;
			vo.setPageNo(NpageNo);	
		}
		System.out.println(category);
		List<FoodTruckVO> list=fservice.getCategoryList(vo);
		int pagecount=fservice.getCategoryCountTruck(category);//총 푸드트럭 개수
		 request.setAttribute("pageNo", pageNo);
		 request.setAttribute("list",list);
	     request.setAttribute("pagecount", pagecount);
	     request.setAttribute("categoryno", category);
		return "foodtruck/CategoryFood";
	}

	// CategoryFood2
	@RequestMapping("/CategoryFood2")
	public String korFoodPage2(Model model,@RequestParam("pageNo") int pageNo,HttpServletRequest request, @RequestParam("category") int category) throws Exception {
		PageVO vo =new PageVO();
		vo.setCategory(category);
		int NpageNo=0;
		if(pageNo==1) {
			pageNo=1;
			vo.setPageNo(pageNo);	
		}else {
			NpageNo=(pageNo-1)*10+1;
			vo.setPageNo(NpageNo);	
		}
		List<FoodTruckVO> list=fservice.getCategoryList(vo);
		int pagecount=fservice.getCategoryCountTruck(category);//총 푸드트럭 개수
		 request.setAttribute("pageNo", pageNo);
		 request.setAttribute("list",list);
		 request.setAttribute("babo",list);
	     request.setAttribute("pagecount", pagecount);
	     request.setAttribute("categoryno", category);
	     
		return "foodtruck/CategoryFood2";
	}	
	
	// 상세정보
	@RequestMapping("/read")
	public String foodinfo(@RequestParam("ftruckNo") String ftruckNo, HttpServletRequest request) throws Exception {
		double pyengjum = 0;//리뷰 평점 합계
		double count = 0; //리뷰 수
		double total = 0; //푸드트럭 총 평점
		FoodTruckVO vo = fservice.getFoodTruck(ftruckNo);//푸드트럭 정보 호출
		if(vo.getFtruckAddr()==null) {
			vo.setFtruckAddr(vo.getFtruckAddr2());
		}
		
		List<ReviewVO> Rlist = rservice.getReviewList(ftruckNo);// 리뷰 정보 호출
		List<ProductVO> Plist = pservice.getProductList(ftruckNo);// 상품 정보 호출
		if(Rlist.size()!=0) {
			for (int i = 0; i < Rlist.size(); i++) {
				double score = Rlist.get(i).getGrade();
				pyengjum += score;
				count = Rlist.size();
				total = pyengjum / count;
				total = Double.parseDouble(String.format("%.2f",total));
			}	
		}else {
			total=0;		
		}
		vo.setFtruckGrade(total);
		request.setAttribute("vo", vo);
		request.setAttribute("review", Rlist);
		request.setAttribute("product", Plist);
		return "foodtruck/detail";
	}

	@RequestMapping("/api")
	public String inputAddr(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// logger.info("PublicData2");
		List<FestivalVO> list = new ArrayList<FestivalVO>();
		int num[] = { 1, 2, 3, 4, 5, 6, 7, 8, 31, 32 };

		for (int q = 0; q < num.length; q++) {
			try {
				int code = num[q];
				System.out.println(code);
				request.setCharacterEncoding("utf-8");
				response.setContentType("text/html; charset=utf-8");

				String addr = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/searchFestival?ServiceKey=";
				String serviceKey = "H%2F5lCacGTb8Gu0hK0t%2FZ%2BR04rZ7FtCgprC9i3gXHYFbGvnPOF1UikRkxLw07AXydV%2BN7SBJCExRUanyQ2DRgVQ%3D%3D";

				String parameter = "";
				// serviceKey = URLEncoder.encode(serviceKey,"utf-8");

				PrintWriter out = response.getWriter();
				Date date = new Date();
				SimpleDateFormat sdformat = new SimpleDateFormat("YYYYMMdd");
				String today = sdformat.format(date);
				// PrintWriter out = new PrintWriter(new OutputStream
				// Writer(response.getOutputStream(),"KSC5601"));
				// ServletOutputStream out = response.getOutputStream();
				parameter = parameter + "&" + "areaCode=" + code;
				parameter = parameter + "&" + "cat1=A02";
				parameter = parameter + "&" + "cat2=A0207";
				parameter = parameter + "&" + "eventStartDate=" + today;
				parameter = parameter + "&" + "eventEndDate=20191231";
				parameter = parameter + "&" + "pageNo=1&numOfRows=100";
				parameter = parameter + "&" + "arrange=B";
				parameter = parameter + "&" + "listYN=Y";
				parameter = parameter + "&" + "MobileOS=ETC";
				parameter = parameter + "&" + "MobileApp=aa";
				parameter = parameter + "&" + "_type=json";

				addr = addr + serviceKey + parameter;
				URL url = new URL(addr);

				System.out.println(addr);

				// BufferedReader in = new BufferedReader(new
				// InputStreamReader(url.openStream(), "UTF-8"));

				InputStream in = url.openStream();
				// CachedOutputStream bos = new CachedOutputStream();
				ByteArrayOutputStream bos1 = new ByteArrayOutputStream();
				IOUtils.copy(in, bos1);
				in.close();
				bos1.close();

				String mbos = bos1.toString("UTF-8");

				byte[] b = mbos.getBytes("UTF-8");
				String s = new String(b, "UTF-8");
				out.println(s);

				/* json parsing */
				System.out.println(s);
				JSONParser parser = new JSONParser();
				Object obj = parser.parse(s);
				JSONObject json = (JSONObject) obj;

				// json.put("data", data);

				JSONObject js = (JSONObject) json.get("response");
				JSONObject jj = (JSONObject) js.get("body");
				JSONObject items = (JSONObject) jj.get("items");
				JSONArray jArray = (JSONArray) items.get("item");

				for (int j = 0; j < jArray.size(); j++) {
					JSONObject a = (JSONObject) jArray.get(j);
					FestivalVO vo = new FestivalVO();
					vo.setAddr1(a.get("addr1").toString());
					vo.setTitle(a.get("title").toString());
					vo.setMapx(a.get("mapx").toString());
					vo.setMapy(a.get("mapy").toString());
					vo.setEventstartdate(a.get("eventstartdate").toString());
					vo.setEventenddate(a.get("eventenddate").toString());
					vo.setTel(a.get("tel").toString());
					vo.setFirstimage((String) a.get("firstimage"));
					vo.setFirstimage2((String) a.get("firstimage2"));
					list.add(vo);

				}
			} catch (Exception e) {
				System.out.println("");
			}
		}
		for (int j = 0; j < list.size(); j++) {

			System.out.println(list.get(j).getAddr1());
			System.out.println(list.get(j).getTitle());
			System.out.println(list.get(j).getEventenddate());
			System.out.println(list.get(j).getEventstartdate());
			System.out.println(list.get(j).getMapx());
			System.out.println(list.get(j).getMapy());
			System.out.println(list.get(j).getTel());
			System.out.println(list.get(j).getFirstimage());
			System.out.println(list.get(j).getFirstimage2());

		}

		return "nav/recommend";

	}
}
