-- semitest
alter session set "_oracle_script" = true;

create user semitest
identified by semitest
default tablespace users;

grant connect, resource to semitest;

alter user semitest quota unlimited on users;

-- Áú´ä °Ô½ÃÆÇ QnAtest Å×ÀÌºí (Å×½ºÆ®¿ë)
create table semitest(
                         qb_no varchar2(10),
                         member_no varchar2(10),
                         title varchar2(50),
                         content varchar2(2000),
                         count number,
                         reg_date date default sysdate,
                         constraint pk_semitest_qb_no primary key(qb_no)
);

create sequence seq_qb_no;

insert into semitest.semitest(qb_no,member_no,title,content,count,reg_date) values(seq_qb_no.nextval,'12','¾È³çÇÏ¼¼¿ë','ºí¶óºí¶ó ¾â¶ó¸®¾â¶ó',default, default);
insert into semitest.semitest(qb_no,member_no,title,content,count,reg_date) values(seq_qb_no.nextval,'133','ÇÏÀÌÇÏÀÌ','ÇÏÇÏÇÏÇÏÇÏ',default, default);
insert into semitest.semitest(qb_no,member_no,title,content,count,reg_date) values(seq_qb_no.nextval,'14','ÄíÄíÄí','”îÁñ',default, default);
insert into semitest.semitest(qb_no,member_no,title,content,count,reg_date) values(seq_qb_no.nextval,'22','Å©Å©Å©','Áñ°Å¿ö¿ä',default, default);
insert into semitest.semitest(qb_no,member_no,title,content,count,reg_date) values(seq_qb_no.nextval,'77','È£È£È£','¹İ°¡¿ö¿äÈ£È£',default, default);
insert into semitest.semitest(qb_no,member_no,title,content,count,reg_date) values(seq_qb_no.nextval,'33','¹ò¹ò¹ò¹ò','ÇÏÇÏÇÏÇáÇá',default, default);
insert into semitest.semitest(qb_no,member_no,title,content,count,reg_date) values(seq_qb_no.nextval,'1','À¯À¯À¯À¯','¾È³çÇÏ¼Ò',default, default);
select * from semitest;


-- DROP SEQUENCE seq_qb_no;
-- drop table semitest;
