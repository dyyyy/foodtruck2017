package com.foodtruck.dao;

import java.util.ArrayList;
import java.util.List;

import com.foodtruck.vo.EventVO;
import com.foodtruck.vo.NoticeVO;

public interface AndroidDAO {

	public List<NoticeVO> getNoticeBoardList();

	public ArrayList<EventVO> getEventBoardList();
}
