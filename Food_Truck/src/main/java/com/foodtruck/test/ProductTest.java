<<<<<<< HEAD
package com.foodtruck.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.foodtruck.service.MemberService;
import com.foodtruck.service.ProductService;
import com.foodtruck.vo.MemberVO;
import com.foodtruck.vo.ProductVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class ProductTest {

	
	@Autowired
	private ProductService productService;
	@Autowired
	private MemberService memberservice;
	
	@Test
	public void getProduct() throws Exception {
		productService.getProduct(2017121165);
	}
	
//	@Test
//	public void testAllList() throws Exception {
//		productService.getProductList();
//	}
//	
// 	@Test
//	public void testGetProduct() throws Exception {
//		productService.getProduct(2017121165);
//	}
//	
//	@Test
//	public void testInsertProduct() throws Exception {
//		ProductVO vo = new ProductVO();
//		vo.setProdNo(2017121390);
//		vo.setProdName("test");
//		vo.setProdContent("testÇÏ´ÂÁß");
//		vo.setProdPrice(30000);
//		
//		productService.insertProduct(vo);
//	}
//	
//	@Test
//	public void testDelelteProduct() throws Exception{
//		productService.deleteProduct(2017121390);
//	}
//	
//	@Test
//	public void testUpdateProduct() throws Exception {
//		ProductVO vo = new ProductVO();
//		vo.setProdNo(2017121311);
//		vo.setProdName("ÇÏÀ×");
//		vo.setProdContent("¸Þ·Õ");
//		vo.setProdPrice(10000);
//		productService.updateProduct(vo);
//	}
	
	
}
=======
//package com.foodtruck.test;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.foodtruck.service.MemberService;
//import com.foodtruck.service.ProductService;
//import com.foodtruck.vo.MemberVO;
//import com.foodtruck.vo.ProductVO;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
//public class ProductTest {
//
//	
//	@Autowired
//	private ProductService productService;
//	@Autowired
//	private MemberService memberservice;
//	
//	@Test
//	public void testAllList() throws Exception {
//		productService.getProductList();
//	}
//	
// 	@Test
//	public void testGetProduct() throws Exception {
//		productService.getProduct(2017121165);
//	}
//	
//	@Test
//	public void testInsertProduct() throws Exception {
//		ProductVO vo = new ProductVO();
//		vo.setProdNo(2017121390);
//		vo.setProdName("test");
//		vo.setProdContent("testÇÏ´ÂÁß");
//		vo.setProdPrice(30000);
//		
//		productService.insertProduct(vo);
//	}
//	
//	@Test
//	public void testDelelteProduct() throws Exception{
//		productService.deleteProduct(2017121390);
//	}
//	
//	@Test
//	public void testUpdateProduct() throws Exception {
//		ProductVO vo = new ProductVO();
//		vo.setProdNo(2017121311);
//		vo.setProdName("ÇÏÀ×");
//		vo.setProdContent("¸Þ·Õ");
//		vo.setProdPrice(10000);
//		productService.updateProduct(vo);
//	}
//	
//	
//}
>>>>>>> branch 'master' of https://github.com/dyyyy/foodtruck2017.git
