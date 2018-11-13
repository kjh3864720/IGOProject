package com.ktds.notice.service;

import com.ktds.notice.vo.NoticeSearchVO;
import com.ktds.notice.vo.NoticeVO;
import com.ktds.member.vo.MemberVO;

import io.github.seccoding.web.pager.explorer.PageExplorer;

public interface NoticeService {
	
	public boolean createNotice( NoticeVO noticeVO, MemberVO memberVO );
	public boolean updateNotice( NoticeVO noticeVO );
	public NoticeVO readOneNotice( int id, MemberVO memberVO );
	public NoticeVO readOneNotice( int id );
	public boolean deleteOneNotice( int id );
	public PageExplorer readAllNotices( NoticeSearchVO noticeSearchVO );
	
}
