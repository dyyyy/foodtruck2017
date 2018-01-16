package com.foodtruck.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodtruck.dao.MemberDAO;
import com.foodtruck.dao.NoticeDAO;
import com.foodtruck.vo.NoticeVO;

@Service
public class NoticeService {
	
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	public List<NoticeVO> getNoticeBoardList(int pageNo) {
		NoticeDAO dao = sessionTemplate.getMapper(NoticeDAO.class);
		return dao.getNoticeBoardList(pageNo);
	}
	
	
	public NoticeVO getNotice(int noticeNo) {
		NoticeDAO dao = sessionTemplate.getMapper(NoticeDAO.class);
		return dao.getNotice(noticeNo);
	}
	
	
	public int insertNotice(NoticeVO vo) {
		NoticeDAO dao = sessionTemplate.getMapper(NoticeDAO.class);
		
		return dao.insertNotice(vo);
	}
	
	public int updateNotice(NoticeVO vo) {
		NoticeDAO dao = sessionTemplate.getMapper(NoticeDAO.class);
		return dao.updateNotice(vo);
	}
	
	public int countNotice(int noticeNo) {
		NoticeDAO dao = sessionTemplate.getMapper(NoticeDAO.class);
		return dao.countNotice(noticeNo);
	}
	
	public int deleteNotice(NoticeVO vo) {
		NoticeDAO dao = sessionTemplate.getMapper(NoticeDAO.class);
		return dao.deleteNotice(vo);
	}
	public int getCountNotice() throws Exception {
		NoticeDAO dao = sessionTemplate.getMapper(NoticeDAO.class);
		return dao.getCountNotice();
	}

}
