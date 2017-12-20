package com.foodtruck.dao;

import java.util.List;

import com.foodtruck.vo.ProductVO;

public interface ProductDAO {

	// 力前 沥焊
	public ProductVO getProduct(int prodNo);

	// 力前 府胶飘
	public List<ProductVO> getProductList();

	// 力前 殿废
	public int insertProduct(ProductVO vo);

	// 力前 荐沥
	public int updateProduct(ProductVO vo);

	// 力前 昏力
	public int deleteProduct(int prodNo);
}
