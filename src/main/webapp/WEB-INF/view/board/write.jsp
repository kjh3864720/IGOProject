<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">

   <link rel="stylesheet" href="/TeamProject/css/styles.css">
   <link rel="stylesheet" type="text/css" href="/TeamProject/css/layout.css" />
   <link rel="stylesheet" href="/TeamProject/bootstrap/css/bootstrap.css">
   <link rel="stylesheet" href="/TeamProject/css/bootstrap.min.css">

   <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
   <script src="/TeamProject/js/script.js"></script>
   <script src="/TeamProject/bootstrap/js/bootstrap.js"></script>
   <script type="text/javascript">
   
	<!--<link rel="stylesheet" href="css/font-awesome.min.css" media="screen" title="no title" charset="utf-8">
	<link rel="stylesheet" href="css/style.css" media="screen" title="no title" charset="utf-8">  -->   
    $('.dropdown-toggle').dropdown();
    $('.dropdown-menu').find('form').click(function (e) {
        e.stopPropagation();
      });
	</script>
<title>Insert title here</title>

<style>	
	
#wrapper {	
	height: 320px;
	margin-top: 200px;	
}	

#navbar {
 	margin-left: 1220px;
}
	
</style>

</head>
<body>
<center>
	<form:form  modelAttribute="boardVO" method="post" action="/TeamProject/board/write" enctype="multipart/form-data">
		<!-- <div class="errors">
			<ul>
				<li><form:errors path="subject" /></li>
				<li><form:errors path="content" /></li>			
			</ul>
		</div> -->	
			
		<div>
			<input type="text" name="subject" required="required" placeholder="제목을 입력하세요." value="${boardVO.subject }" />
		</div>
		<div>
			<textarea name="content" rows="5" cols="30" required="required" placeholder="내용을 입력하세요." >${boardVO.content }</textarea>
		</div>
		<div>
			<input type="file" name="file" placeholder="파일을 선택하세요." />
		</div>
<%-- 		<div>
			<input type="email" name="email" placeholder="이메일을 입력하세요" value="${sessionScope._USER_.email }"/>
		</div> --%>
		<div>
			<input type="submit" value="등록" />
			<a href="/TeamProject/board/list">목록</a>
		</div>
	</form:form>
</center>

<nav class="navbar navbar-inverse navbar-fixed-top">
<div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>

<div id="navbar" class="collapse navbar-collapse">
      <ul class="nav navbar-nav">
      <li ><a href="#"><span style="font-size:16px;" class="pull-right hidden-xs showopacity glyphicon glyphicon-th-list"></span></a></li>
</ul>    
</div> 
</div>
</div>
</nav>
	
</body>
</html>