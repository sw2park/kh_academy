SELECT	EMPLOYEE_ID , LAST_NAME , SALARY 
FROM 	EMPLOYEES e 
WHERE 	LAST_NAME = 'Smith'
AND 	e.SALARY = 8000;

-- 1. employees 테이블에서 department_id가 100이고, job_id가 FI_MGR인 사람의 모든 데이터 조회
SELECT	*
FROM 	EMPLOYEES e 
WHERE 	DEPARTMENT_ID = 100
AND 	e.JOB_ID = 'FI_MGR';

-- 2. employees 테이블에서 first_name이 Guy인 사람의 employee_id, first_name, last_name, job_id를 조회
SELECT 	EMPLOYEE_ID , FIRST_NAME , LAST_NAME , JOB_ID 
FROM 	EMPLOYEES e
WHERE 	FIRST_NAME = 'Guy';

-- 3. employees 테이블에서 department_id가 50이고, manager_id가 121인 사람의 employee_id, first_name, last_name, job_id 조회
SELECT	EMPLOYEE_ID , FIRST_NAME , LAST_NAME , JOB_ID 
FROM 	EMPLOYEES e 
WHERE 	DEPARTMENT_ID = 50
AND 	MANAGER_ID = 121;

-- as : 별칭, 알리아스 
SELECT 	EMPLOYEE_ID AS "ID" , 
		SALARY "SAL"
FROM 	EMPLOYEES e ;

-- distinct : 중복제거
SELECT 	DISTINCT DEPARTMENT_ID 
FROM 	EMPLOYEES e ;

SELECT 	DISTINCT JOB_ID 
FROM 	EMPLOYEES e ;

-- >, <, >=, <=
SELECT 	*
FROM 	EMPLOYEES e 
WHERE 	SALARY >= 5000;

-- or 
SELECT 	EMPLOYEE_ID , DEPARTMENT_ID , MANAGER_ID , LAST_NAME 
FROM 	EMPLOYEES e 
WHERE 	DEPARTMENT_ID = 50
OR 		MANAGER_ID = 100;

-- not
SELECT 	EMPLOYEE_ID , LAST_NAME , DEPARTMENT_ID 
FROM 	EMPLOYEES e 
WHERE 	NOT (DEPARTMENT_ID = 50);

-- not -> <>
SELECT 	EMPLOYEE_ID , LAST_NAME , DEPARTMENT_ID 
FROM 	EMPLOYEES e 
WHERE 	DEPARTMENT_ID <> 50;

-- not -> != 
SELECT 	EMPLOYEE_ID , LAST_NAME , DEPARTMENT_ID 
FROM 	EMPLOYEES e 
WHERE 	DEPARTMENT_ID != 50;

-- salary 4000 ~ 8000
SELECT 	EMPLOYEE_ID , FIRST_NAME , SALARY 
FROM 	EMPLOYEES e 
WHERE 	SALARY >= 4000
AND 	SALARY <= 8000;

-- salary 4000 ~ 8000 -> between A and B / 4000이상 8000이하
SELECT 	EMPLOYEE_ID , FIRST_NAME , SALARY 
FROM 	EMPLOYEES e 
WHERE 	SALARY BETWEEN 4000 AND 8000;

-- 급여가 6500 또는 7700 또는 13000인 사람 출력
-- employee_id, first_name, salary
SELECT 	EMPLOYEE_ID , FIRST_NAME , SALARY 
FROM 	EMPLOYEES e 
WHERE 	SALARY = 6500
OR 		SALARY = 7700
OR 		SALARY = 13000;

-- in()	-> or와 동일
SELECT 	EMPLOYEE_ID , FIRST_NAME , SALARY 
FROM 	EMPLOYEES e 
WHERE 	SALARY IN (6500, 7700, 13000);

/*
 * 1.employees 테이블에서 employee_id, first_name, 
 * last_anem, job_id를 출력하는데,
 * job_id가 ST_MAN이고, manager_id가 100이고, 
 * salary가 5000이상인 사람.
 */
SELECT 	EMPLOYEE_ID , FIRST_NAME , LAST_NAME , JOB_ID 
FROM 	EMPLOYEES e 
WHERE 	JOB_ID = 'ST_MAN'
AND 	MANAGER_ID = 100
AND 	SALARY >= 5000;

-- 2. EMPLOYEES 테이블에서 EMPLOYEE_ID, first_name, 
-- last_name, JOB_ID
-- MANAGER_ID, SALARY 를 조회
-- DEPARTMENT_ID가 10 또는 30 또는 100 또는 90에 속하고,
-- 급여(SALARY)가 5000에서 10000사이 이고
-- 매니저(MANAGER_ID)가 100이 아닌 사람을 조회
SELECT 	EMPLOYEE_ID , FIRST_NAME , LAST_NAME , JOB_ID , MANAGER_ID , SALARY 
FROM 	EMPLOYEES e 
WHERE 	e.DEPARTMENT_ID IN(10, 30, 100, 90) -- IN()절은 속도가 느리다.
AND 	SALARY BETWEEN 5000 AND 10000 
AND 	MANAGER_ID <> 100;

-- like -> 
SELECT 	EMPLOYEE_ID , FIRST_NAME , LAST_NAME 
FROM 	EMPLOYEES e 
WHERE 	FIRST_NAME LIKE 'D%'; -- LIKE절은 속도가 느리다.

-- like -> d로 끝나는 사람
SELECT 	EMPLOYEE_ID , FIRST_NAME , LAST_NAME 
FROM 	EMPLOYEES e 
WHERE 	e.FIRST_NAME LIKE '%d';

-- like -> __a%
SELECT 	EMPLOYEE_ID , FIRST_NAME , LAST_NAME 
FROM 	EMPLOYEES e 
WHERE 	FIRST_NAME LIKE '__a%';

-- is null
SELECT 	*
FROM 	EMPLOYEES e 
WHERE 	DEPARTMENT_ID IS NULL ;

-- is null
SELECT 	*
FROM 	EMPLOYEES e 
WHERE 	COMMISSION_PCT IS NULL ;

-- is not null
SELECT 	*
FROM 	EMPLOYEES e 
WHERE 	COMMISSION_PCT IS NOT NULL ;

-- order by asc -> 오름차순 정렬 (업무적
 중요함) / asc 생략가능
SELECT 	*
FROM 	EMPLOYEES e
ORDER BY FIRST_NAME , LAST_NAME;

-- order by desc -> 내림차순 정렬
SELECT 	*
FROM 	EMPLOYEES e 
ORDER BY SALARY DESC;

-- 합계 -> sum
SELECT 	sum(SALARY)
FROM 	EMPLOYEES e;

-- count() -> 카운트
SELECT 	COUNT(COMMISSION_PCT) 
FROM 	EMPLOYEES e ;

SELECT 	COUNT(FIRST_NAME), COUNT(DISTINCT FIRST_NAME) 
FROM 	EMPLOYEES e ;

-- 평균 -> avg()
SELECT 	AVG(SALARY) 
FROM 	EMPLOYEES e 
WHERE 	DEPARTMENT_ID = 80;

-- max() -> 최대값
SELECT 	MAX(SALARY) 
FROM 	EMPLOYEES e ;

SELECT  MAX(HIRE_DATE) 
FROM 	EMPLOYEES e ;

-- min() -> 최소값
SELECT 	MIN(SALARY) 
FROM	EMPLOYEES e;

SELECT	MIN(HIRE_DATE) 
FROM 	EMPLOYEES e;

-- 절대값 -> abs
SELECT 	ABS(-33) 
FROM 	dual;

-- 반올림 -> round()
SELECT 	ROUND(0.123), ROUND(0.5678) 
FROM 	dual;

-- trunc -> 절사(소수점을 다 잘라버림)
SELECT 	TRUNC(1234.5678) trunc 
FROM 	dual;

SELECT 	TRUNC(1234.5678, 2) trunc 
FROM 	dual;

SELECT 	TRUNC(1234.5678, -1) trunc 
FROM 	dual;

-- 1. 연봉이 12000 초과되는 직원들의 LAST_NAME 및 연봉을 조회한다.
-- 단, 급여 오름차순으로 조회
SELECT 	LAST_NAME , SALARY 
FROM 	EMPLOYEES e 
WHERE 	SALARY > 12000
ORDER BY SALARY ;

-- 2. 사원번호가 176 인 사람의 LAST_NAME 과 부서 번호를 조회한다.
SELECT 	LAST_NAME , DEPARTMENT_ID 
FROM 	EMPLOYEES e 
WHERE 	e.EMPLOYEE_ID = 176;

-- 3. 연봉이 5000 에서 12000의 범위 이외인 사람들의 
-- LAST_NAME 및 연봉을 조회힌다.
SELECT 	LAST_NAME , SALARY 
FROM	EMPLOYEES e 
WHERE 	NOT (SALARY BETWEEN 5000 AND 12000);

/*
* 4. 20 번 및 50 번 부서에서 근무하는 모든 사원들의 
* LAST_NAME, DEPARTMENT_ID
* 를 조회하고, LAST_NAME 알파벳순으로 정렬
*/
SELECT 	LAST_NAME , DEPARTMENT_ID 
FROM 	EMPLOYEES e
WHERE 	DEPARTMENT_ID = 20
OR	 	DEPARTMENT_ID = 50
ORDER  BY LAST_NAME ;

--  5. 20 번 및 50 번 부서에 근무하며, 
-- 연봉이 5000 ~ 12,000 사이인 사원들의 
-- LAST_NAME 및 연봉을 조회한다.
SELECT 	LAST_NAME , SALARY 
FROM 	EMPLOYEES e 
WHERE 	DEPARTMENT_ID IN (20, 50)
AND 	SALARY BETWEEN 5000 AND 12000;

--  6. LAST_NAME 첫 글자가 A 인 사원들의 LAST_NAME 을 조회한다.
SELECT 	LAST_NAME 
FROM 	EMPLOYEES e 
WHERE 	LAST_NAME LIKE 'A%';

--  7. 매니저가 없는 사람들의 LAST_NAME 및 JOB_ID 를 조회한다.
SELECT 	LAST_NAME , JOB_ID 
FROM 	EMPLOYEES e 
WHERE 	MANAGER_ID IS NULL ;

-- 문자열 연결 -> concat(char1, char2) ||
SELECT 	CONCAT('Hello','Bye'), CONCAT('good', 'bad') , 'good' || 'bad'
FROM 	dual;

-- 첫 글자를 대문자로 -> initcap
SELECT 	INITCAP('good morning')
FROM	dual;

-- 대/소문자 -> upper(char), lower(char)
SELECT 	UPPER('good morning') , LOWER('GOOD MORNING')
FROM	dual;

-- LPAD(값, 총문자길이, 채움문자)/RPAD(값, 총문자길이, 채움문자) / JAVA에서의 String Format
SELECT 	LPAD('good', 6), LPAD('good', 7, '#'), LPAD('good', 8, 'A') 
FROM	dual;

SELECT 	RPAD('good', 6), RPAD('good', 7, '#'), RPAD('good', 8, 'A')
FROM	dual;

-- 시간 -> sysdate
SELECT 	SYSDATE
FROM 	dual;

-- 7개월을 더한다 -> add_months()
SELECT 	ADD_MONTHS(SYSDATE, 7)
FROM 	dual;

-- 현재달의 마지막 날짜 -> last_day
SELECT 	LAST_DAY(SYSDATE)
FROM	dual;

SELECT 	SYSDATE +(INTERVAL '1' YEAR)
,		SYSDATE +(INTERVAL '1' MONTH)
,		SYSDATE +(INTERVAL '1' DAY)
,		SYSDATE +(INTERVAL '1' HOUR)
,		SYSDATE +(INTERVAL '1' MINUTE)
,		SYSDATE +(INTERVAL '1' SECOND)
FROM dual;

-- to_char() 문자열 변환
SELECT 	TO_CHAR(SYSDATE, 'yyyy/mm/dd'), SYSDATE 
FROM	dual;

SELECT 	TO_CHAR(SYSDATE, 'yyyymmdd')
,		TO_CHAR(SYSDATE, 'yyyy/mm/dd')
,		TO_CHAR(SYSDATE, 'yyyy-mm-dd')
,		TO_CHAR(SYSDATE, 'yyyy-mm-dd HH24:MI:SS')
FROM 	dual;

-- 날짜형으로 변환 - to_date()
SELECT 	TO_DATE('2024/07/30', 'yyyy/mm/dd')
FROM	dual;

-- nvl() : 널값을 다른 데이터로 변경하는 함수
SELECT 	FIRST_NAME , LAST_NAME , COMMISSION_PCT
,		NVL(COMMISSION_PCT, 0) commission 
FROM 	EMPLOYEES e ;

-- JAVA에서의 switch문의 역할을 하는 함수 : decode()
SELECT 	DEPARTMENT_ID , DECODE(DEPARTMENT_ID, 20, 'MA', 60, 'IT', 90, 'EX', 'ETC') decode  
FROM 	DEPARTMENTS d ;

-- case - when 
SELECT 	FIRST_NAME , DEPARTMENT_ID 
, 		CASE WHEN DEPARTMENT_ID = 20 THEN 'MA'
			 WHEN DEPARTMENT_ID = 60 THEN 'IT'
			 WHEN DEPARTMENT_ID = 90 THEN 'EX'
			 ELSE 'ETC'
		END "departments"
FROM 	EMPLOYEES e  ;

/*
문제1) EMPLOYEES 테이블에서 King의 정보를 소문자로 검색하고
사원번호,성명, 담당업무(소문자로),부서번호를 출력하라.
*/
SELECT 	EMPLOYEE_ID , FIRST_NAME , LAST_NAME , LOWER(JOB_ID), DEPARTMENT_ID 
FROM 	EMPLOYEES e 
WHERE 	LOWER(e.LAST_NAME) = 'king' ;

/*
문제2) EMPLOYEES 테이블에서 King의 정보를 대문자로 검색하고 사원번호,
성명, 담당업무(대문자로),부서번호를 출력하라.
*/

SELECT 	EMPLOYEE_ID , FIRST_NAME , LAST_NAME , UPPER(JOB_ID), DEPARTMENT_ID 
FROM 	EMPLOYEES e 
WHERE 	UPPER(e.LAST_NAME) = 'KING'; 

/*
문제3) DEPARTMENTS 테이블에서 부서번호와 부서이름, 
위치번호를 합하여 출력하도록 하라.(||사용)
*/
SELECT  DEPARTMENT_ID || DEPARTMENT_NAME  || LOCATION_ID 
FROM 	DEPARTMENTS d ;

/*
문제4) EMPLOYEES 테이블에서 30번 부서 중 사원번호 이름과 
담당자 아이디(manager_id)를 연결하여 출력하여라. (concat 사용)
*/
SELECT 	CONCAT(CONCAT(EMPLOYEE_ID , LAST_NAME), MANAGER_ID) 
FROM 	EMPLOYEES e 
WHERE 	DEPARTMENT_ID = 30;


/*
 * 문제 5. SALARY+SALARY*nvl(COMMISSION_PCT ,0) 이 
 * 10000이상이면, 'good' 
 * 5000 이상이면, 'average', 
 * 1이상 5000미만이면 'bad'
      0이면 no good 로 평가하고  
   EMPLOYEE_ID ,FIRST_NAME , SALARY ,COMMISSION_PCT, 
    SALARY+SALARY*nvl(COMMISSION_PCT ,0) 평가를 출력해라.
 */
SELECT 	EMPLOYEE_ID , FIRST_NAME , SALARY , COMMISSION_PCT 
, 		CASE WHEN SALARY+SALARY*nvl(COMMISSION_PCT , 0) >= 10000 THEN 'good'
			 WHEN SALARY+SALARY*nvl(COMMISSION_PCT , 0) >= 5000 THEN 'average'
			 WHEN SALARY+SALARY*nvl(COMMISSION_PCT , 0) = 0 THEN 'no good'
			 ELSE 'bad'
		END 
FROM 	EMPLOYEES e ;

-- 강사쌤이 한것
SELECT 	EMPLOYEE_ID , FIRST_NAME , SALARY, COMMISSION_PCT 
, 		SALARY + SALARY * nvl(COMMISSION_PCT, 0) AS sal
,		CASE WHEN SALARY+SALARY*nvl(COMMISSION_PCT , 0) >= 10000 THEN 'good'
			 WHEN SALARY+SALARY*nvl(COMMISSION_PCT , 0) >= 5000 THEN 'average'
			 WHEN SALARY+SALARY*nvl(COMMISSION_PCT , 0) >= 1 THEN 'bad'
			 WHEN SALARY+SALARY*nvl(COMMISSION_PCT , 0) = 0 THEN 'no good'
		END AS grade
FROM 	EMPLOYEES e 
ORDER BY sal;
