package com.iu.sb6.board.notice;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.aspectj.weaver.ast.Not;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.iu.sb6.board.qna.QnaVO;
import com.jayway.jsonpath.spi.cache.NOOPCache;

@SpringBootTest
class NoticeRepositoryTest {

	@Autowired
	private NoticeRepository noticeRepository;
	
	@Autowired
	private NoticeService noticeService;
	
	@Test
	void test() throws Exception{
		//this.saveTest1();
		//this.selectTest1();
		this.saveTest2();
	}
	
	private void saveTest2() {
		List<NoticeVO> ar = new ArrayList<NoticeVO>();
		for(int i=0;i<100;i++) {
			NoticeVO noticeVO = new NoticeVO();
			noticeVO.setTitle("title"+i);
			noticeVO.setWriter("writer"+i);
			noticeVO.setContents("contnents"+i);
			ar.add(noticeVO);
		}
		
		noticeRepository.saveAll(ar);
		System.out.println("Finish");
	}
	
	private void selectTest1() {
		//글번호로 notice, noticeFiles 조회
		//글제목, 작성자, fileName, oriName
		//Optional<NoticeVO> opt = noticeRepository.findById(1L);
		//NoticeVO noticeVO = opt.get();
		
		NoticeVO noticeVO = noticeService.noticeSelect();
		
		System.out.println(noticeVO.getTitle());
		System.out.println(noticeVO.getContents());
		
		for(NoticeFileVO noticeFileVO:noticeVO.getNoticeFileVOs()) {
			
			System.out.println("---------------------------------");
			System.out.println(noticeFileVO.getFileName());
			System.out.println(noticeFileVO.getOriName());
		}
		
		System.out.println("----------- Finish --------------");
		
	}
	
	private void saveTest1() {
		
		//insert notice, noticeFile
		
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setTitle("test title1");
		noticeVO.setWriter("test writer1");
		noticeVO.setContents("test contents1");
		
		List<NoticeFileVO> ar = new ArrayList<NoticeFileVO>();
		NoticeFileVO noticeFileVO = new NoticeFileVO();
		noticeFileVO.setFileName("fileName1.jpg");
		noticeFileVO.setOriName("oriName1.jpg");
		noticeFileVO.setNoticeVO(noticeVO);
		
		ar.add(noticeFileVO);
		
		NoticeFileVO noticeFileVO2 = new NoticeFileVO();
		noticeFileVO2.setFileName("fileName2.jpg");
		noticeFileVO2.setOriName("oriName2.jpg");
		noticeFileVO2.setNoticeVO(noticeVO);
		
		ar.add(noticeFileVO2);
		
		noticeVO.setNoticeFileVOs(ar);
		
		noticeRepository.save(noticeVO);
		
		System.out.println("Finish");
		
		
		
		
	}

}
