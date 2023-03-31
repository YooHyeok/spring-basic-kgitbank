--한줄 주석문
--tbl_member 테이블 생성
create table tbl_member(
 userid varchar2(50) primary key	--회원 아이디
 ,userpw varchar2(50) not null 		--회원 비밀번호
 ,username varchar2(50) not null 	--회원 이름
 ,email varchar2(100) 				--이메일
 ,regdate date 						--등록날짜
 ,updatedate date 					--수정날짜
);

/*
1.primary key     	: 기본키 제약조건으로 반드시 자료를 입력해야 하고, 중복 자료 저장금지
2.not null 제약조건	: 중복자료는 허용하고, null금지
3.varchar2			: 오라클 가변문자 자료형
4.date			  	: 오라클 날짜 자료형
*/
select * from tbl_member;

--오라클 날짜 함수 확인
select sysdate from dual;
--dual테이블은 오라클 설치시 설치되는 임시테이블로 주로 오라클 함수나, 연산 결과값 확인용도로 사용됩니다.

--tbl_board 게시판 테이블 생성
create table tbl_board(
 bno number(38) primary key 	-- number(38) 오라클 정수숫자 타입으로 최대 38자
 ,writer varchar2(100) not null -- 작성자
 ,title varchar2(200) not null 	-- 게시판 제목
 ,content varchar2(4000) 		-- 내용
 ,viewcnt number(38) default 0 	-- 조회수, default 0 제약조건을 주면 이컬럼에 번호값을 저장하지 않아도 기본값 0이 저장됩니다.
 ,regdate date 					-- 등록날짜. date는 날짜타입.
);

select * from tbl_board;
/*
시퀀스 특징)
1. 번호발생기이다. 주로 게시판 번호값 저장용도로 활용된다.
2. 현재 이후 번호값만 발생한다. 중복번호가 없고, 빈 번호값이 없다.
*/
--bno_seq 시퀀스 생성
create sequence bno_seq
start with 1 	-- 1부터 시작
increment by 1 	-- 1씩 증가
nocache; 		-- 임시메모리를 사용하지 않겠다는 뜻

--시퀀스 명. nextval 다음 시퀀스 번호값 확인
select bno_seq.nextval from dual;

--댓글 수를 저장할 replycnt 컬럼을 추가
alter table tbl_board
add (replycnt number(38) default 0);

select * from tbl_board order by bno desc;

--tbl_reply 테이블의 각 게시판 번호에 해당하는 댓글목록과 tbl_board테이블의 각 게시물 번호에 댓글 개수를 일치시킨다
update tbl_board set replycnt=(select count(rno) from tbl_reply 
where bno=tbl_board.bno) where bno>0;

--count()함수는 오라클에서 레코드 개수를 헤아린다.



