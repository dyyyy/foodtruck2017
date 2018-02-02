package com.foodtruck.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.foodtruck.service.MemberService;
import com.foodtruck.service.ProductService;
import com.foodtruck.vo.MemberVO;
import com.foodtruck.vo.ProductVO;

@Controller
public class ProductController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	private final String PATH = "..\\Food_Truck\\src\\main\\webapp\\resources\\img\\upload\\";

	@Autowired
	MappingJackson2JsonView jsonView;

	@Autowired
	private ProductService productService;

	@Autowired
	private MemberService memberService;

	// ��ǰ ��� �ϴ� ������ �̵�
	@RequestMapping("/insertProductForm")
	public String insertProductForm(Model model, HttpSession session) {

		MemberVO mvo = (MemberVO) session.getAttribute("member");

		String selId = mvo.getMemberId();

		// ����� ��ȣ
		model.addAttribute("list", memberService.getLicenseNo(selId));

		return "nav/productInsert";
	}

	// ��ǰ ���
	@RequestMapping("/insertProduct")
	@ResponseBody
	public int insertProduct(ProductVO vo) throws IOException {

		int num = productService.insertProduct(vo);
		return num;

	}

	@RequestMapping("/imggo")
	@ResponseBody
	public HashMap img(MultipartHttpServletRequest request) throws IllegalStateException, IOException {
		ModelAndView model = new ModelAndView();
		model.setView(jsonView);

		Iterator<String> itr = request.getFileNames();

		if (itr.hasNext()) {
			List<MultipartFile> mpf = request.getFiles(itr.next());
			// 임시 파일을 복사한다.
			for (int i = 0; i < mpf.size(); i++) {

				File file = new File(PATH + mpf.get(i).getOriginalFilename());
				logger.info(file.getAbsolutePath());
				mpf.get(i).transferTo(file);

			}

			JSONObject json = new JSONObject();
			json.put("code", "true");
			model.addObject("result", json);
			// model.addObject("path", PATH);
			String pa=PATH + mpf.get(0).getOriginalFilename();
			HashMap map = new HashMap();
			map.put("path", pa);
			return map;
		} else {
			HashMap map = new HashMap();
			JSONObject json = new JSONObject();
			json.put("code", "false");
			model.addObject("result", json);
			map.put("path", "실패");
			return map;

		}

	}
}
