package com.ktds.notice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ktds.notice.dao.NoticeDao;
import com.ktds.notice.vo.NoticeSearchVO;
import com.ktds.notice.vo.NoticeVO;
import com.ktds.common.exceptions.PolicyViolationException;
import com.ktds.member.vo.MemberVO;

import io.github.seccoding.web.pager.Pager;
import io.github.seccoding.web.pager.PagerFactory;
import io.github.seccoding.web.pager.explorer.ClassicPageExplorer;
import io.github.seccoding.web.pager.explorer.PageExplorer;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	@Qualifier("noticeDaoImplMyBatis")
	private NoticeDao noticeDao;
	
//	public void setBoardDao(BoardDao boardDao) {
//		System.out.println("Spring?��?�� ?��출함.");
//		System.out.println(this.boardDao);
//		this.boardDao = boardDao;
//	}
	
	@Override
	public boolean createNotice( NoticeVO noticeVO, MemberVO memberVO ) {
		
		return this.noticeDao.insertNotice( noticeVO ) > 0;
	}

	@Override
	public boolean updateNotice( NoticeVO noticeVO ) {
		return this.noticeDao.updateNotice( noticeVO ) > 0;
	}

	@Override
	public NoticeVO readOneNotice(int id, MemberVO memberVO) {
		NoticeVO noticeVO = this.readOneNotice(id);
		
		return noticeVO;
	}
	
	@Override
	public NoticeVO readOneNotice(int id) {
		return this.noticeDao.selectOneNotice(id);
	}

	@Override
	public boolean deleteOneNotice(int id) {
		return this.noticeDao.deleteOneNotice(id) > 0;
	}

	@Override
	public PageExplorer readAllNotices( NoticeSearchVO noticeSearchVO ) {
		
		int totalCount = this.noticeDao.selectAllNoticesCount(noticeSearchVO);
		
		Pager pager = PagerFactory.getPager( Pager.ORACLE, noticeSearchVO.getPageNo()+"" );
	
		pager.setTotalArticleCount(totalCount);
		
		PageExplorer pageExplorer = pager.makePageExplorer(ClassicPageExplorer.class, noticeSearchVO);
		
		pageExplorer.setList(this.noticeDao.selectAllNotices(noticeSearchVO));
		
		return pageExplorer;
	}

}
