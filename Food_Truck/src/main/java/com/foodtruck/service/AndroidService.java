package com.foodtruck.service;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodtruck.dao.AndroidDAO;
import com.foodtruck.vo.EventVO;
import com.foodtruck.vo.NoticeVO;

@Service
public class AndroidService {
	@Autowired
	private SqlSessionTemplate sessionTemplate;

	public List<NoticeVO> getNoticeBoardList () throws Exception{
		AndroidDAO dao = sessionTemplate.getMapper(AndroidDAO.class);
		return dao.getNoticeBoardList();
	}
	public ArrayList<EventVO> getEventeBoardList () throws Exception{
		AndroidDAO dao = sessionTemplate.getMapper(AndroidDAO.class);
		return dao.getEventBoardList();
	}
}
