package com.foodtruck.dao;

import java.util.List;

import com.foodtruck.vo.SellerVO;

public interface SellerDAO {

	// 판매자 정보
	public SellerVO getSeller(String sellerId);

	// 판매자 리스트
	public List<SellerVO> getSellerList();

	// 판매자 등록
	public int insertSeller(SellerVO vo);

	// 판매자 수정
	public int updateSeller(SellerVO vo);

	// 판매자 삭제
	public int deleteSeller(String sellerId);
}
