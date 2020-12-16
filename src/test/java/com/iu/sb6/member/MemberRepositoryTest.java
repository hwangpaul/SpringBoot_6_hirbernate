package com.iu.sb6.member;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MemberRepositoryTest {

	@Autowired
	private MemberRepository memberRepository;
	@Autowired
	private MemberFilesRepository memberFilesRepository;
	
	private MemberVO memberVO;
	private MemberFilesVO memberFilesVO;
	
	//@BeforeEach
	public void makeMember() throws Exception{
		
		int num = 6;
		String data = "test"+num;
		
		this.memberVO = new MemberVO();
		this.memberVO.setId(data);
		this.memberVO.setPw(data);
		this.memberVO.setAge(num*10);
		this.memberVO.setName(data);
		this.memberVO.setEmail(data+"@eamil.com");
		
		this.memberFilesVO = new MemberFilesVO();
		this.memberFilesVO.setFileName("fileName"+num);
		this.memberFilesVO.setOriName("oriName"+num);
		
	}
	
	@Test
	void deleteTest() throws Exception{
		MemberVO memberVO = new MemberVO();
		memberVO.setId("test4");
		memberRepository.deleteById(memberVO.getId());
		
	}
	
	//@Test
	void updateTest2() throws Exception{
		MemberVO memberVO = new MemberVO();
		MemberFilesVO memberFilesVO = new MemberFilesVO();
		
		memberVO.setId("test2");
		memberVO.setPw("updatetest33");
		memberVO.setName("updatetest33");
		memberVO.setAge(33);
		memberVO.setEmail("updatetest33@email.com");
		
		memberFilesVO.setNum(1);
		memberFilesVO.setFileName("updateFileName33");
		memberFilesVO.setOriName("updateOrilName33");
		
		memberFilesVO.setMemberVO(memberVO);
		memberVO.setMemberFilesVO(memberFilesVO);
		
		memberRepository.save(memberVO);
		
	}
	
	//@Test
	void updateTest() throws Exception{
		MemberVO memberVO = new MemberVO();
		memberVO.setId("test2");
		memberVO.setPw("updatetest2");
		memberVO.setName("updatetest2");
		memberVO.setAge(29);
		memberVO.setEmail("updatetest2@email.com");
		memberRepository.save(memberVO);
		
		MemberFilesVO memberFilesVO = new MemberFilesVO();
		memberFilesVO.setNum(1);
		memberFilesVO.setFileName("updateFileName2");
		memberFilesVO.setOriName("updateOrilName2");
		memberFilesVO.setMemberVO(memberVO);
		memberFilesRepository.save(memberFilesVO);
		
	}
	
	//@Test
	void selectFileTest() throws Exception{
		MemberFilesVO memberFilesVO = memberFilesRepository.findById(4L).get();
		
		System.out.println(memberFilesVO.getFileName());
		System.out.println(memberFilesVO.getOriName());
		System.out.println(memberFilesVO.getMemberVO().getId());
		System.out.println(memberFilesVO.getMemberVO().getEmail());
	}
	
	//@Test
	void selectTest() throws Exception{
	MemberVO mmemberVO = memberRepository.findById("test1").get();
	
	System.out.println(memberVO.getId());
	System.out.println(memberVO.getEmail());
	System.out.println(memberVO.getMemberFilesVO().getFileName());
	System.out.println(memberVO.getMemberFilesVO().getOriName());
	}
	
	//@Test
	void saveTest() throws Exception{
		saveTest3();

		
	}
	
	private void saveTest3() throws Exception{
		memberVO.setMemberFilesVO(memberFilesVO);
		memberFilesVO.setMemberVO(memberVO);
		memberFilesRepository.save(memberFilesVO);
		
	}
	
	
	private void saveTest2() throws Exception{
		//오류 없이 잘 실행됨
		
		//MemberFilees 테이블에 id가 Null이 들어가는 버그가 발생
		memberVO.setMemberFilesVO(memberFilesVO);
		
		//서로 값을 넣어주어야 함
		memberFilesVO.setMemberVO(memberVO);
		memberRepository.save(memberVO);
		
	}

	private void  saveTest1() throws Exception{
		
		memberFilesVO.setMemberVO(memberVO);
		
		memberVO = memberRepository.save(memberVO);
		memberFilesRepository.save(memberFilesVO);
		
		assertNotNull(memberVO);
	}
}
