package com.ktds.reply.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktds.reply.biz.ReplyBiz;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	private ReplyBiz replyBiz;
	
}
