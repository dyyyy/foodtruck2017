package com.foodtruck.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodtruck.dao.FoodTruckDAO;
import com.foodtruck.vo.FoodTruckVO;
import com.foodtruck.vo.PageVO;

@Service
public class FoodTruckService {
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	//푸드트럭 정보
	public FoodTruckVO getFoodTruck(String ftruckNo) throws Exception {
		FoodTruckDAO dao = sessionTemplate.getMapper(FoodTruckDAO.class);
		return dao.getFoodTruck(ftruckNo);
	}
	//푸드트럭 리스트
	public List<FoodTruckVO> getFoodTruckList(int index) throws Exception{
		FoodTruckDAO dao = sessionTemplate.getMapper(FoodTruckDAO.class);
		return dao.getFoodTruckList(index);
	}
	
	//카테고리별 리스트
	public List<FoodTruckVO> getCategoryList(PageVO vo)   {
		
		System.out.println("진입2");
		FoodTruckDAO dao = sessionTemplate.getMapper(FoodTruckDAO.class);
		System.out.println("진입3");
		try
		{
		return dao.getCategoryList(vo);
	
		}
		catch(Exception e)
		{
			 System.out.println( "ERROR : " + e.getMessage()); 
			e.printStackTrace();
		}
		return null;
	}
	
	// 푸드트럭 위클리 랭킹
	public List<FoodTruckVO> getFoodTruckRank() {
		System.out.println("11111");
		FoodTruckDAO dao = sessionTemplate.getMapper(FoodTruckDAO.class);
		System.out.println(dao.getFoodTruckRank());
		return dao.getFoodTruckRank();
	}

	//푸드트럭 입력
	public int insertFoodTruck(FoodTruckVO vo) throws Exception{
		FoodTruckDAO dao = sessionTemplate.getMapper(FoodTruckDAO.class);
		return dao.insertFoodTruck(vo);
	}
	//푸드트럭 수정
	public int updateFoodTruck(FoodTruckVO vo) throws Exception {
		FoodTruckDAO dao = sessionTemplate.getMapper(FoodTruckDAO.class);
		return dao.updateTruck(vo);
	}
	//푸드트럭 삭제
	public int deleteFoodTruck(String licenseNo) throws Exception{
		FoodTruckDAO dao = sessionTemplate.getMapper(FoodTruckDAO.class);
		return dao.deleteTruck(licenseNo);
	}
	//푸드트럭 전체 리스트 count
	public int getCountTruck() throws Exception{
		FoodTruckDAO dao = sessionTemplate.getMapper(FoodTruckDAO.class);
		return dao.getCountTruck();
	}
	//푸드트럭 카테고리별 리스트 count
	public int getCategoryCountTruck(int category) throws Exception{
		FoodTruckDAO dao = sessionTemplate.getMapper(FoodTruckDAO.class);
		return dao.getCategoryCountTruck(category);
	}

}
