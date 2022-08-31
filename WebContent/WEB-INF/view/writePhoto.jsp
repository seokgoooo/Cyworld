<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${ empty authUser }">
	<jsp:forward page='login.do' />
</c:if>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<title>${ authUser.name }님의미니홈피입니다.</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/font.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/layout.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/home.css" />

<style>
textarea {
    width: 100%;
    height: 6.25em;
    resize: none;
  }
</style>
</head>
<body>
	<div class="bookcover">
		<div class="bookdot">
			<div class="page">
				<div class="home">
					<div class="upside">

						<br> <strong><span style="color: coral;"></span></strong>
						&emsp;&emsp;&emsp; &emsp; <span class="title">${ authUser.name }님의
							미니홈피입니다.</span> &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
					</div>

					<div class="home_main">
						<div class="profile">
							<div class="profile_1">
								<!-- 회원가입할때 등록한 사진을 출력 -->
								<c:if test="${ empty authUser.img }">
									<img class="profile_image" src="./image/m.jpg" />
								</c:if>

								<img class="profile_image" src="../upload/${authUser.img}" />
							</div>

							<div class="profile_3">
								<div class="profile-dropdown">
									<div class="dropdown-btn">
										<div class="dropdown-title">Related Link</div>
										<div class="triangle-down"></div>
									</div>

									<div class="dropdown-content">
										<a href="#" target="_blank">Devlog</a> <a
											href="https://github.com/" target="_blank">Github</a>
										<!-- 깃허브로 이동하는 태그 -->
										<a href="https://www.instagram.com/" target="_blank">Instagram</a>
										<!-- 인스타그램으로 이동하는 태그 -->
									</div>
								</div>
							</div>
						</div>

						<div class="home_contents">
							<form action="/CyworldProject/photo/write.do" name="myform" enctype="multipart/form-data" method="POST" >
								<table>
									<tr>
										<th style="color: black;">타이틀</th>
										<!-- 사진 제목을 입력하는 텍스트창 -->
										<td><input type="text" name="title" size="60"></td>
									</tr>
									<tr>
										<th style="color: black;">설 명</th>
										<!-- 사진에 대한 설명을 입력하는 텍스트창 -->
										<td><textarea cols="60" rows="10" name="content"></textarea></td>
									</tr>
									<tr>
										<th style="color: black;">사 진</th>
										<!-- 사진을 선택하는 버튼 -->
										<td><input type="file" name="url"><br></td>
									</tr>
								</table>
								<input type = "submit" style = "float: right;"value = "등록하기"><!-- form데이터에 입력된 정보를 등록하는 버튼 -->
							</form>
						</div>
					</div>
				</div>

				<div class="menu_bar">
					<!-- 홈페이지로 이동 -->
					<a href="#" class="menu_button1">&nbsp;&nbsp;홈</a>
					<!-- 사진첩 페이지로 이동 -->
					<a href="<%=request.getContextPath()%>/photo/list.do"
						class="menu_button3">&nbsp;&nbsp;사진첩</a>
					<!-- 방명록 페이지로 이동 -->
					<a href="<%=request.getContextPath()%>/visitor/list.do"
						class="menu_button4">&nbsp;&nbsp;방명록</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>