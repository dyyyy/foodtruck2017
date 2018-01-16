package com.foodtruck.dao;

import java.util.List;

import com.foodtruck.vo.EventVO;
import com.foodtruck.vo.NoticeVO;

public interface EventDAO {
	
	public List<EventVO> getEventBoardList();
	
	public EventVO getEvent(int noticeNo);
	
	public int insertEvent(EventVO vo);
	
	public int updateEvent(EventVO vo);
	
	public int countEvent(int noticeNo);
	
	public int deleteEvent(EventVO vo);
	

}
