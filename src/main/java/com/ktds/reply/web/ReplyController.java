package com.ktds.reply.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ktds.reply.service.ReplyService;

@Controller
public class ReplyController {
	
	@Autowired
	private ReplyService replyService;

}
