<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>
</head>
<body>
<table border="1">
	<tr>
		<td colspan="4"><a href="write.do">[게시글쓰기]</a></td>
	</tr>
	<tr>
		<td>번호</td>
		<td>작성자</td>
		<td>방명록</td>
	</tr>
	<c:if test="${ visitorPage.hasNoVisitor() }">
		<tr>
			<td colspan="4">게시글이 없습니다.</td>
		</tr>
	</c:if>
	<c:forEach var="visitor" items="${ visitorPage.content }">
		<tr>
			<td>${ visitor.content_num }</td>
			<td> 
				<a href="read.do?no=${ visitor.content_num }&pageNo=${ visitorPage.currentPage }">
					<c:out value="${ visitor.content }"/>
				</a>
			</td>
			<td>${ visitor.content_num }</td>
			<td>${ visitor.user_id }</td>
			<td>${ visitor.content }</td>
		</tr>
	</c:forEach>
	<c:if test="${ visitorPage.hasVisitor() }">
		<tr> 
			<td colspan="4"> 
				<c:if test="${ visitorPage.startPage > 5 }">
					<a href="list.do?pageNo=${ visitorPage.startPage - 5 }">[이전]</a>
				</c:if>
				<c:forEach var="pNo" begin="${ visitorPage.startPage }" end="${ visitorPage.endPage }">
					<a href="list.do?pageNo=${ pNo }">[${ pNo }]</a>
				</c:forEach>
				<c:if test="${ visitorPage.endPage < visitorPage.totalPages }"> 
					<a href="list.do?pageNo=${ visitorPage.startPage + 5 }">[다음]</a>
				</c:if>
			</td>
		</tr>
	</c:if>
</table>
</body>
</html>