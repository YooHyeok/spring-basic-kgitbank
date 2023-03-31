--admin 테이블 생성
create table admin(--관리자 테이블
 admin_no number(38) --최대 자리수 38자까지 정수숫자값을 저장 => number(38)
 ,admin_id varchar2(30) primary key --관리자 아이디 (아이디는 중복되면 안되므로 primary key선언)
 ,admin_pwd varchar2(200) not null --관리자 비번
 ,admin_name varchar2(20) not null --관리자 이름
 ,admin_date date --등록날짜
);

--admin_no_seq 시퀀스 생성
create sequence admin_no_seq
start with 1
increment by 1
nocache;

insert into admin values(admin_no_seq.nextval,'admin','1234', '관리자', sysdate);

select * from admin;

--오라클 sysdate 날짜함수 값 확인
select sysdate from dual;