<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%-- <c:if test="${empty loginUser}">
	<jsp:forward page='login.do' />
</c:if> --%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<title>${ authUser.id }님의미니홈피입니다.</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/font.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/layout.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/home.css" />
<style type="text/css">
	#uploadContent {
		color:black;
		overflow:scroll; 
		height:520px; 
		padding:10px; 
	}
	.upload_content {
			width: 90%;
			height: 150px;
			padding: 10px;
            position: relative;
            left: 15px;
            top: 10px;
            background-color: #ddd;
            border: solid;
            border-color: gray white gray white;
            border-width: 3px 0px 3px 0px
	}
	
	#uploadBtn {
		position: relative;
		left: 410px;
		bottom: 25px;
		background-color: white;
		border: solid 1px gray;
		border-radius: 5px;
	}
	
	#textline {
		width: 330px;
		height: 120px;
        position: relative;
        left: 120px;
        bottom: 15px;
        box-sizing: border-box;
        border: solid 1px gray;
		border-radius: 5px;
		font-size: 13px;
		resize: none;
	}
	
	#contentlist {
		position: relative;
		top: 30px;
		margin: 30px 15px 0px 15px;
	
	}
	
	#contenttop {
		width: 100%;
		background-color: #ddd;
	}
	
	#contentdate {
		float: right;
	}
	
	#mainprofile {
		background-color:black;
		width: 150px;
		height: 150px;
	}
	
	#maincontent {
		width: 357px;
		height: 150px;
		background-color: gray;
		overflow:auto; 
		scrollbar-width: none;
		display: flex;
		align-items: center;
	}
	
	#contentdiv {
		display: flex;
	}
	
	#page {
		scrollbar-width: none;
		margin: 30px 0px 0px 210px;
	}
	
	#commentdiv {
		margin: 30px 15px 0px 15px;
		background-color: #ddd;
	}
	
	#commentid {
		margin: 0px 0px 0px 10px;
	}
	
	#maincomment {
		margin: 0px 0px 0px 10px;
	}
	
	#commentdate {
		float: right;
	}
	
	#contentnum {
		margin: 0px 0px 0px 10px;
	}
	
	.upload_comment {
		background-color: #ddd;
		margin: 30px 15px 0px 15px;
		height: 70px;
		
	}
	
	#uploadBtn2 {
		position: relative;
		left: 45px;
		bottom: 10px;
		width: 50px;
		height: 50px;
		background-color: white;
		border: solid 1px gray;
		border-radius: 5px;
	}
	
	#comment {
		position: relative;
		left: 20px;
		top: 10px;
        box-sizing: border-box;
        border: solid 1px gray;
		border-radius: 5px;
		font-size: 13px;
		resize: none;
	}
	
	#content_num {
		display: none;
	}
	
	#commentdiv {
		position: relative;
		background-color: #ddd;
		height: 100px;
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
						&emsp;&emsp;&emsp; &emsp; <span class="title">${ authUser.id }님의
							미니홈피입니다.</span> &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
					</div>

					<div class="home_main">

						<div class="profile">

							<div class="profile_1">

								<%-- <!-- 회원가입할때 등록한 사진을 출력 -->
								<img class="profile_image" src="../upload/${authUser.photoUrl}" />
 --%>
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

						<div id="uploadContent" class="home_contents">

							<div class="updated_news_title">

								<br> <strong>방명록</strong>

							</div>
							
					
							
							
							<div class="upload_content">
								<form action="write.do" method="post">
									<p>
										<textarea id="textline" name="content" rows="5" cols="30"  onclick="this.value='';">${ param.content }</textarea>
									</p>
									<input id="uploadBtn" type="submit" value="확인"/>
								</form>
							</div>
							
						
								
							
							
								<c:if test="${ visitorPage.hasNoVisitor() }">
										<div>게시글이 없습니다.</div>
								</c:if>
								<c:forEach var="visitor" items="${ visitorPage.content }">
								  <div id="contentlist">
								  	<div id="contenttop">
										<span id="contentnum" class="content">${ visitor.content_num }</span>
										<span class="content">${ visitor.name }</span>
										<span id="contentdate" class="content">${ visitor.content_regdate }</span>
									</div>
									<div id="contentdiv">
										<div id="mainprofile"></div>
										<div id="maincontent" class="content">${ visitor.content }</div>
									</div>
								 </div>
								 <c:if test="${ visitor.owner.comment != null }">
									 <div id="commentdiv">
										 	<span id="commentid" class="comment">${ visitor.owner.name } : </span>
											<span id="maincomment" class="comment">${ visitor.owner.comment }</span>
									        <span id="commentdate" class="comment">${ visitor.owner.comment_regdate }</span> <%-- 오너 날짜 보여주는부분 --%>
									 </div>
								 </c:if>
								 <%-- 댓글 등록 부분 --%>
								 <c:if test="${ visitor.owner.comment == null }">
								 <div class="upload_comment">
									<form action="<%=request.getContextPath()%>/owner/newowner.do" method="post">
											<input id="content_num" name="content_num" value="${ visitor.content_num }"/>
											<textarea id="comment" name="comment" rows="3" cols="50"  onclick="this.value='';">${ param.comment }</textarea>
										
										<input id="uploadBtn2" type="submit" value="확인"/>
									</form>
							     </div>
								 </c:if>
								</c:forEach>
								<c:if test="${ visitorPage.hasVisitor() }">
										<div id="page">
											<c:if test="${ visitorPage.startPage > 5 }">
												<span><a href="list.do?pageNo=${ visitorPage.startPage - 5 }">[이전]</a></span>
											</c:if>
											<c:forEach var="pNo" begin="${ visitorPage.startPage }" end="${ visitorPage.endPage }">
												<span><a href="list.do?pageNo=${ pNo }">[${ pNo }]</a></span>
											</c:forEach>
											<c:if test="${ visitorPage.endPage < visitorPage.totalPages }"> 
												<span><a href="list.do?pageNo=${ visitorPage.startPage + 5 }">[다음]</a></span>
											</c:if>
										</div>
								</c:if>
							

						</div>
					</div>
				</div>

				<div class="menu_bar">
					<!-- 홈페이지로 이동 -->
					<a href="#" class="menu_button1">&nbsp;&nbsp;홈</a>
					<!-- 다이어리 페이지로 이동 -->
					<a href="<%=request.getContextPath()%>/diary/diary.do"
						class="menu_button2">&nbsp;&nbsp;다이어리</a>
					<!-- 사진첩 페이지로 이동 -->
					<a href="<%=request.getContextPath()%>/photo/photo.do"
						class="menu_button3">&nbsp;&nbsp;사진첩</a>
					<!-- 방명록 페이지로 이동 -->
					<a href="<%=request.getContextPath()%>/visitor/list.do"
						class="menu_button4">&nbsp;&nbsp;방명록</a>
				</div>

			</div>
		</div>
	</div>
</body>
<script>
	function textempty() {
	}
</script>
</html>