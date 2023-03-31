<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- JSTL 코어 태그립 추가 --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스프링 MVC 게시판 목록</title>
</head>
<body>
	<table border="1">
		<tr>
			<th colspan="5">스프링 MVC 게시판 목록</th>
		</tr>
		<tr>
			<td colspan="5" align="right">총 게시물 수: <b>${totalCount}</b> 개
			</td>
		</tr>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>이름</th>
			<th>조회수</th>
			<th>등록날짜</th>
		</tr>
		<c:if test="${!empty blist}">
			<c:forEach var="b" items="${blist}">
				<tr>
					<th>${b.bno}</th>
					<th><a href="/controller/board/board_cont?bno=${b.bno}&page=${page}">${b.title} &nbsp;&nbsp;
					<strong>[댓글갯수] ${b.replycnt}</strong></a> <%-- strong태그는 글자를 진하게 출력 --%>
					<%--board_cont?bno=번호값 형태의 웹주소창에 노출되는 get방식으로 bno파라미터 이름에 게시판 번호값을 담아서 내용보기 매핑주소로 전달. 
					게시물 목록에서 복수개의 파라미터값을 내용보기로 전달하는법 : board_cont?bno=번호 &page=쪽번호  핵심은 & 앤드기호--%>
					</th>
					<th>${b.writer}</th>
					<th>${b.viewcnt}</th>
					<th>${b.regdate}</th>
				</tr>
			</c:forEach>
		</c:if>
		<c:if test="%{empty blist}">
			<tr>
				<th colspan="5">게시판 목록이 없습니다!</th>
			</tr>
		</c:if>
		
		<%-- 페이징 추가 --%>
		<tr>
		<th colspan="5">
		<c:if test="${page <= 1}">
		[이전]&nbsp; <%--&nbsp;은 특수문자로 한칸 빈 공백을 만듬. --%>
		</c:if>
		<c:if test="${page > 1}">
		<a href="/controller/board/board_list?page=${page-1}">[이전]</a>
		&nbsp;
		</c:if>
		<%-- 현재 쪽번호 출력 --%>
		<c:forEach var="a" begin="${startpage}" end="${endpage}" step="1">
			<%-- 시작 페이지 부터 끝 페이지 까지 1씩 증가하는 반복문 --%>
			<c:if test="${a == page}"> <%-- 현재 쪽 번호가 선택된 경우 --%>
			<${a}>
			</c:if>
			
			<c:if test="${a != page}"> <%-- 현재 쪽번호가 선택 안된 경우 --%>
			<a href="/controller/board/board_list?page=${a}">[${a}]</a>
			&nbsp;
			</c:if>
		</c:forEach>
		
		<c:if test="${page >= maxpage}">
		[다음]
		</c:if>
		<c:if test="${page < maxpage}">
		<a href="/controller/board/board_list?page=${page+1}">[다음]</a>
		</c:if>
		</th>
		</tr>
		
		<%-- 페이징 끝 --%> 
		<tr>
			<td colspan="5" align="right"><input type="button" value="글쓰기"
				onclick="location='/controller/board/board_write?page=${page}';" /> 
				<%-- 자바스크립트 location객체에 의해서 게시판 글쓰기 폼으로 이동 --%>
				<%-- 책갈피 기능을 구현하기 위해서 get방식으로 board_write?page=쪽번호를 전달함. --%>
			</td>
		</tr>
	</table>
	<script>
	var msg='${msg}'; //자바스크립트에서 var키워드는 변수정의 예약어
	//자바스크립트에서 스프링 컨트롤러의 키이름을 참조해서 EL or JSTL로 가져올 수 있다.
	//여기서는 표현언어인 EL로 키를 참조해서 SUCCESS문자열을 가져옴.
	//jQuery로 표현하면 $msg='${msg}'; 좌 : jQuery = 우 : EL표현식
	if(msg == "SUCCESS"){
		alert('게시물 처리에 성공했습니다.')
	}
	</script>
	
</body>
</html>