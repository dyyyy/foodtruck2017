package com.foodtruck.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodtruck.dao.SellerDAO;
import com.foodtruck.vo.FoodTruckVO;
import com.foodtruck.vo.LicenseVO;
import com.foodtruck.vo.MInquiryVO;
import com.foodtruck.vo.ProductVO;
import com.foodtruck.vo.SellerVO;

@Service
public class SellerService {

	@Autowired
	private SqlSessionTemplate sessionTemplate;

	// 푸드트럭 정보
	public FoodTruckVO getFoodTruck(String licenseNo) {
		SellerDAO dao = sessionTemplate.getMapper(SellerDAO.class);
		return dao.getFoodTruck(licenseNo);
	}

	// 오늘의 주문 내역 리스트
	public List<SellerVO> getTodayOrderList(String licenseNo) {
		SellerDAO dao = sessionTemplate.getMapper(SellerDAO.class);
		return dao.getTodayOrderList(licenseNo);
	}


	// 오늘의 배달 내역 리스트
	public List<SellerVO> getTodayDlvList(String licenseNo) {
		SellerDAO dao = sessionTemplate.getMapper(SellerDAO.class);
		return dao.getTodayDlvList(licenseNo);
	}
	
	// 오늘의 배달 내역 리스트
		public List<SellerVO> getTodayPayment(String licenseNo) {
			SellerDAO dao = sessionTemplate.getMapper(SellerDAO.class);
			return dao.getTodayPayment(licenseNo);
		}

	// 총 주문 리스트
	public List<SellerVO> getOrderList(String licenseNo) {
		SellerDAO dao = sessionTemplate.getMapper(SellerDAO.class);
		return dao.getOrderList(licenseNo);
	}

	// 판매자의 라이센스 번호 가져오기
	public List<SellerVO> getLicense(String memberId) {
		SellerDAO dao = sessionTemplate.getMapper(SellerDAO.class);
		System.out.println("mmmmmmmmmmmmmmmmmmmm" + dao.getLicense(memberId));
		return dao.getLicense(memberId);
	}
	// 판매자의 푸드트럭 승인 flg
		public List<SellerVO> getLicense2(String memberId) {
			SellerDAO dao = sessionTemplate.getMapper(SellerDAO.class);
			return dao.getLicense2(memberId);
		}

	// 푸드트럭 리스트
	public List<FoodTruckVO> getFoodTruckList(String licenseNo) {
		SellerDAO dao = sessionTemplate.getMapper(SellerDAO.class);
		return dao.getFoodTruckList(licenseNo);
	}

	// 푸드트럭 등록
	public int insertFoodTruck(FoodTruckVO vo) {
		SellerDAO dao = sessionTemplate.getMapper(SellerDAO.class);
		return dao.insertFoodTruck(vo);
	}
	
	
	// 푸드트럭 마감
	public int closeFoodTruck(FoodTruckVO vo) {
		SellerDAO dao = sessionTemplate.getMapper(SellerDAO.class);
		return dao.closeFoodTruck(vo);
	}
	
	// 푸드트럭 오픈
	public int openFoodTruck(FoodTruckVO vo) {
		SellerDAO dao = sessionTemplate.getMapper(SellerDAO.class);
		return dao.openFoodTruck(vo);
	}
	
	// 매출 등록
	public int insertPrice(SellerVO vo) {
		SellerDAO dao = sessionTemplate.getMapper(SellerDAO.class);
		return dao.insertPrice(vo);
	}
	
	// 매출 수정
	public int updatePrice(SellerVO vo) {
		SellerDAO dao = sessionTemplate.getMapper(SellerDAO.class);
		return dao.updatePrice(vo);
	}
	
	// 매출 조회
	public List<SellerVO> getPrice(String licenseNo) {
		SellerDAO dao = sessionTemplate.getMapper(SellerDAO.class);
		return dao.getPrice(licenseNo);
	}
	
	// 매출 중복 체크
	public SellerVO getPrice1(String licenseNo) {
		SellerDAO dao = sessionTemplate.getMapper(SellerDAO.class);
		return dao.getPrice1(licenseNo);
	}
	
	// 라이센스 등록
	public int insertLicense(LicenseVO vo) {
		SellerDAO dao = sessionTemplate.getMapper(SellerDAO.class);
		return dao.insertLicense(vo);
	}
	
	
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

	// lisenceNo로 푸드트럭 정보가져오기
	public FoodTruckVO getFoodtruckDtail(String licenseNo) {
		SellerDAO dao = sessionTemplate.getMapper(SellerDAO.class);
		return dao.getFoodtruckDtail(licenseNo);

	}
	
	// 푸드트럭별 상품 리스트
	public List<ProductVO> getProductList(String licenseNo) {
		SellerDAO dao = sessionTemplate.getMapper(SellerDAO.class);
		return dao.getProductList(licenseNo);

	}
	
	public List<SellerVO> getDate(String licenseNo) {
		SellerDAO dao = sessionTemplate.getMapper(SellerDAO.class);
		return dao.getDate(licenseNo);
	}
}
