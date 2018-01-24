package com.foodtruck.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodtruck.dao.AdminDao;
import com.foodtruck.vo.MinquiryReplyVO;

@Service
public class AdminService {

	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	public int insertMinquryReply(MinquiryReplyVO vo) {
		AdminDao dao=sessionTemplate.getMapper(AdminDao.class);
		return dao.insertMinquryReply(vo);
	}
}
