package com.ktds.qna.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
	@ResponseBody
	public boolean doOneQnaRegistAction(@ModelAttribute QnaVO qnaVO) {
		boolean isRegist = this.qnaService.registOneQna(qnaVO);
		System.out.println("QnaController" + qnaVO.getContent());
		return isRegist;
	}
	
	@GetMapping("/qna")
	public ModelAndView viewQnaListPage() {
		ModelAndView view = new ModelAndView("qna/list");
		List<QnaVO> qnaList = this.qnaService.readAllQna();
		view.addObject("qnaList", qnaList);
		return view;
	}
	
	@GetMapping("/qna/detail/{qnaId}")
	public ModelAndView viewQnaDetailPage(@PathVariable String qnaId) {
		ModelAndView view = new ModelAndView("qna/detail");
		QnaVO qnaVO = this.qnaService.readOneQna(qnaId);
		view.addObject("qnaVO", qnaVO);
		return view;
	}
	
}
