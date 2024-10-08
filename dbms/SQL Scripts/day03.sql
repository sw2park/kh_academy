---------------------------------------------------------------------------------
-- distinct 중복제거
-- group by 데이터를 그룹핑해서 그 결과를 가져오는 경우 사용
-- 			집계함수와 짝을 이루어 사용할 수 있다.
SELECT 	DISTINCT DEPARTMENT_ID 
FROM 	EMPLOYEES e ;

SELECT 	DEPARTMENT_ID 
FROM 	EMPLOYEES e 
GROUP BY DEPARTMENT_ID;

-- 부서별 급여 합계
SELECT 	DISTINCT DEPARTMENT_ID , SUM(SALARY) 
FROM 	EMPLOYEES e ;

SELECT 	DEPARTMENT_ID , SUM(SALARY) 
FROM 	EMPLOYEES e 
GROUP BY DEPARTMENT_ID ;

SELECT 	EMPLOYEE_ID , SALARY , DEPARTMENT_ID 
FROM 	EMPLOYEES e 
ORDER BY DEPARTMENT_ID ;

SELECT 	DEPARTMENT_ID , EMPLOYEE_ID 
FROM 	EMPLOYEES e 
GROUP BY DEPARTMENT_ID ;

SELECT 	EMPLOYEE_ID 
FROM 	EMPLOYEES e 
GROUP BY EMPLOYEE_ID ;

-- 부서별 사원수와 급여의합 평균급여
SELECT	COUNT(EMPLOYEE_ID), COUNT(SALARY) , SUM(SALARY), AVG(SALARY) 
FROM 	EMPLOYEES e 
GROUP BY DEPARTMENT_ID;

-- 부서별 직급별(job_id) 사원수와 평균 급여 
SELECT 	DEPARTMENT_ID , JOB_ID , SUM(SALARY) , AVG(SALARY) , COUNT(EMPLOYEE_ID) 
FROM 	EMPLOYEES e 
WHERE 	DEPARTMENT_ID = 80
GROUP BY DEPARTMENT_ID, JOB_ID ;

-- having 절 
/*
 * having 절
 * - where절 에서는 집계함수를 사용할 수 없다.
 * - having절은 집계함수를 가지고 조건비교를 할때 사용
 */

SELECT 	DEPARTMENT_ID , COUNT(EMPLOYEE_ID) 
FROM 	EMPLOYEES e 
WHERE   DEPARTMENT_ID IS NOT NULL
-- AND 	COUNT(EMPLOYEE_ID) >= 10 where절에서 사용할 수 없다.  
GROUP BY DEPARTMENT_ID 
HAVING 	COUNT(EMPLOYEE_ID) >= 10
ORDER BY DEPARTMENT_ID ;

-- 문제1) EMPLOYEES 테이블에서 job_id가 'SA'로 시작하는 사람에 대하여 
-- 급여의 평균, 최고액, 최저액, 합계를 구하여 출력하여라.
SELECT 	AVG(SALARY) , MAX(SALARY), MIN(SALARY), SUM(SALARY) 
FROM 	EMPLOYEES e 
WHERE 	JOB_ID LIKE 'SA%';

-- 문제2) EMPLOYEES 테이블에 등록되어 있는 인원수, 
-- 커미션이 NULL이 아닌 인원수, 연봉평균, 
-- 등록되어 있는 부서의 수를 구하여 출력하라.
SELECT 	COUNT(*) , COUNT(COMMISSION_PCT), AVG(SALARY) , COUNT(DISTINCT DEPARTMENT_ID) 
FROM 	EMPLOYEES e ;


-- 문제3) EMPLOYEES 테이블에서 부서별로 인원수, 
-- 평균 급여, 최저급여, 최고 급여, 급여의 합을 구하여 출력하라.
SELECT 	COUNT(EMPLOYEE_ID) , TRUNC(AVG(SALARY)), MIN(SALARY), MAX(SALARY), SUM(SALARY) 
FROM 	EMPLOYEES e
GROUP BY DEPARTMENT_ID;

/*
* 문제4)EMPLOYEES테이블에서 각 부서별로 인원수,
* 급여의 평균, 최저급여, 최고급여, 급여의합을 구하여
* 급여의 합이 많은 순으로 출력하라
*/
SELECT 	COUNT(EMPLOYEE_ID) , TRUNC(AVG(SALARY)), MIN(SALARY), MAX(SALARY), SUM(SALARY) 
FROM 	EMPLOYEES e
GROUP BY DEPARTMENT_ID
ORDER BY SUM(SALARY) DESC ;

-- 문제5) EMPLOYEES 테이블에서 부서별, 업무별 그룹하여 결과를 부서번호, 
-- 업무, 인원수, 급여의 평균, 급여의 합을 구하여 출력하여라.
SELECT 	DEPARTMENT_ID , JOB_ID , COUNT(EMPLOYEE_ID) , TRUNC(AVG(SALARY)) , SUM(SALARY) 
FROM 	EMPLOYEES e 
GROUP BY DEPARTMENT_ID , JOB_ID ;

-- 문제6) EMPLOYEES 테이블에서 부서 인원이 4명보다 많은 부서의 부서번호, 
-- 인원수, 급여의 합을 구하여 출력하여라
SELECT 	DEPARTMENT_ID , COUNT(EMPLOYEE_ID), SUM(SALARY) 
FROM 	EMPLOYEES e 
GROUP BY DEPARTMENT_ID 
HAVING COUNT(DEPARTMENT_ID) > 4 ;

-- 문제7) EMPLOYEES 테이블에서 급여의 최대값이 10000이상인 부서에 대해서 부서번호, 
-- 평균 급여, 급여의 합을 구하여 출력하여라.
SELECT 	DEPARTMENT_ID , AVG(SALARY) , SUM(SALARY) 
FROM 	EMPLOYEES e 
GROUP BY DEPARTMENT_ID 
HAVING MAX(SALARY) >= 10000;

-- 문제8) EMPLOYEES 테이블에서 업무별 급여의 평균이 10000 이상인 업무에 대해서 업무명,
-- 평균 급여, 급여의 합을 구하여 출력하라.
SELECT 	JOB_ID , AVG(SALARY) , SUM(SALARY) 
FROM	EMPLOYEES e 
GROUP BY JOB_ID
HAVING AVG(SALARY) >= 10000 ;


-- 문제9) 각 JOB_ID 별, 최대 연봉, 최소 연봉, 연봉 총 합 및 평균 연봉을 
-- JOB_ID 내림차순으로 조회
SELECT 	JOB_ID , MAX(SALARY) , MIN(SALARY) , SUM(SALARY) , AVG(SALARY) 
FROM 	EMPLOYEES e 
GROUP BY JOB_ID 
ORDER BY JOB_ID DESC ;

-- 문제10) 동일한 직업(JOB_ID)을 가진 사원들의 총 수를 조회한다.
SELECT 	JOB_ID , COUNT(JOB_ID) 
FROM 	EMPLOYEES e 
GROUP BY JOB_ID ;

-- 문제11) 매니저의 사번 및 그 매니저가 관리하는 직원들 중 
--   최소 연봉을 받는 사원의 연봉을 조회한다.
--     매니저가 없는 사람들은 제외한다.
--     최소 연봉 기준 역순으로 조회한다.
SELECT 	MIN(SALARY) 
FROM 	EMPLOYEES e 
WHERE 	MANAGER_ID IS NOT NULL
ORDER BY SALARY DESC ;


-------강사쌤이 한 것---------------

-- 문제1) EMPLOYEES 테이블에서 job_id가 'SA'로 시작하는 사람에 대하여 
-- 급여의 평균, 최고액, 최저액, 합계를 구하여 출력하여라.
SELECT 	AVG(SALARY), MAX(SALARY), MIN(SALARY), SUM(SALARY) 
FROM 	EMPLOYEES e 
WHERE 	JOB_ID LIKE 'SA%';

-- 문제2) EMPLOYEES 테이블에 등록되어 있는 인원수, 
-- 커미션이 NULL이 아닌 인원수, 연봉평균, 
-- 등록되어 있는 부서의 수를 구하여 출력하라.
-- count()는 null값을 제외한 수를 세줌 
SELECT 	COUNT(*) , COUNT(COMMISSION_PCT) , AVG(SALARY) , COUNT(DISTINCT DEPARTMENT_ID)  
FROM 	EMPLOYEES e ;

-- 문제3) EMPLOYEES 테이블에서 부서별로 인원수, 
-- 평균 급여, 최저급여, 최고 급여, 급여의 합을 구하여 출력하라.
SELECT 	DEPARTMENT_ID , COUNT(*) , AVG(SALARY) ,MIN(SALARY), MAX(SALARY), SUM(SALARY) 
FROM 	EMPLOYEES e 
GROUP BY DEPARTMENT_ID ;

/*
* 문제4)EMPLOYEES테이블에서 각 부서별로 인원수,
* 급여의 평균, 최저급여, 최고급여, 급여의합을 구하여
* 급여의 합이 많은 순으로 출력하라
*/
SELECT 	DEPARTMENT_ID , COUNT(*) , AVG(SALARY) ,MIN(SALARY), MAX(SALARY), SUM(SALARY) AS totalsal 
FROM 	EMPLOYEES e 
GROUP BY DEPARTMENT_ID 
ORDER BY totalsal DESC ;

-- 문제5) EMPLOYEES 테이블에서 부서별, 업무별 그룹하여 결과를 부서번호, 
-- 업무, 인원수, 급여의 평균, 급여의 합을 구하여 출력하여라.
SELECT 	DEPARTMENT_ID , JOB_ID , COUNT(*) , AVG(SALARY) , SUM(SALARY) 
FROM 	EMPLOYEES e 
GROUP BY DEPARTMENT_ID , JOB_ID ;

-- 문제6) EMPLOYEES 테이블에서 부서 인원이 4명보다 많은 부서의 부서번호, 
-- 인원수, 급여의 합을 구하여 출력하여라
SELECT 	DEPARTMENT_ID , COUNT(*) , SUM(SALARY) 
FROM 	EMPLOYEES e 
GROUP BY DEPARTMENT_ID 
HAVING COUNT(*) > 4 ;

-- 문제7) EMPLOYEES 테이블에서 급여의 최대값이 10000이상인 부서에 대해서 부서번호, 
-- 평균 급여, 급여의 합을 구하여 출력하여라.
SELECT 	DEPARTMENT_ID , AVG(SALARY) , SUM(SALARY) 
FROM 	EMPLOYEES e 
GROUP BY DEPARTMENT_ID 
HAVING MAX(SALARY) >= 10000 ;

-- 문제8) EMPLOYEES 테이블에서 업무별 급여의 평균이 10000 이상인 업무에 대해서 업무명,
-- 평균 급여, 급여의 합을 구하여 출력하라.
SELECT 	JOB_ID , AVG(SALARY) , SUM(SALARY) 
FROM 	EMPLOYEES e 
GROUP BY JOB_ID 
HAVING AVG(SALARY) >= 10000 ;

-- 9. 각 JOB_ID 별, 최대 연봉, 최소 연봉, 연봉 총 합 및 평균 연봉을 
-- JOB_ID 내림차순으로 조회
SELECT 	JOB_ID , MAX(SALARY) , MIN(SALARY) , SUM(SALARY) , AVG(SALARY) 
FROM 	EMPLOYEES e 
GROUP BY JOB_ID 
ORDER BY JOB_ID DESC ;

-- 10. 동일한 직업(JOB_ID)을 가진 사원들의 총 수를 조회한다.
SELECT 	JOB_ID , COUNT(*) 
FROM 	EMPLOYEES e 
GROUP BY JOB_ID ;

-- 11. 매니저의 사번 및 그 매니저가 관리하는 직원들 중 
--   최소 연봉을 받는 사원의 연봉을 조회한다.
--     매니저가 없는 사람들은 제외한다.
--     최소 연봉 기준 역순으로 조회한다.
SELECT 	MANAGER_ID , MIN(SALARY) 
FROM 	EMPLOYEES e 
WHERE 	MANAGER_ID IS NOT NULL 
GROUP BY MANAGER_ID 
ORDER BY MIN(SALARY) DESC ;

-- join
-- 부서번호 50 
SELECT	*
FROM 	EMPLOYEES e 
WHERE 	EMPLOYEE_ID = 125;

SELECT 	*
FROM 	DEPARTMENTS d 
WHERE 	DEPARTMENT_ID = 50;

-- inner join / NULL값 제외하고 보여줌
SELECT	e.EMPLOYEE_ID , e.FIRST_NAME , d.DEPARTMENT_ID , d.DEPARTMENT_NAME 
FROM 	EMPLOYEES e INNER JOIN DEPARTMENTS d
ON		e.DEPARTMENT_ID = d.DEPARTMENT_ID
WHERE 	d.DEPARTMENT_ID = 80
ORDER BY e.EMPLOYEE_ID ;

SELECT 	e.EMPLOYEE_ID , e.FIRST_NAME 
,		d.DEPARTMENT_ID , d.DEPARTMENT_NAME 
,		l.LOCATION_ID, l.STREET_ADDRESS, l.CITY 
FROM 	EMPLOYEES e 
INNER JOIN DEPARTMENTS d ON e.DEPARTMENT_ID = d.DEPARTMENT_ID 
INNER JOIN LOCATIONS l 	 ON d.LOCATION_ID = l.LOCATION_ID 
WHERE 	l.CITY = 'Seattle'
ORDER BY e.EMPLOYEE_ID ;

-- left outer join 
SELECT 	e.EMPLOYEE_ID , e.FIRST_NAME 
,		d.DEPARTMENT_ID , d.DEPARTMENT_NAME 
FROM 	EMPLOYEES e 
LEFT OUTER JOIN DEPARTMENTS d ON e.DEPARTMENT_ID = d.DEPARTMENT_ID 
ORDER BY e.EMPLOYEE_ID ;

SELECT 	e.EMPLOYEE_ID , e.FIRST_NAME 
,		d.DEPARTMENT_ID , d.DEPARTMENT_NAME 
FROM 	DEPARTMENTS d 
LEFT OUTER JOIN EMPLOYEES e ON d.DEPARTMENT_ID = e.DEPARTMENT_ID 
ORDER BY e.EMPLOYEE_ID ;

-- right outer join / 바로 위 Query와 같다.
SELECT 	e.EMPLOYEE_ID , e.FIRST_NAME 
,		d.DEPARTMENT_ID , d.DEPARTMENT_NAME 
FROM 	EMPLOYEES e 
RIGHT OUTER JOIN DEPARTMENTS d ON e.DEPARTMENT_ID = d.DEPARTMENT_ID 
ORDER BY e.EMPLOYEE_ID ;

-- full outer join
SELECT 	e.EMPLOYEE_ID , e.FIRST_NAME 
,		d.DEPARTMENT_ID , d.DEPARTMENT_NAME 
FROM 	EMPLOYEES e 
FULL OUTER JOIN DEPARTMENTS d ON e.DEPARTMENT_ID = d.DEPARTMENT_ID 
ORDER BY e.EMPLOYEE_ID ;
