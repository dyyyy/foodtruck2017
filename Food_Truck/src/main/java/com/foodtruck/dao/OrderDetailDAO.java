package com.foodtruck.dao;

import java.util.List;
import java.util.Map;

import com.foodtruck.vo.OrderDetailVO;

public interface OrderDetailDAO {

   // �ֹ��� ����
   public OrderDetailVO getOrderDetail(int ordNo);

   // �ֹ��� ����Ʈ
   public List<OrderDetailVO> getOrderDetailList(String selId);

   // �ֹ��� ���
   public int insertOrderDetail(OrderDetailVO vo);

   // �ֹ��� ����
   public int updateOrderDetail(OrderDetailVO vo);

   // �ֹ��� ����
   public int deleteOrderDetail(int ordNo) throws Exception;;
   
   // 주문
   public int insertOrderDetail(Map<String, Object> map);
   
   // 주문하고 주문 리스트 보여주는 거(영수증 역할) -> 비회원
   public List<OrderDetailVO> getOrderInfoList(String ordNo);
}