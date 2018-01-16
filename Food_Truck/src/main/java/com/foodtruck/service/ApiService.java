package com.foodtruck.service;

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

import com.foodtruck.vo.FestivalVO;

public class ApiService {
	public static List<FestivalVO> inputAddr(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
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
				String today = sdformat.format(date);// �쁽�옱�궇吏�
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
				System.out.println("s=" + s);
				JSONParser parser = new JSONParser();
				Object obj = parser.parse(s);
				JSONObject json = (JSONObject) obj;

				// json.put("data", data);
				// 지역별 행사정보 가져오기
				JSONObject js = (JSONObject) json.get("response");
				JSONObject jj = (JSONObject) js.get("body");
				JSONObject items = (JSONObject) jj.get("items");
				JSONArray jArray = (JSONArray) items.get("item");

				

			} catch (Exception e) {
				System.out.println("축제정보없음");
			}
		}

		return list;

	}

}
