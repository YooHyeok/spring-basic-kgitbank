<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스프링 게시판 글쓰기 폼</title>


<script type="text/javascript" src="../resources/js/jquery.js"></script>
<%-- jquery 외부라이브러리 읽어오기. type속성 생략가능 --%>

<script src="../resources/js/board.js"></script>
<%-- board.js 자바스크립트 외부 포함파일 읽어오기 --%>


</head>
<body>
	<form method="post" action="board_write_ok" onsubmit="return check();">
		<%-- onsubmit은 사건처리기 즉 이벤트 핸들러라 한다. 데이터가 서버로 전송된 것을 처리함.
			 check()함수를 호출. check()는 자바스크립트에서 정의한 함수명 --%>
			 
		<table border="1">
			<%-- table html태그는 표를 만든다. border속성을 표테이블 두께. 숫자가 커질수록 두꼐는 굵어진다. --%>
			<tr><%-- tr태그는 행을 만듬. --%>
				<th><%-- th태그는 열을 만듬. 이 태그의 특징은 글자를 중앙정렬하고 진하게 출력.--%> 글쓴이
				</th>
				<td><%-- td태그도 열을 만듬. --%> 
				<input type="text" name="writer" id="writer" size="14" /> 
				<%-- type="text"는 한줄 입력박스를 만듬. 입력한 값은 name속성명 writer에 저장되어 서버로 전달됨. --%>
				</td>
			</tr>
			<tr>
			<th>제목</th>
			<td><input name="title" id="title" size="36"/> </td>
			<%-- type속성을 생략하면 기본값이 text이다. --%>
			</tr>
			<tr>
			<th>글내용</th>
			<td><textarea name="content" id="content" rows="10" cols="36"></textarea></td>
			<%-- rows속성은 행을만들고, cols속성은 열을 만듬. textarea태그는 한줄이상 입력할 수 있는 박스를 만듬. --%>
			</tr>
			<tr>
			<th colspan="2"> <%-- colspan속성은 열을 합침. 여기서는 2개의 열을 합침. --%>
			<input type="submit" value="저장"/> <%-- submit은 입력한 자료를 서버로 전송한ㄷㅏ. --%>
			<input type="reset" value="취소"/> <%-- reset은 입력한 값을 초기화. --%>
			<input type="button" value="목록" onclick="location='/controller/board/board_list?page=${page}';" />
			<%-- onclick은 클릭사건을 처리하는 사건처리기 즉 이벤트 핸들러이다.
				 location은 자바스크립트 내장객체로 지정한 매핑주소로 이동시킨다. --%>
			</th>
			</tr>
		</table>
		</form>
</body>
</html>