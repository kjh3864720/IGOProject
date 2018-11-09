package com.ktds.qna.vo;

import com.nhncorp.lucy.security.xss.XssFilter;

public class QnaVO {

	private String qnaId;
	private String title;
	private String content;
	private String regDate;

	public String getQnaId() {
		return qnaId;
	}

	public void setQnaId(String qnaId) {
		this.qnaId = qnaId;
	}

	public String getTitle() {
		XssFilter filter = XssFilter.getInstance("lucy-xss-superset.xml");
		return filter.doFilter(title);
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		XssFilter filter = XssFilter.getInstance("lucy-xss-superset.xml");
		return filter.doFilter(content);
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

}
