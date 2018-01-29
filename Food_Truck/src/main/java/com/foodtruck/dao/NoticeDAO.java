package com.foodtruck.dao;

import java.util.List;

import com.foodtruck.vo.NoticeVO;

public interface NoticeDAO {
	
	//공시지사항 게시물가져오기
	public List<NoticeVO> getNoticeBoardList(int pageNo);
	
	public NoticeVO getNotice(int noticeNo);
	
	public int insertNotice(NoticeVO vo);
	
	public int updateNotice(NoticeVO vo);
	
	public int countNotice(int noticeNo);
	
	public int deleteNotice(NoticeVO vo);
	
	//공지사항 페이징 전체 개시물 count 가져오기
	public int getCountNotice() throws Exception;
	 

}
