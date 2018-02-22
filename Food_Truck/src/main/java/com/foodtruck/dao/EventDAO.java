package com.foodtruck.dao;

import java.util.List;

import com.foodtruck.vo.EventVO;
import com.foodtruck.vo.NoticeVO;

public interface EventDAO {
	
	public List<EventVO> getEventBoardList(int NpageNo);
	
	public EventVO getEvent(int noticeNo);
	
	public int insertEvent(EventVO vo);
	
	public int updateEvent(EventVO vo);
	
	public int countEvent(int noticeNo);
	
	public int deleteEvent(EventVO vo);
	
	public int getCountEvent();
	
	// menuBoard에 이벤트 진행중이면, 푸드트럭 이름 옆에 이벤트 띄워 주려고
	public List<EventVO> progressEvent();
}
