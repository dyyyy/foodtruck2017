package com.foodtruck.service;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodtruck.dao.MemberDAO;
import com.foodtruck.vo.MemberVO;

@Service
public class MemberService {
	@Autowired
	private SqlSessionTemplate sessionTemplate;

	// 회원 정보
	public MemberVO getMember(String memberId) {
		MemberDAO dao = sessionTemplate.getMapper(MemberDAO.class);
		return dao.getMember(memberId);
	}

	// 회원 리스트
	public List<MemberVO> getMemberList() {
		MemberDAO dao = sessionTemplate.getMapper(MemberDAO.class);
		return dao.getMemberList();
	}

	// 회원 입력
	public int insertMember(MemberVO vo) {
		MemberDAO dao = sessionTemplate.getMapper(MemberDAO.class);
		return dao.insertMember(vo);
	}

	// 회원 수정
	public int updateMember(MemberVO vo) {
		MemberDAO dao = sessionTemplate.getMapper(MemberDAO.class);
		return dao.updateMember(vo);
	}

	// 회원 삭제
	public int deleteMember(String memberId) {
		MemberDAO dao = sessionTemplate.getMapper(MemberDAO.class);
		return dao.deleteMember(memberId);
	}
	
	
	


}
