package com.foodtruck.controller;

import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.foodtruck.service.EventService;
import com.foodtruck.service.MemberService;
import com.foodtruck.service.NoticeService;
import com.foodtruck.vo.EventVO;
import com.foodtruck.vo.MemberVO;
import com.foodtruck.vo.NoticeVO;
import com.sun.media.jfxmedia.Media;

@Controller
@RequestMapping("/android")
public class AndroidController<Article> {
	@Autowired
	private NoticeService noticeService;
	@Autowired
	private EventService eventService;
	@Autowired
	private MemberService memberService;

	/*안드로이드에서 페이징처리 어떻게 할것인지*/
	
	
	
	/* NOTICE */
	@RequestMapping(value = "/notice", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	@ResponseBody
	public String androidNotice() throws Exception {
		System.out.println("android notice connect");

		List<NoticeVO> list = noticeService.getNoticeBoardList(1);

		String result = new ObjectMapper().writeValueAsString(list);

		System.out.println("json: " + result);

		return result;

	}

	/* NOTICE COUNT */
	@RequestMapping(value = "/noticecount", method = RequestMethod.PUT)
	public ResponseEntity<String> androidNoticeCount(@RequestBody NoticeVO vo) throws Exception {
		System.out.println("android notice connect");

		int i = noticeService.countNotice(vo.getNoticeNo());

		return new ResponseEntity<String>(HttpStatus.OK);
	}

	/* EVENT */
	@RequestMapping(value = "/event", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	@ResponseBody
	public String androidEvent() throws Exception {
		System.out.println("android event connect");

		List<EventVO> list = eventService.getEventBoardList(1);

		String result = new ObjectMapper().writeValueAsString(list);

		System.out.println("json: " + result);

		return result;
	}

	/* EVENT COUNT */
	@RequestMapping(value = "/eventcount", method = RequestMethod.PUT)
	public ResponseEntity<String> androidEventCount(@RequestBody EventVO vo) throws Exception {

		if (eventService.countEvent(vo.getEventNo()) <= 1) {
			return new ResponseEntity<String>(HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}

	}

	/* REGISTER */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> androidRegister(@RequestBody MemberVO vo) throws Exception {
		System.out.println("register connect");
		vo.setMemberAuth("3");
		memberService.insertMember(vo);

		return new ResponseEntity<String>(HttpStatus.CREATED);
	}

	/* LOGIN CHECK */
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json;charset=utf-8", consumes = "application/json;charset=utf-8")
	@ResponseBody
	public String androidLogin(@RequestBody String json) throws Exception {
		System.out.println("login connect");
		System.out.println("json : " + json);
		// Map<String, String> map = new ObjectMapper().readValue(params, Map.class);
		JSONObject jsonObject = new ObjectMapper().readValue(json, JSONObject.class);

		
		
		MemberVO mvo = memberService.getMember(jsonObject.get("id").toString());
		System.out.println("mvo : "+mvo);
		
		String result;

		/* 데이터베이스에 사용자가 등록되어있는지 */
		if (mvo != null) {
			/* 비밀번호가 맞는지 */
			if (mvo.getMemberPw().equals(jsonObject.get("pw").toString())) {

				result = new ObjectMapper().writeValueAsString(mvo);

				System.out.println(result);
				/* mvo(데이터베이스정보)를 json을 안드로이드에 전달.하고 로그인이 성공했다고 알려주기 */
				return result;
			} else {
				/* 비밀번호가 틀렸을때 false */
				result = "pw failed";

				return result;
			}

		} else {
			/* 없는 사용자일때 알려주기 */
			result = "id failed";
			return result;
		}

	}

	/* 푸드트럭과 상품보여주기 */
	/* 푸드트럭 검색기능 */
	/* 푸드트럭 상세보기 기능 */
	/* 푸드트럭 위치 지도로 보여주는 기능 */

}
