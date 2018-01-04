//package com.foodtruck.test;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.foodtruck.service.SellerService;
//import com.foodtruck.vo.SellerVO;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
//public class SellerTest {
//
//	
//	@Autowired
//	private SellerService sellerService;
//	
//	@Test
//	public void getSellerListTest() throws Exception{
//		sellerService.getSellerList();
//	}
//	
//	@Test
//	public void insertSellerTest() throws Exception {
//		SellerVO vo = new SellerVO();
//		vo.setSelId("test");
//		vo.setSelPw("test");
//		vo.setSelName("¹®´Ù´Ï¿¤");
//		vo.setSelTel("010-1111-1234");
//		sellerService.insertSeller(vo);
//	}
//	
//	@Test
//	public void updateSellerTest() throws Exception {
//		SellerVO vo = new SellerVO();
//		
//		vo.setSelId("test");
//		vo.setSelPw("»Ñ¾Æ¾Æ¾Æ¾Ó");	
//		vo.setSelName("ÇýÇýÇý");
//		vo.setSelTel("010-1122-3333");
//		sellerService.updateSeller(vo);
//	}
//	
//	@Test
//	public void deleteSellerTest() throws Exception {
//		SellerVO vo = new SellerVO();
//		
//		sellerService.deleteSeller("test");
//	}
//
//}
