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
    reg_date date default sysdate,
    birthday VARCHAR2(8),
    weight_loss_goal NUMBER,
    point NUMBER,
    answer VARCHAR2(50),
    local_no VARCHAR2(10) NOT NULL,
    title_no VARCHAR2(10) NOT NULL,
    CONSTRAINT PK_MEMBER PRIMARY KEY (member_no)
);

drop table member;
select * from member;

-- Inserting sample data into the "member" table
INSERT INTO member (
    member_no, member_id, password, name, nickname, height, role, reg_date, birthday,
    weight_loss_goal, point, answer, local_no, title_no
) VALUES (
    '1', 'user123', 'password123', 'John Doe', 'johndoe', 175, 'U', default, '19900101',
    5, 100, 'Answer123', 'L001', 'T001'
);

INSERT INTO member (
    member_no, member_id, password, name, nickname, height, role, reg_date, birthday,
    weight_loss_goal, point, answer, local_no, title_no
) VALUES (
    '2', 'admin456', 'adminPass', 'Admin User', 'adminuser', 180, 'A', default, '19851231',
    10, 200, 'Answer456', 'L002', 'T002'
);

-- Inserting sample data into other tables (if needed)
-- ...

-- Committing the transaction
COMMIT;

select * from member;

select * from member where member_id = 'user123';
