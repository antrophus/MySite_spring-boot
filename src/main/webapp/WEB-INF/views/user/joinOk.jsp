<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MySite-가입성공</title>
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
					<div id="joinOk">

						<p class="text-large bold">
							회원가입을 축하합니다.<br> <br> <a href="${pageContext.request.contextPath}/user/loginform">[로그인하기]</a>
						</p>

					</div>
					<!-- //joinOK -->
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