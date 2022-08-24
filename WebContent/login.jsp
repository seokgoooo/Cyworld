<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<head>
<meta charset="UTF-8">
<title>로그인</title>

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<link rel="canonical"
	href="https://getbootstrap.kr/docs/5.1/examples/sign-in/">
<!-- Bootstrap core CSS -->
<link href="/docs/5.1/dist/css/bootstrap.min.css" rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<!-- Favicons -->
<meta name="theme-color" content="#7952b3">

<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}
</style>

<!-- Custom styles for this template -->
<link href="signin.css" rel="stylesheet">
</head>

<body class="text-center">
	<main class="form-signin">
		<form action="login.do" method="post">
			<img class="mb-4" src="./image/logo.jpg" alt="" width="300"
				height="300">

			<c:if test="${ errors.idOrPwNotMatch }">아이디와 암호가 일치하지 않습니다.</c:if>

			<div class="form-floating">
				<input type="text" class="form-control" id="floatingId"
					placeholder="ID" width="300" height="300" name="id"> <label
					for="floatingId">아이디</label>
			</div>

			<div class="form-floating">
				<input type="password" class="form-control" id="floatingPassword"
					placeholder="Password" name="password"> <label
					for="floatingPassword">비밀번호</label>
			</div>

			<c:if test="${ errors.id }">
				<span class="help-block"> 아이디를 입력하세요. </span>
			</c:if>

			<c:if test="${ errors.password }">비밀번호를 입력하세요.</c:if>

			<!-- 자동로그인 체크 -->
			<div class="checkbox mb-3">
				<label> <input type="checkbox" value="remember-me">
					자동 로그인
				</label>
			</div>

			<button class="w-10 btn btn-lg btn-primary" type="submit">로그인</button>
		</form>

		<form action="./joinForm.jsp" method="post">
			<button class="w-10 btn btn-lg btn-secondary" type="submit">
				회원가입</button>
		</form>

		<iframe src="./joinForm.jsp" width="500" height="500"> </iframe>

		<p class="mt-5 mb-3 text-muted">&copy; 2017–2022</p>
	</main>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
		integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
		integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
		crossorigin="anonymous"></script>
</body>
</html>