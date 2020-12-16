package com.iu.sb6.board.qna;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QnaRepository extends JpaRepository<QnaVO, Long>{
	
	//부모의 ref와 같고 step이 부모의 step보다 큰것들 SELECT
	public List<QnaVO> findByRefAndStepGreaterThan(long ref, long step);

	
}
