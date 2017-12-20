//package com.foodtruck.test;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.foodtruck.dao.AdminDAO;
//import com.foodtruck.service.AdminService;
//import com.foodtruck.vo.AdminVO;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
//public class AdminTest {
//
//	@Autowired
//	private AdminService dao;
//	
//	
//	
//	@Test
//	public void testInsertAdmin() throws Exception {
//		AdminVO vo = new AdminVO();
//		vo.setAdminId("admin00");
//		vo.setAdminPw("admin00");
//		vo.setAdminTel("02-123-4567");
////		dao.insertAdmin(vo);
//	}
//	
//	@Test
//	public void testRead()throws Exception {
//		System.out.println(dao.getAdmin("admin01").toString());
//	}
//}
