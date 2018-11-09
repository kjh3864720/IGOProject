package com.ktds.member.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ktds.member.dao.MemberDao;
import com.ktds.member.vo.MemberVO;

@Component
public class MemberBizImpl implements MemberBiz{

	@Autowired
	private MemberDao memberDao;
	
	@Override
	public boolean registOneMember(MemberVO memberVO) {
		return memberDao.insertOneMember(memberVO) > 0;
	}

}
