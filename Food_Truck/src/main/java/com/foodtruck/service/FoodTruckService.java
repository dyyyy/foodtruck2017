package com.foodtruck.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodtruck.dao.FoodTruckDAO;
import com.foodtruck.vo.FoodTruckVO;

@Service
public class FoodTruckService {
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	//푸드트럭 정보
	public FoodTruckVO getFoodTruck(int ftruckNo) throws Exception {
		FoodTruckDAO dao = sessionTemplate.getMapper(FoodTruckDAO.class);
		return dao.getFoodTruck(ftruckNo);
	}
	//푸드트럭 리스트
	public List<FoodTruckVO> getFoodTruckList() throws Exception{
		FoodTruckDAO dao = sessionTemplate.getMapper(FoodTruckDAO.class);
		return dao.getFoodTruckList();
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
	public int deleteFoodTruck(int ftruckNo) throws Exception{
		FoodTruckDAO dao = sessionTemplate.getMapper(FoodTruckDAO.class);
		return dao.deleteTruck(ftruckNo);
	}

}
