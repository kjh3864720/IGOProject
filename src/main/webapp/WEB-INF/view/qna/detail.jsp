<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	
</body>
</html>