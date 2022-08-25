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
	${ param.content }
	<br> ${ctxPath = pageContext.request.contextPath ;''}
	<a href="${ctxPath}/Photo/list.do"> 게시글 보기 </a>
	<a href="${ctxPath}/Photo/read.do?no=${newArticleNo}">[게시글 내용보기]</a>
</body>
</html>