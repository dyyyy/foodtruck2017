package com.foodtruck.controller;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.foodtruck.service.MemberService;
import com.foodtruck.service.ProductService;
import com.foodtruck.vo.MemberVO;
import com.foodtruck.vo.ProductVO;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private MemberService memberService;
	@Resource(name="uploadPath")
    String uploadPath;
	
	// ��ǰ ��� �ϴ� ������ �̵�
	@RequestMapping("/insertProductForm") 
	public String insertProductForm(Model model, HttpSession session) {
		
		MemberVO mvo = (MemberVO)session.getAttribute("member");
		
		String selId = mvo.getMemberId(); 
		
		// ����� ��ȣ 
		model.addAttribute("list", memberService.getLicenseNo(selId));
		
		return "nav/productInsert";
	}
	
	
	// ��ǰ ���
	@RequestMapping("/insertProduct")
	@ResponseBody
	public int insertProduct(ProductVO vo ,@RequestParam("img") MultipartFile file) throws IOException {
		 String savedName = file.getOriginalFilename();
		 File target = new File(uploadPath, savedName);
		 FileCopyUtils.copy(file.getBytes(), target);
		System.out.println(uploadPath);
		vo.setProdImg(uploadPath);
		int num=productService.insertProduct(vo);
		
		return num;
	}
}
