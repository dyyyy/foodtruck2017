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

import com.foodtruck.service.EventService;
import com.foodtruck.service.MemberService;
import com.foodtruck.vo.EventVO;
import com.foodtruck.vo.MemberVO;

@Controller
public class EventController {
	
	@Autowired
	EventService eventService;
	
	@Autowired
	MemberService memberService;
	
	// 공지사항
	@RequestMapping("/eventBoard")
	public String getEventBoardList(Model model, HttpServletResponse response, HttpSession session, MemberVO mvo, HttpServletRequest request) {
		List<EventVO> list = eventService.getEventBoardList();
		
		if(list != null) {
			model.addAttribute("rank", list);
		}
		
		return "nav/eventBoard";
	}
	
	// 공지사항 상세
	@RequestMapping("/detailEventForm")
	public String detailEventForm(@RequestParam("noticeNo")int noticeNo, HttpServletRequest request) {
		EventVO vo = eventService.getEvent(noticeNo);
		
		request.setAttribute("vo", vo);
		
		eventService.countEvent(vo.getNoticeNo()); // 조회수
		
		return "nav/detailEventForm";
	}
	
	
	// 공지사항 글쓰기
	@RequestMapping("/writeEventForm")
	public String writeEvent() {
		return "nav/writeEventForm";
	}
	
	
	// 공지사항 등록
	@RequestMapping("/insertEvent")
	public String insertEvent(HttpSession session, EventVO vo, MemberVO mvo) {
		
		MemberVO m = (MemberVO)session.getAttribute("member");
		vo.setMemberId(m.getMemberId());
		
//		vo.setMemberId(mvo.getMemberId());
		
		eventService.insertEvent(vo);
		return "redirect:/eventBoard";
	}

	
	// 공지사항 수정 폼
	@RequestMapping("/updateEventForm")
	public String updateEventForm(HttpServletRequest request, @RequestParam("noticeNo")int noticeNo) {
		EventVO vo = eventService.getEvent(noticeNo);
		request.setAttribute("event", vo);
		return "nav/updateEventForm";
	}
	
	
	// 공지사항 수정
	@RequestMapping("/updateEvent")
	public String updateEvent(EventVO vo) {
		eventService.updateEvent(vo);
		
		System.out.println("update Controller");
		return "redirect:/eventBoard";
	}
	
	
	// 공지사항 삭제
	@RequestMapping("/deleteEvent")
	public String deleteEvent(EventVO vo) {
		eventService.deleteEvent(vo);
		
		return "redirect:/eventBoard";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
