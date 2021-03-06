package com.ktds.qna.biz;

import com.ktds.qna.vo.QnaSearchVO;
import com.ktds.qna.vo.QnaVO;

import io.github.seccoding.web.pager.explorer.PageExplorer;

public interface QnaBiz {
	
	public boolean registOneQna(QnaVO qnaVO);
	
	public QnaVO readOneQna(String qnaId);
	
	public PageExplorer readAllQna(QnaSearchVO qnaSearchVO);
	
	
	public boolean modifyOneQna(QnaVO qnaVO);
	

}
