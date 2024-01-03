alter session set"_oracle_script" =true;

create user semi_diet
identified by K1H3isgood123
default tablespace users;

commit;
show user;

grant connect, resource to semi_diet;
alter user semi_diet quota unlimited on users;

--SELECT 'DROP TABLE "' || TABLE_NAME || '" CASCADE CONSTRAINTS;' FROM user_tables; 모든 테이블 드랍문

--drop table nickname_title


--
--select * from location_code;

select 
    q.*,
    m.member_id
from
    question_board q 
        left join member m
            on q.member_no = m.member_no;

    




--지역코드 LC
create table location_code (
    local_no varchar2(10) not null,
    local_si varchar2(20) not null,
    local_gu varchar2(20) not null,
    constraints pk_local_no primary key(local_no)
);
create sequence seq_local_no;
--insert into location_code 
--values ('LC' || seq_local_no.nextval, '서울특별시', '강남구');
--insert into location_code 
--values ('LC' || seq_local_no.nextval, '서울특별시', '서초구');




--헬스장 db G
create table gym_data (
    gym_no varchar2(10) not null,
    local_no varchar2(10) not null,
    name varchar2(50) not null,
    address varchar2(200) not null,
    phone varchar2(15) not null,
    constraints pk_gym_no primary key(gym_no),
    constraints fk_gym_local_no foreign key (local_no) references location_code(local_no) on delete set null
);
create sequence seq_gym_no;
--insert into gym_data 
--values ('G' || seq_gym_no.nextval,'LC1', '강남헬스', '서울특별시 강남구 역삼동 123번지', '010-2312-2134');


--닉네임 N
create table nickname_title (
    title_no varchar2(10) not null,
    name varchar2(20) not null,
    range number,
    constraints pk_nickname_title_no primary key(title_no)
);
create sequence seq_title_no;

--insert into nickname_title
--values ('N' || seq_title_no.nextval, '초보', '10');
select * from nickname_title;


--멤버 M
create table member(
    member_no varchar2(10) not null,
    member_id varchar2(20) not null,
    password varchar2(50) default '' not null, 
    name varchar2(15) not null,
    nickname varchar2(50) not null,
    height number,
    role varchar2(1) not null ,
    reg_date date default sysdate,
    birthday varchar2(8),
    weight_loss_goal number ,
    point number default 0,
    answer varchar2(300) default '',
    local_no varchar2(10),
    title_no varchar2(10) default 'N1',
    constraints pk_member_no primary key(member_no),
    constraints uq_member_id unique(member_id),
    constraints uq_member_nickname unique(nickname),
    constraints ck_member_role check(role in ('M', 'A')),
    constraints fk_member_local_no foreign key (local_no) references location_code(local_no) on delete set null,
    constraints fk_member_title_no foreign key (title_no) references nickname_title(title_no) on delete set null
);
create sequence seq_member_no;
--alter table member add password varchar2(50) default '' not null;
-- alter table member add answer varchar2(200) default '';
--alter table member modify point default 0;
--alter table member modify title_no default 'N1';

insert into member 
values ('M' || seq_member_no.nextval, 'honggd', 'asd123@', '홍길동', '길동길',175,'M', default, '19910101', 10, default,'LC1', default);

insert into member 
values ('M' || 0, 'admin', 'admin', '관리자','관리자', 200, 'A', default, '19910101', default, 100000,'LC1', default,default);


select * from member where member_id = 'admin';
delete from member where name = '관리자';

 

--질문게시판 Q
create table question_board (
    qb_no varchar2(10) not null,
    member_no varchar2(10) not null,
    title varchar2(50) not null,
    content varchar2(4000) not null, 
    reg_date date default sysdate,
    admin_choice number default 0,
    constraints pk_qb_no primary key(qb_no),
    constraints ck_admin_choice check (admin_choice in (0, 1)),
    constraints fk_question_member_no foreign key (member_no) references member(member_no) on delete set null
);
create sequence seq_qb_no;
insert into question_board 
values ('Q' || seq_qb_no.nextval,'M4', '테스트 게시물', '테스트입니다 123', default, default );
insert into question_board 
values ('Q' || seq_qb_no.nextval,'M4', '테스트 게시물2', '2테스트입니다 123', default, default );
insert into question_board 
values ('Q' || seq_qb_no.nextval,'M4', '테스트 게시물3', '3테스트입니다 123', default, default );
select * from question_board;insert into question_board 
values ('Q' || seq_qb_no.nextval,'M4', '테스트 게시물4', '4테스트입니다 123', default, default );

--답변 A
create table answer_comment (
    ac_no varchar2(10) not null,
    member_no varchar2(10) not null,
    qb_no varchar2(10) not null,
    title varchar2(50) not null,
    content varchar2(4000) not null, 
    choice number default 0 not null,
    like_count number default 0,
    reg_date date default sysdate,
    constraints pk_ac_no primary key(ac_no),
    constraints ck_choice check (choice in (1,0)),
    constraints fk_ansewer_member_no foreign key (member_no) references member(member_no) on delete set null,
    constraints fk_answer_qb_no foreign key (qb_no) references question_board(qb_no) on delete cascade
);
create sequence seq_ac_no;
insert into answer_comment 
values('A' || seq_ac_no.nextval, 'M4', 'Q1', '답변 테스트', '답변 테스트문 입니다', default,default,default );


--일일기록 테이블 DR
create table daily_recode (
    daily_no varchar2(10) not null,
    daily_weight number,
    member_no varchar2(10) not null,
    recode_date date default sysdate,
    point_check number default 0,
    constraints pk_daily_no primary key(daily_no),
    constraints ck_point_check check (point_check in (1, 0)), 
    constraints fk_daily_member_no foreign key (member_no) references member(member_no) on delete cascade
);
create sequence seq_daily_no;
insert into daily_recode
values ('DR'||seq_daily_no.nextval, 70, 'M4', default,default);

select * from daily_recode;


--운동데이터 E
create table exercies_data(
    ex_no varchar2(10) not null, 
    ex_name varchar2(50) not null,
    kcal number not null, 
    body_part varchar2(50),
    ex_url varchar2(400),
    constraints pk_ex_no primary key(ex_no),
    constraints uq_ex_name unique(ex_name)
);
create sequence seq_ex_no; 
-- 기존 유무산소 구분 컬럼 삭제했음. 유산소의 경우 body_part(자극부위)를 유산소로 설정
-- 이두, 어깨, 삼두, 하체, 가슴, 등, 유산소 
insert into exercies_data 
values('E' || seq_ex_no.nextval, '달리기', 120, '유산소', 'https://youtu.be/Ggbm_coe5uM?si=0e7d2x6vkRQ3HHlE');

insert into exercies_data 
values('E' || seq_ex_no.nextval, '덤벨 드래그 컬', 84, '이두근', 'https://youtu.be/1iuzb9Br_pc?si=xBAvIojZ3xincJL6');

insert into exercies_data 
values('E' || seq_ex_no.nextval, '덤벨 킥백', 90, '삼두근', 'https://youtu.be/mQlJ15jx6Q8?si=YgY6A7IbbvAVwFwA');

insert into exercies_data 
values('E' || seq_ex_no.nextval, '스쿼트', 98, '하체', 'https://youtu.be/50f62PSGY7k?si=Hi29PdAQjfaVK0Bm');


select * from exercies_data;

--운동 스크랩 보관 테이블 SE
create table scrap_exercise (
    ex_scrap_no varchar2(10) not null,
    member_no varchar2(10) not null,
    ex_no varchar2(10) not null,
    constraints pk_ex_scrap_no primary key(ex_scrap_no),
    constraints fk_se_member_no foreign key (member_no) references member(member_no) on delete set null,
    constraints fk_se_ex_no foreign key (ex_no) references exercies_data(ex_no) on delete cascade
);
create sequence seq_scrap_ex_no; 

--운동 일일기록 테이블 DE
create table daily_ex(
    de_no varchar2(10) not null,
    ex_id varchar2(10) not null,
    daily_no varchar2(10) not null,
    ex_sets number,
    constraints pk_de_no primary key(de_no),
    constraints fk_de_ex_id foreign key (ex_id) references exercies_data(ex_no) on delete cascade,
    constraints fk_de_daily_no foreign key (daily_no) references daily_recode(daily_no) on delete cascade
);
create sequence seq_de_no;

insert into daily_ex values('DE'||seq_de_no.nextval, 'E2', 'DR2', 4);


--눈바디 첨부파일 저장 EA
create table eyebody_attachment (
    ea_no varchar2(10) not null,
    daily_no varchar2(10) not null,
    original_file varchar2(100) not null,
    renamed_file varchar2(100) not null,
    constraints pk_ea_no primary key(ea_no),
    constraints fk_ea_daily_no foreign key(daily_no) references daily_recode(daily_no) on delete cascade
);
create sequence seq_ea_no;

--음식 F
create table food_data (
    food_no varchar2(10) not null,
    name varchar2(20) not null,
    kcal number,
    carbo number,
    prot number,
    fat number,
    constraints pk_food_no primary key(food_no)
);
create sequence seq_food_no;

select * from food_data;
insert into food_data 
values('F' || seq_food_no.nextval, '사과', 130, 35, 1.5, 0.5);



--식단 일일기록 테이블 DF
create table daily_food (
    df_no varchar2(10) not null,
    food_time varchar2(1) default '',
    food_no varchar2(10) not null, 
    daily_no varchar2(10) not null,
    constraints pk_df_no primary key(df_no),
    constraints fk_df_food_no foreign key(food_no) references food_data(food_no) on delete cascade,
    constraints fk_df_daily_no foreign key(daily_no) references daily_recode(daily_no)on delete cascade
);
create sequence seq_df_no; 


-- 포인트 카운트 테이블 P
create table point_count (
    pc_no varchar2(10) not null,
    reg_date date default sysdate,
    get_point number default 0,
    member_no varchar2(10) not null,
    daily_no varchar2(10),
    ac_no varchar2(10), 
    constraints pk_pc_no primary key (pc_no),
    constraints fk_pc_member_no foreign key(member_no) references member(member_no) on delete cascade,
    constraints fk_pc_daily_no foreign key(daily_no) references daily_recode(daily_no) on delete cascade,
    constraints fk_pc_ac_no foreign key(ac_no) references answer_comment(ac_no) on delete cascade
);
create sequence seq_pc_no;

-- 신고 게시물 관리 테이블 RQ
create table report_qna (
    report_no varchar2(10) not null,
    qb_no varchar2(10) not null,
    member_no varchar2(10) not null,
    reg_date date default sysdate,
    report_result varchar2(6) default 'notyet',
    content varchar2(1000),
    constraints pk_report_no primary key (report_no),
    constraints fk_rep_qb_no foreign key(qb_no) references question_board(qb_no) on delete set null,
    constraints fk_rep_member_no foreign key(member_no) references member(member_no) on delete set null
);
create sequence seq_report_no;

-- 그룹 목록 G
create table group_list (
    group_no varchar2(10) not null,
    group_name varchar2(10) not null,
    slogan varchar2(60),
    limit number,
    constraints pk_group_no primary key (group_no)
);
create sequence seq_group_list;

insert into group_list
values ();
 
-- 그룹 회원관리 GM
create table group_member(
    gm_no varchar2(10) not null,
    group_no varchar2(10) not null,
    member_no varchar2(10) not null,
    state varchar2(4),
    grade varchar2(1),
    reg_date date default sysdate,
    constraints fk_gm_group_no foreign key (group_no) references group_list(group_no) on delete cascade,
    constraints fk_gm_member_no foreign key (member_no) references member(member_no) on delete cascade,
    constraints ck_state check (state in ('join', 'out')),
    constraints ck_grade check (grade in ('M', 'L'))
);
create sequence seq_group_member;

-- 그룹 게시판 GB
create table group_board (
    gb_no varchar2(10) not null,
    group_no varchar2(10) not null,
    member_no varchar2(10) not null,
    title varchar2(50) not null, 
    content varchar2(4000) not null, 
    reg_date date default sysdate,
    constraints pk_gb_no primary key(gb_no),
    constraints fk_gb_group_no foreign key (group_no) references group_list(group_no) on delete cascade,
    constraints fk_gb_member_no foreign key (member_no) references member(member_no) on delete set null
);
create sequence seq_group_board;


-- 그룹 게시판 댓글 GC
Create table group_comment (
    gc_no varchar2(10) not null,
    gb_no varchar2(10) not null,
    member_no varchar2(10) not null,
    content varchar2(2000),
    comment_level number default 1, -- 댓글 1 대댓글 2
    parent_comment_id varchar2(10), 
    reg_date date default sysdate,
    constraints pk_gc_no primary key (gc_no),
    constraints fk_gc_gb_no foreign key (gb_no) references group_board(gb_no) on delete cascade,
    constraints fk_gc_member_no foreign key (member_no) references member(member_no) on delete set null,
    constraints fk_gc_parent_comment_id foreign key (parent_comment_id) references group_comment on delete cascade -- 댓글 삭제시 자동삭제 
);
create sequence seq_group_comment;