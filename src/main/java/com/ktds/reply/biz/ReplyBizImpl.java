package com.ktds.reply.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ktds.reply.dao.ReplyDao;

@Component
public class ReplyBizImpl implements ReplyBiz {

	@Autowired
	private ReplyDao replyDao;
}
