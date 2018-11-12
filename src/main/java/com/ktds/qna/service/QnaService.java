package com.ktds.qna.service;

import java.util.List;

import com.ktds.qna.vo.QnaVO;

public interface QnaService {
	
	public boolean registOneQna(QnaVO qnaVO);
	
	public QnaVO readOneQna(String qnaId);
	
	public List<QnaVO> readAllQna();

}
