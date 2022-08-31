<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
​

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
<script src="https://kit.fontawesome.com/8bcf872b48.js" crossorigin="anonymous"></script>
<style type="text/css">
.photo_contents {
	height: 500px;
	overflow: scroll;
}

.photo_contents {
	overflow: auto;
	position: absolute;
	top: 5px;
	bottom: 5px;
	left: 5px;
	right: 5px;
	color: black;
	font-family: 'Nanum Gothic', sans-serif;
}

.photonumber {
	margin: 10px;
	height: 35px;
	font-size: 14px;
	font-weight: 700;
	line-height: 35px;
	background-color: #BBDEFB;
}

.photoregdate {
	font-size: 10px;
	color: steelblue;
}

.photo {
	width: 460px;
	margin-left: 40px;
	border-radius: 7px;
}

.photo_content {
	margin-top: 10px;
	margin-bottom: 30px;
	margin-left: 35px;
	font-size: 14px;
}

#delete {
	margin: 6px 0px 0px 0px;
}
#comment {
 
 width: 500px;
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
						<!-- 여기부터 고쳐요,. -->
						<div class="home_contents">
							<div class="photo_contents">
								<!-- 사진을 등록하는 페이지로 이동하는 버튼 -->
								<c:if test="${photoPage.hasNoPhoto()}">
								<p>게시글이 없습니다. 등록부탁드립니다.</p>
								</c:if>
								<input type="button" style="float: right;" value="등록하기"
									onclick="location.href='../photo/write.do'">
								<c:forEach var="photo" items="${photoPage.content}">
									<!-- 등록된 사진을 출력 -->
									<div class="photonumber">
										&emsp;&nbsp;${photo.number} <span class="photoregdate">${photo.regDate}</span>
									</div>
									<form action="../photo/photoDelete.do" method="post">
										<input type="hidden" name="number" value="${photo.number}">
										<input id="delete" type="submit" value="삭제"
											style="float: left;">
									</form>
									<form action="../photo/photoupdate.do" method="post">
										<input type="hidden" name="title" value="${photo.title}">
										<input type="hidden" name="content" value="${photo.content}">
										<input type="hidden" name="number" value="${photo.number}">
										<input type="hidden" name="url" value="${photo.url}">
										<input type="submit" value="수정" style="float: left;">
									</form>

									<c:choose>
										<c:when test="${empty photo.url}">
											<img src="../upload/noimage.gif">
										</c:when>
										<c:otherwise>
											<img src="../image/${photo.url}"
												style="width: 350px; height: 350px;">
										</c:otherwise>
									</c:choose>

									<div class="photo_content">${photo.content}</div>
									
									<div class="commentarea">
									<c:forEach var="photocomment" items="${photocomment}">
									<c:set var="photo_num" value="${photo.number}"></c:set>
									<form action="../reply/comment.do" method="post">
									 <textarea rows="4" cols="60" id="comment" placeholder="댓글을 작성하세요"></textarea>
									 <br />
									 <button type="button" id="commentbtn">작성</button>
									 </c:forEach>
									 </form>
									</div>
								</c:forEach>
								<!-- 페이지 -->
								<c:if test="${photoPage.startPage > 5}">
									<a href="list.do?pageNo=${photoPage.startPage -5}">[이전]</a>
								</c:if>
								<c:forEach var="pNo" begin="${photoPage.startPage}"
									end="${photoPage.endPage }">
									<a href="list.do?pageNo=${pNo}">[${pNo}]</a>
								</c:forEach>
								<c:if test="${photoPage.endPage < photoPage.totalPages }">
									<a href="list.do?pageNo=${photoPage.startPage + 5}">[다음]</a>
								</c:if>
							</div>

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
<script type="text/javascript"></script>
</html>