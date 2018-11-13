package com.ktds.notice.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktds.notice.vo.NoticeSearchVO;
import com.ktds.notice.vo.NoticeVO;

@Repository
public class NoticeDaoImplMyBatis extends SqlSessionDaoSupport implements NoticeDao {

	@Autowired
	@Override
	public void setSqlSessionTemplate( SqlSessionTemplate sqlSessionTemplate ) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	@Override
	public int insertNotice(NoticeVO noticeVO) {
		return this.getSqlSession().insert("NoticeDao.insertNotice", noticeVO);
	}

	@Override
	public int updateNotice(NoticeVO noticeVO) {
		return this.getSqlSession().update("NoticeDao.updateNotice", noticeVO);
	}

	@Override
	public NoticeVO selectOneNotice(int id) {
		return this.getSqlSession().selectOne("NoticeDao.selectOneNotice", id);
	}

	@Override
	public int deleteOneNotice(int id) {
		return this.getSqlSession().delete("NoticeDao.noticeOneNotice", id);
	}

	@Override
	public List<NoticeVO> selectAllNotices( NoticeSearchVO noticeSearchVO ) {
		return this.getSqlSession().selectList("NoticeDao.selectAllNotices", noticeSearchVO);
	}

	@Override
	public int selectAllNoticesCount(NoticeSearchVO noticeSearchVO) {
		return this.getSqlSession().selectOne("NoticeDao.selectAllNoticesCount", noticeSearchVO);
	}

}
