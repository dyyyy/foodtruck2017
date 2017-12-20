package com.foodtruck.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.foodtruck.service.MemberService;
import com.foodtruck.vo.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class MemberTest {

	@Autowired
	private MemberService dao;
	
	@Test
	public void testLogin()throws Exception {
		MemberVO vo = new MemberVO();
		vo.setMemberId("user00");
		System.out.println(dao.getMember("user00").toString());
	}
}
