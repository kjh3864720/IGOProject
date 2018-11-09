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
	
	
	<c:url var="qnaResist"  value="/qna/regist" />
	<form method="post" action="${qnaResist}">
		<div>
			<input type="text" id="qnaTitle" name="title" placeholder="제목을 입력하세요."/>
		</div>
		<div>
			<textarea id="qnaContent" name="content" placeholder="내용을 입력하세요."></textarea>
		</div>
		<div>
			<input type="submit" id="qnaBtn" value="등록" />
		</div>
	</form>

</body>
</html>