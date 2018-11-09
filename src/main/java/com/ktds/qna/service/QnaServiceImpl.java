package com.ktds.qna.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktds.qna.biz.QnaBiz;
import com.ktds.qna.vo.QnaVO;

@Service
public class QnaServiceImpl implements QnaService {
	
	@Autowired
	private QnaBiz qnaBiz;
	
	@Override
	public boolean registOneQna(QnaVO qnaVO) {
		return this.qnaBiz.registOneQna(qnaVO);
	}

}
