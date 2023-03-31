create table tbl_reply(
rno number(38) primary key -- 댓글번호, number(38)은 오라클에서 최대 38자까지 정수숫자값을 지정하는 자료형, primary key는 기본키 제약조건으로 중복번호값이 없고 null저장 금지
,bno number(38) default 0 -- tbl_board테이블의 bno컬럼 게시판 번호값만 저장됨. -- 외래키 제약조건으로 추가 설정. defualt 0 제약조건은 굳이 번호값을 저장하지 않아도 기본값 0 이 저장됨.
,replyer varchar2(100) not null -- 댓글 작성자
,replytext varchar2(4000) not null -- 댓글 내용
,regdate date -- 댓글 등록날짜, date는 오라클 날짜 타입
,updatedate date -- 댓글 수정날짜
);

select * from tbl_reply order by rno desc; --댓글 번호를 기준으로 내림차순 정렬

--외래키 설정
alter table tbl_reply add constraint fk_board
foreign key(bno) references tbl_board(bno); --주인테이블의 tbl_board의 기본키 컬럼 bno를 참조하고 있다. 그러므로 게시판 번호값만 저장됨.

--댓글번호값이 저장된 시퀀스 생성
create sequence rno_seq
start with 1 --1부터 시작
increment by 1 --1씩 증가
nocache;--임시 저장 장소를 사용하지 않겠다.

-- 시퀀스 다음번호값 확인
select rno_seq.nextval from dual;
--dual테이블은 오라클 설치시 설치되는 임시테이블로 시퀀스 번호값 확인 용도, 오라클 함수값 확인 용도, 연산결과값 확인용도 등으로 활용됨.

--sysdate 오라클 날짜함수 값 확인
select sysdate from dual;