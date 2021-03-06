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
	
	<div>
		<span>글 번호</span>
		<span>제목</span>
		<span>작성자</span>
		<span>작성일</span>
	</div>
	
	
	<c:forEach items="${qnaList}" var="qnaVO">
		<div>
			<span>${qnaVO.rnum}</span>
			<span><a href="<c:url value='/qna/detail/${qnaVO.qnaId}'/>">${qnaVO.title}</a></span>
			<span>${qnaVO.memberVO.name}</span>
			<span>${qnaVO.regDate}</span>
		</div>
	</c:forEach>
	
	<div class="padded">
      	<form id="searchForm" onsubmit="javascript:movePage(0);">
      		${pagenation}
      		<div>
      			<input type="text" name="searchKeyword" value="${qnaSearchVO.searchKeyword}" placeholder="제목">
      			<a href="<c:url value='/qna/init'/>">검색 초기화</a>
      		</div>
      	</form>
      </div>
</body>
</html>