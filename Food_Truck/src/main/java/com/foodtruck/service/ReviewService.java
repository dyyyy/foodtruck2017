package com.foodtruck.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.foodtruck.dao.ReviewDAO;

import com.foodtruck.vo.ReviewVO;

@Service
public class ReviewService {
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
		// ¸®ºä ¸®½ºÆ®
		public List<ReviewVO> getReviewList(String ftruckNo) {
			ReviewDAO dao = sessionTemplate.getMapper(ReviewDAO.class);
			return dao.getReviewList(ftruckNo);
		}

		// ¸®ºä ÀÔ·Â
		public int insertReview(ReviewVO vo) {
			ReviewDAO dao = sessionTemplate.getMapper(ReviewDAO.class);
			return dao.insertReview(vo);
		}

		// ¸®ºä ¼öÁ¤
		public int updateReview(ReviewVO vo) {
			ReviewDAO dao = sessionTemplate.getMapper(ReviewDAO.class);
			return dao.updateReview(vo);
		}

		// ¸®ºä »èÁ¦
		public int deleteReview(int revSeq) {
			ReviewDAO dao = sessionTemplate.getMapper(ReviewDAO.class);
			return dao.deleteReview(revSeq);
		}
}
