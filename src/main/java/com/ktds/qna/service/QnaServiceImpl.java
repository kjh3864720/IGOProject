package com.ktds.qna.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktds.qna.biz.QnaBiz;
import com.ktds.qna.vo.QnaSearchVO;
import com.ktds.qna.vo.QnaVO;
import com.ktds.reply.biz.ReplyBiz;
import com.ktds.reply.vo.ReplyVO;

import io.github.seccoding.web.pager.explorer.PageExplorer;

@Service
public class QnaServiceImpl implements QnaService {
	
	@Autowired
	private QnaBiz qnaBiz;
	
	@Autowired
	private ReplyBiz replyBiz;
	
	@Override
	public boolean registOneQna(QnaVO qnaVO) {
		return this.qnaBiz.registOneQna(qnaVO);
	}
	
	@Override
	public QnaVO readOneQna(String qnaId) {
		return this.qnaBiz.readOneQna(qnaId);
	}
	
	@Override
	public PageExplorer readAllQna(QnaSearchVO qnaSearchVO) {
		return this.qnaBiz.readAllQna(qnaSearchVO);
	}
	
	@Override
	public boolean modifyOneQna(QnaVO qnaVO) {
		return this.qnaBiz.modifyOneQna(qnaVO);
	}

	@Override
	public List<ReplyVO> readRepliesByQna(String qnaId) {
		return this.replyBiz.selectReplyList(qnaId);
	}
	

}
