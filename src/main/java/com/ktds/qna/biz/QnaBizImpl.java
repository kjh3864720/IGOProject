package com.ktds.qna.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ktds.qna.dao.QnaDao;
import com.ktds.qna.vo.QnaSearchVO;
import com.ktds.qna.vo.QnaVO;

import io.github.seccoding.web.pager.Pager;
import io.github.seccoding.web.pager.PagerFactory;
import io.github.seccoding.web.pager.explorer.ClassicPageExplorer;
import io.github.seccoding.web.pager.explorer.PageExplorer;

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
	public PageExplorer readAllQna(QnaSearchVO qnaSearchVO) {
		int qnaTotalCount = this.qnaDao.selectAllQnaCount(qnaSearchVO);
		Pager pager = PagerFactory.getPager(Pager.ORACLE, qnaSearchVO.getPageNo() + "");
		
		pager.setTotalArticleCount(qnaTotalCount);

		PageExplorer pageExplorer = pager.makePageExplorer(ClassicPageExplorer.class, qnaSearchVO); // 시작번호와 끝번호가 나옴

		pageExplorer.setList(this.qnaDao.selectAllQna(qnaSearchVO));

		return pageExplorer;
	}
	
	@Override
	public boolean modifyOneQna(QnaVO qnaVO) {
		return this.qnaDao.updateOneQna(qnaVO) > 0;
	}

}
