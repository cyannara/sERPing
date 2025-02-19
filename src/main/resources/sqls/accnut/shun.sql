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

select * from erp_company;
select * from hr_employee;


SELECT debt_code, debt_name, section, creditor, amount, interest, register_date
FROM (SELECT /*+INDEX_DESC(accnut_debt pk_accnut_debt)*/ rownum rn, debt_code, debt_name, fn_get_cmmn_name(section) as section, creditor, amount, interest, register_date
		FROM accnut_debt
        WHERE rownum <= 40 
        AND company_num = 0
--        AND rownum >=1
        )
WHERE rn >= 21
;

select * from accnut_dealings_account_book;


-- 2025-02-14
SELECT dealings_account_book_code, section, types_of_transaction, amount, vat_alternative, dealings_contents, deal_date, department, company_num
FROM accnut_dealings_account_book
--;
WHERE to_char(deal_date, 'yyyy-mm-dd') = '2025-02-14'
;
--WHERE dealings_account_book_code = #{dealingsAccountBookCode}
--;
select to_char(to_timestamp('02/14/2025 00:00:00.000', 'mm/dd/yyyy hh24:mi:ss.ff3'), 'yyyy-mm-dd') from dual;
create sequence accnut_dealings_book_seq;
commit;

insert into accnut_dealings_account_book values (ACCNUT_DEALINGS_BOOK_SEQ.nextval, fn_get_cmmn_code('부채'), fn_get_cmmn_code('통장'), 100000, 'Y', 'A회사 미지급금1', sysdate, fn_get_cmmn_code('본사'), 0);

insert into accnut_dealings_account_book
select ACCNUT_DEALINGS_BOOK_SEQ.nextval, section, types_of_transaction, amount, vat_alternative, dealings_contents, deal_date, department, company_num
from accnut_dealings_account_book;

select fn_get_cmmn_code('지점') from dual;
select * from cmmn;
select * from cmmn where cmmn_code like upper('%dt%');
select * from cmmn where cmmn_code like upper('%ee%');
select * from cmmn where cmmn_code like upper('%py%');
select * from cmmn where cmmn_code like upper('%pc%');
select * from cmmn where cmmn_code like upper('%ac%');
select * from cmmn where cmmn_code like upper('%ca%');

insert into cmmn(cmmn_code, cmmn_name, description) values ('FI','금융기관구분','은행 및 카드사');
insert into cmmn(cmmn_code, cmmn_name, description) values ('EE','수익여부구분','수익인지 지출인지 자산인지 부채인지');
insert into cmmn(cmmn_code, cmmn_name, description) values ('PY','지급여부구분','지급 미지급');
insert into cmmn(cmmn_code, cmmn_name, description) values ('PC','처리여부구분','처리 반려 미처리');
insert into cmmn(cmmn_code, cmmn_name, description) values ('AC','계정과목구분','어떤 계정과목인지');
insert into cmmn(cmmn_code, cmmn_name, description) values ('CA','카드구분','개인인지 법인인지');

insert into cmmn(cmmn_code, upper_cmmn_code, cmmn_name) values ('FI01','FI','농협');
insert into cmmn(cmmn_code, upper_cmmn_code, cmmn_name) values ('FI02','FI','국민');
insert into cmmn(cmmn_code, upper_cmmn_code, cmmn_name) values ('FI03','FI','기업');
insert into cmmn(cmmn_code, upper_cmmn_code, cmmn_name) values ('FI04','FI','신한');
insert into cmmn(cmmn_code, upper_cmmn_code, cmmn_name) values ('FI05','FI','IM(대구)');
insert into cmmn(cmmn_code, upper_cmmn_code, cmmn_name) values ('FI06','FI','하나');
insert into cmmn(cmmn_code, upper_cmmn_code, cmmn_name) values ('FI07','FI','우리');

insert into cmmn(cmmn_code, upper_cmmn_code, cmmn_name) values ('EE01','EE','수익');
insert into cmmn(cmmn_code, upper_cmmn_code, cmmn_name) values ('EE02','EE','지출');
insert into cmmn(cmmn_code, upper_cmmn_code, cmmn_name) values ('EE03','EE','자산');
insert into cmmn(cmmn_code, upper_cmmn_code, cmmn_name) values ('EE04','EE','부채');

insert into cmmn(cmmn_code, upper_cmmn_code, cmmn_name) values ('PY01','PY','미지급');
insert into cmmn(cmmn_code, upper_cmmn_code, cmmn_name) values ('PY02','PY','지급');

insert into cmmn(cmmn_code, upper_cmmn_code, cmmn_name) values ('PC01','PC','미처리');
insert into cmmn(cmmn_code, upper_cmmn_code, cmmn_name) values ('PC02','PC','처리');
insert into cmmn(cmmn_code, upper_cmmn_code, cmmn_name) values ('PC03','PC','반려');

insert into cmmn(cmmn_code, upper_cmmn_code, cmmn_name) values ('CA01','CA','개인');
insert into cmmn(cmmn_code, upper_cmmn_code, cmmn_name) values ('CA02','CA','법인');

insert into cmmn(cmmn_code, upper_cmmn_code, cmmn_name) values ('AC01','AC','현금');
insert into cmmn(cmmn_code, upper_cmmn_code, cmmn_name) values ('AC02','AC','통장');
insert into cmmn(cmmn_code, upper_cmmn_code, cmmn_name) values ('AC03','AC','카드');
insert into cmmn(cmmn_code, upper_cmmn_code, cmmn_name) values ('AC04','AC','비품');
insert into cmmn(cmmn_code, upper_cmmn_code, cmmn_name) values ('AC05','AC','토지');
insert into cmmn(cmmn_code, upper_cmmn_code, cmmn_name) values ('AC06','AC','건물');
insert into cmmn(cmmn_code, upper_cmmn_code, cmmn_name) values ('AC07','AC','대출금');
insert into cmmn(cmmn_code, upper_cmmn_code, cmmn_name) values ('AC08','AC','미지급금');
insert into cmmn(cmmn_code, upper_cmmn_code, cmmn_name) values ('AC09','AC','외상매입금');
insert into cmmn(cmmn_code, upper_cmmn_code, cmmn_name) values ('AC10','AC','예수금');
insert into cmmn(cmmn_code, upper_cmmn_code, cmmn_name) values ('AC11','AC','선수금');
insert into cmmn(cmmn_code, upper_cmmn_code, cmmn_name) values ('AC12','AC','사채');
insert into cmmn(cmmn_code, upper_cmmn_code, cmmn_name) values ('AC13','AC','임대보증금');
insert into cmmn(cmmn_code, upper_cmmn_code, cmmn_name) values ('AC14','AC','자본금');
insert into cmmn(cmmn_code, upper_cmmn_code, cmmn_name) values ('AC15','AC','이익잉여금');
insert into cmmn(cmmn_code, upper_cmmn_code, cmmn_name) values ('AC16','AC','매출액');
insert into cmmn(cmmn_code, upper_cmmn_code, cmmn_name) values ('AC17','AC','용역수익');
insert into cmmn(cmmn_code, upper_cmmn_code, cmmn_name) values ('AC18','AC','이자수익');
insert into cmmn(cmmn_code, upper_cmmn_code, cmmn_name) values ('AC19','AC','급여');
insert into cmmn(cmmn_code, upper_cmmn_code, cmmn_name) values ('AC20','AC','임차료');
insert into cmmn(cmmn_code, upper_cmmn_code, cmmn_name) values ('AC21','AC','판매비');
insert into cmmn(cmmn_code, upper_cmmn_code, cmmn_name) values ('AC22','AC','광고비');
insert into cmmn(cmmn_code, upper_cmmn_code, cmmn_name) values ('AC23','AC','운반비');
insert into cmmn(cmmn_code, upper_cmmn_code, cmmn_name) values ('AC24','AC','감가상각비');
insert into cmmn(cmmn_code, upper_cmmn_code, cmmn_name) values ('AC25','AC','법인세비');

select * from accnut_salary_account_book;

select * from accnut_debt where section = 'AC08';
commit;

-- 2025-02-17

create sequence accnut_salary_book_seq;

SELECT * FROM accnut_salary_account_book;
insert into accnut_salary_account_book(SALARY_ACCOUNT_BOOK_CODE, EMPLOYEE_CODE, EMPLOYEE_NAME, SALARY, PAYMENT_AMOUNT, PAYMENT_ALTERNATIVE)
values(ACCNUT_SALARY_BOOK_SEQ.nextval, 'emp003', '홍길동',5000, 5000, 'PY02');


SELECT lower(column_name)  as "컬럼명", data_type, nullable FROM COLS where  lower(table_name) = 'accnut_incidental_cost' order by column_id;


select * from accnut_etc_payment;

INSERT INTO accnut_etc_payment(ETC_PAYMENT_CODE, SECTION, TIME_LIMIT, AMOUNT, PAYMENT_ALTERNATIVE, COMPANY_NUM)
VALUES (ACCNUT_ETC_PAYMENT_SEQ.nextval, 'AC20', sysdate, 5000, 'PY01', 0);

CREATE SEQUENCE accnut_etc_payment_seq;

select * from cmmn where upper_cmmn_code like 'CA';
select * from cmmn where cmmn_name like '%처리%';

insert into cmmn(cmmn_code , upper_cmmn_code, cmmn_name)
values ('AC26', 'AC', '운영비');
commit;

create sequence accnut_incidental_seq;

insert into accnut_incidental_cost(incidental_cost_code, section, card_num, amount, register_date, process_alternative, company_num)
values( ACCNUT_INCIDENTAL_SEQ.nextval, 'CA02', '123456789' , 1000, sysdate, 'PC01', 0);

select * from accnut_assets;
update accnut_assets set section = 'AC04' where assets_code = '3';

select * from cmmn where upper_cmmn_code = 'AC';
select * from cmmn where upper_cmmn_code = 'EE';


-- 2025-02-18

select * from accnut_assets;

SELECT /*+INDEX_DESC(ACCNUT_ASSETS PK_ACCNUT_ASSETS)*/ rownum rn, assets_code, assets_name, fn_get_cmmn_name(section) as section, fn_get_cmmn_name(financial_institution) as financial_institution, finance_information, owner, NVL(amount,0) as amount, register_date, NVL(quantity, 0) as quantity, NVL(fixtures_amount, 0) as fixtures_amount 
		      FROM accnut_assets;
              
UPDATE ACCNUT_ASSETS SET assets_code = '0' + assets_code where TO_NUMBER(assets_code, '999999') < 10;
Commit;
select * from accnut_dealings_account_book order by 1 desc;
select accnut_dealings_book_seq.nextval from dual;

update (select a.quantity as asd, b.quantity as def
        from bhf_warehouse a, bhf_returning_detail b
        where a.option_code = b.option_code) c
set c.asd = (c.asd - c.def);

UPDATE (SELECT e.salary AS emp_salary, d.bonus AS dept_bonus
        FROM employees e
        JOIN departments d ON e.dept_id = d.dept_id)
SET emp_salary = emp_salary + dept_bonus;

UPDATE (SELECT a.quantity as asd, b.quantity as def, a.warehouse_code, b.returning_detail_code
        FROM bhf_warehouse a
        JOIN bhf_returning_detail b ON a.option_code = b.option_code)
SET asd = (asd - def);
