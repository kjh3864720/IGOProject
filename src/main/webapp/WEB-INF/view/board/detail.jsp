<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${boardVO.subject } <span style="font-size: 12pt;">${boardVO.crtDt }</span></h1>
	<h3>${boardVO.memberVO.name }</h3>
	<c:if test="${not empty boardVO.originFileName }">
		<p><a href="/TeamProject/board/download/${boardVO.id }">${boardVO.originFileName }</a></p>
	</c:if>
	<div>
		${boardVO.content }
	</div>
	<div>
		<a href="/TeamProject/board/delete/${boardVO.id }">삭제</a>
		<a href="/TeamProject/board/list">목록</a>
	</div>
</body>
</html>