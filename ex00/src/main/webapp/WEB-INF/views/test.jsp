<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아작스 댓글연습</title>

<style>
#modDiv {
	width: 300px;
	height: 100px;
	background-color: gray; /* 배경색 */
	position: absolute;
	top: 50%;
	left: 50%;
	margin-top: -50px; /* css주석문기호, 바깥 윗쪽 여백 */
	margin-left: -150px; /* 바깥 왼쪽 여백 */
	padding: 10px; /*상하 좌우 여백*/
	z-index: 1000;
	/* position 속성이 absolute나 fixed으로 설정된 곳에서 사용한다. 이 속성은 요소가 겹쳐지는 순서를 제어할수 있다. 값이 큰것이 앞에 나온다. */
}
</style>

</head>
<body>
	<%-- 댓글 수정 화면 --%>
	<div id="modDiv" style="display: none;">
		<%-- display:none; css속성 값은 해당 화면을 안보이게 함. --%>
		<div class="modal-title"></div>
		<div>
			<textarea rows="3" cols="30" id="replytext"></textarea>
		</div>
		<div>
			<button type="button" id="replyModBtn">댓글 수정</button>
			<button type="button" id="replyDelBtn">댓글 삭제</button>
			<button type="button" id="closeBtn" onclick="modDivClose();">닫기</button>
		</div>
	</div>

	<H2>아작스 댓글 페이지</H2>
	<%-- H2태그는 본문제목을 지정할 때 사용함. H1태그가 글자크기가 가장 크고, H6 글자크기가 가장 작다. --%>
	<div>
		<%-- div태그는 레이아웃을 그릴때 사용 --%>
		<div>
			댓글 작성자 : <input type="text" name="replyer" id="newReplyWriter" />
		</div>
		<br />
		<%-- br태그는 단독태그로 줄바꿈(개행) --%>
		<div>
			댓글 내용 :
			<textarea rows="5" cols="30" name="replytext" id="newReplyText"></textarea>
		</div>
		<br />
		<button id="replyAddBtn">댓글등록</button>
	</div>
	
	<br />
	<hr />
	<%--hr태그는 수평선을 긋는다. --%>
	<br />

	<%-- 댓글 목록 --%>
	<ul id="replies"></ul>
	<%-- ul li 태그는 순서없는 목록태그 --%>


	<%-- jQuery라이브러리 읽어오기 --%>
	<script src="./resources/js/jquery.js"></script>
	<script>
		//type속성을 생략하면 기본값이 javascrpit
		var bno = 19; //게시판 번호. 		
		/*			var : 변수 정의 예약어. 
		 bno : 자바스크립트 변수명				 */

		getAllList();//댓글목록 함수 호출
		function getAllList() { //function키워드로 getAllList()함수로 정의
			$
					.getJSON(
							"/controller/replies/all/" + bno,
							function(data) {
								//get방식으로 JSON데이터를 가져오기 위한 jQuery비동기식 아작스 함수 => 가져오는것 성공시 data매개변수에 값이 저장됨.
								var str = "";
								$(data)
										.each(
												function() { //&는 jQuery란 뜻이고, each()는 jQuery함수로서 반복한다는 뜻.

													str += "<li data-rno='"+this.rno+"' class='replyLi'>"
															+ this.rno
															+ " : <span class='com' style='color:blue;font-weight:bold;'>"
															+ this.replytext
															+ "</span>"
															+ " <button>댓글수정</button></li><br/>";

												});
								$("#replies").html(str);//jQuery html()함수로 str변수에 저장된 문자와 html태그를 replies 아이디 영역에 변경적용한다.

							});
		}//댓글 목록 getAllList()

		//댓글 추가
		$("#replyAddBtn").on("click", function() { //해당 버튼 클릭이벤트가 발생했을때 실행.
			var replyer = $("#newReplyWriter").val(); //val() jQuery함수는 입력박스 입력값을 가져옴.
			var replytext = $("#newReplyText").val();
			$.ajax({ //get or post방식을 처리하는 jQuery 비동기식 아작스 함수 => 가장 사용빈도가 높다. , $대신 jQuery를 사용해도 됨
				type : 'post', //비동기식 아작스로 서버로 자료를 보내는 법
				url : '/controller/replies', //아작스 서버 매핑주소 경로
				headers : {
					"Content-Type" : "application/json",
					"X-HTTP-Method-Override" : "POST"
				},
				dataType : 'text',
				data : JSON.stringify({
					bno : bno, //json 키이름 : 값 쌍으로 전달, 게시판 번호값
					replyer : replyer, //키이름은 ReplyVO.java의 변수명과 일치, 댓글작성자
					replytext : replytext
				//댓글 내용
				}),
				success : function(result) { //비동기식으로 가져온 것이 성공식 호출되는 콜백함수 => 정상적으로 가져온 데이터는 result매개변수에 저장됨. 
					//반환문자열을 result 매개변수에 저장됨.
					if (result == 'success') {
						alert("댓글이 등록 되었습니다."); //자바스크립트에서는 한문장 끝을 뜻하는 ;(세미콜론)은 해도되고 안해도된다.
						getAllList();//댓글 목록 함수
					}
				}
			});
		});

		//댓글 수정화면
		$("#replies").on("click", ".replyLi button", function() {
			//.replyLi는 클래스명 선택자.
			var reply = $(this).parent();
			var rno = reply.attr("data-rno");//data-rno속성값인 댓글번호
			var replytext = reply.text(); //댓글 내용.

			$(".modal-title").html(rno);//댓글번호를 .modal-title클래스 선택자 영역에 문자와 태그를 변경 적용
			$("#replytext").val(replytext);
			$("#modDiv").show("slow"); //수정 화면을 show()함수로 천천히 보이게 함.

		});
		//댓글 수정화면 닫기
		function modDivClose() {
			$("#modDiv").hide("slow");//hide()함수로 천천히 숨긴다.
		}//modDivClose()함수 정의

		  
		
		//댓글수정 완료
		$("#replyModBtn").on("click",function(){
			var rno = $(".modal-title").html();//댓글 번호
			var replytext = $("#replytext").val();//댓글 내용
			
			$.ajax({
				type:'put',
				url:'/controller/replies/'+rno,
				headers:{
					"Content-Type": "application/json",
					"X-HTTP-Method-Override":"PUT"},
					data:JSON.stringify({replytext:replytext}), //replytext키이름에 수정댓글내용이 담겨져서 전달됨.
					dataType:'text',
					success:function(result){
						//console.log("result: " + result);
						if(result=='SUCCESS'){
							alert("댓글이 수정 되었습니다.");
							$("#modDiv").hide("slow"); //수정화면 숨김
							getAllList();	//댓글 목록함수를 호출
							//getPageList(replyPage);
						
					}
				}
			});
		});
		//댓글 삭제 완료
		$('#replyDelBtn').on('click',function(){
			var rno=$(".modal-title").html();//댓글번호
			$.ajax({
				type:'delete',
				url:'/controller/replies/'+rno,
				headers:{
					"Content-Type":"application/json",
					"X-HTTP-Method-Override":"DELETE"},
					dataType:'text',
					success:function(result){
						if(result=='success'){//ReplyContoroller.java에서 삭제 entity코드의 문자열과 같아야함(대소문자 구분)
							alert('댓글이 삭제되었습니다.');
							$("#modDiv").hide('slow');//댓글 수정화면 닫고
							getAllList();//댓글 목록함수 호출
						
					}
				}
			});
		});
		
		
	</script>

</body>
</html>