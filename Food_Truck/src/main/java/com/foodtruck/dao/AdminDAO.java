package com.foodtruck.dao;

import java.util.List;

import com.foodtruck.vo.AdminVO;

public interface AdminDAO {

	// 관리자 정보
	public AdminVO getAdmin(String AdminId);

	// 관리자 리스트
	public List<AdminVO> getAdminList();

	// 관리자 등록
	public int insertAdmin(AdminVO vo);

	// 관리자 수정
	public int updateAdmin(AdminVO vo);

	// 관리자 삭제
	public int deleteAdmin(String AdminId);
}
