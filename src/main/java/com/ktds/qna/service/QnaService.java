package com.ktds.qna.service;

import com.ktds.qna.vo.QnaSearchVO;
import com.ktds.qna.vo.QnaVO;
import com.ktds.reply.vo.ReplyVO;

import io.github.seccoding.web.pager.explorer.PageExplorer;

public interface QnaService {
	
	public boolean registOneQna(QnaVO qnaVO);
	
	public QnaVO readOneQna(String qnaId);
	
	public PageExplorer readAllQna(QnaSearchVO qnaSearchVO);
	
	public boolean modifyOneQna(QnaVO qnaVO);

	public List<ReplyVO> readRepliesByQna(String qnaId);
}
