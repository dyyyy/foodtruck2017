package com.foodtruck.dao;

import java.util.List;

import com.foodtruck.vo.ProductVO;

public interface ProductDAO {

	// ��ǰ ����
	public ProductVO getProduct(int prodNo);

	// ��ǰ ����Ʈ
	public List<ProductVO> getProductList(String licenseNo);

	// ��ǰ ���
	public int insertProduct(ProductVO vo);

	// ��ǰ ����
	public int updateProduct(ProductVO vo);

	// ��ǰ ����
	public int deleteProduct(int prodNo);
}
