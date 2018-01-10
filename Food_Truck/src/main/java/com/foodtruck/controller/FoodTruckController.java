package com.foodtruck.controller;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.jsoup.Jsoup;
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

import com.sun.xml.internal.txw2.Document;
import com.sun.xml.internal.ws.developer.MemberSubmissionEndpointReference.Elements;

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
		List<FoodTruckVO> list =fservice.getFoodTruckList(NpageNo);//rownum�� Ǫ��Ʈ�� ����Ʈ
		;
		 int pagecount=fservice.getCountTruck();//�� Ǫ��Ʈ�� ����
		 System.out.println("������ ��ȣ"+pageNo);
		 request.setAttribute("pageNo", pageNo);
		 request.setAttribute("list",list);
	     request.setAttribute("pagecount", pagecount);//�� ������ ��
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
		int pagecount=fservice.getCategoryCountTruck(category);//�� Ǫ��Ʈ�� ����
		 request.setAttribute("pageNo", pageNo);
		 request.setAttribute("list",list);
	     request.setAttribute("pagecount", pagecount);
	     request.setAttribute("categoryno", category);
		return "foodtruck/CategoryFood";
	}


	// ������
	@RequestMapping("/read")
	public String foodinfo(@RequestParam("ftruckNo") String ftruckNo, HttpServletRequest request) throws Exception {
		double pyengjum = 0;//���� ���� �հ�
		double count = 0; //���� ��
		double total = 0; //Ǫ��Ʈ�� �� ����
		FoodTruckVO vo = fservice.getFoodTruck(ftruckNo);//Ǫ��Ʈ�� ���� ȣ��
		if(vo.getFtruckAddr()==null) {
			vo.setFtruckAddr(vo.getFtruckAddr2());
		}
		
		List<ReviewVO> Rlist = rservice.getReviewList(ftruckNo);// ���� ���� ȣ��
		List<ProductVO> Plist = pservice.getProductList(ftruckNo);// ��ǰ ���� ȣ��
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
	
	//���� api�޾ƿ���
	   @RequestMapping("/api")
	   public String inputAddr(HttpServletRequest request, HttpServletResponse response) throws Exception {
		      //logger.info("PublicData2");
		   List<ApiVO> list = new ArrayList<ApiVO>();
		   
		      request.setCharacterEncoding("utf-8");
		      response.setContentType("text/html; charset=utf-8");

		      String addr = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/searchFestival?ServiceKey=";
		      String serviceKey = "H%2F5lCacGTb8Gu0hK0t%2FZ%2BR04rZ7FtCgprC9i3gXHYFbGvnPOF1UikRkxLw07AXydV%2BN7SBJCExRUanyQ2DRgVQ%3D%3D";
		      
		      String parameter = "";
		      // serviceKey = URLEncoder.encode(serviceKey,"utf-8");
		      
		      PrintWriter out = response.getWriter();
		      Date date = new Date();
		      SimpleDateFormat sdformat = new SimpleDateFormat("YYYYMMdd");
		      String today = sdformat.format(date);//현재날짜
		      // PrintWriter out = new PrintWriter(new OutputStream
		      // Writer(response.getOutputStream(),"KSC5601"));
		      // ServletOutputStream out = response.getOutputStream();
		      parameter = parameter + "&" + "areaCode=1";
		      parameter = parameter + "&" + "eventStartDate="+today;
		      parameter = parameter + "&" + "eventEndDate=20181231";
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
		      System.out.println("mbos: " + mbos);

		      byte[] b = mbos.getBytes("UTF-8");
		      String s = new String(b, "UTF-8");
		      out.println(s);
		      System.out.println("s: " + s);

		      JSONObject json = new JSONObject();
		      json.put("data", s);
		      // json.put("data", data);
		      System.out.println("json: " + json);

		      JSONObject jso = json.getJSONObject("data");
		      JSONObject js = jso.getJSONObject("response");
		      JSONObject jj = js.getJSONObject("body");
		      JSONObject items = jj.getJSONObject("items");
		      JSONArray jArray = items.getJSONArray("item");

		      
		      
		      for (int j = 0; j < list.size(); j++) {
		         JSONObject a = jArray.getJSONObject(j);
		         
		         ApiVO vo = new ApiVO();
		         vo.setAddr1(a.getString("addr1"));
		         vo.setTitle(a.getString("title"));
		         vo.setMapx(a.getString("mapx"));
		         vo.setMapy(a.getString("mapy"));
		         vo.setEventstartdate(a.getString("eventstartdate"));
		         vo.setEventenddate(a.getString("eventenddate"));
		         vo.setTel(a.getString("tel"));
		         
		         list.add(vo);
		      }
		   
		     // int i = service.inputAddr(list);
		      //System.out.println(i);
		      return "test";
		   }
	   

}
