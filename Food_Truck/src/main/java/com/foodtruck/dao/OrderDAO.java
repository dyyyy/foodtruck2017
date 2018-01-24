package com.foodtruck.dao;

import java.util.List;

import com.foodtruck.vo.OrderVO;

public interface OrderDAO {

	// 주문 정보
	public OrderVO getOrder(int ordNo);

	// 주문 리스트
	public List<OrderVO> getOrderList(String licenseNo);
	
	// 주문 등록
	public int insertOrder(OrderVO vo);

	// 주문 수정
	public int updateOrder(OrderVO vo);

	// 주문 삭제
	public int deleteOrder(int ordNo);
	
	public List<OrderVO> getLicense(String memberId);
	
	public List<OrderVO> getLicense2(String licenseNo);
	
	
}
