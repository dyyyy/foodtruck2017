package com.foodtruck.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodtruck.dao.MemberDAO;
import com.foodtruck.vo.LicenseVO;
import com.foodtruck.vo.MInquiryVO;
import com.foodtruck.vo.MemberVO;

@Service
public class MemberService {
	@Autowired
	private SqlSessionTemplate sessionTemplate;

	// ȸ�� ����
	public MemberVO getMember(String memberId) {
		MemberDAO dao = sessionTemplate.getMapper(MemberDAO.class);
		return dao.getMember(memberId);
	}

	// ȸ�� ����Ʈ
	public List<MemberVO> getMemberList() {
		MemberDAO dao = sessionTemplate.getMapper(MemberDAO.class);
		return dao.getMemberList();
	}

	public MemberVO getId(String memberTel) {
		MemberDAO dao = sessionTemplate.getMapper(MemberDAO.class);
		return dao.getId(memberTel);
	}
	
	public MemberVO getPw(Map<String,Object> map) {
		MemberDAO dao = sessionTemplate.getMapper(MemberDAO.class);
		return dao.getPw(map);
	}
	
	// ȸ�� �Է�
	public int insertMember(MemberVO vo) {
		MemberDAO dao = sessionTemplate.getMapper(MemberDAO.class);
		return dao.insertMember(vo);
	}

	// ȸ�� ����
	public int updateMember(MemberVO vo) {
		MemberDAO dao = sessionTemplate.getMapper(MemberDAO.class);
		return dao.updateMember(vo);
	}

	// ȸ�� ����
	public int deleteMember(String memberId) {
		MemberDAO dao = sessionTemplate.getMapper(MemberDAO.class);
		return dao.deleteMember(memberId);
	}

	//�Ǹ����� ���̼�����ȣ
	public List<LicenseVO> getLicenseNo(String selId) {
		MemberDAO dao = sessionTemplate.getMapper(MemberDAO.class);
		return dao.getLicenseNo(selId);
	}
	//1:1 insert하기
	public int insertInquiry(MInquiryVO vo) {
		MemberDAO dao = sessionTemplate.getMapper(MemberDAO.class);
		return dao.insertInquiry(vo);
	}
	//1:1 문의사항 list가져오기
	public List<MInquiryVO> getMinquiryList(int NpageNo){
		MemberDAO dao = sessionTemplate.getMapper(MemberDAO.class);
		return dao.getMinquiryList(NpageNo);
	}
	//1:1문의사항 count 가져오기
	public int getMinquiryListcount() {
		MemberDAO dao = sessionTemplate.getMapper(MemberDAO.class);
		return dao.getMinquiryListcount();
	}
	//1:1 문의사항 select
	public MInquiryVO getinfo(int qno) {
		MemberDAO dao = sessionTemplate.getMapper(MemberDAO.class);
		return dao.getinfo(qno);
	}
	public int updateMinquiry(int qno) {
		MemberDAO dao = sessionTemplate.getMapper(MemberDAO.class);
		return dao.updateMinquiry(qno);
	}
	//1:1 insert 하기
	public int insertInquiry2(MInquiryVO vo) {
		MemberDAO dao = sessionTemplate.getMapper(MemberDAO.class);
		return dao.insertInquiry2(vo);
	}

}
