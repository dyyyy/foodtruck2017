package com.foodtruck.service;

import java.util.List;
import java.util.Map;

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

	// 주문 정보
	public OrderVO getOrder(int ordNo) {
		OrderDAO dao = sessionTemplate.getMapper(OrderDAO.class);
		return dao.getOrder(ordNo);
	}

	// 주문 리스트
	public List<OrderVO> getOrderList() {
		OrderDAO dao = sessionTemplate.getMapper(OrderDAO.class);
		return dao.getOrderList();
	}

	// 주문 수정
	public int updateOrder(OrderVO vo) {
		OrderDAO dao = sessionTemplate.getMapper(OrderDAO.class);
		return dao.updateOrder(vo);
	}

	// 주문 삭제
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

	// 비회원이 주문번호 & 전화번호로 주문내역 조회
	public List<OrderVO> getNonmemberInfo(Map<String,Object> map) {
		OrderDAO dao = sessionTemplate.getMapper(OrderDAO.class);
		return dao.getNonmemberInfo(map);
	}
	   
	// 사용자 이용내역
	public List<OrderVO> getMemberOrderList(String memberId) {
		OrderDAO dao = sessionTemplate.getMapper(OrderDAO.class);
		return dao.getMemberOrderList(memberId);
	}
	
	// 주문
	public int insertOrder(Map<String, Object> map) {
		OrderDAO dao = sessionTemplate.getMapper(OrderDAO.class);
		return dao.insertOrder(map);
	}
}
