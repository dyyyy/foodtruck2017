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
import com.foodtruck.vo.ApiVO;
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
		List<FoodTruckVO> list = fservice.getFoodTruckList(NpageNo);// rownumï¿½ï¿½ Çªï¿½ï¿½Æ®ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½Æ®
		;
		int pagecount = fservice.getCountTruck();// ï¿½ï¿½ Çªï¿½ï¿½Æ®ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½
		System.out.println("ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½È£" + pageNo);
		request.setAttribute("pageNo", pageNo);
		request.setAttribute("list", list);
		request.setAttribute("pagecount", pagecount);// ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½
		return "foodtruck/menuBoard";
	}

	// FoodTruck ¹ÙµÏÆÇ List
	@RequestMapping("/menuBoard2")
	public String menuBoardPage2(Model model,@RequestParam("pageNo") int pageNo,HttpServletRequest request)throws Exception {
		int NpageNo=0;
		if(pageNo==1) {
			pageNo=1;
		}else {
			NpageNo=(pageNo-1)*10+1;
		}
		List<FoodTruckVO> list =fservice.getFoodTruckList(NpageNo);//rownumµÈ ÇªµåÆ®·° ¸®½ºÆ®
		;
		 int pagecount=fservice.getCountTruck();//ÃÑ ÇªµåÆ®·° °³¼ö
		 System.out.println("ÆäÀÌÁö ¹øÈ£"+pageNo);
		 request.setAttribute("pageNo", pageNo);
		 request.setAttribute("list",list);
	     request.setAttribute("pagecount", pagecount);//ÃÑ ÆäÀÌÁö ¼ö
	     
		return "foodtruck/menuBoard2";
	}
	
	// CategoryFood
	@RequestMapping("/CategoryFood")
	public String korFoodPage(Model model, @RequestParam("pageNo") int pageNo, HttpServletRequest request,
			@RequestParam("category") int category) throws Exception {
		PageVO vo = new PageVO();
		vo.setCategory(category);
		int NpageNo = 0;
		if (pageNo == 1) {
			pageNo = 1;
			vo.setPageNo(pageNo);
		} else {
			NpageNo = (pageNo - 1) * 10 + 1;
			vo.setPageNo(NpageNo);
		}

		List<FoodTruckVO> list = fservice.getCategoryList(vo);
		int pagecount = fservice.getCategoryCountTruck(category);// ï¿½ï¿½ Çªï¿½ï¿½Æ®ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½
		request.setAttribute("pageNo", pageNo);
		request.setAttribute("list", list);
		request.setAttribute("pagecount", pagecount);
		request.setAttribute("categoryno", category);
		return "foodtruck/CategoryFood";
	}

	// ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½
	@RequestMapping("/read")
	public String foodinfo(@RequestParam("ftruckNo") String ftruckNo, HttpServletRequest request) throws Exception {
		double pyengjum = 0;// ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ ï¿½Õ°ï¿½
		double count = 0; // ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½
		double total = 0; // Çªï¿½ï¿½Æ®ï¿½ï¿½ ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½
		FoodTruckVO vo = fservice.getFoodTruck(ftruckNo);// Çªï¿½ï¿½Æ®ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ È£ï¿½ï¿½
		if (vo.getFtruckAddr() == null) {
			vo.setFtruckAddr(vo.getFtruckAddr2());
		}

		List<ReviewVO> Rlist = rservice.getReviewList(ftruckNo);// ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ È£ï¿½ï¿½
		List<ProductVO> Plist = pservice.getProductList(ftruckNo);// ï¿½ï¿½Ç° ï¿½ï¿½ï¿½ï¿½ È£ï¿½ï¿½
		if (Rlist.size() != 0) {
			for (int i = 0; i < Rlist.size(); i++) {
				double score = Rlist.get(i).getGrade();
				pyengjum += score;
				count = Rlist.size();
				total = pyengjum / count;
				total = Double.parseDouble(String.format("%.2f", total));
			}
		} else {
			total = 0;
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

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		String addr = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/searchFestival?ServiceKey=";
		String serviceKey = "H%2F5lCacGTb8Gu0hK0t%2FZ%2BR04rZ7FtCgprC9i3gXHYFbGvnPOF1UikRkxLw07AXydV%2BN7SBJCExRUanyQ2DRgVQ%3D%3D";

		String parameter = "";
		// serviceKey = URLEncoder.encode(serviceKey,"utf-8");

		PrintWriter out = response.getWriter();
		Date date = new Date();
		SimpleDateFormat sdformat = new SimpleDateFormat("YYYYMMdd");
		String today = sdformat.format(date);// ï¿½ì½ï¿½ì˜±ï¿½ê¶‡ï§žï¿½
		// PrintWriter out = new PrintWriter(new OutputStream
		// Writer(response.getOutputStream(),"KSC5601"));
		// ServletOutputStream out = response.getOutputStream();
		parameter = parameter + "&" + "areaCode=1";
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

		JSONParser parser = new JSONParser();
		Object obj = parser.parse(s);
		JSONObject json = (JSONObject) obj;

		// json.put("data", data);

		JSONObject js = (JSONObject) json.get("response");
		JSONObject jj = (JSONObject) js.get("body");
		JSONObject items = (JSONObject) jj.get("items");
		JSONArray jArray = (JSONArray) items.get("item");

		List<ApiVO> list = new ArrayList<ApiVO>();
		for (int j = 0; j < jArray.size(); j++) {
			JSONObject a = (JSONObject) jArray.get(j);
			ApiVO vo = new ApiVO();

			vo.setAddr1(a.get("addr1").toString());
			vo.setTitle(a.get("title").toString());
			vo.setMapx(a.get("mapx").toString());
			vo.setMapy(a.get("mapy").toString());
			vo.setEventstartdate(a.get("eventstartdate").toString());
			vo.setEventenddate(a.get("eventenddate").toString());
			vo.setTel(a.get("tel").toString());
			vo.setFirstimage(a.get("firstimage").toString());
			vo.setFirstimage2(a.get("firstimage2").toString());
			list.add(vo);

		}
		for (int j = 0; j < list.size(); j++) {

			System.out.println("list:" + list.get(j).getFirstimage());

		}
		
		return "nav/recommend";
	}
}
