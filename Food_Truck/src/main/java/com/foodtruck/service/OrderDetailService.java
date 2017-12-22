package com.foodtruck.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodtruck.dao.OrderDetailDAO;
import com.foodtruck.vo.OrderDetailVO;
import com.foodtruck.vo.ProductVO;

@Service
public class OrderDetailService {
	@Autowired
	private SqlSessionTemplate sessionTemplate;

	// 주문상세 정보
	public OrderDetailVO getOrderDetail(int ordNo) {
		OrderDetailDAO dao = sessionTemplate.getMapper(OrderDetailDAO.class);
		return dao.getOrderDetail(ordNo);
	}

	// 주문상세 리스트
	public List<OrderDetailVO> getOrderDetailList() {
		OrderDetailDAO dao = sessionTemplate.getMapper(OrderDetailDAO.class);
		return dao.getOrderDetailList();
	}
	
	// 주문상세 입력
	public int insertOrderDetail(OrderDetailVO vo) {
		OrderDetailDAO dao = sessionTemplate.getMapper(OrderDetailDAO.class);
		return dao.insertOrderDetail(vo);
	}

	// 주문상세 수정
	public int updateOrderDetail(OrderDetailVO vo) {
		OrderDetailDAO dao = sessionTemplate.getMapper(OrderDetailDAO.class);
		return dao.updateOrderDetail(vo);
	}

	// 주문상세 삭제
	public int deleteOrderDetail(int ordNo) {
		OrderDetailDAO dao = sessionTemplate.getMapper(OrderDetailDAO.class);
		return dao.deleteOrderDetail(ordNo);
	}

}
