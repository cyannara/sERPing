-- 2025-02-11

-- 테이블 삭제 명령문
select 'drop table'|| ' ' || table_name || ';'
from user_tables;

-- 테이블 컬럼 추가 명령문
select 'ALTER TABLE '|| table_name ||' ADD company_num NUMBER(6,0);'
from user_tables
where table_name like 'ACCNUT_'||'%';

create table accnut_assets(
    assets_code varchar2(50) primary key,
    assets_name varchar2(100) not null,
    section varchar2(20) not null,
    financial_institution varchar2(20),
    finance_information varchar2(30),
    owner varchar2(100),
    amount number(12,0),
    register_date date default sysdate,
    quantity number(10),
    fixtures_amount number(12,0)
);
insert into accnut_assets( assets_code, assets_name, section, financial_institution, finance_information, owner, amount, register_date, quantity, fixtures_amount)
values ('a1001','초기 소지 현금1','AC01','FI01','-','본사',1000, sysdate, 100, 10);
insert into accnut_assets( assets_code, assets_name, section, financial_institution, finance_information, owner, amount, register_date, quantity, fixtures_amount)
values ('a1002','초기 소지 현금2','AC01','FI01','-','본사',10000, sysdate, 100, 100);
insert into accnut_assets( assets_code, assets_name, section, financial_institution, finance_information, owner, amount, register_date, quantity, fixtures_amount)
values ('a1003','초기 소지 현금3','AC01','FI01','-','본사',100000, sysdate, 100, 1000);
insert into accnut_assets( assets_code, assets_name, section, financial_institution, finance_information, owner, amount, register_date, quantity, fixtures_amount)
values ('a1004','초기 소지 현금4','AC01','FI01','-','본사',500000, sysdate, 100, 5000);
insert into accnut_assets( assets_code, assets_name, section, financial_institution, finance_information, owner, amount, register_date, quantity, fixtures_amount)
values ('a1005','초기 소지 현금5','AC01','FI01','-','본사',1000000, sysdate, 100, 10000);
insert into accnut_assets( assets_code, assets_name, section, financial_institution, finance_information, owner, amount, register_date, quantity, fixtures_amount)
values ('a1006','초기 소지 현금6','AC01','FI01','-','본사',5000000, sysdate, 100, 50000);
insert into accnut_assets( assets_code, assets_name, section, financial_institution, finance_information, owner, amount, register_date, quantity, fixtures_amount)
values ('a1007','초기 소지 현금7','AC01','FI01','-','본사',10000000, sysdate, 100, 100000);

select assets_code, assets_name, fn_get_cmmn_name(section), fn_get_cmmn_code(fn_get_cmmn_name(financial_institution)), finance_information, owner, amount, register_date, quantity, fixtures_amount
from accnut_assets;

commit;

insert into cmmn(cmmn_code,cmmn_name)
values ('AC', '계정과목');
insert into cmmn(cmmn_code,upper_cmmn_code, cmmn_name)
values ('AC01','AC', '현금');
insert into cmmn(cmmn_code, cmmn_name)
values ('FI', '금융기관구분');
insert into cmmn(cmmn_code,upper_cmmn_code, cmmn_name)
values ('FI01','FI' , '농협');

select * from cmmn;


-- 2025-02-12
select * from accnut_assets;
update accnut_assets
set company_num = 0;
commit;

create SEQUENCE assets_seq;


INSERT INTO accnut_assets
SELECT assets_seq.NEXTVAL, assets_name, section, financial_institution, finance_information, owner, amount, register_date, quantity, fixtures_amount, company_num
FROM accnut_assets;

update accnut_assets set company_num = 1;

commit;

select fn_get_cmmn_code('가')
from dual;


select * from hr_employee;

