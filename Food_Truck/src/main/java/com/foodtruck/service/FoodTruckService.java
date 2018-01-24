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

	//Ǫ��Ʈ�� ����
	public FoodTruckVO getFoodTruck(String ftruckNo) throws Exception {
		FoodTruckDAO dao = sessionTemplate.getMapper(FoodTruckDAO.class);
		return dao.getFoodTruck(ftruckNo);
	}
	//Ǫ��Ʈ�� ����Ʈ
	public List<FoodTruckVO> getFoodTruckList(int pageNo) throws Exception{
		FoodTruckDAO dao = sessionTemplate.getMapper(FoodTruckDAO.class);
		return dao.getFoodTruckList(pageNo);
	}
	
	//ī�װ��� ����Ʈ
	public List<FoodTruckVO> getCategoryList(PageVO vo)   {
		
		System.out.println("����2");
		FoodTruckDAO dao = sessionTemplate.getMapper(FoodTruckDAO.class);
		System.out.println("����3");
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
	
	// Ǫ��Ʈ�� ��Ŭ�� ��ŷ
	public List<FoodTruckVO> getFoodTruckRank() {
		System.out.println("11111");
		FoodTruckDAO dao = sessionTemplate.getMapper(FoodTruckDAO.class);
		System.out.println(dao.getFoodTruckRank());
		return dao.getFoodTruckRank();
	}

	//Ǫ��Ʈ�� �Է�
	public int insertFoodTruck(FoodTruckVO vo) throws Exception{
		FoodTruckDAO dao = sessionTemplate.getMapper(FoodTruckDAO.class);
		return dao.insertFoodTruck(vo);
	}
	//Ǫ��Ʈ�� ����
	public int updateFoodTruck(FoodTruckVO vo) throws Exception {
		FoodTruckDAO dao = sessionTemplate.getMapper(FoodTruckDAO.class);
		return dao.updateTruck(vo);
	}
	//Ǫ��Ʈ�� ����
	public int deleteFoodTruck(String licenseNo) throws Exception{
		FoodTruckDAO dao = sessionTemplate.getMapper(FoodTruckDAO.class);
		return dao.deleteTruck(licenseNo);
	}
	//Ǫ��Ʈ�� ��ü ����Ʈ count
	public int getCountTruck() throws Exception{
		FoodTruckDAO dao = sessionTemplate.getMapper(FoodTruckDAO.class);
		return dao.getCountTruck();
	}
	//Ǫ��Ʈ�� ī�װ��� ����Ʈ count
	public int getCategoryCountTruck(int category) throws Exception{
		FoodTruckDAO dao = sessionTemplate.getMapper(FoodTruckDAO.class);
		return dao.getCategoryCountTruck(category);
	}
	public List<FoodTruckVO>  getFoodTruckList2(int PageNo) throws Exception{
		FoodTruckDAO dao = sessionTemplate.getMapper(FoodTruckDAO.class);
		return dao.getFoodTruckList2(PageNo);
	}

}
