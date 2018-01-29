package com.foodtruck.dao;

import java.util.List;

import com.foodtruck.vo.LicenseVO;
import com.foodtruck.vo.MinquiryReplyVO;

public interface AdminDao {
	//1:1 Q&A 댓글 insert
	public int insertMinquryReply(MinquiryReplyVO vo);
	//푸드트럭 신청 list select
	public List<LicenseVO> getRequestList(int NpageNo);
	//푸드트럭 신청 count
	public int getRequestCount();
	//푸드트럭 등록 최종 승인 업데이트
	public int appFoodtruck(LicenseVO vo)throws Exception;
}
