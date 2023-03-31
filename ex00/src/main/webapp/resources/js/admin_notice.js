/**
 * admin_notice.js
 */

function gw_check(){//function키워드로 gw_check()함수 정의
	//if($.trim($("#notice_").val()) == ""){alert("공지 작성자를 입력하세요!"); $("#notice_").val("").focus(); return false; }
	
	if($.trim($("#notice_name").val()) == ""){
		alert("공지 작성자를 입력하세요!");
		$("#notice_name").val("").focus();//입력박스 값을 초기화하고 포커스 이동
		return false;
	}
	if($.trim($("#notice_title").val()) == ""){
		alert("공지 제목 입력하세요!");
		$("#notice_title").val("").focus();//입력박스 값을 초기화하고 포커스 이동
		return false;
	}
	if($.trim($("#notice_pwd").val()) == ""){
		alert("비밀번호를 입력하세요!"); 
		$("#notice_pwd").val("").focus(); 
		return false; 
	}
	if($.trim($("#notice_cont").val()) == ""){
		alert("공지 내용을 입력하세요!");
		$("#notice_cont").val("").focus();
		return false;
	}
	


}//유효성 검증=>validate