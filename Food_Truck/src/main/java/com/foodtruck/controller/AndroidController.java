package com.foodtruck.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.foodtruck.service.AndroidService;
import com.foodtruck.service.EventService;
import com.foodtruck.service.MemberService;
import com.foodtruck.service.NoticeService;
import com.foodtruck.vo.EventVO;
import com.foodtruck.vo.MInquiryVO;
import com.foodtruck.vo.MemberVO;
import com.foodtruck.vo.NoticeVO;

@Controller
public class AndroidController {
	@Autowired
	private NoticeService noticeService;
	@Autowired
	private AndroidService androidService;
	@Autowired
	private EventService eventService;
	@Autowired
	private MemberService memberService;

	/* NOTICE */
	@RequestMapping(value = "/notice", produces = "application/json;charset=utf8")
	@ResponseBody
	public String androidNotice(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("android notice connect");

		List<NoticeVO> list = androidService.getNoticeBoardList();

		String result = new ObjectMapper().writeValueAsString(list);

		System.out.println("json: " + result);

		return result;
	}

	/* NOTICE COUNT */
	@RequestMapping("/noticecount")
	public String androidNoticeCount(@RequestBody String params, HttpServletRequest request)
			throws JsonParseException, JsonMappingException, IOException {

		Map<String, Integer> map = new ObjectMapper().readValue(params, Map.class);

		int i = noticeService.countNotice(map.get("no"));

		return String.valueOf(i);
	}

	/* EVENT */
	@RequestMapping(value = "/event", produces = "application/json;charset=utf8")
	@ResponseBody
	public String androidEvent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("android event connect");

		List<EventVO> list = androidService.getEventeBoardList();

		String result = new ObjectMapper().writeValueAsString(list);

		System.out.println("json: " + result);

		return result;
	}

	/* EVENT COUNT */
	@RequestMapping("/eventcount")
	public String androidEventCount(@RequestBody String params, HttpServletRequest request)
			throws JsonParseException, JsonMappingException, IOException {

		Map<String, Integer> map = new ObjectMapper().readValue(params, Map.class);

		int i = eventService.countEvent(map.get("no"));

		return String.valueOf(i);
	}

	/* LOGIN CHECK */
	@RequestMapping(value = "/androidlogin", produces = "application/json;charset=utf8")
	@ResponseBody
	public String androidLogin(@RequestBody String params, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) throws Exception {
		System.out.println("login connect");

		Map<String, String> map = new ObjectMapper().readValue(params, Map.class);

		MemberVO mvo = memberService.getMember(map.get("id"));

		String result;

		/* 데이터베이스에 사용자가 등록되어있는지 */
		if (mvo != null) {
			/* 비밀번호가 맞는지 */
			if (mvo.getMemberPw().equals(map.get("pw"))) {

				result = new ObjectMapper().writeValueAsString(mvo);

				/* mvo(데이터베이스정보)를 json을 안드로이드에 전달.하고 로그인이 성공했다고 알려주기 */
				return result;
			} else {
				/* 비밀번호가 틀렸을때 false */
				result = "not pw";
				return result;
			}

		} else {
			/* 없는 사용자일때 알려주기 */
			result = "not id";
			return result;
		}

	}

	/* REGISTER */
	@RequestMapping(value = "/androidregister", produces = "application/json;charset=utf8")
	@ResponseBody
	public boolean androidRegister(@RequestBody String params, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) throws Exception {
		System.out.println("register connect");

		MemberVO vo = new ObjectMapper().readValue(params, MemberVO.class);

		int result = memberService.insertMember(vo);

		if (result <= 1) {
			return true;
		} else {
			return false;
		}
	}

	/* 문의하기 */
	// MemberController - memberinquriy 메소드, MinquiryVO, MinquiryReplyVO
	@RequestMapping(value = "/androidmemberinquiry", produces = "application/json;charset=utf8")
	@ResponseBody
	public Boolean androidinquriy(@RequestBody String params, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("inquiry connect");
		MInquiryVO vo = new MInquiryVO();

		vo = new ObjectMapper().readValue(params, MInquiryVO.class);
		vo.setQaScStat("N");

		if (params != null) {

			memberService.insertInquiry(vo);

			return true;
		} else {
			return false;
		}
	}

	/* 문의내역 */
	@RequestMapping(value = "/androidinqueryinfo", produces = "application/json;charset=utf8")
	@ResponseBody
	public String androidInquriyInfo(@RequestBody String params, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("inqueryinfo connect");

		Map<String, String> map = new ObjectMapper().readValue(params, Map.class);

		List<MInquiryVO> list = memberService.getMemberQaInfoList(map.get("id"));

		String result = new ObjectMapper().writeValueAsString(list);

		System.out.println("json: " + result);

		return result;
	}

	/* 상품보여주기 */

	// 판매자
	/* 로그인이 되면 로그인 정보와 소켓프로그램 작동 */

	/* 주문확인, 종료, 주문거부 확인(소켓통신) */

	/* 매출통계 및 매출관리 */
}
