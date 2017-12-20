//
//package com.foodtruck.test;
//
//import java.sql.Connection;
//
//import javax.sql.DataSource;
//
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.junit.runners.MethodSorters;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.foodtruck.service.FoodTruckService;
//import com.foodtruck.vo.FoodTruckVO;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
//public class FoodTruckTest {
//
//	
//	@Autowired
//	private DataSource ds;
//	
//	@Autowired
//	private FoodTruckService service;
//	
//	
//	@Test
//	public void testConnection() throws Exception {
//		try (Connection con = ds.getConnection()) {
//			System.out.println(con);
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	//등록테스트
//	@Test
//	public void testInsertFoodTruck()throws Exception {
//		FoodTruckVO vo = new FoodTruckVO();
//		vo.setLicenseNo(1234567890);
//		vo.setFtruckName("유자차");
//		vo.setFtruckTel("02-123-1234");	
//		vo.setFtruckDlvYn("Y");
//		vo.setFtruckRsvYn("Y");
//		service.insertFoodTruck(vo);
//	}
//	//상세정보
//	@Test
//	public void testReadFoodTruck()throws Exception {
//		System.out.println(service.getFoodTruck(10001).toString());
//	}
//	//삭제테스트
//	@Test
//	public void testDeleteFoodTruck()throws Exception {
//		service.deleteFoodTruck(1);
//	}
//	//수정테스트
//	@Test
//	public void testUpdateFoodTruck()throws Exception {
//		FoodTruckVO vo = new FoodTruckVO();
//		vo.setFtruckName("수정테스트");
//		vo.setFtruckTel("02-777-7777");
//		vo.setFtruckDlvYn("N");
//		vo.setFtruckRsvYn("N");
//		service.updateFoodTruck(vo);
//	}
//	@Test
//	public void testListAll() throws Exception {
//		System.out.println(service.getFoodTruckList().toString());
//	}
//}
