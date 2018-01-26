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

	// ��������
	@RequestMapping("/eventBoard")
	public String getEventBoardList(Model model, HttpServletResponse response, HttpSession session, MemberVO mvo,
			HttpServletRequest request, @RequestParam("pageNo") int pageNo) {
		// 페이징처리
		int NpageNo = 1;
		if (pageNo != 1) {
			NpageNo = (pageNo - 1) * 10 + 1;
		}
		int count =eventService.getCountEvent();
		
		List<EventVO> list = eventService.getEventBoardList(NpageNo);
		if (list != null) {
			model.addAttribute("rank", list);
		}
		request.setAttribute("pageNo", pageNo);
		request.setAttribute("pagecount", count);
		return "nav/eventBoard";
	}

	// �������� ��
	@RequestMapping("/detailEventForm")
	public String detailEventForm(@RequestParam("eventNo") int eventNo, HttpServletRequest request) {
		EventVO vo = eventService.getEvent(eventNo);

		request.setAttribute("vo", vo);

		eventService.countEvent(vo.getEventNo()); // ��ȸ��

		return "nav/detailEventForm";
	}

	// �������� �۾���
	@RequestMapping("/writeEventForm")
	public String writeEvent() {
		return "nav/writeEventForm";
	}

	// �������� ���
	@RequestMapping("/insertEvent")
	public String insertEvent(HttpSession session, EventVO vo, MemberVO mvo) {

		MemberVO m = (MemberVO) session.getAttribute("member");
		vo.setMemId(m.getMemberId()); 
		System.out.println(vo.getEventTitle());
		// vo.setMemberId(mvo.getMemberId());

		eventService.insertEvent(vo);
		return "redirect:/eventBoard?pageNo=1";
	}

	// �������� ���� ��
	@RequestMapping("/updateEventForm")
	public String updateEventForm(HttpServletRequest request, @RequestParam("eventNo") int eventNo) {
		EventVO vo = eventService.getEvent(eventNo);
		request.setAttribute("event", vo);
		return "nav/updateEventForm";
	}

	// �������� ����
	@RequestMapping("/updateEvent")
	public String updateEvent(EventVO vo) {
		eventService.updateEvent(vo);

		System.out.println("update Controller");
		return "redirect:/eventBoard?pageNo=1";
	}

	// �������� ����
	@RequestMapping("/deleteEvent")
	public String deleteEvent(EventVO vo) {
		eventService.deleteEvent(vo);

		return "redirect:/eventBoard?pageNo=1";
	}

}
