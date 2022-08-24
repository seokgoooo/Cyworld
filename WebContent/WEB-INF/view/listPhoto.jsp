<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<td>제목</td>
<td>작성자</td>
<td>조회수</td>
<td>작성시간</td>
<td>수정시간</td>

</tr>

<c:if test="${photoPage.hasNoPhoto()}">
<tr>
<td colspan="4">게시글이 없습니다.</td>
</tr>
</c:if>

<c:forEach var="photo" items="${photoPage.content}">
<tr>
<td>${photo.photoNum}</td>
<td>
<a href="read.do?no=${photo.photoNum}&pageNo=${photoPage.currentPage}">
<c:out value="${photo.title}"/>
</a>
</td>
<td>${photo.photoNum }</td>
<td>${photo.title}</td>
<td>${photo.userId}</td>
<td>${photo.regDate}</td>
<td>${photo.modDate}</td>
<td>${photo.readCount}</td>

</tr>
</c:forEach>

<c:if test="${photoPage.hasPhoto()}">

<tr>
<td colspan="4">
<c:if test="${photoPage.startPage > 5}">
<a href="list.do?pageNo=${photoPage.startPage -5}">[이전]</a>
</c:if>
<c:forEach var="pNo" 
begin="${photoPage.startPage}"
end="${photoPage.endPage }">
<a href="list.do?pageNo=${pNo}">[${pNo}]</a>
</c:forEach>
<c:if test="${photoPage.endPage < photoPage.totalPages }">
<a href="list.do?pageNo=${photoPage.startPage + 5}">[다음]</a>
</c:if>
</td>
</tr>

</c:if>





</table>

</body>
</html>