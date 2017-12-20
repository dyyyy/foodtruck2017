package com.foodtruck.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodtruck.dao.AdminDAO;
import com.foodtruck.vo.AdminVO;

@Service
public class AdminService {
	@Autowired
	private SqlSessionTemplate sessionTemplate;

	// 관리자 정보
	public AdminVO getAdmin(String AdminId) {
		AdminDAO dao = sessionTemplate.getMapper(AdminDAO.class);
		return dao.getAdmin(AdminId);
	}
//
//	// 관리자 리스트
//	public List<AdminVO> getAdminList() {
//		AdminDAO dao = sessionTemplate.getMapper(AdminDAO.class);
//		return dao.getAdminList();
//	}
//
//	// 관리자 입력
//	public int insertAdmin(AdminVO vo) {
//		AdminDAO dao = sessionTemplate.getMapper(AdminDAO.class);
//		return dao.insertAdmin(vo);
//	}
//
//	// 관리자 수정
//	public int updateAdmin(AdminVO vo) {
//		AdminDAO dao = sessionTemplate.getMapper(AdminDAO.class);
//		return dao.updateAdmin(vo);
//	}
//
//	// 관리자 삭제
//	public int deleteAdmin(String AdminId) {
//		AdminDAO dao = sessionTemplate.getMapper(AdminDAO.class);
//		return dao.deleteAdmin(AdminId);
//	}

}
