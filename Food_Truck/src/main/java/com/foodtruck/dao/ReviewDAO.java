package com.foodtruck.dao;

import java.util.List;

import com.foodtruck.vo.ReviewVO;

public interface ReviewDAO {

		// ¸®ºä ¸®½ºÆ®
		public List<ReviewVO> getReviewList(String licenseNo);

		// ¸®ºä µî·Ï
		public int insertReview(ReviewVO vo);

		// ¸®ºä ¼öÁ¤
		public int updateReview(ReviewVO vo);

		// ¸®ºä »èÁ¦
		public int deleteReview(int revSeq);
}
