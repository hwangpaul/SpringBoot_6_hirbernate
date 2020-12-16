package com.iu.sb6.board.notice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.iu.sb6.board.qna.QnaVO;

@Service
public class NoticeService {

	@Autowired
	private NoticeRepository noticeRepository;
	
	public Page<NoticeVO> noticeList(Pageable pageable) throws Exception{
		return noticeRepository.findAll(pageable);
	} 
	
	public NoticeVO noticeSelect() {
		return noticeRepository.findById(1L).get();
		
	}
}
