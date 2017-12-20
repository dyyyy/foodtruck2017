package com.foodtruck.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodtruck.dao.ProductDAO;
import com.foodtruck.vo.ProductVO;

@Service
public class ProductService {
	
	@Autowired
	private SqlSessionTemplate sessionTemplate;

	// 상품 정보
	public ProductVO getProduct(int prodNo) {
		ProductDAO dao = sessionTemplate.getMapper(ProductDAO.class);
		return dao.getProduct(prodNo);
	}

	// 상품 리스트
	public List<ProductVO> getProductList() {
		ProductDAO dao = sessionTemplate.getMapper(ProductDAO.class);
		return dao.getProductList();
	}

	// 상품 입력
	public int insertProduct(ProductVO vo) {
		ProductDAO dao = sessionTemplate.getMapper(ProductDAO.class);
		return dao.insertProduct(vo);
	}

	// 상품 수정
	public int updateProduct(ProductVO vo) {
		ProductDAO dao = sessionTemplate.getMapper(ProductDAO.class);
		return dao.updateProduct(vo);
	}

	// 상품 삭제
	public int deleteProduct(int prodNo) {
		ProductDAO dao = sessionTemplate.getMapper(ProductDAO.class);
		return dao.deleteProduct(prodNo);
	}

}
