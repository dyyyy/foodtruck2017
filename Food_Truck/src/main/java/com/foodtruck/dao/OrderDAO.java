package com.foodtruck.dao;

import java.util.List;
import java.util.Map;

import com.foodtruck.vo.OrderVO;

public interface OrderDAO {

	// �ֹ� ����
	public OrderVO getOrder(int ordNo);

	// �ֹ� ����Ʈ
	public List<OrderVO> getOrderList();

	// �ֹ� ���
	public int insertOrder(OrderVO vo);

	// �ֹ� ����
	public int updateOrder(OrderVO vo);

	// �ֹ� ����
	public int deleteOrder(int ordNo);
	
	// 비회원이 주문번호 & 전화번호로 주문내역 조회
	public List<OrderVO> getNonmemberInfo(Map<String,Object> map);	
}
