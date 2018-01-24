package com.foodtruck.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodtruck.dao.EventDAO;
import com.foodtruck.dao.MemberDAO;
import com.foodtruck.dao.NoticeDAO;
import com.foodtruck.vo.EventVO;
import com.foodtruck.vo.NoticeVO;

@Service
public class EventService {
	
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	public List<EventVO> getEventBoardList(int NpageNo) {
		EventDAO dao = sessionTemplate.getMapper(EventDAO.class);
		return dao.getEventBoardList(NpageNo);
	}
	
	
	public EventVO getEvent(int noticeNo) {
		EventDAO dao = sessionTemplate.getMapper(EventDAO.class);
		return dao.getEvent(noticeNo);
	}
	
	
	public int insertEvent(EventVO vo) {
		EventDAO dao = sessionTemplate.getMapper(EventDAO.class);
		
		return dao.insertEvent(vo);
	}
	
	public int updateEvent(EventVO vo) {
		EventDAO dao = sessionTemplate.getMapper(EventDAO.class);
		return dao.updateEvent(vo);
	}
	
	public int countEvent(int noticeNo) {
		EventDAO dao = sessionTemplate.getMapper(EventDAO.class);
		return dao.countEvent(noticeNo);
	}
	
	public int deleteEvent(EventVO vo) {
		EventDAO dao = sessionTemplate.getMapper(EventDAO.class);
		return dao.deleteEvent(vo);
	}
	public int getCountEvent() {
		EventDAO dao = sessionTemplate.getMapper(EventDAO.class);
		return dao.getCountEvent();
	}

}
