SELECT * FROM EMP_DETAILS_VIEW edv ;

-- job_id가 ST_CLERK인 사원들의 사번, 이름, 직업, 고용일, 부서 아이디를 뷰로 생성
-- 뷰 생성
CREATE VIEW v_emp(emp_id, first_name, job_id, hiredate, dept_id)
AS 
SELECT  employee_id, first_name, job_id, hire_date, department_id
FROM 	EMPLOYEES e 
WHERE 	job_id = 'ST_CLERK';

SELECT * FROM V_EMP ve ;

-- 뷰 삭제
DROP VIEW V_EMP ;

-- job_id가 SH_CHERK인 사원들의 emp_id, first_name, job_id, hiredate, dept_id, comission_pct를 가진 view 생성.
-- 단, comission_pct가 null일 경우 0으로 출력되는 view를 생성
-- or replace << 동일 이름의 테이블이나 뷰가 존재할 시 기존의 테이블을 drop하고 새로 생성함. 
CREATE OR REPLACE VIEW v_emp(emp_id, first_name, job_id, hiredate, dept_id, commission_pct)
AS 
SELECT  employee_id, first_name, job_id, hire_date, department_id, NVL(commission_pct, 0) 
FROM 	EMPLOYEES e 
WHERE 	job_id = 'SH_CLERK';

DROP VIEW V_EMP ;
SELECT * FROM V_EMP ve ;

SELECT * FROM EMPLOYEES e;

-- 180번 사원의 이름이 현재 Winston이다.
-- 이름을 kim으로 수정하자.
UPDATE V_EMP SET first_name = 'Winston'
WHERE emp_id = 180;

SELECT * FROM V_EMP ve ;

-- 180번 사원의 commission_pct를 0.5로 수정
-- 함수로 작성된 부분은 수정 불가 
UPDATE V_EMP SET COMMISSION_PCT = 0.5
WHERE EMP_ID = 180;

SELECT	FIRST_NAME , COMMISSION_PCT 
FROM 	EMPLOYEES e 
WHERE 	EMPLOYEE_ID = 180;

-- emp_id, last_name, annual_sal
-- employee_id, last_name, (salary+salary * nvl(commission_pct, 0))*12
-- read_only 옵션
CREATE OR REPLACE VIEW v_emp(employee_id, last_name, annual_sal)
AS 
SELECT  employee_id, last_name, (salary+salary * nvl(commission_pct, 0))*12
FROM 	EMPLOYEES e 
WITH 	READ ONLY;

SELECT * FROM V_EMP ve ;

-- 100번 사원의 last_name을 king -> kim으로 수정
UPDATE V_EMP SET LAST_NAME = 'kim'
WHERE EMPLOYEE_ID = 100;

/*
 * 1. salary가 3000이상이고, 부서가 50번이고, job_ud가 'ST_CLERK'인 사용자의 emp_id, last_name, dept_id, hire_date까지 출력
 */
CREATE OR REPLACE VIEW qa_one(employee_id, last_name, dept_id, hire_date)
AS
SELECT employee_id, last_name, department_id, hire_date
FROM EMPLOYEES e 
WHERE salary >= 3000
AND department_id = 50
AND job_id = 'ST_CLERK';

SELECT EMPLOYEE_ID ,LAST_NAME ,DEPT_ID ,HIRE_DATE 
FROM QA_ONE qo ;

/*
 * 2. emp_id, name(first_name last_name), dept_id, hire_date
 * 단, 50번 부서의 사원
 */
CREATE OR REPLACE VIEW qa_two(emp_id, name, dept_id, hire_date)
AS 
SELECT employee_id, CONCAT(CONCAT(first_name, ' '), last_name), department_id, hire_date  
FROM EMPLOYEES e 
WHERE department_id = 50;

SELECT * FROM qa_two;

/*
 * 3. emp_id, fisrt_name, dept_id, dept_name
 */
CREATE OR REPLACE VIEW qa_three(emp_id, first_name, dept_id, dept_name)
AS 
SELECT e.employee_id, e.first_name, d.department_id, d.department_name
FROM EMPLOYEES e 
LEFT OUTER JOIN DEPARTMENTS d ON e.department_id = d.department_id;

SELECT * FROM QA_THREE qt ;

-- index
-- 테스트를 위한 테이블 복사
CREATE TABLE EMPLOYEES3 AS SELECT * FROM EMPLOYEES e ;
SELECT * FROM EMPLOYEES3 e ;

-- index에 활용되는 rowid
SELECT 	rowid, EMPLOYEE_ID 
FROM 	EMPLOYEES3 e 
WHERE 	EMPLOYEE_ID = 200;

-- 중복 데이터를 만들어보자
INSERT INTO EMPLOYEES3 e (employee_id, first_name, last_name) VALUES(100, 'kim', 'Chen');
SELECT * FROM EMPLOYEES3 e WHERE EMPLOYEE_ID = 100;

-- unique index 생성
CREATE UNIQUE INDEX idx_emp_id ON employees3(employee_id);

-- Kim Chen 데이터 2건 삭제 후, unique index 걸어주기
DELETE FROM employees3 
WHERE first_name = 'kim'
AND LAST_name = 'Chen';
CREATE UNIQUE INDEX idx_emp_id ON employees3(employee_id); 
INSERT INTO EMPLOYEES3 e (employee_id, first_name, last_name) VALUES(100, 'Steven', 'King');

SELECT * FROM EMPLOYEES3 e WHERE FIRST_NAME = 'kim' AND LAST_NAME = 'Chen';

-- non-unique index 생성
CREATE INDEX idx_emp_first ON employees3(first_name);
SELECT  * FROM EMPLOYEES3 e WHERE FIRST_NAME = 'TJ';
INSERT INTO EMPLOYEES3 e (employee_id, first_name, last_name) VALUES (500, 'TJ', 'name');