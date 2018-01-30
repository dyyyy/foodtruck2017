package com.foodtruck.dao;

import java.util.List;
import java.util.Map;

import com.foodtruck.vo.LicenseVO;
import com.foodtruck.vo.MInquiryVO;
import com.foodtruck.vo.MemberVO;

public interface MemberDAO {
	
	// 회원 정보
	public MemberVO getMember(String memberId);

	// 회원 리스트
	public List<MemberVO> getMemberList();

	//ID 찾기
	public MemberVO getId(String memberTel);
	
	//PW 찾기
	public MemberVO getPw(Map<String,Object> map);
	
	// 회원 등록
	public int insertMember(MemberVO vo);

	// 회원 수정
	public int updateMember(MemberVO vo);

	// 회원 삭제
	public int deleteMember(String memberId);
	
	//판매자의 라이센스번호
	public List<LicenseVO> getLicenseNo(String selId);
	
	//1:1문의 insert하기
	public int insertInquiry(MInquiryVO vo);
	
	//1:1문의 list가져오기
	public List<MInquiryVO> getMinquiryList(int NpageNo);
	
	//1:1문의 total count가져오기
	public int getMinquiryListcount();
	
	//1:1문의 select
	public MInquiryVO getinfo(int qno);
	
	//1:1문의 update
	public int updateMinquiry(int qno);
	
	//1:1문의 insert하기(판매자)
	public int insertInquiry2(MInquiryVO vo);
}
