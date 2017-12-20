package com.foodtruck.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodtruck.dao.SellerDAO;
import com.foodtruck.vo.SellerVO;

@Service
public class SellerService {
	@Autowired
	private SqlSessionTemplate sessionTemplate;

	// 판매자 정보
	public SellerVO getSeller(String sellerId) {
		SellerDAO dao = sessionTemplate.getMapper(SellerDAO.class);
		return dao.getSeller(sellerId);
	}

	// 판매자 리스트
	public List<SellerVO> getSellerList() {
		SellerDAO dao = sessionTemplate.getMapper(SellerDAO.class);
		return dao.getSellerList();
	}

	// 판매자 입력
	public int insertSeller(SellerVO vo) {
		SellerDAO dao = sessionTemplate.getMapper(SellerDAO.class);
		return dao.insertSeller(vo);
	}

	// 판매자 수정
	public int updateSeller(SellerVO vo) {
		SellerDAO dao = sessionTemplate.getMapper(SellerDAO.class);
		return dao.updateSeller(vo);
	}

	// 판매자 삭제
	public int deleteSeller(String sellerId) {
		SellerDAO dao = sessionTemplate.getMapper(SellerDAO.class);
		return dao.deleteSeller(sellerId);
	}

}
