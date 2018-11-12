package com.ktds.reply.web;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ktds.reply.service.ReplyService;
import com.ktds.reply.vo.ReplyVO;

@Controller
public class ReplyController {
	
	@Autowired
	private ReplyService replyService;
	
	@PostMapping("/reply/write")
	@ResponseBody
	public Map<String, Object> doReplyWriteAction (@Valid @ModelAttribute ReplyVO replyVO, Errors error) {
		
		Map<String, Object> result = new HashMap<>();
		
		replyVO.setEmail("admin@igo.com");
		boolean isSuccess = this.replyService.writeReply(replyVO);
		
		if(isSuccess) {
			result.put("status", "ok");
			result.put("content", replyVO.getContent());
			result.put("email", replyVO.getEmail());
		} else {
			result.put("status", "fail");
		}
		
		return result;
	}
	
}
