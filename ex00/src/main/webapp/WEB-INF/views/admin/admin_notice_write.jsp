<%@ page contentType="text/html; charset=UTF-8"%>
<jsp:include page="../include/admin_header.jsp" />
<%-- 관리자상단 공통페이지 외부 포함파일 불러오기 => jsp:include 액션태그 --%>

<%--관리자 공지 작성 --%>
<div id="aMain_cont">
 <div id="aBw_wrap">
 <h2 class="aBw_title">관리자 공지 작성</h2>
 <form method="post" action="admin_notice_write_ok" onsubmit="return gw_check();">
 <table id="aBw_t">
 <tr>
 <th>작성자</th>
 <td>
 <input name="notice_name" id="notice_name" size="14"/>
 </td>
 </tr>
 <tr>
 <th>공지 제목</th>
 <td>
 <input name="notice_title" id="notice_title" size="36"/>
 <%-- type속성을 생략하면 기본값이 text이다. --%>
 </td>
 </tr>
 <tr>
 <th>비밀번호</th>
 <td>
 <input type="password" name="notice_pwd" id="notice_pwd" size="14"/>
 </td>
 </tr>
 <tr>
 <th>공지내용</th>
 <td>
 <textarea name="notice_cont" id="notice_cont" rows="9" cols="36"></textarea>
 </td>
 </tr>
 </table>
 <div id="aBw_menu">
 <input type="submit" value="공지작성"/>
 <input type="reset" value="작성취소" onclick="$('#gongji_name').focus();"/>
 <%-- $('#gongji_name').focus()는 작성자 입력박스로 포커스가 이동됨. --%>
 
 </div>
 </form>
 </div>
</div>

<%-- 관리자 하단 공통페이지 외부 포함파일 처리. --%>
<%@ include file="../include/admin_footer.jsp" %>