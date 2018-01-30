package com.foodtruck.dao;

import java.util.List;

import com.foodtruck.vo.FoodTruckVO;
import com.foodtruck.vo.SellerVO;

public interface SellerDAO {
	
	// 푸드트럭 정보
	public FoodTruckVO getFoodTruck(String licenseNo);
	
	// 오늘의 주문 내역 리스트
	public List<SellerVO> getTodayOrderList(String licenseNo);
	
	// 오늘의 예약 내역 리스트
	public List<SellerVO> getTodayRsvList(String licenseNo);
	
	// 오늘의 배달 내역 리스트
	public List<SellerVO> getTodayDlvList(String licenseNo);
	
	// 총 주문 리스트
	public List<SellerVO> getOrderList(String licenseNo);
	
	// 판매자의 라이센스 번호 가져오기
	public List<SellerVO> getLicense(String memberId);
	
	// 푸드트럭 리스트
	public List<FoodTruckVO> getFoodTruckList(String licenseNo);
	
	// 푸드트럭 등록
	public FoodTruckVO insertFoodTruck(FoodTruckVO vo);

}
