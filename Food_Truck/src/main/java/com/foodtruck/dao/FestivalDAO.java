package com.foodtruck.dao;

import java.util.List;

public interface FestivalDAO {
	
	//축제정보 리스트 가져오기
	public List<FestivalDAO> getFestivalList() throws Exception;
	//축제정보 insert하기
	public int getIntsertFestival(FestivalDAO vo) throws Exception;
	//축제정보 update하기
	public int getUpdateFestival(FestivalDAO vo) throws Exception;
}
