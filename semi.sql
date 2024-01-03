alter session set "_oracle_script" = true;

create user semi
identified by semi
default tablespace users;

grant connect, resource to semi;

alter user semi quota unlimited on users;

CREATE TABLE member (
    member_no VARCHAR2(10) NOT NULL,
    member_id VARCHAR2(20),
    password VARCHAR2(50),
    name VARCHAR2(15),
    nickname VARCHAR2(50) NOT NULL,
    height NUMBER,
    role VARCHAR2(1) NOT NULL,
    reg_date DATE NOT NULL,
    birthday VARCHAR2(8),
    weight_loss_goal NUMBER,
    point NUMBER,
    answer VARCHAR2(50),
    local_no VARCHAR2(10) NOT NULL,
    title_no VARCHAR2(10) NOT NULL,
    CONSTRAINT PK_MEMBER PRIMARY KEY (member_no)
);

select * from member;

-- Inserting sample data into the "member" table
INSERT INTO member (
    member_no, member_id, password, name, nickname, height, role, reg_date, birthday,
    weight_loss_goal, point, answer, local_no, title_no
) VALUES (
    '1', 'user123', 'password123', 'John Doe', 'johndoe', 175, 'U', TO_DATE('2023-01-01', 'YYYY-MM-DD'), '19900101',
    5, 100, 'Answer123', 'L001', 'T001'
);

INSERT INTO member (
    member_no, member_id, password, name, nickname, height, role, reg_date, birthday,
    weight_loss_goal, point, answer, local_no, title_no
) VALUES (
    '2', 'admin456', 'adminPass', 'Admin User', 'adminuser', 180, 'A', TO_DATE('2023-01-02', 'YYYY-MM-DD'), '19851231',
    10, 200, 'Answer456', 'L002', 'T002'
);

-- Inserting sample data into other tables (if needed)
-- ...

-- Committing the transaction
COMMIT;

select * from member;

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
insert into semi.question_board(qb_no,member_no,title,content,reg_date,admin_choice) values(seq_qb_no.nextval,'1','안녕하세용','블라블라 얄라리얄라',default, default);
insert into semi.question_board(qb_no,member_no,title,content,reg_date,admin_choice) values(seq_qb_no.nextval,'2','하이하이','하하하하하',default, default);
--insert into semi.question_board(qb_no,member_no,title,content,reg_date,admin_choice) values(seq_qb_no.nextval,'14','쿠쿠쿠','뷁즐',default, default);
--insert into semi.question_board(qb_no,member_no,title,content,reg_date,admin_choice) values(seq_qb_no.nextval,'22','크크크','즐거워요',default, default);
--insert into semi.question_board(qb_no,member_no,title,content,reg_date,admin_choice) values(seq_qb_no.nextval,'77','호호호','반가워요호호',default, default);
--insert into semi.question_board(qb_no,member_no,title,content,reg_date,admin_choice) values(seq_qb_no.nextval,'33','뱌뱌뱌뱌','하하하햐햐',default, default);
--insert into semi.question_board(qb_no,member_no,title,content,reg_date,admin_choice) values(seq_qb_no.nextval,'131','유유유유','안녕하소',default, default);
--insert into semi.question_board(qb_no,member_no,title,content,reg_date,admin_choice) values(seq_qb_no.nextval,'221','이편지는 영국에서..','즐거워요',default, default);
--insert into semi.question_board(qb_no,member_no,title,content,reg_date,admin_choice) values(seq_qb_no.nextval,'7','1월1일이네','치피치피차파차파',default, default);
--insert into semi.question_board(qb_no,member_no,title,content,reg_date,admin_choice) values(seq_qb_no.nextval,'43','세상에!!','루비루비라바라바',default, default);
--insert into semi.question_board(qb_no,member_no,title,content,reg_date,admin_choice) values(seq_qb_no.nextval,'10','놀라워라','붐붐붐',default, default);
--insert into semi.question_board(qb_no,member_no,title,content,reg_date,admin_choice) values(seq_qb_no.nextval,'43','그대를만나고~','매니악매니악매니악~',default, default);
--insert into semi.question_board(qb_no,member_no,title,content,reg_date,admin_choice) values(seq_qb_no.nextval,'10','우우우','만남은쉽고~이별은어려워 ㅠ~',default, default);

select * from question_board;


-- DROP SEQUENCE seq_qb_no;
-- drop table question_board;

답변 A
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
                                constraints fk_answer_member_no foreign key (member_no) references member(member_no) on delete set null,
                                constraints fk_answer_qb_no foreign key (qb_no) references question_board(qb_no) on delete cascade
);
create sequence seq_ac_no;

--ALTER TABLE "SEMI"."ANSWER_COMMENT"
--MODIFY QB_NO VARCHAR2(15);
-- delete from answer_comment where title ='하이하이';
insert into semi.answer_comment(ac_no,member_no,qb_no,title,content,choice,like_count,reg_date) values(seq_ac_no.nextval,'1','5','답변드리리다','이게맞나',default, default, default);
insert into semi.answer_comment(ac_no,member_no,qb_no,title,content,choice,like_count,reg_date) values(seq_ac_no.nextval,'2','8','답변 ㅎㅇ','캬캬캬',default, default, default);
insert into semi.answer_comment(ac_no,member_no,qb_no,title,content,choice,like_count,reg_date) values(seq_ac_no.nextval,'2','8','답변 ㅎㅇ22','안녕',default, default, default);
insert into semi.answer_comment(ac_no,member_no,qb_no,title,content,choice,like_count,reg_date) values(seq_ac_no.nextval,'1','8','답변 ㅎㅇ33','안녕',default, default, default);
select * from answer_comment;

select
        *
    from
        answer_comment;
--    where
--        ac_no = 19;