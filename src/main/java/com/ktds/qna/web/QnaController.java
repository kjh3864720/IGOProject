package com.ktds.qna.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ktds.qna.service.QnaService;
import com.ktds.qna.vo.QnaVO;

@Controller
public class QnaController {

	@Autowired
	private QnaService qnaService;
	
	@GetMapping("/qna/regist")
	public String viewTestPage() {
		return "qna/regist";
	}
	
	@PostMapping("/qna/regist")
	public String doOneQnaRegistAction(@ModelAttribute QnaVO qnaVO) {
		this.qnaService.registOneQna(qnaVO);
		System.out.println("QnaController" + qnaVO.getContent());
		return "qna/regist";
	}
	
}
