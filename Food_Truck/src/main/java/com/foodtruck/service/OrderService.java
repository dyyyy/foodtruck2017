package com.foodtruck.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodtruck.dao.OrderDAO;
import com.foodtruck.vo.LicenseVO;
import com.foodtruck.vo.OrderVO;

@Service
public class OrderService {
	@Autowired
	private SqlSessionTemplate sessionTemplate;

	// 회원 정보
	public OrderVO getOrder(int ordNo) {
		OrderDAO dao = sessionTemplate.getMapper(OrderDAO.class);
		return dao.getOrder(ordNo);
	}

	// 회원 리스트
	public List<OrderVO> getOrderList(String licenseNo) {
		OrderDAO dao = sessionTemplate.getMapper(OrderDAO.class);
		return dao.getOrderList(licenseNo);
	}

	// 회원 입력
	public int insertOrder(OrderVO vo) {
		OrderDAO dao = sessionTemplate.getMapper(OrderDAO.class);
		return dao.insertOrder(vo);
	}

	// 회원 수정
	public int updateOrder(OrderVO vo) {
		OrderDAO dao = sessionTemplate.getMapper(OrderDAO.class);
		return dao.updateOrder(vo);
	}

	// 회원 삭제
	public int deleteOrder(int ordNo) {
		OrderDAO dao = sessionTemplate.getMapper(OrderDAO.class);
		return dao.deleteOrder(ordNo);
	}
	
	public List<OrderVO> getLicense(String memberId) {
		OrderDAO dao = sessionTemplate.getMapper(OrderDAO.class);
		return dao.getLicense(memberId);
	}
	
	public List<OrderVO> getLicense2(String licenseNo) {
		OrderDAO dao = sessionTemplate.getMapper(OrderDAO.class);
		return dao.getLicense(licenseNo);
	}

}
