<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<style>
body {
	min-height: 100vh;
	background: -webkit-gradient(linear, left bottom, right top, from(#92b5db),
		to(#1d466c));
	background: -webkit-linear-gradient(bottom left, #92b5db 0%, #1d466c 100%);
	background: -moz-linear-gradient(bottom left, #92b5db 0%, #1d466c 100%);
	background: -o-linear-gradient(bottom left, #92b5db 0%, #1d466c 100%);
	background: linear-gradient(to top right, #92b5db 0%, #1d466c 100%);
}

.input-form {
	max-width: 680px;
	margin-top: 80px;
	padding: 32px;
	background: #fff;
	-webkit-border-radius: 10px;
	-moz-border-radius: 10px;
	border-radius: 10px;
	-webkit-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
	-moz-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
	box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15)
}
</style>
</head>

<body>
	<div class="container">
		<div class="input-form-backgroud row">
			<div class="input-form col-md-12 mx-auto">
				<h4 class="mb-3">회원가입</h4>
				<form class="validation-form" novalidate action="join.do"
					method="post">
					<div class="row">
						<div class="col-md-6 mb-3">
							<label for="name">이름</label> <input type="text"
								class="form-control" id="name" placeholder="" value="" required>
							<div class="invalid-feedback">이름을 입력해주세요.</div>
						</div>
					</div>

					<div class="mb-3">
						<label for="id">아이디</label> <input type="text"
							class="form-control" id="id" placeholder="아이디" name="id" required>
						<div class="invalid-feedback">아이디를 입력해주세요.</div>
					</div>

					<div class="mb-3">
						<label for="password">비밀번호</label> <input type="password"
							class="form-control" id="password" placeholder="" name="password"
							required>
						<div class="invalid-feedback">비밀번호를 입력해주세요.</div>
					</div>

					<div class="mb-3">
						<label for="confirmPassword">비밀번호 확인</label> <input
							type="password" class="form-control" id="confirmPassword"
							placeholder="" required>
						<div class="invalid-feedback">비밀번호를 한번 더 입력해주세요.</div>
					</div>

					<div class="mb-3">
						<label for="name">이름</label> <input type="text"
							class="form-control" id="name" placeholder="홍길동" name="name"
							required>
						<div class="invalid-feedback">이름을 입력해주세요.</div>
					</div>

					<div class="row">
						<div class="col-md-8 mb-3">
							<p>성별</p>
							<div class="btn-group btn-group-toggle" data-toggle="buttons">
								<label class="btn btn-primary">
								<input type="radio" name="jb-radio" id="jb-radio-1" value="M"> 남성
								</label>
								 <label class="btn btn-primary">
								 <input type="radio" name="jb-radio" id="jb-radio-2" value="W"> 여성
								</label>
							</div>
							<!-- <div class="invalid-feedback">성별을 선택해주세요.</div> -->
						</div>

						<div class="col-md-4 mb-3">
							<label for="code">추천인 코드</label> <input type="text"
								class="form-control" id="code" placeholder="" required>
							<div class="invalid-feedback">추천인 코드를 입력해주세요.</div>
						</div>
					</div>

					<hr class="mb-4">

					<div class="mb-4"></div>

					<button class="btn btn-primary btn-lg btn-block" type="submit">회원
						가입</button>
				</form>
			</div>
		</div>

		<footer class="my-3 text-center text-small">
			<p class="mb-1">&copy; 2022</p>
		</footer>

	</div>
	<script>
    window.addEventListener('load', () => {
      const forms = document.getElementsByClassName('validation-form');

      Array.prototype.filter.call(forms, (form) => {
        form.addEventListener('submit', function (event) {
          if (form.checkValidity() === false) {
            event.preventDefault();
            event.stopPropagation();
          }

          form.classList.add('was-validated');
        }, false);
      });
    }, false);
	</script>

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>