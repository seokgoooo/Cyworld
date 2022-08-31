<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 읽기</title>
</head>
<body>
	<table border="1" width="100%">
		<tr>
			<td>번호</td>
			<td>${contentData.photo.photo_num}</td>
		</tr>

		<tr>
			<td>작성자</td>
			<td>${contentData.photo.user_id}</td>
		</tr>

		<tr>
			<td>제목</td>
			<td><c:out value="${contentData.photo.photo_title}" /></td>
		</tr>

		<tr>
			<td>내용</td>
			<td><u:pre value="${contentData.content}" /></td>
		</tr>








	</table>

</body>
</html>