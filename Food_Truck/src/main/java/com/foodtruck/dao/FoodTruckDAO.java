package com.foodtruck.dao;

import java.util.List;
import com.foodtruck.vo.FoodTruckVO;
import com.foodtruck.vo.PageVO;

public interface FoodTruckDAO {
	
	// 푸드트럭 정보
	public FoodTruckVO getFoodTruck(String ftruckNo)throws Exception;

	// 푸드트럭 리스트
	public List<FoodTruckVO> getFoodTruckList(int indexs)throws Exception;
	
	// 카테고리별 리스트
	public List<FoodTruckVO> getCategoryList(PageVO vo)throws Exception;
	
	// 푸드트럭 위클리 랭킹
	public List<FoodTruckVO> getFoodTruckRank();

	// 푸드트럭 등록
	public int insertFoodTruck(FoodTruckVO vo)throws Exception;

	// 푸드트럭 수정
	public int updateTruck(FoodTruckVO vo)throws Exception;

	// 푸드트럭 삭제
	public int deleteTruck(String ftruckNo)throws Exception;
	
	//푸드트럭 전체count(페이징처리)
	public int getCountTruck()throws Exception;
	
	//푸드트럭 카테고리별 count(페이징처리)
	public int getCategoryCountTruck(int category)throws Exception;
	
}
