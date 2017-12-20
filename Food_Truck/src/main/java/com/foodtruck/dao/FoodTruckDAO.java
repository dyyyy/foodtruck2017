package com.foodtruck.dao;

import java.util.List;
import com.foodtruck.vo.FoodTruckVO;

public interface FoodTruckDAO {
	
	// 푸드트럭 정보
	public FoodTruckVO getFoodTruck(String licenseNo)throws Exception;

	// 푸드트럭 리스트
	public List<FoodTruckVO> getFoodTruckList()throws Exception;
	
	// 카테고리별 리스트
	public List<FoodTruckVO> getCategoryList(int category)throws Exception;

	// 푸드트럭 등록
	public int insertFoodTruck(FoodTruckVO vo)throws Exception;

	// 푸드트럭 수정
	public int updateTruck(FoodTruckVO vo)throws Exception;

	// 푸드트럭 삭제
	public int deleteTruck(String licenseNo)throws Exception;
}
