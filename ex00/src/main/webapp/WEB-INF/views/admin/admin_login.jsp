<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 로그인 페이지</title>
<script src="./resources/js/jquery.js"></script>
<%-- jQuery라이브러리 읽어오기 --%>
<link rel="stylesheet" type="text/css" href="./resources/css/admin.css" />
<%--css파일 읽어오기 --%>
<script>
function admin_check(){
	//javascript function 예약어로 admin_check()함수 정의
	if($.trim($('#admin_id').val())==""){
		/*
		1. $는 jquery란 뜻이고 trim() jQuery함수는 양쪽 공백을 제거해서 빈공백값이 서버로 전달되는것을 막는다.
		2. val() jQuery함수는 입력박스 입력값을 가져옴. 
		*/
		alert('관리자 아이디를 입력하세요!'); //alert()자바스크립트 내장함수로서 경고메시지를 띄운다.
		$("#admin_id").val("").focus(); //val("") jQuery함수는 입력필드(박스) 값을 초기화. focus()는 자바스크립트 메서드로서 입력박스로 포커스를 이동시킴.
		return false;
	}
	
	$admin_pwd=$.trim($('#admin_pwd').val());//$.trim = 양쪽 공백을 제거
	if($admin_pwd.length == 0){//length속성으로 문자열 길이
		window.alert('관리자 비번을 입력하세요!');//window.은 생략가능
		$("#admin_pwd").val('');//비번 입력박스 초기화
		$("#admin_pwd").focus();//비번 입력박스로 포커스 이동		
		return false;
	}
	
}
</script>

</head>
<body>
	<div id="aLogin_wrap">
		<%--div는 레이아웃을 그릴때 사용한다. 이 태그는 가로줄 전체를 차지하는 블록요소 태그이다 --%>
		<h2 class="aLogin_title">관리자 로그인</h2>
		<%-- h1태그가 글자크기가 가장 크고, h6태그가 글자크기가 가장 작다. --%>
		<form method="post" action="admin_login_ok"
			onsubmit="return admin_check();">
			<table id="aLogin_t">
				<%--table은 표를 만든다. --%>
				<tr>
					<th>관리자 아이디</th>
					<td><input name="admin_id" id="admin_id" size="14" tabindex="1"/><%--id값은 jQuery에서 사용된다--%>
					<%-- type속성을 생략하면 기본값이 text이다. tabindex속성은 탭키를 눌렀을때 첫번째로 포커스(입력대기 깜빡임)를 가진다 --%>
					</td>
					<th rowspan="2"><%--rowspan속성은 행을 합침. 2개행을 합침. --%>
					<input type="submit" value="로그인"/>
					</th>
				</tr>
				<tr>
				<th>관리자 비밀번호</th> <%--th는 열을 만들고 글자를 중앙정렬 시키며 굵기를 진하게한다. --%>
				<td>
				<input type="password" name="admin_pwd" id="admin_pwd" size="14" tabindex="2"/>
				<%--tabindex속성을 2로하면 탭키를 눌렀을 때 2번째로 포커스를 가짐. --%>
				</td>
				</tr>
				
			</table>
		</form>
	</div>

</body>
</html>