/**
 * 자바스크립트 한줄이상 주석문 기호.
 * board.js
 */
function check(){
	//function예약어는 자바스크립트에서 함수정의 예약어. check()는 함수명

	if($.trim($("#writer").val())==""){
		//trim()은 jQuery함수로 양쪽공백을 제거. $는 jQuery란 뜻.
		//#writer는 유일한 아이디 선택자 문법으로 접근하는법.
		//val()은 jQuery함수로 입력박스에 입력한 값을 가져옴. ==은 같다연산
		alert("글쓴이를 입력하세요!"); //alert()는 자바스크립트 함수로 경고창을 만듬
		$("#writer").val('').focus();//val('')은 입력박스값을 초기화
		//focus()는 입력박스로 포커스 이동
		return false;
	}
	if($.trim($("#title").val())==''){
		alert('제목을 입력!');
		$('#title').val('').focus();
		return false;
	}
	if($.trim($("#content").val())==''){
		alert("글내용을 입력하세요!");
		$('#content').val('').focus();
		return false;
	}
}