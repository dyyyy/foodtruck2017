package com.foodtruck.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodtruck.dao.AdminDao;
import com.foodtruck.vo.LicenseVO;
import com.foodtruck.vo.MinquiryReplyVO;

@Service
public class AdminService {

	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	public int insertMinquryReply(MinquiryReplyVO vo) {
		AdminDao dao=sessionTemplate.getMapper(AdminDao.class);
		return dao.insertMinquryReply(vo);
	}
	public List<LicenseVO> getRequestList(int NpageNo){
		AdminDao dao=sessionTemplate.getMapper(AdminDao.class);
		return dao.getRequestList(NpageNo);
	}
	public int getRequestCount() {
		AdminDao dao=sessionTemplate.getMapper(AdminDao.class);
		return dao.getRequestCount();
	}
}
