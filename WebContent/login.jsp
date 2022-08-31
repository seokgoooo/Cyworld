<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta name="theme-color" content="#7952b3">
<meta charset="UTF-8">
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<link type="text/css" rel="stylesheet" href="css/bootstrap.min.css">
<title>로그인</title>
</head>
<body class="text-center">
	<main class="form-signin">
		<img class="mb-4" src="./image/logo.jpg" alt="" width="300"
			height="300">

		<form action="login.do" method="post">

			<input type="text" class="form-control" id="floatingId"
				placeholder="아이디" name="id" value="${ param.id }"
				required="required" />
			 <input type="password" class="form-control"
				id="floatingPassword" placeholder="비밀번호" name="password"
				required="required" />

			<c:if test="${ errors.idOrPwNotMatch }"> 아이디와 암호가 일치하지 않습니다.	</c:if>
			<c:if test="${ errors.id }"> 아이디를 입력하세요. </c:if>
			<c:if test="${ errors.password }">비밀번호를 입력하세요.</c:if>

			<!-- 자동로그인 체크 -->
			<div class="checkbox mb-3">
				<label> <input type="checkbox" value="remember-me">
					자동 로그인
				</label>
			</div>

			<button class="btn btn-lg btn-primary btn-inline-block" type="submit">로그인</button>
		</form>

		<a href="join.do">
			<button class="btn btn-lg btn-secondary btn-inline-block"
				type="submit">회원가입</button>
		</a>

		<p class="mt-5 mb-3 text-muted">&copy; 2022</p>
	</main>
</body>
</html>