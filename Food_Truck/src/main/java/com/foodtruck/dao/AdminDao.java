package com.foodtruck.dao;

import com.foodtruck.vo.MinquiryReplyVO;

public interface AdminDao {
	
	//1:1 Q&A 댓글 insert
	public int insertMinquryReply(MinquiryReplyVO vo);
}
