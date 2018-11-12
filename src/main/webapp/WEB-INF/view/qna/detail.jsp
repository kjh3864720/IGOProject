<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div>	
		${qnaVO.title}
	</div>
	<div>	
		${qnaVO.memberVO.name}
	</div>
	<div>	
		${qnaVO.regDate}
	</div>
	<div>	
		${qnaVO.content}
	</div>
	
	<div>
		<a href="<c:url value="/qna"/>">목록</a>
		<a href="<c:url value="/qna/modify/${qnaVO.qnaId}"/>">수정</a>
	</div>
	
</body>
</html>