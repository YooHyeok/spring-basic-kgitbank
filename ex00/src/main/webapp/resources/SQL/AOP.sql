					--tbl_user 테이블설정
create table tbl_user(
uid2 varchar2(50) primary key --회원 아이디 
,upw varchar2(50) not null	--비밀번호
,uname varchar2(100) not null	--회원 이름
,upoint number(38) default 0	--메시지가 보내지면 포인터점수 10점이 올라간다.
--default 0 제약조건은 해당컬럼에 포인터 점수를 저장하지 않아도 기보값인 0이 저장됨.
);

					--레코드 입력
insert into tbl_user (uid2,upw,uname) values('user00','user00','홍길동');
insert into tbl_user (uid2,upw,uname) values('user01','user01','이순신');
					
					--검색
select * from tbl_user; 

					--tbl_message 테이블 생성
create table tbl_message(
mid number(38) primary key
,targetid varchar2(50) not null --외래키 제약조건으로 설정. tbl_user 테이블의 uid2 컬럼 아이디값만 저장됨.
,sender varchar2(50) not null --메시지를 보낸 사람
,message varchar2(1000) not null -- 보낸 메시지
,senddate date --보낸 날짜
);

					--외래키 제약 조건
alter table tbl_message add constraint fk_usertarget
foreign key(targetid) references tbl_user(uid2);
--주인테이블 tbl_user의 기본키 컬럼 uid2를 참조하고 있다. 그러므로 uid2컬럼 아이디값만 저장된다.

					--mid_no_seq 시퀀스 생성
create sequence mid_no_seq
start with 1 --1부터 시작
increment by 1 --1씩 증가
nocache; --임시 메모리를 사용하지 않겠다는 뜻.

					--mid_no_seq 시퀀스 다음번호 값을 확인
select mid_no_seq.nextval from dual;

select * from tbl_message;

delete from tbl_message where mid=9;


