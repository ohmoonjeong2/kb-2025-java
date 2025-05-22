-- mysql.users 테이블은 사용자 계정 및 관련 권한 정보를 저장합니다. 주로 사용자 인증과 권한 관리를 위해 사용합니다.
-- 사용자 권한 조회  
SELECT * FROM mysql.user
WHERE user = 'root';
-- -------------------------------------

-- INFORMATION_SCHEMA는 사용되는 모든 데이터베이스, 테이블, 칼럼 등의 메타데이터 정보를 제공합니다.
-- 오직 읽기 전용 정보를 제공하는 목적으로 사용됩니다.

-- 데이터베이스 목록 조회 : NFORMATION_SCHEMA.SCHEMATA
SELECT * FROM INFORMATION_SCHEMA.SCHEMATA;
-- 또는 
SHOW DATABASES;

-- 데이터베이스의 테이블 목록 조회 : INFORMATION_SCHEMA.TABLES
SELECT * 
FROM INFORMATION_SCHEMA.TABLES
WHERE TABLE_SCHEMA = 'employees';

USE employees;
SHOW TABLES;

-- 테이블의 컬럼조회 : INFORMATION_SCHEMA.COLUMNS
SELECT * FROM INFORMATION_SCHEMA.COLUMNS
WHERE TABLE_SCHEMA = 'employees'
  AND TABLE_NAME = 'dept_emp';
  
DESCRIBE employees.dept_emp;
SHOW COLUMNS FROM employees.dept_emp;

-- 제약조건 조회 : INFORMATION_SCHEMA.TABLE_CONSTRAINTS
SELECT 
    CONSTRAINT_NAME, 
    CONSTRAINT_TYPE, 
    TABLE_NAME 
FROM 
    INFORMATION_SCHEMA.TABLE_CONSTRAINTS
WHERE 
    TABLE_SCHEMA = 'employees' 
    AND TABLE_NAME = 'dept_emp';

-- 인덱스 조회  : INFORMATION_SCHEMA.STATISTICS
SELECT * FROM INFORMATION_SCHEMA.STATISTICS
WHERE TABLE_SCHEMA = 'employees'
  AND TABLE_NAME = 'dept_emp';