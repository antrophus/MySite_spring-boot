<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MySite-회원가입</title>
<link href="${pageContext.request.contextPath}/assets/css/mysite.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/assets/css/user.css" rel="stylesheet" type="text/css">


</head>

<body>
	<div id="wrap">

		<c:import url="/WEB-INF/views/include/header.jsp"></c:import>

		<div id="container" class="clearfix">
			<div id="aside">
				<h2>회원</h2>
				<ul>
					<li><a href="${pageContext.request.contextPath}/user/modifyform">회원정보</a></li>
					<li><a href="${pageContext.request.contextPath}/user/loginform">로그인</a></li>
					<li><a href="${pageContext.request.contextPath}/user/joinform">회원가입</a></li>
				</ul>
			</div>
			<!-- //aside -->

			<div id="content">

				<div id="content-head">
					<h3>회원가입</h3>
					<div id="location">
						<ul>
							<li><a href="${pageContext.request.contextPath}/main">홈</a></li>
							<li><a href="${pageContext.request.contextPath}/user/loginform">회원</a></li>
							<li class="last"><a href="${pageContext.request.contextPath}/user/joinform">회원가입</a></li>
						</ul>
					</div>
					<div class="clear"></div>
				</div>
				<!-- //content-head -->

				<div id="user">
					<div id="joinForm">
						<form action="${pageContext.request.contextPath}/user/join" method="get">

							<!-- 아이디 -->
							<div class="form-group">
								<label class="form-text" for="input-uid">아이디</label> 
								<input type="text" id="input-uid" name="id" required value="" placeholder="아이디를 입력하세요">
								<button type="button" id="">중복체크</button>
							</div>

							<!-- 비밀번호 -->
							<div class="form-group">
								<label class="form-text" for="input-pass">패스워드</label> 
								<input type="text" id="input-pass" name="password" required value="" placeholder="비밀번호를 입력하세요">
							</div>

							<!-- 이메일 -->
							<div class="form-group">
								<label class="form-text" for="input-name">이름</label> 
								<input type="text" id="input-name" name="name" required value="" placeholder="이름을 입력하세요">
							</div>

							<!-- //나이 -->
							<div class="form-group">
								<span class="form-text">성별</span> 
								<label for="rdo-male">남</label> 
								<input type="radio" id="rdo-male" name="gender" value="남"> 
								<label for="rdo-female">여</label>
								<input type="radio" id="rdo-female" name="gender" value="여">

							</div>

							<!-- 약관동의 -->
							<div class="form-group">
								<span class="form-text">약관동의</span> 
								<input type="checkbox" id="chk-agree" value="" required name=""> 
								<label for="chk-agree">서비스 약관에 동의합니다.</label>
							</div>

							<!-- 버튼영역 -->
							<div class="button-area">
								<button type="submit" id="btn-submit">회원가입</button>
							</div>

						</form>
					</div>
					<!-- //joinForm -->
				</div>
				<!-- //user -->
			</div>
			<!-- //content  -->
		</div>
		<!-- //container  -->

		<!-- footer -->
		<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
		<!-- //footer -->

	</div>
	<!-- //wrap -->

</body>

</html>