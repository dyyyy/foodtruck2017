package com.foodtruck.dao;

import java.util.List;
import java.util.Map;

import com.foodtruck.vo.LicenseVO;
import com.foodtruck.vo.MInquiryVO;
import com.foodtruck.vo.MemberVO;

public interface MemberDAO {
	
	// ȸ�� ����
	public MemberVO getMember(String memberId);

	// ȸ�� ����Ʈ
	public List<MemberVO> getMemberList();

	//ID 찾기
	public MemberVO getId(String memberTel);
	
	//PW 찾기
	public MemberVO getPw(Map<String,Object> map);
	
	// ȸ�� ���
	public int insertMember(MemberVO vo);

	// ȸ�� ����
	public int updateMember(MemberVO vo);

	// ȸ�� ����
	public int deleteMember(String memberId);
	
	//�Ǹ����� ���̼�����ȣ
	public List<LicenseVO> getLicenseNo(String selId);
	
	//1:1문의 insert하기
	public int insertInquiry(MInquiryVO vo);
	
	//1:1문의 list가져오기
	public List<MInquiryVO> getMinquiryList();
}
