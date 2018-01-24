package com.foodtruck.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodtruck.dao.MemberDAO;
import com.foodtruck.dao.SellerDAO;
import com.foodtruck.vo.LicenseVO;
import com.foodtruck.vo.MInquiryVO;

@Service
public class SellerService {
	@Autowired
	private SqlSessionTemplate sessionTemplate;

	// id로 라이센스 가져오기
	public List<LicenseVO> getInfo(LicenseVO vo) {
		SellerDAO dao = sessionTemplate.getMapper(SellerDAO.class);
		return dao.getInfo(vo);
	}

	// 1:1 문의사항 list가져오기
	public List<MInquiryVO> getSinquiryList(int NpageNo) {
		SellerDAO dao = sessionTemplate.getMapper(SellerDAO.class);
		return dao.getSinquiryList(NpageNo);
	}

	// 1:1문의사항 count 가져오기
	public int getSinquiryListcount() {
		SellerDAO dao = sessionTemplate.getMapper(SellerDAO.class);
		return dao.getSinquiryListcount();
	}
}
