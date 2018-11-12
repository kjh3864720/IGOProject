package com.ktds.reply.vo;

public class ReplyVO {

	private String replyId;
	private String content;
	private String email;
	private String regDate;
	private String qnaId;

	public String getReplyId() {
		return replyId;
	}

	public void setReplyId(String replyId) {
		this.replyId = replyId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getQnaId() {
		return qnaId;
	}

	public void setQnaId(String qnaId) {
		this.qnaId = qnaId;
	}

	@Override
	public String toString() {
		return "ReplyVO [replyId=" + replyId + ", content=" + content + ", email=" + email + ", regDate=" + regDate
				+ ", qnaId=" + qnaId + "]";
	}

}
