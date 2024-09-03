SELECT 	* FROM SAMPLE s ;
-- deptname이 전산실인 데이터를 삭제
SELECT * FROM SAMPLE s;
-- DELETE sample
-- WHERE DEPTNAME  = '전산실';
COMMIT;

-- 기획실 데이터 삭제
-- SELECT * FROM SAMPLE s
DELETE sample
WHERE DEPTNAME = '기획실';

SELECT * FROM SAMPLE s ;
COMMIT;
ROLLBACK;

-- 제약조건
-- not null
-- 기본이 null 허용
CREATE TABLE null_test(
	col1	varchar2(20) NOT NULL,  -- NULL데이터가 들어갈 수 없음
	col2	varchar2(20) NULL,		-- NULL데이터가 들어가도 상관없음
	col3	varchar2(20) 			-- NULL << 이라는 표현 생략, NULL데이터가 들어가도 상관없음
);
SELECT * FROM null_test;

INSERT INTO null_test(col1, col2)
VALUES ('aa', 'bb');
SELECT * FROM null_test nt ;
-- col1 오류 발생 구문
INSERT INTO null_test(col2, col3)
VALUES ('cc', 'dd');

INSERT INTO null_test(col1, col3)
VALUES ('cc', 'dd');

-- unique
CREATE TABLE unique_test(
	col1	varchar2(20) NOT NULL UNIQUE,	-- 
	col2	varchar2(20) UNIQUE,			-- UNIQUE 조건일때 null값은 얼마든지 삽입될 수 있다. 
	col3	varchar2(20) NOT NULL,			-- 
	col4	varchar2(20) NOT null
);
SELECT * FROM UNIQUE_TEST ut ;
INSERT INTO UNIQUE_TEST ut (col1, col2, col3, col4)
VALUES ('aa', 'bb', 'cc', 'dd');
INSERT INTO UNIQUE_TEST ut (col1, col2, col3, col4)
VALUES ('aa2', 'bb2', 'cc2', 'dd2');

UPDATE UNIQUE_TEST 
SET COL1 = 'aa'
WHERE COL2 = 'bb2';

INSERT INTO UNIQUE_TEST ut (col1, col2, col3, col4)
VALUES ('aa3', '', 'cc3', 'dd3');

INSERT INTO UNIQUE_TEST ut (col1, col2, col3, col4)
VALUES ('aa4', '', 'cc4', 'dd4');

-- unique 제약으로 들어가는 컬럼들은 그들의 조합이 유일해야 한다.
-- 각 컬럼의 데이터의 유일함은 의미가 없고, 조합이 유일해야 한다. 
CREATE TABLE UNIQUE_TEST2(
	col1	varchar2(20),
	col2	varchar2(20),
	CONSTRAINTS temp_unique UNIQUE(col1, col2)
	-- CONSTRAINTS 제약조건명 unique(대상컬럼1, 대상컬럼2)
);

SELECT * FROM UNIQUE_TEST2 ut; 
INSERT INTO UNIQUE_TEST2 ut (col1, col2)
VALUES ('aa', 'bb');
INSERT INTO UNIQUE_TEST2 ut (col1, col2)
VALUES ('aa', 'aa');
INSERT INTO UNIQUE_TEST2 ut (col1, col2)
VALUES ('aa', 'cc');
INSERT INTO UNIQUE_TEST2 ut (col1, col2)
VALUES ('bb', 'aa');
INSERT INTO UNIQUE_TEST2 ut (col1, col2)
VALUES ('bb', 'bb');
INSERT INTO UNIQUE_TEST2 ut (col1, col2)
VALUES ('bb', 'cc');

-- check
CREATE TABLE CHECK_TEST(
	gender	varchar2(10) NOT NULL, 
	CONSTRAINTS check_gender CHECK (gender IN('남자','여자'))
);
SELECT * FROM CHECK_TEST ct ;
INSERT INTO CHECK_TEST ct values('남자');
INSERT INTO CHECK_TEST ct values('여자');
INSERT INTO CHECK_TEST ct values('F'); -- 제한된 데이터만 입력 가능해서 오류 발생
INSERT INTO CHECK_TEST ct values('M'); -- 위와 동일

-- primary key
CREATE TABLE PRIMARY_TEST(
	student_id	number(10) PRIMARY KEY,
	name		varchar2(20)
);

CREATE TABLE PRIMARY_TEST2(
	student_id	number(10),
	name		varchar2(20),
	CONSTRAINTS student_pk PRIMARY KEY (student_id)
);

SELECT * FROM JOB_HISTORY jh ORDER BY EMPLOYEE_ID ;

---------------------------------------------------------
-- FK
CREATE TABLE daddy(
	idx		number(10),
	mid		number(10) PRIMARY KEY 
);
CREATE TABLE daughter(
	idx		number(10) PRIMARY KEY,
	mid		number(10),
	CONSTRAINTS fk_da FOREIGN KEY(mid) REFERENCES daddy(mid) ON DELETE CASCADE
);
INSERT INTO DADDY d VALUES (1, 10);
INSERT INTO DADDY d VALUES (2, 20);
SELECT * FROM DADDY d ;

INSERT INTO DAUGHTER d VALUES (100, 10);
INSERT INTO DAUGHTER d VALUES (101, 10);
INSERT INTO DAUGHTER d VALUES (102, 10);
INSERT INTO DAUGHTER d VALUES (103, 10);
INSERT INTO DAUGHTER d VALUES (200, 20);
INSERT INTO DAUGHTER d VALUES (201, 20);
INSERT INTO DAUGHTER d VALUES (300, 30);
SELECT * FROM DAUGHTER d ;

SELECT		*
FROM		DADDY d
LEFT OUTER JOIN DAUGHTER d2 ON d.MID = d2.MID ;
SELECT * FROM DADDY d ;
DELETE daddy WHERE idx = 1;

-------------------------------------------------------------------------------------------
-- pdf 문제
CREATE TABLE TB_TEAM(
	team_id		number(10) PRIMARY KEY,
	location	varchar2(10) NOT NULL,
	team_name	varchar2(10) NOT NULL,
	telphone	varchar2(15),
	team_url	varchar2(60)
);
CREATE TABLE TB_PLAYER(
	player_id		number(10) PRIMARY KEY,
	player_name 	varchar2(10) NOT NULL,
	player_pos		varchar2(10),
	player_height	number(3),
	player_teamid	NUMBER(10),
	CONSTRAINTS TB_id FOREIGN KEY(player_teamid) REFERENCES TB_TEAM(team_id) ON DELETE CASCADE
);
INSERT INTO TB_TEAM tt VALUES (1, '서울', '두산', '010-1234-5678', 'www.doosan.com');
INSERT INTO TB_TEAM tt VALUES (2, '서울', 'LG', '010-5678-1234', 'www.LG.com');
INSERT INTO TB_PLAYER tp VALUES (1, '박두산', '1루수', 160, 1);
INSERT INTO TB_PLAYER tp VALUES (2, '김두산', '2루수', 162, 2);
INSERT INTO TB_PLAYER tp VALUES (3, '이두산', '3루수', 150, 1);
INSERT INTO TB_PLAYER tp VALUES (4, '나두산', '외야', 164, 1);
INSERT INTO TB_PLAYER tp VALUES (5, '권두산', '내야', 165, 1);
INSERT INTO TB_PLAYER tp VALUES (6, '홍두산', '포수', 166, 1);
INSERT INTO TB_PLAYER tp VALUES (7, '송두산', '중견', 167, 1);
INSERT INTO TB_PLAYER tp VALUES (8, '최두산', '좌익', 168, 1);
INSERT INTO TB_PLAYER tp VALUES (9, '정두산', '우익', 169, 1);
INSERT INTO TB_PLAYER tp VALUES (10, '조두산', '지명', 170, 1);

SELECT tp.PLAYER_ID , tp.PLAYER_NAME , tp.PLAYER_POS , tp.PLAYER_HEIGHT , tt.TEAM_ID , tt.TEAM_URL 
FROM TB_TEAM tt LEFT OUTER JOIN TB_PLAYER tp ON tt.TEAM_ID = tp.PLAYER_TEAMID ;

DROP TABLE TB_PLAYER;
DROP TABLE TB_TEAM; 


-- sequence
CREATE SEQUENCE seq_serial_no
INCREMENT BY 1
START WITH 100
MAXVALUE 110
MINVALUE 99
CYCLE 
cache 2;
-- 
CREATE TABLE goods(
	good_no		number(3),
	good_name	varchar2(10)
);
-- nextval : 다음값
INSERT INTO goods values(seq_serial_no.nextval, '제품1');
SELECT *FROM goods;
-- 현재 seq 번호보는 방법
SELECT seq_serial_no.currval FROM dual;
-- seq 삭제
DROP SEQUENCE seq_serial_no;

-- 강사쌤이 한 pdf 문제 해결 + 시퀀스
CREATE SEQUENCE tema_id_seq
INCREMENT BY 1
START WITH 1
nomaxvalue
MINVALUE 1;

CREATE TABLE tbt_team(
	team_id		number(10) PRIMARY KEY,
	locals		varchar2(10) NOT NULL,
	team_name	varchar2(10) NOT NULL,
	phone_number	varchar2(15),
	home_page	varchar2(60)
);

CREATE SEQUENCE player_id_seq
INCREMENT BY 1
START WITH 1
nomaxvalue
MINVALUE 1;

CREATE TABLE tbt_player(
	player_no		number(10) PRIMARY KEY,
	player_name		varchar2(10) NOT NULL,
	positions		varchar2(10),
	height			number(3),
	team_id			number(10),
	CONSTRAINTS fk_code FOREIGN KEY (team_id)
	REFERENCES tbt_team(team_id) ON DELETE CASCADE 
);

INSERT INTO TBT_TEAM tt values(tema_id_seq.nextval, '서울', '서울팀', '01012345678', 'www.seoul.com');
INSERT INTO TBT_TEAM tt values(tema_id_seq.nextval, '부산', '부산팀', '01012345678', 'www.busan.com');
SELECT * FROM TBT_TEAM tt ;
-- 선수 저장
INSERT INTO TBT_PLAYER tp VALUES (player_id_seq.nextval, '일서울', '투수', 175, 1);
INSERT INTO TBT_PLAYER tp VALUES (player_id_seq.nextval, '이서울', '외야', 175, 1);
INSERT INTO TBT_PLAYER tp VALUES (player_id_seq.nextval, '삼서울', '내야', 175, 2);
INSERT INTO TBT_PLAYER tp VALUES (player_id_seq.nextval, '사서울', '유격', 175, 1);
INSERT INTO TBT_PLAYER tp VALUES (player_id_seq.nextval, '오서울', '1루', 175, 1);
INSERT INTO TBT_PLAYER tp VALUES (player_id_seq.nextval, '육서울', '2루', 175, 2);
INSERT INTO TBT_PLAYER tp VALUES (player_id_seq.nextval, '칠서울', '3루', 175, 2);
INSERT INTO TBT_PLAYER tp VALUES (player_id_seq.nextval, '팔서울', '포수', 175, 1);
INSERT INTO TBT_PLAYER tp VALUES (player_id_seq.nextval, '구서울', '좌익', 175, 2);
INSERT INTO TBT_PLAYER tp VALUES (player_id_seq.nextval, '십서울', '우익', 175, 1);
SELECT * FROM TBT_PLAYER tp ;

-- 조회
SELECT tp.PLAYER_NO , tp.PLAYER_NAME , tp.POSITIONS , tp.HEIGHT , tt.HOME_PAGE
FROM  TBT_TEAM tt LEFT OUTER JOIN TBT_PLAYER tp ON tt.TEAM_ID = tp.TEAM_ID ;