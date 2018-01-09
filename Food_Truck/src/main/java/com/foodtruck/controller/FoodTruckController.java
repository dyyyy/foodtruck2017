package com.foodtruck.controller;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.foodtruck.service.FoodTruckService;
import com.foodtruck.service.ProductService;
import com.foodtruck.service.ReviewService;
import com.foodtruck.vo.ApiVO;
import com.foodtruck.vo.FoodTruckVO;
import com.foodtruck.vo.PageVO;
import com.foodtruck.vo.ProductVO;
import com.foodtruck.vo.ReviewVO;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class FoodTruckController {
	//dd
	@Autowired
	private FoodTruckService fservice;
	@Autowired
	private ReviewService rservice;
	@Autowired
	private ProductService pservice;

	// FoodTrcuk List
	@RequestMapping("/menuBoard")
	public String menuBoarPage(Model model,@RequestParam("pageNo") int pageNo,HttpServletRequest request) throws Exception {
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
		return "foodtruck/menuBoard";
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
		
		List<FoodTruckVO> list=fservice.getCategoryList(vo);
		int pagecount=fservice.getCategoryCountTruck(category);//총 푸드트럭 개수
		 request.setAttribute("pageNo", pageNo);
		 request.setAttribute("list",list);
	     request.setAttribute("pagecount", pagecount);
	     request.setAttribute("categoryno", category);
		return "foodtruck/CategoryFood";
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
	
	//오픈 api받아오기
	   @RequestMapping("/api")
	      public void inputAddr(HttpServletRequest request, HttpServletResponse response) throws Exception {
	         
	         request.setCharacterEncoding("utf-8");
	         response.setContentType("text/html; charset=utf-8");

	         String addr = "http://www.localdata.kr/platform/rest/24_87_01_P/openApi?authKey=";
	         String serviceKey = "mqvI9PePHU5a4wcrdPyt2wCtulRkfOMEZCFVtKJNqaU=";
	         String parameter = "";
	         // serviceKey = URLEncoder.encode(serviceKey,"utf-8");

	         PrintWriter out = response.getWriter();
	         // PrintWriter out = new PrintWriter(new OutputStream
	         // Writer(response.getOutputStream(),"KSC5601"));
	         // ServletOutputStream out = response.getOutputStream();
	         //api중 가져올 조건을 등록하기 예)영업중인 푸드트럭만 가져오기
	         parameter = parameter + "&" + "state=01";
	         parameter = parameter + "&" + "addrType=0";
	         parameter = parameter + "&" + "resultType=json";
	         parameter = parameter + "&" + "pageSize=1000";

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
	         System.out.println("mbos: " + mbos);

	         byte[] b = mbos.getBytes("UTF-8");
	         String s = new String(b, "UTF-8");
	         out.println(s);
	         System.out.println("s: " + s);

	         JSONObject json = new JSONObject();
	         json.put("data", s);
	         // json.put("data", data);
	         System.out.println("json: " + json);
	         //api의 구조
	         JSONObject jso = json.getJSONObject("data");
	         JSONObject js = jso.getJSONObject("result");
	         JSONObject jj = js.getJSONObject("body");
	         JSONObject items = jj.getJSONObject("rows");
	         JSONArray jArray = items.getJSONArray("row");
	         
	         //받아온 api 데이터를 list에 넣는 작업
	         List<ApiVO> list = new ArrayList<ApiVO>();
	         for (int i = 0; i < list.size(); i++) {
	            JSONObject a = jArray.getJSONObject(i);
	            
	            ApiVO vo = new ApiVO();
	            vo.setBplcNm(a.getString("bplcNm"));
	            vo.setSiteTel(a.getString("siteTel"));
	            vo.setRdnWhlAddr(a.getString("rdnWhlAddr"));
	            vo.setSiteWhlAddr(a.getString("siteWhlAddr"));
	            vo.setApvPermYmd(a.getString("apvPermYmd"));
	            vo.setDtlStateNm(a.getString("dtlStateNm"));
	            vo.setX(a.getString("x"));
	            vo.setY(a.getString("y"));
	            list.add(vo);
	         }
	         //int i = service.inputAddr(list);
	        
	         for(int i=0;i<list.size();i++) {
	            System.out.println(list.get(i).getBplcNm());
	         }
	   }       

}
