package com.foodtruck.dao;

import java.util.List;
import com.foodtruck.vo.FoodTruckVO;
import com.foodtruck.vo.PageVO;

public interface FoodTruckDAO {
	
	// Ǫ��Ʈ�� ����
	public FoodTruckVO getFoodTruck(String ftruckNo)throws Exception;

	// Ǫ��Ʈ�� ����Ʈ
	public List<FoodTruckVO> getFoodTruckList(int pageNo)throws Exception;
	
	// ī�װ��� ����Ʈ
	public List<FoodTruckVO> getCategoryList(PageVO vo)throws Exception;
	
	// Ǫ��Ʈ�� ��Ŭ�� ��ŷ
	public List<FoodTruckVO> getFoodTruckRank();

	// Ǫ��Ʈ�� ���
	public int insertFoodTruck(FoodTruckVO vo)throws Exception;

	// Ǫ��Ʈ�� ����
	public int updateTruck(FoodTruckVO vo)throws Exception;

	// Ǫ��Ʈ�� ����
	public int deleteTruck(String ftruckNo)throws Exception;
	
	//Ǫ��Ʈ�� ��ücount(����¡ó��)
	public int getCountTruck()throws Exception;
	
	//Ǫ��Ʈ�� ī�װ��� count(����¡ó��)
	public int getCategoryCountTruck(int category)throws Exception;
	//영업안하는 푸드트럭가져오기
	public List<FoodTruckVO> getFoodTruckList2(int PageNo) throws Exception;
	
}
