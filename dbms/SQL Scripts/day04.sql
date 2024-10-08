-- 문제1) 사원들의 이름, 부서번호, 부서명을 출력하라
SELECT 	e.FIRST_NAME , d.DEPARTMENT_ID , d.DEPARTMENT_NAME 
FROM 	EMPLOYEES e 
LEFT OUTER JOIN DEPARTMENTS d ON e.DEPARTMENT_ID = d.DEPARTMENT_ID ;

-- 문제2) 30번 부서의 사원들의 이름,직업,부서명을 출력하라
SELECT 	e.FIRST_NAME , e.JOB_ID , d.DEPARTMENT_NAME 
FROM 	EMPLOYEES e 
LEFT OUTER JOIN DEPARTMENTS d ON e.DEPARTMENT_ID = d.DEPARTMENT_ID 
WHERE 	e.DEPARTMENT_ID = 30;

-- 문제3) 커미션을 받는 사원의 이름, 직업, 부서번호,부서명을 출력하라
SELECT 	e.FIRST_NAME , e.JOB_ID , d.DEPARTMENT_ID , d.DEPARTMENT_NAME 
FROM 	EMPLOYEES e 
LEFT OUTER JOIN DEPARTMENTS d ON e.DEPARTMENT_ID = d.DEPARTMENT_ID 
WHERE 	e.COMMISSION_PCT IS NOT NULL ;

-- 문제4) 지역번호 2500 에서 근무하는 
-- 사원의 이름, 직업,부서번호,부서명을 출력하라
SELECT 	e.FIRST_NAME , e.JOB_ID , d.DEPARTMENT_ID , d.DEPARTMENT_NAME 
FROM 	EMPLOYEES e 
LEFT OUTER JOIN DEPARTMENTS d ON e.DEPARTMENT_ID = d.DEPARTMENT_ID 
WHERE 	d.LOCATION_ID = 2500;

-- 문제5) 이름에 A가 들어가는 사원들의 이름과 부서이름을 출력하라
SELECT 	e.FIRST_NAME , d.DEPARTMENT_NAME 
FROM 	EMPLOYEES e 
LEFT OUTER JOIN DEPARTMENTS d ON e.DEPARTMENT_ID = d.DEPARTMENT_ID 
WHERE 	e.FIRST_NAME LIKE '%A%';

-- 문제6) 사원이름과 그 사원의 관리자 이름을 출력하라 >> ???
SELECT 	e.FIRST_NAME , e.FIRST_NAME 
FROM 	EMPLOYEES e 
LEFT OUTER JOIN DEPARTMENTS d ON e.DEPARTMENT_ID = d.DEPARTMENT_ID
WHERE 	d.MANAGER_ID = e.MANAGER_ID ;

SELECT 	e.first_name, e2.FIRST_NAME , e.employee_id, e2.EMPLOYEE_ID 
FROM 	EMPLOYEES e 
INNER JOIN EMPLOYEES e2 ON e.manager_id = e2. EMPLOYEE_ID
ORDER BY e.emloyee_id ; 

SELECT 	e.first_name AS 사원명, e.employee_id, ee.FIRST_NAME AS 매니저명, ee.EMPLOYEE_ID 
FROM 	EMPLOYEES e 
INNER JOIN EMPLOYEES ee ON e.MANAGER_ID = ee.EMPLOYEE_ID 
ORDER BY e.employee_id; 

-- 문제7) 사원이름과 부서명과 월급을 출력하는데 
-- 월급이 3000 이상인 사원을 출력하라
SELECT 	e.FIRST_NAME , d.DEPARTMENT_NAME , e.SALARY 
FROM 	EMPLOYEES e 
LEFT OUTER JOIN DEPARTMENTS d ON e.DEPARTMENT_ID = d.DEPARTMENT_ID 
WHERE 	e.SALARY >= 3000;

-- 문제8) 급여가 3000에서 5000사이인 사원의 이름과 소속부서명 출력하라
SELECT 	e.FIRST_NAME , d.DEPARTMENT_NAME 
FROM 	EMPLOYEES e 
LEFT OUTER JOIN DEPARTMENTS d ON e.DEPARTMENT_ID = d.DEPARTMENT_ID 
WHERE 	e.SALARY BETWEEN 3000 AND 5000;

-- 문제9) 급여가 3000이하인 사원의 이름과 급여, 
-- 근무지(location_id, city)를 출력하라
SELECT 	e.FIRST_NAME , e.SALARY , l.LOCATION_ID , l.CITY 
FROM 	EMPLOYEES e 
LEFT OUTER JOIN DEPARTMENTS d ON e.DEPARTMENT_ID = d.DEPARTMENT_ID 
LEFT OUTER JOIN LOCATIONS l ON d.LOCATION_ID = l.LOCATION_ID 
WHERE 	e.SALARY <= 3000;

-- 문제10) Steven King의 부서명을 출력하라.
SELECT 	d.DEPARTMENT_NAME 
FROM 	EMPLOYEES e 
LEFT OUTER JOIN DEPARTMENTS d ON e.DEPARTMENT_ID = d.DEPARTMENT_ID 
WHERE 	e.FIRST_NAME = 'Steven'
AND 	e.LAST_NAME = 'King';

-- 문제11) IT부서에서 근무하고 있는 사람들을 출력하라.
SELECT 	e.FIRST_NAME 
FROM 	EMPLOYEES e 
LEFT OUTER JOIN DEPARTMENTS d ON e.DEPARTMENT_ID = d.DEPARTMENT_ID 
WHERE 	d.DEPARTMENT_NAME = 'IT';

-- 문제12) EMPLOYEES 테이블에서 사원번호,이름,업무, 
-- EMPLOYEES 테이블의 부서번호, 
-- DEPARTMENTS 테이블의 부서번호,부서명,근무지를 출력하여라.
SELECT 	e.EMPLOYEE_ID , e.FIRST_NAME , e.JOB_ID , e.DEPARTMENT_ID , d.DEPARTMENT_ID , d.DEPARTMENT_NAME , l.CITY 
FROM 	EMPLOYEES e 
LEFT OUTER JOIN DEPARTMENTS d ON e.DEPARTMENT_ID = d.DEPARTMENT_ID
LEFT OUTER JOIN LOCATIONS l ON d.LOCATION_ID = l.LOCATION_ID ;

-- 문제13) EMPLOYEES 테이블과 
-- DEPARTMENTS 테이블의 부서번호를 조인하고 
-- SA_MAN 사원만의 사원번호,이름,급여,부서명,근무지를 출력하라.
SELECT 	e.EMPLOYEE_ID , e.FIRST_NAME , e.SALARY , d.DEPARTMENT_NAME , l.CITY
FROM 	EMPLOYEES e 
LEFT OUTER JOIN DEPARTMENTS d ON e.DEPARTMENT_ID = d.DEPARTMENT_ID 
LEFT OUTER JOIN LOCATIONS l ON d.LOCATION_ID = l.LOCATION_ID 
WHERE 	e.JOB_ID = 'SA_MAN';

-- 서브쿼리
-- 평균 급여보다 적게 받는 사람
SELECT	*
FROM 	EMPLOYEES e 
WHERE 	e.SALARY < (SELECT ROUND(AVG(SALARY)) FROM EMPLOYEES e);

-- 1400, 1500, 1600, 1700
SELECT 	LOCATION_ID FROM LOCATIONS l WHERE 	COUNTRY_ID = 'US';

SELECT 	* FROM DEPARTMENTS d 
WHERE 	LOCATION_ID IN (SELECT LOCATION_ID FROM LOCATIONS l WHERE COUNTRY_ID = 'US');

-- 월급이 가장 적은 사원
SELECT  min(SALARY) FROM EMPLOYEES e ;

SELECT 	*
FROM 	EMPLOYEES e 
WHERE 	SALARY = (SELECT  min(SALARY) FROM EMPLOYEES e);

-- 월급이 가장 많은 사원
SELECT 	MAX(SALARY)	FROM EMPLOYEES e ;

SELECT 	* FROM EMPLOYEES e 
WHERE 	SALARY = (SELECT MAX(SALARY) FROM EMPLOYEES e);

-- 평균 급여보다 많이 받는 사원들
SELECT AVG(SALARY) FROM EMPLOYEES e;

SELECT * FROM EMPLOYEES e 
WHERE SALARY > (SELECT AVG(SALARY) FROM EMPLOYEES e)
ORDER BY SALARY ;

-- 문제1) EMPLOYEES 테이블에서 Kochhar의 급여보다 많은 
-- 사원의 정보를 사원번호,이름,담당업무,급여를 출력하라.
SELECT SALARY FROM EMPLOYEES e WHERE LAST_NAME = 'Kochhar';
SELECT EMPLOYEE_ID, FIRST_NAME, JOB_ID, SALARY FROM EMPLOYEES e 
WHERE SALARY > (SELECT SALARY FROM EMPLOYEES e WHERE LAST_NAME = 'Kochhar');

-- 문제2) EMPLOYEES 테이블에서 급여의 평균보다 적은 사원의 
-- 사원번호,이름,담당업무,급여,부서번호를 출력하여라.  
SELECT AVG(SALARY) FROM EMPLOYEES e;
SELECT EMPLOYEE_ID, FIRST_NAME, JOB_ID, SALARY, DEPARTMENT_ID FROM EMPLOYEES e
WHERE SALARY < (SELECT AVG(SALARY) FROM EMPLOYEES e);

-- 문제3) EMPLOYEES 테이블에서 (가장 많은 사원이 속해 있는 부서 번호)와 
-- 사원수를  출력하라. >> ???
SELECT MAX(COUNT(*)) FROM EMPLOYEES e GROUP BY DEPARTMENT_ID ;
SELECT DEPARTMENT_ID, COUNT(*) FROM EMPLOYEES e GROUP BY DEPARTMENT_ID 
HAVING COUNT(DEPARTMENT_ID) = (SELECT MAX(COUNT(*)) FROM EMPLOYEES e GROUP BY DEPARTMENT_ID) ;
 

-- 문제4) EMPLOYEES 테이블에서 (사원번호가 123인 사원의 직업)과 같고 
-- (사원번호가 192인 사원의 급여(SAL))보다 많은 사원의 
-- 사원번호,이름,직업,급여를 출력하라.
SELECT JOB_ID FROM EMPLOYEES e WHERE EMPLOYEE_ID = 123;
SELECT SALARY FROM EMPLOYEES e WHERE EMPLOYEE_ID = 192;
SELECT EMPLOYEE_ID, FIRST_NAME, JOB_ID, SALARY FROM EMPLOYEES e 
WHERE JOB_ID = (SELECT JOB_ID FROM EMPLOYEES e WHERE EMPLOYEE_ID = 123)
AND SALARY > (SELECT SALARY FROM EMPLOYEES e WHERE EMPLOYEE_ID = 192);


-- 문제5) EMPLOYEES 테이블에서 (50번 부서의 최소 급여)를 받는 사원보다 많은 급여를 받는 
-- 사원의 사원번호,이름,업무,입사일자,급여,부서번호를 출력하라. 
-- 단 50번 부서는 제외
SELECT MIN(SALARY) FROM EMPLOYEES e WHERE e.DEPARTMENT_ID = 50;
SELECT EMPLOYEE_ID, FIRST_NAME, JOB_ID, HIRE_DATE, SALARY, DEPARTMENT_ID FROM EMPLOYEES e 
WHERE SALARY > (SELECT MIN(SALARY) FROM EMPLOYEES e WHERE e.DEPARTMENT_ID = 50) 
AND e.DEPARTMENT_ID <> 50;

-------------------------------------------------------------------------------------
-- create
-- table 이름 	: employees2
-- 컬럼 이름 		: employee_id	number(10)
-- 			 	  name			varchar2(20)
-- 				  salary		number(7,2)
CREATE TABLE employees2(
	employee_id		number(10),
	name			varchar2(20),
	salary			number(7,2)
);

-- 기존 테이블과 동일하게 작성
CREATE TABLE EMPLOYEES3
AS
SELECT * FROM EMPLOYEES2 e ;

-- employees2 테이블에 컬럼 추가 
ALTER TABLE EMPLOYEES2 ADD(
	manager_id		varchar2(10)
);

SELECT * FROM EMPLOYEES2 e ;

-- 존재하는 컬럼의 데이터 컬럼을 수정
ALTER TABLE	EMPLOYEES2 modify(
	manager_id	varchar2(20)
);

-- 컬럼 삭제
ALTER TABLE EMPLOYEES2 DROP COLUMN manager_id;

-- 테이블 삭제
DROP TABLE EMPLOYEES3 ;

-- 데이터 저장
SELECT * FROM EMPLOYEES2 e ;
INSERT INTO EMPLOYEES2 e VALUES(1, '홍길동', 30000);
-- 테이블 데이터 전체 삭제
-- TRUNCATE TABLE EMPLOYEES2 ;

/*
 * 테이블명	: sample
 * 컬럼명		: deptNo	number(20)
 * 			  deptName	varchar2(15)
 * 			  deptloc	varchar2(15)
 * 			  deptManager	varchar2(10)
 * 데이터		: 10, 기획실, 서울, 홍길동
 * 			  20, 전산실, 부산, 김말똥
 * 			  30, 영업부, 광주, null
 */
CREATE TABLE SAMPLE(
		deptNo	number(20),
		deptName varchar2(15),
		deptloc	varchar2(15),
		deptManager	varchar2(10)
);
SELECT * FROM SAMPLE s ;
INSERT INTO SAMPLE s (deptNo, deptName, deptloc, deptManager) VALUES(10, '기획실', '서울', '홍길동');
INSERT INTO SAMPLE s (deptNo, deptName, deptloc, deptManager) VALUES(20, '전산실', '부산', '김말똥');
INSERT INTO SAMPLE s (deptNo, deptName, deptloc, deptManager) VALUES(30, '영업부', '광주', null);

-- sample 테이블의 30번 부서의 부서번호를 50번으로 수정
UPDATE SAMPLE SET DEPTNO = 50 WHERE DEPTNO = 30;
-- sample 테이블의 영업부의 deptloc를 인천으로 수정
UPDATE SAMPLE SET DEPTLOC = '인천' WHERE DEPTNAME ='영업부';
-- 부서명칭이 '영업부' 데이터를 삭제
-- SELECT * FROM SAMPLE s
DELETE sample 
WHERE DEPTNAME = '영업부';

