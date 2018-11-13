package com.ktds.notice.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ktds.notice.vo.NoticeSearchVO;
import com.ktds.notice.vo.NoticeVO;
import com.ktds.common.dao.support.BindData;
import com.ktds.member.vo.MemberVO;

@Repository
public class NoticeDaoImpl implements NoticeDao{

	// Inner Class (Interface)
	private interface Query {
		int INSERT = 0;
		int SELECT_ONE = 1;
		int DELETE_ONE = 2;
		int SELECT_ALL = 3;
	}
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Resource(name="noticeQueries")
	private List<String> noticeQueries;
	
	@Override
	public int insertNotice( NoticeVO noticeVO ) {
		return this.jdbcTemplate.update(
				this.noticeQueries.get(Query.INSERT)
				, noticeVO.getSubject()
				, noticeVO.getContent()
				, noticeVO.getEmail()
				, noticeVO.getFileName()
				, noticeVO.getOriginFileName());
	}

	@Override
	public int updateNotice( NoticeVO noticeVO ) {
		System.out.println("Call updateBoard();");
		return 0;
	}

	@Override
	public NoticeVO selectOneNotice(int id) {
		return this.jdbcTemplate.queryForObject(this.noticeQueries.get(Query.SELECT_ONE)
						, new Object[] {id}
						, new RowMapper<NoticeVO>() {

							@Override
							public NoticeVO mapRow(ResultSet rs, int rowNum) throws SQLException {
								MemberVO memberVO = BindData.bindData(rs, new MemberVO());
								NoticeVO noticeVO = BindData.bindData(rs, new NoticeVO());
								noticeVO.setMemberVO(memberVO);
								return noticeVO;
							}
							
						});
	}

	@Override
	public int deleteOneNotice( int id ) {
		return this.jdbcTemplate.update(this.noticeQueries.get(Query.DELETE_ONE), id);
	}

	@Override
	public List<NoticeVO> selectAllNotices( NoticeSearchVO noticeSearchVO ) {
		return this.jdbcTemplate.query(this.noticeQueries.get(Query.SELECT_ALL), new RowMapper<NoticeVO>() {
			@Override
			public NoticeVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				MemberVO memberVO = BindData.bindData(rs, new MemberVO());
				NoticeVO noticeVO = BindData.bindData(rs, new NoticeVO());
				noticeVO.setMemberVO(memberVO);
				return noticeVO;
			}
		});
	}

	@Override
	public int selectAllNoticesCount(NoticeSearchVO noticeSearchVO) {
		
		return 0;
	}

}
