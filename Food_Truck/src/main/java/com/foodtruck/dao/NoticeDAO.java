package com.foodtruck.dao;

import java.util.List;

import com.foodtruck.vo.NoticeVO;

public interface NoticeDAO {
	
	public List<NoticeVO> getNoticeBoardList();
	
	public NoticeVO getNotice(int noticeNo);
	
	public int insertNotice(NoticeVO vo);
	
	public int updateNotice(NoticeVO vo);
	
	public int countNotice(int noticeNo);
	
	public int deleteNotice(NoticeVO vo);

}
