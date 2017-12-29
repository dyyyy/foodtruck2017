package com.foodtruck.dao;

import java.util.List;

import com.foodtruck.vo.LicenseVO;
import com.foodtruck.vo.MemberVO;

public interface MemberDAO {
	
	// 회원 정보
	public MemberVO getMember(String memberId);

	// 회원 리스트
	public List<MemberVO> getMemberList();

	// 회원 등록
	public int insertMember(MemberVO vo);

	// 회원 수정
	public int updateMember(MemberVO vo);

	// 회원 삭제
	public int deleteMember(String memberId);
	
	//판매자의 라이센스번호
	public List<LicenseVO> getLicenseNo(String selId);
}
