<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="${pageContext.request.contextPath}/assets/css/mysite.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/assets/css/guestbook.css" rel="stylesheet" type="text/css">
<!-- Axios 라이브러리 포함 -->
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>

</head>

<body>
	<div id="wrap">

		<c:import url="/WEB-INF/views/include/header.jsp"></c:import>

		<div id="container" class="clearfix">
			<div id="aside">
				<h2>방명록</h2>
				<ul>
					<li><a href="${pageContext.request.contextPath}/guestbook/addlist">일반방명록</a></li>
					<li>ajax방명록</li>
				</ul>
			</div>
			<!-- //aside -->

			<div id="content">

				<div id="content-head" class="clearfix">
					<h3>ajax방명록</h3>
					<div id="location">
						<ul>
							<li>홈</li>
							<li>방명록</li>
							<li class="last">ajax방명록</li>
						</ul>
					</div>
				</div>
				<!-- //content-head -->

				<div id="guestbook">
					<form id="guestbookForm" action="${pageContext.request.contextPath}/api/guestbook/write" method="">
						<table id="guestAdd">
							<colgroup>
								<col style="width: 70px;">
								<col>
								<col style="width: 70px;">
								<col>
							</colgroup>
							<tbody>
								<tr>
									<th><label class="form-text" for="input-uname">이름</label></th>
									<td><input id="input-uname" type="text" name="name" value=""></td>
									<th><label class="form-text" for="input-pass">패스워드</label></th>
									<td><input id="input-pass" type="password" name="pass" value=""></td>
								</tr>
								<tr>
									<td colspan="4"><textarea name="content" cols="72" rows="5" value=""></textarea></td>
								</tr>
								<tr class="button-area">
									<td colspan="4" class="text-center"><button type="submit">등록</button></td>
								</tr>
							</tbody>

						</table>
						<!-- //guestWrite -->
						<input type="hidden" name="action" value="add">

					</form>
					
					<!-- guestRead -->
					<div id="guestbookListArea">
												
					</div>
					<!-- //guestRead -->

				</div>
				<!-- //guestbook -->

			</div>
			<!-- //content  -->
		</div>
		<!-- //container  -->

		<!-- footer -->
		<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
		<!-- //footer -->
	</div>
	<!-- //wrap -->
<script>
//DOM Tree 완료 후
document.addEventListener('DOMContentLoaded', function(){
	console.log("DOM tree 완료");
	
	//서버로 데이터 요청
    axios({
        method: 'get',           // put, post, delete                   
        url: '${pageContext.request.contextPath}/api/guestbook/list',
        headers: {"Content-Type" : "application/json; charset=utf-8"}, //전송타입
        /* params: guestbookVo,  //get방식 파라미터로 값이 전달
        data: guestbookVo,   //put, post, delete 방식 자동으로 JSON으로 변환 전달 */
    
        responseType: 'json' //수신타입
    }).then(function (response) {
       // console.log(response); //수신데이타
       // console.log(response.data); //수신데이타만

       for(let i=0; i<response.data.length; i++){
       		//console.log(response.data[i].name);
       		let guestVo = response.data[i];
       		
       		render(guestVo);
        }

    }).catch(function (error) {
        console.log(error);
    
    });
	// 버튼태그가 아니라 form을 가져와야 한다.
    let guestbookForm = document.querySelector('#guestbookForm');
    
  	//전송버튼(form, submit) 클릭했을때
	guestbookForm.addEventListener('submit', function(){
		event.preventDefault();
		console.log('전송 submit 눌렀음');
		
		//form의 데이터 수집( 이름, 패스워드, 본문 )
		let name = document.querySelector('#input-uname').value;
		let password = document.querySelector('#input-pass').value;
		let content = document.querySelector('[name="content"]').value;
/* 		console.log(name);
		console.log(pass);
		console.log(content); */
		
		//묶어보자 데이타
		let guestbookVo = {
			name: name,
			password: password,
			content: content
		};
		console.log(guestbookVo);
		
		//전송
	    axios({
	        method: 'get',           // put, post, delete                   
	        url: '${pageContext.request.contextPath}/api/guestbook/write', //주소창에 파라미터 기입식으로 줄줄 써도 됨.
	        headers: {"Content-Type" : "application/json; charset=utf-8"}, //전송타입
	        params: guestbookVo,  //get방식 파라미터로 값이 전달
	        // data: guestbookVo,   //put, post, delete 방식 자동으로 JSON으로 변환 전달 
	    
	        responseType: 'json' //수신타입
	    }).then(function (response) {
	       // console.log(response); //수신데이타

	    }).catch(function (error) {
	        console.log(error);
	    
	    });
		
	});
	
});

//그림 그리는 render함수(이름은 임의로 지어도 됨)
function render(guestvo){
	//태그 가져오기
	 let listArea = document.querySelector('#guestbookListArea');

let str = '';
str += '<table class="guestRead">';
str += '	<colgroup>';
str += '		<col style="width: 10%;">';
str += '		<col style="width: 40%;">';
str += '		<col style="width: 40%;">';
str += '		<col style="width: 10%;">';
str += '	</colgroup>';
str += '	<tr>';
str += '		<td>' + guestvo.no + '</td>';
str += '		<td>' + guestvo.name + '</td>';
str += '		<td>' + guestvo.regDate + '</td>';
str += '		<td><a href="">[삭제]</a></td>';
str += '	</tr>';
str += '	<tr>';
str += '		<td colspan=4 class="text-left">' + guestvo.content + '</td>';
str += '	</tr>';
str += '</table>';

listArea.insertAdjacentHTML('afterbegin', str);

}
</script>

</body>

</html>