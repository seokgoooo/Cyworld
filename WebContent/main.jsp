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
<title>${ authUser.title }</title>

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/font.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/layout.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/home.css" />
</head>
<body>
	<div class="bookcover">
		<div class="bookdot">
			<div class="page">
				<div class="home">
					<div class="upside">
						<br> <strong><span style="color: coral;"></span></strong>
						&emsp;&emsp;&emsp; &emsp; <span class="title">${ authUser.title }</span>
						&emsp;&emsp;&emsp;&emsp;&emsp;&emsp; <a href="edit.jsp"> <span
							class="updated_news_blue" style="float: right">&nbsp;EDIT&nbsp;</span></a>
					</div>


					<div class="home_main">
						<div class="profile">
							<div class="profile_1">
								<!-- 회원가입할때 등록한 사진을 출력 -->
								<img class="profile_image" src="${authUser.img}" />

								<!-- <a href="#"> <span class="updated_news_blue"
									style="float: right">&nbsp;EDIT&nbsp;</span></a> -->
							</div>

							<div class="profile_2">
								<p>${ authUser.profile }</p>
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
							<div class="updated_news_title">
								<br> <strong>Updated news</strong>
							</div>

							<div class="updated_news_contents">
								<div class="updated_news_left">
									<!-- 사진첩에서 가장 최근에 등록된 글을 띄어줌 -->
									<span class="updated_news_left1"> <!-- 사진첩 페이지로 이동하는 태그 -->
										<a href="../photo/photo.do"> <span
											class="updated_news_blue">&nbsp;사진첩&nbsp;</span> ${photo }
									</a>
									</span>
									<!-- 방명록에서 가장 최근에 등록된 글을 띄어줌 -->
									<span class="updated_news_left2"> <!-- 방명록 페이지로 이동하는 태그 -->
										<a href="../visit/visit.do"> <span
											class="updated_news_red">&nbsp;방명록&nbsp;</span> ${visit }
									</a>
									</span>
								</div>

								<div class="updated_news_right">
									<!-- 사진첨의 총 개수를 출력 -->
									<div class="updated_news_right1">
										사진첩 <span class="updated_news_right_number">${pcount} 개</span>
									</div>
									<!-- 방명록의 총 개수를 출력 -->
									<div class="updated_news_right2">
										방명록 <span class="updated_news_right_number">${vcount }
											개</span>
									</div>
									<div class="updated_news_right2"></div>
								</div>
							</div>

							<div class="miniroom_title">
								<br> <strong>Miniroom</strong>
							</div>

							<div class="miniroom_contents">
								<!-- 자신의 미니홈페이지 사진을 띄움 -->
								<img class="miniroom_gif" src="../photo/cyworld_Home2.png">
							</div>

						</div>
					</div>
				</div>

				<div class="menu_bar">
					<!-- 홈페이지로 이동 -->
					<a href="#" class="menu_button1">&nbsp;&nbsp;홈</a>
					<!-- 사진첩 페이지로 이동 -->
					<a href="<%=request.getContextPath()%>/photo/list.do"
						class="menu_button2">&nbsp;&nbsp;사진첩</a>
					<!-- 방명록 페이지로 이동 -->
					<a href="<%=request.getContextPath()%>/visitor/list.do"
						class="menu_button3">&nbsp;&nbsp;방명록</a>
					<!-- 관리 페이지로 이동 -->
					<a href="<%=request.getContextPath()%>/setting.do"
						class="menu_button4">&nbsp;&nbsp;관리페이지</a>
				</div>
			</div>
		</div>
	</div>







</body>
</html>