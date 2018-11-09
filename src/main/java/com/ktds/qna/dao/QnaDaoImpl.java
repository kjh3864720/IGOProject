package com.ktds.qna.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktds.qna.vo.QnaVO;

@Repository
public class QnaDaoImpl extends SqlSessionDaoSupport implements QnaDao {
	
	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	@Override
	public int insertOneQna(QnaVO qnaVO) {
		return getSqlSession().insert("QnaDao.insertOneQna", qnaVO);
	}

}
