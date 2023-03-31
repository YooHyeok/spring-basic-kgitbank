--notice테이블 생성 (공지사항)

create table notice (
 notice_no number(38) primary key -- 번호
 ,notice_name varchar2(30) not null -- 작성자 / not null 제약조건 = 반드시 데이터를 입력해야하고 중복기능을 허용함
 ,notice_title varchar2(200) not null -- 공지 제목
 ,notice_pwd varchar2(20) not null -- 공지 비밀번호
 ,notice_cont varchar2(4000) not null -- 공지내용
 ,notice_hit number(38) default 0 --조회수
 ,notice_date date --공지 등록날짜
 );
 
 select * from notice order by notice_no desc; --공지 번호를 기준으로 내림차순 정렬
 
-- g_no_seq 시퀀스 생성(번호생성기)
create sequence g_no_seq
start with 1  --1부터 시작
increment by 1--1씩 증가
nocache; --임시저장 장소를 사용하지 않겠다는 뜻.

--시퀀스 번호값 확인
select g_no_seq.nextval from dual;

 