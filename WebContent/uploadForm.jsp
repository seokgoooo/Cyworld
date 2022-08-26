<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사진 업로드</title>
</head>
<body>
	<form action = "./photo/upload.do" method="POST">
	
		<p>
			제목 :<br /><input type="text" name="title" value="${ param.title }">
			<c:if test="${ errors.title }"> 제목을 입력하세요. </c:if>
		</p>
		
		<p>
			내용:<br />
			<textarea name="content" rows="5" cols="30"> ${ param.content }</textarea>
		</p>
		
		<input type="submit" value="글쓰기">
		
	</form>
</body>
</html>
