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
	public int deleteOrder(String ordNo) {
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
	
	// 판매자 입장 / 상태 변경하기 (대기 / 조리 / 완료)
	public int cookSataChange(Map<String, Object> map) {
		OrderDAO dao = sessionTemplate.getMapper(OrderDAO.class);
		return dao.cookStatChange(map);
	}	
	
	// 새로운 주문알림 갯수 표시하기
	public List<OrderVO> getNewCount(String memId) {
		OrderDAO dao = sessionTemplate.getMapper(OrderDAO.class);
		return dao.getNewCount(memId);
	}	
	
	// 새로운 주문 확인
	public int checkNewOrder(String memId) {
		OrderDAO dao = sessionTemplate.getMapper(OrderDAO.class);
		return dao.checkNewOrder(memId);
	}

	// 자주 시켜먹은 푸드트럭 순위
	public List<OrderVO> getFavoriteFoodtruck(String memId) {
		OrderDAO dao = sessionTemplate.getMapper(OrderDAO.class);
		return dao.getFavoriteFoodtruck(memId);
	}
}
