package com.foodtruck.dao;

import java.util.List;

import com.foodtruck.vo.DeliveryDetailVO;

public interface DeliveryDetailDAO {

	// 배달상세 정보
	public DeliveryDetailVO getDeliveryDetail(int prodNo);

	// 배달상세 리스트
	public List<DeliveryDetailVO> getDeliveryDetailList();

	// 배달상세 등록
	public int insertDeliveryDetail(DeliveryDetailVO vo);

	// 배달상세 수정
	public int updateDeliveryDetail(DeliveryDetailVO vo);

	// 배달상세 삭제
	public int deleteDeliveryDetail(int prodNo);
}
