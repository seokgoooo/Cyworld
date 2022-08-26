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
<table border="1">
	<tr>
		<td>번호</td>
		<td>방명록</td>
		<td>작성일자</td>
	</tr>
	<c:if test="${ ownerPage.hasNoOwner() }">
		<tr>
			<td colspan="4">게시글이 없습니다.</td>
		</tr>
	</c:if>
	<c:forEach var="owner" items="${ ownerPage.comment }">
		<tr>
			<td>${ owner.comment_num }</td>
			<td>${ owner.comment }</td>
			<td>${ owner.comment_regdate }</td>
		</tr>
	</c:forEach>
	<c:if test="${ ownerPage.hasOwner() }">
		<tr> 
			<td colspan="4"> 
				<c:if test="${ ownerPage.startPage > 5 }">
					<a href="list.do?pageNo=${ ownerPage.startPage - 5 }">[이전]</a>
				</c:if>
				<c:forEach var="pNo" begin="${ ownerPage.startPage }" end="${ ownerPage.endPage }">
					<a href="list.do?pageNo=${ pNo }">[${ pNo }]</a>
				</c:forEach>
				<c:if test="${ ownerPage.endPage < ownerPage.totalPages }"> 
					<a href="list.do?pageNo=${ ownerPage.startPage + 5 }">[다음]</a>
				</c:if>
			</td>
		</tr>
	</c:if>
</table>
</body>
</html>