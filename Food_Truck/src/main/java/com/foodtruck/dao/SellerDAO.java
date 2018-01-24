package com.foodtruck.dao;

import java.util.List;

import com.foodtruck.vo.LicenseVO;
import com.foodtruck.vo.MInquiryVO;

public interface SellerDAO {
	// id로 라이센스 번호 가져오기
	public List<LicenseVO> getInfo(LicenseVO vo);

	// 1:1 문의 insert하기
	public int insertSinquiry();

	// 1:1문의 list가져오기
	public List<MInquiryVO> getSinquiryList(int NpageNo);

	// 1:1문의 total count가져오기
	public int getSinquiryListcount();
}
