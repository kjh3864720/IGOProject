package com.ktds.qna.service;

import java.util.List;

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
	
	@Override
	public QnaVO readOneQna(String qnaId) {
		return this.qnaBiz.readOneQna(qnaId);
	}
	
	@Override
	public List<QnaVO> readAllQna() {
		return this.qnaBiz.readAllQna();
	}

}
