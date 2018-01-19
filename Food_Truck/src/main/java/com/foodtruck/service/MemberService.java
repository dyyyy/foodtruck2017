package com.foodtruck.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodtruck.dao.MemberDAO;
import com.foodtruck.vo.LicenseVO;
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


}
