package com.foodtruck.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.foodtruck.service.MemberService;
import com.foodtruck.service.OrderDetailService;
import com.foodtruck.service.ProductService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class ProductTest {

	
	@Autowired
	private ProductService productService;
	@Autowired
	private MemberService memberservice;
	@Autowired
	private OrderDetailService OrderDetailService;
	
	
	@Test
	public void getProduct() throws Exception {
		OrderDetailService.getOrderDetailList("seller@daum.net");
//		sellerService.getLicenseNo("seller@daum.net");
	}
}
