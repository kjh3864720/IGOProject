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
	리스트 페이지
	
	<div>
		<span>제목</span>
		<span>작성자</span>
		<span>작성일</span>
	</div>
	
	
		<c:forEach items="${qnaList}" var="qnaVO">
			<div>
				<span>${qnaVO.title}</span>
				<span>${qnaVO.memberVO.name}</span>
				<span>${qnaVO.regDate}</span>
			</div>
		</c:forEach>
</body>
</html>