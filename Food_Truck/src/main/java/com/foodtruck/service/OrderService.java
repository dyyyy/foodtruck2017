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

	// ȸ�� ����
	public OrderVO getOrder(int ordNo) {
		OrderDAO dao = sessionTemplate.getMapper(OrderDAO.class);
		return dao.getOrder(ordNo);
	}

	// ȸ�� ����Ʈ
	public List<OrderVO> getOrderList() {
		OrderDAO dao = sessionTemplate.getMapper(OrderDAO.class);
		return dao.getOrderList();
	}

	// ȸ�� �Է�
	public int insertOrder(OrderVO vo) {
		OrderDAO dao = sessionTemplate.getMapper(OrderDAO.class);
		return dao.insertOrder(vo);
	}

	// ȸ�� ����
	public int updateOrder(OrderVO vo) {
		OrderDAO dao = sessionTemplate.getMapper(OrderDAO.class);
		return dao.updateOrder(vo);
	}

	// ȸ�� ����
	public int deleteOrder(int ordNo) {
		OrderDAO dao = sessionTemplate.getMapper(OrderDAO.class);
		return dao.deleteOrder(ordNo);
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
