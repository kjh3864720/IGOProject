package com.ktds.qna.biz;

import java.util.List;

import com.ktds.qna.vo.QnaVO;

public interface QnaBiz {
	
	public boolean registOneQna(QnaVO qnaVO);
	
	public QnaVO readOneQna(String qnaId);
	
	public List<QnaVO> readAllQna();

}
