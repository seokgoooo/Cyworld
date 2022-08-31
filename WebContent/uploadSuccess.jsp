<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>업로드 성공</title>
</head>
<body>
	업로드를 성공했습니다.
	<p>${ param.content }</p>
	<p>${ newPhotoNo }</p>
	<br> ${ctxPath = pageContext.request.contextPath ;''}
	<a href="${ctxPath}/photo/list.do"> 게시글 보기 </a>
	<a href="${ctxPath}/photo/read.do?no=${newPhotoNo}">[게시글 내용보기]</a>
</body>
</html>