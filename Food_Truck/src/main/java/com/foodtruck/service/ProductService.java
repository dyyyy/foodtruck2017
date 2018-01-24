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

	// ��ǰ ����
	public ProductVO getProduct(int prodNo) {
		ProductDAO dao = sessionTemplate.getMapper(ProductDAO.class);
		return dao.getProduct(prodNo);
	}

	// ��ǰ ����Ʈ
	public List<ProductVO> getProductList(String licenseNo) {
		ProductDAO dao = sessionTemplate.getMapper(ProductDAO.class);
		return dao.getProductList(licenseNo);
	}

	// ��ǰ �Է�
	public int insertProduct(ProductVO vo) {
		ProductDAO dao = sessionTemplate.getMapper(ProductDAO.class);
		return dao.insertProduct(vo);
	}

	// ��ǰ ����
	public int updateProduct(ProductVO vo) {
		ProductDAO dao = sessionTemplate.getMapper(ProductDAO.class);
		return dao.updateProduct(vo);
	}

	// ��ǰ ����
	public int deleteProduct(int prodNo) {
		ProductDAO dao = sessionTemplate.getMapper(ProductDAO.class);
		return dao.deleteProduct(prodNo);
	}

}
