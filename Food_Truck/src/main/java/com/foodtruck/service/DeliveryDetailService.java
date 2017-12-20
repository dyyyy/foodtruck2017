package com.foodtruck.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodtruck.dao.DeliveryDetailDAO;
import com.foodtruck.vo.DeliveryDetailVO;

@Service
public class DeliveryDetailService {
	@Autowired
	private SqlSessionTemplate sessionTemplate;

	// 배달상세 정보
	public DeliveryDetailVO getDeliveryDetail(int ordNo) {
		DeliveryDetailDAO dao = sessionTemplate.getMapper(DeliveryDetailDAO.class);
		return dao.getDeliveryDetail(ordNo);
	}

	// 배달상세 리스트
	public List<DeliveryDetailVO> getDeliveryDetailList() {
		DeliveryDetailDAO dao = sessionTemplate.getMapper(DeliveryDetailDAO.class);
		return dao.getDeliveryDetailList();
	}

	// 배달상세 입력
	public int insertDeliveryDetail(DeliveryDetailVO vo) {
		DeliveryDetailDAO dao = sessionTemplate.getMapper(DeliveryDetailDAO.class);
		return dao.insertDeliveryDetail(vo);
	}

	// 배달상세 수정
	public int updateDeliveryDetail(DeliveryDetailVO vo) {
		DeliveryDetailDAO dao = sessionTemplate.getMapper(DeliveryDetailDAO.class);
		return dao.updateDeliveryDetail(vo);
	}

	// 배달상세 삭제
	public int deleteDeliveryDetail(int ordNo) {
		DeliveryDetailDAO dao = sessionTemplate.getMapper(DeliveryDetailDAO.class);
		return dao.deleteDeliveryDetail(ordNo);
	}

}
