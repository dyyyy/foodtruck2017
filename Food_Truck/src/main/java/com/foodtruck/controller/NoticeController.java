package com.foodtruck.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.foodtruck.service.MemberService;
import com.foodtruck.service.NoticeService;
import com.foodtruck.vo.MemberVO;
import com.foodtruck.vo.NoticeVO;

@Controller
public class NoticeController {
	
	@Autowired
	NoticeService noticeService;
	
	@Autowired
	MemberService memberService;
	
	// 占쏙옙占쏙옙占쏙옙占쏙옙
	@RequestMapping("/noticeBoard")
	public String getNoticeBoardList(Model model, HttpServletResponse response, HttpSession session, MemberVO mvo, HttpServletRequest request,@RequestParam("pageNo") int pageNo) throws Exception {
		//�럹�씠吏뺤쿂由�
		int NpageNo = 0;
		if (pageNo == 1) {
			pageNo = 1;
		} else {
			NpageNo = (pageNo - 1) * 10 + 1;
		}
		List<NoticeVO> list = noticeService.getNoticeBoardList(NpageNo);
		System.out.println(list.size());
		if(list != null) {
			model.addAttribute("rank", list);
		}
		int count=noticeService.getCountNotice();
		request.setAttribute("pageNo", pageNo);
		request.setAttribute("pagecount", count);
		
		
		return "nav/noticeBoard";
	}
	
	// 占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙
	@RequestMapping("/detailNoticeForm")
	public String detailNoticeForm(@RequestParam("noticeNo")int noticeNo, HttpServletRequest request) {
		NoticeVO vo = noticeService.getNotice(noticeNo);
		
		
		request.setAttribute("vo", vo);
		
		noticeService.countNotice(vo.getNoticeNo()); // 占쏙옙회占쏙옙
		
		return "nav/detailNoticeForm";
	}
	
	
	// 占쏙옙占쏙옙占쏙옙占쏙옙 占쌜억옙占쏙옙
	@RequestMapping("/writeNoticeForm")
	public String writeNotice(HttpSession session, HttpServletRequest request) {
//		MemberVO vo = (MemberVO)session.getAttribute("member");
//		request.setAttribute("vo", vo);
		
		return "nav/writeNoticeForm";
	}
	
	
	// 占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙占�
	@RequestMapping("/insertNotice")
	public String insertNotice(HttpSession session, NoticeVO vo, MemberVO mvo) {
		
		MemberVO m = (MemberVO)session.getAttribute("member");
		vo.setMemId(m.getMemberId());
		
//		vo.setMemberId(mvo.getMemberId());
		
		noticeService.insertNotice(vo);
		return "redirect:/noticeBoard?pageNo=1";
	}

	
	// 占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙
	@RequestMapping("/updateNoticeForm")
	public String updateNoticeForm(HttpServletRequest request, @RequestParam("noticeNo")int noticeNo) {
		NoticeVO vo = noticeService.getNotice(noticeNo);
		request.setAttribute("notice", vo);
		return "nav/updateNoticeForm";
	}
	
	
	// 占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙
	@RequestMapping("/updateNotice")
	public String updateNotice(NoticeVO vo) {
		noticeService.updateNotice(vo);
		
		System.out.println("update Controller");
		return "redirect:/noticeBoard?pageNo=1";
	}
	
	
	// 占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙
	@RequestMapping("/deleteNotice")
	public String deleteNotice(NoticeVO vo) {
		noticeService.deleteNotice(vo);
		
		return "redirect:/noticeBoard?pageNo=1";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
