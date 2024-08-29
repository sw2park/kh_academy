SELECT * FROM EMPLOYEES e;

-- 주석
/*
 * 주석
 */

-- 데이터 조작어 : 검색
SELECT * -- 대상, 테이블의 컬럼, * : 전체
FROM	EMPLOYEES e ;	-- 대상 테이블

-- DEPARTMENTS 테이블 전체 조회
SELECT * 
FROM 	DEPARTMENTS d ;

-- JOBS 테이블 전체 조회
SELECT * 
FROM 	JOBS j ;

-- EMPLOYEES 테이블에서 사번, FIRST_NAME만 조회
SELECT EMPLOYEE_ID , FIRST_NAME 
FROM 	EMPLOYEES e ;
