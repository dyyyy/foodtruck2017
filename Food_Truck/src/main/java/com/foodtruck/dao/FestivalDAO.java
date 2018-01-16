package com.foodtruck.dao;

import java.util.List;

import com.foodtruck.vo.FestivalVO;

public interface FestivalDAO {
	
	//축제정보 리스트 가져오기
	public List<FestivalVO> getFestivalList() throws Exception;
	//축제정보 insert하기
	public int IntsertFestival(FestivalVO festivalVO) throws Exception;
	//축제정보 update하기
	public int UpdateFestival(FestivalDAO vo) throws Exception;
	//축제정보 삭제하기
	public int deleteFestival() throws Exception;
}
