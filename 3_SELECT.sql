SELECT  YEAR(hire_date), IFNULL(gender, '입사')g, COUNT(*) cnt
FROM employees
GROUP BY YEAR(hire_date), gender;

SELECT IFNULL(YEAR(hire_date), '총'), IFNULL(gender, '입사'), COUNT(*) cnt
FROM employees
GROUP BY YEAR(hire_date), gender
with rollup;
	   
       


SELECT CASE WHEN GROUPING(y) = 1 THEN '총'
	        WHEN GROUPING(gender) = 1 THEN ' 입사'
			ELSE y
	   END 년도,
    IFNULL(gender, '사원수')성별,
   
	SUM(cnt) 사원수
FROM ( SELECT YEAR(hire_date) y, gender, COUNT(*) cnt
       FROM employees
       GROUP BY YEAR(hire_date), gender
	   HAVING COUNT(*) < 2000
)t
GROUP BY y, gender
WITH ROLLUP;       



SELECT YEAR(hire_date) y, gender, 
grouping(YEAR(hire_date)), 
grouping(gender),
COUNT(*) cnt
       FROM employees
       GROUP BY YEAR(hire_date), gender
	  
WITH ROLLUP;


SELECT YEAR(hire_date) y, gender, 
CASE 
    WHEN grouping(YEAR(hire_date)) = 1 THEN '총' 
    ELSE YEAR(hire_date)
    END
, 
grouping(gender),
COUNT(*) cnt
FROM employees
GROUP BY YEAR(hire_date), gender
WITH ROLLUP;


           