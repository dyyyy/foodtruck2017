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
	
	public List<OrderVO> getLicense(String memberId);
	
	public List<OrderVO> getLicense2(String licenseNo);
	
	
	// 비회원이 주문번호 & 전화번호로 주문내역 조회
	public List<OrderVO> getNonmemberInfo(Map<String,Object> map);
	
	//사용자 이용내역
	public List<OrderVO> getMemberOrderList(String memberId);
	
	//주문
	public int insertOrder(Map<String, Object> map);
}
