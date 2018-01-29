package com.foodtruck.dao;

import java.util.List;
import com.foodtruck.vo.FoodTruckVO;
import com.foodtruck.vo.LicenseVO;
import com.foodtruck.vo.PageVO;

public interface FoodTruckDAO {
	
	// 푸占쏙옙트占쏙옙 占쏙옙占쏙옙
	public FoodTruckVO getFoodTruck(String ftruckNo)throws Exception;

	// 푸占쏙옙트占쏙옙 占쏙옙占쏙옙트
	public List<FoodTruckVO> getFoodTruckList(int pageNo)throws Exception;
	
	// 카占쌓곤옙占쏙옙 占쏙옙占쏙옙트
	public List<FoodTruckVO> getCategoryList(PageVO vo)throws Exception;
	
	// 푸占쏙옙트占쏙옙 占쏙옙클占쏙옙 占쏙옙킹
	public List<FoodTruckVO> getFoodTruckRank();

	// 푸占쏙옙트占쏙옙 占쏙옙占�
	public int insertFoodTruck(FoodTruckVO vo)throws Exception;

	// 푸占쏙옙트占쏙옙 占쏙옙占쏙옙
	public int updateTruck(FoodTruckVO vo)throws Exception;

	// 푸占쏙옙트占쏙옙 占쏙옙占쏙옙
	public int deleteTruck(String ftruckNo)throws Exception;
	
	//푸占쏙옙트占쏙옙 占쏙옙체count(占쏙옙占쏙옙징처占쏙옙)
	public int getCountTruck()throws Exception;
	
	//푸占쏙옙트占쏙옙 카占쌓곤옙占쏙옙 count(占쏙옙占쏙옙징처占쏙옙)
	public int getCategoryCountTruck(int category)throws Exception;
	//�쁺�뾽�븞�븯�뒗 �뫖�뱶�듃�윮媛��졇�삤湲�
	public List<FoodTruckVO> getFoodTruckList2(int PageNo) throws Exception;
	//라이센스번호로 푸드트럭 정보가져오기
	public FoodTruckVO getFoodTruck2(String licenseNo)throws Exception;
	
	
}
