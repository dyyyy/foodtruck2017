package com.foodtruck.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodtruck.dao.FestivalDAO;
import com.foodtruck.vo.FestivalVO;

@Service
public class FestivalService {
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	public List<FestivalDAO> getFestivalList() throws Exception{
		FestivalDAO dao=sessionTemplate.getMapper(FestivalDAO.class);
		return dao.getFestivalList();
	}
	public int getIntsertFestival(FestivalDAO vo) throws Exception{
		FestivalDAO dao=sessionTemplate.getMapper(FestivalDAO.class);
		return dao.getIntsertFestival(vo);
	}
	public int getgetUpdateFestival(FestivalDAO vo) throws Exception{
		FestivalDAO dao=sessionTemplate.getMapper(FestivalDAO.class);
		return dao.getUpdateFestival(vo);
	}
	
}