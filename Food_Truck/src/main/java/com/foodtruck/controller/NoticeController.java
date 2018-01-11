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
	
	// 공지사항
	@RequestMapping("/noticeBoard")
	public String getNoticeBoardList(Model model, HttpServletResponse response, HttpSession session, MemberVO mvo, HttpServletRequest request) {
		List<NoticeVO> list = noticeService.getNoticeBoardList();
		
		if(list != null) {
			model.addAttribute("rank", list);
		}
		
		return "nav/noticeBoard";
	}
	
	// 공지사항 상세
	@RequestMapping("/detailNoticeForm")
	public String detailNoticeForm(@RequestParam("noticeNo")int noticeNo, HttpServletRequest request) {
		NoticeVO vo = noticeService.getNotice(noticeNo);
		
		request.setAttribute("vo", vo);
		
		noticeService.countNotice(vo.getNoticeNo()); // 조회수
		
		return "nav/detailNoticeForm";
	}
	
	
	// 공지사항 글쓰기
	@RequestMapping("/writeNoticeForm")
	public String writeNotice() {
		return "nav/writeNoticeForm";
	}
	
	
	// 공지사항 등록
	@RequestMapping("/insertNotice")
	public String insertNotice(HttpSession session, NoticeVO vo, MemberVO mvo) {
		
		MemberVO m = (MemberVO)session.getAttribute("member");
		vo.setMemberId(m.getMemberId());
		
//		vo.setMemberId(mvo.getMemberId());
		
		noticeService.insertNotice(vo);
		return "redirect:/noticeBoard";
	}

	
	// 공지사항 수정 폼
	@RequestMapping("/updateNoticeForm")
	public String updateNoticeForm(HttpServletRequest request, @RequestParam("noticeNo")int noticeNo) {
		NoticeVO vo = noticeService.getNotice(noticeNo);
		request.setAttribute("notice", vo);
		return "nav/updateNoticeForm";
	}
	
	
	// 공지사항 수정
	@RequestMapping("/updateNotice")
	public String updateNotice(NoticeVO vo) {
		noticeService.updateNotice(vo);
		
		System.out.println("update Controller");
		return "redirect:/noticeBoard";
	}
	
	
	// 공지사항 삭제
	@RequestMapping("/deleteNotice")
	public String deleteNotice(NoticeVO vo) {
		noticeService.deleteNotice(vo);
		
		return "redirect:/noticeBoard";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
