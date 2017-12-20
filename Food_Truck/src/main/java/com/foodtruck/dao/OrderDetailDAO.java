package com.foodtruck.dao;

import java.util.List;

import com.foodtruck.vo.OrderDetailVO;

public interface OrderDetailDAO {

	// 주문상세 정보
	public OrderDetailVO getOrderDetail(int ordNo);

	// 주문상세 리스트
	public List<OrderDetailVO> getOrderDetailList();

	// 주문상세 등록
	public int insertOrderDetail(OrderDetailVO vo);

	// 주문상세 수정
	public int updateOrderDetail(OrderDetailVO vo);

	// 주문상세 삭제
	public int deleteOrderDetail(int ordNo);
}
