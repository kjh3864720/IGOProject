package com.ktds.qna.service;

import java.util.List;

import com.ktds.qna.vo.QnaVO;
import com.ktds.reply.vo.ReplyVO;

public interface QnaService {
	
	public boolean registOneQna(QnaVO qnaVO);
	
	public QnaVO readOneQna(String qnaId);
	
	public List<QnaVO> readAllQna();

	public List<ReplyVO> readRepliesByQna(String qnaId);
}
