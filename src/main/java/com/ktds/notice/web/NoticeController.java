package com.ktds.notice.web;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.common.web.DownloadUtil;
import com.ktds.member.vo.MemberVO;
import com.ktds.notice.service.NoticeService;
import com.ktds.notice.vo.NoticeSearchVO;
import com.ktds.notice.vo.NoticeVO;

import io.github.seccoding.web.pager.explorer.PageExplorer;

@Controller
public class NoticeController {
	
	private Logger statiticsLogger = LoggerFactory.getLogger("list.statistics");
	private Logger paramLogger = LoggerFactory.getLogger(NoticeController.class);

	@Value("${upload.path}") // properties ?��?��?�� ?��?��?�� ?��?��?��
	private String uploadPath;
	
	@Autowired
	@Qualifier("noticeServiceImpl")
	private NoticeService noticeService;
	
	@RequestMapping("board/list")
	
	public ModelAndView viewNoticeListPage( 
			@ModelAttribute NoticeSearchVO noticeSearchVO 
			, HttpServletRequest request ) {
		PageExplorer pageExplorer = this.noticeService.readAllNotices(noticeSearchVO);
		statiticsLogger.info("URL : /board/list, IP : " + request.getRemoteAddr() 
			+ ", List Size : " + pageExplorer.getList().size());
		
		ModelAndView view = new ModelAndView("board/list");
		view.addObject("noticeVOList", pageExplorer.getList());
		view.addObject("pagenation", pageExplorer.make());
		return view;
	}
	
	// Spring 4.2 ?��?��?��?�� ?��?��
	// @RequestMapping(value="/write", method=RequestMethod.GET)
	// Spring 4.3 ?��?��?��?�� ?��?��
	@GetMapping("board/write")
	public String viewNoticeWritePage() {
		return "board/write";
	}
	
	//                                   //
	@GetMapping("board/notice")
	public String viewNoticePage() {
		return "board/notice";
	}
	
	@PostMapping("board/write")
	public ModelAndView doNoticeWriteAction( 
			@Valid @ModelAttribute NoticeVO noticeVO
			, Errors errors
			, @SessionAttribute(name="_USER_") MemberVO memberVO
			, HttpServletRequest request) {

		ModelAndView view = new ModelAndView("redirect:/board/list");
		
		if ( errors.hasErrors() ) {
			view.setViewName("board/write");
			view.addObject("noticeVO", noticeVO);
			return view;
		}
		
		MultipartFile uploadFile = noticeVO.getFile();
		
		if ( !uploadFile.isEmpty() ) {
			String originFileName = uploadFile.getOriginalFilename();
			String fileName = UUID.randomUUID().toString();
			
			File uploadDir = new File(this.uploadPath);
			if ( !uploadDir.exists() ) {
				uploadDir.mkdirs();
			}
			
			File destFile = new File(this.uploadPath, fileName);
			
			try {
				uploadFile.transferTo(destFile);
				noticeVO.setOriginFileName(originFileName);
				noticeVO.setFileName(fileName);
			} catch (IllegalStateException | IOException e) {
				throw new RuntimeException(e.getMessage(), e);
			}

		}
		
		noticeVO.setMemberVO(memberVO);
		noticeVO.setEmail(memberVO.getEmail());
		
//		(condition) ? true : false; <- ?��?��?��?��?��(Elvis Operator), �??�� 과정?�� ?��?��?�� if-else?�� 비해 ?���?
//		String view = this.boardService.createBoard(boardVO, memberVO) ? "redirect:/board/list" : "redirect:/board/write";
		
		boolean isSuccess = this.noticeService.createNotice(noticeVO, memberVO);
		
		String paramFormat = "IP:%s, Param:%s, Result:%s";
		paramLogger.debug( String.format(paramFormat
				, request.getRemoteAddr()
				, noticeVO.getSubject() + " , "
				+ noticeVO.getContent() + " , "
				+ noticeVO.getEmail() + " , " 
				+ noticeVO.getFileName() + " , "
				+ noticeVO.getOriginFileName()
				, view.getViewName() ));
		
		return view;
	}
	
	@RequestMapping("/board/detail/{id}")
	public ModelAndView viewNoticeDetailPage( 
			@PathVariable int id 
			, @SessionAttribute(name="_USER_") MemberVO memberVO 
			, HttpServletRequest request
			) {
		
		NoticeVO noticeVO = null;
		
		noticeVO = this.noticeService.readOneNotice(id, memberVO);
/*		if ( boardVO == null ) {
			return new ModelAndView("redirect:/board/list");
		}*/

		ModelAndView view = new ModelAndView("board/detail");
		view.addObject("noticeVO", noticeVO);
		
		String paramFormat = "IP:%s, Param:%s, Result:%s";
		paramLogger.debug( String.format(paramFormat
				, request.getRemoteAddr()
				, id
				, noticeVO.getId() + " , "
				+ noticeVO.getSubject() + " , "
				+ noticeVO.getContent() + " , "
				+ noticeVO.getEmail() + " , " 
				+ noticeVO.getFileName() + " , "
				+ noticeVO.getOriginFileName()
				));
		
		return view;
	}
	
	@RequestMapping("/board/delete/{id}")
	public String doNoticeDeleteAction( @PathVariable int id
			, HttpServletRequest request
			, @SessionAttribute("_USER_") MemberVO memberVO) {
		boolean isSuccess = this.noticeService.deleteOneNotice(id);
		
		String paramFormat = "IP:%s, Param:%s, Result:%s";
		paramLogger.debug( String.format(paramFormat
				, request.getRemoteAddr()
				, memberVO.getEmail() + " , "
				+ id + " , " 
				+ isSuccess
				, "redirect:/board/list"
				));
		
		return "redirect:/board/list";
	}
	
	@RequestMapping("/board/download/{id}")
	public void fileDownload(
			@PathVariable int id
			, HttpServletRequest request
			, HttpServletResponse response
			, @SessionAttribute("_USER_") MemberVO memberVO
			) {
		
		NoticeVO noticeVO = this.noticeService.readOneNotice(id);
		String originFileName = noticeVO.getOriginFileName();
		String fileName = noticeVO.getFileName();
		
		// File.separator : windows - '\' , Unix/Linux/macos - '/'
		try {
			new DownloadUtil(this.uploadPath + File.separator + fileName).download(request, response, originFileName);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
	
}
