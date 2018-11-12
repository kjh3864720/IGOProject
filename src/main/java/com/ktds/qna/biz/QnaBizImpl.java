package com.ktds.qna.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ktds.qna.dao.QnaDao;
import com.ktds.qna.vo.QnaVO;

@Component
public class QnaBizImpl implements QnaBiz {

	@Autowired
	private QnaDao qnaDao;
	
	@Override
	public boolean registOneQna(QnaVO qnaVO) {
		return this.qnaDao.insertOneQna(qnaVO) > 0;
	}
	
	@Override
	public QnaVO readOneQna(String qnaId) {
		return this.qnaDao.selectOneQna(qnaId);
	}
	
	@Override
	public List<QnaVO> readAllQna() {
		return this.qnaDao.selectAllQna();
	}

}
