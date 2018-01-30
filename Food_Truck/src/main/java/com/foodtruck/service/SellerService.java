package com.foodtruck.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodtruck.dao.SellerDAO;
import com.foodtruck.vo.FoodTruckVO;
import com.foodtruck.vo.SellerVO;

@Service
public class SellerService {
	
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	// 푸드트럭 정보
	public FoodTruckVO getFoodTruck(String licenseNo) {
		SellerDAO dao = sessionTemplate.getMapper(SellerDAO.class);
		return dao.getFoodTruck(licenseNo);
	}
	
	// 오늘의 주문 내역 리스트
	public List<SellerVO> getTodayOrderList(String licenseNo) {
		SellerDAO dao = sessionTemplate.getMapper(SellerDAO.class);
		return dao.getTodayOrderList(licenseNo);
	}
	
	// 오늘의 예약 내역 리스트
	public List<SellerVO> getTodayRsvList(String licenseNo) {
		SellerDAO dao = sessionTemplate.getMapper(SellerDAO.class);
		return dao.getTodayRsvList(licenseNo);
	}
	
	// 오늘의 배달 내역 리스트
	public List<SellerVO> getTodayDlvList(String licenseNo) {
		SellerDAO dao = sessionTemplate.getMapper(SellerDAO.class);
		return dao.getTodayDlvList(licenseNo);
	}

	// 총 주문 리스트
	public List<SellerVO> getOrderList(String licenseNo) {
		SellerDAO dao = sessionTemplate.getMapper(SellerDAO.class);
		return dao.getOrderList(licenseNo);
	}
	
	// 판매자의 라이센스 번호 가져오기
	public List<SellerVO> getLicense(String memberId) {
		SellerDAO dao = sessionTemplate.getMapper(SellerDAO.class);
		return dao.getLicense(memberId);
	}
	
	// 푸드트럭 리스트
	public List<FoodTruckVO> getFoodTruckList(String licenseNo) {
		SellerDAO dao = sessionTemplate.getMapper(SellerDAO.class);
		return dao.getFoodTruckList(licenseNo);
	}
	
	// 푸드트럭 등록
	public FoodTruckVO insertFoodTruck(FoodTruckVO vo) {
		SellerDAO dao = sessionTemplate.getMapper(SellerDAO.class);
		return dao.insertFoodTruck(vo);
	}
}
