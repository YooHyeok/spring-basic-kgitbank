<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 메인화면</title>
<link rel="stylesheet" type="text/css" href="./resources/css/admin.css" />
<link rel="stylesheet" type="text/css" href="./resources/css/admin_notice.css" />
<script src="./resources/js/jquery.js"></script>
<script src="./resources/js/admin_notice.js"></script>
</head>
<body>
	<div id="aMain_wrap">
	<%-- div는 레이아웃을 그릴떄 사용한다. 이 태그는 가로줄 전체를 차지하는 블록요소 태그이다 --%>
		<%--관리자 메인 상단 --%>
		<div id="aMain_header">

			<%--관리자 로고 --%>
			<div id="aMain_logo">
				<a href="admin_main"> <img
					src="./resources/images/admin/sp_search.png" /> <%-- img src="그림파일경로" 그림삽입태그 --%>
			
			</div>
				
					
			<%--관리자 상단 메뉴 --%>
			<div id="aMain_menu">
				<ul>
					<%--메뉴구성은 ul li태그로 한다. --%>
					<li><a href="admin_notice_write">공지사항</a></li>
					<%-- 하이퍼링크를 걸때 href="#"로 주면 이동통로를 막았다는 뜻. --%>
					<li><a href="/controller/board/board_list">게시판</a></li>
					<li><a href="#">댓글</a></li>
					<li><a href="#">자료실</a></li>
					<li><a href="#">회원관리</a></li>
				</ul>
			</div>

			<%-- 관리자 우측 메뉴 --%>
			<div id="aMain_right">
				<form method="post" action="admin_logout">
					<h3 class="aRight_title">
						${admin_name}님 로그인을 환영합니다. <input type="submit" value="로그아웃" />
					</h3>
				</form>
			</div>
		</div>
		<div class="clear"></div>