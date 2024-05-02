--Q1: Get supplier names and numbers for all suppliers who supplied part P3 and whose name begins with letter A.
SELECT s.s_num, s.s_name 
FROM S s INNER JOIN SPJ spj ON s.s_num = spj.s_num 
WHERE s.s_name LIKE 'A%' AND spj.p_num = 'p3';

--Q2: Get supplier names and numbers for all suppliers whose name (supplier name) begins with letter A
--    and who supplied parts whose name (part's name) begins with letter S.
SELECT DISTINCT s.s_num, s.s_name 
FROM S s INNER JOIN SPJ spj ON s.s_num = spj.s_num INNER JOIN P ON spj.p_num = p.p_num 
WHERE s.s_name LIKE 'A%' AND p.pname LIKE 'S%';

--Q3: Get supplier names for suppliers who supplied for job J2. (Use a nested query)
SELECT DISTINCT s.s_name 
FROM S s INNER JOIN SPJ spj ON s.s_num = spj.s_num 
WHERE spj.j_num = (SELECT DISTINCT j_num FROM J where j_num = 'j2');

--Q4: Get supplier names for suppliers who supplied parts for jobs only in Athens. (Use a nested query)
SELECT DISTINCT s.s_name 
FROM S s INNER JOIN SPJ spj ON s.s_num = spj.s_num INNER JOIN J j ON spj.j_num = j.j_num
WHERE j.city = (SELECT DISTINCT city FROM J WHERE city = 'Athens');

--Q5: Get part names for parts that are not supplied for job J3. (Use a nested query)
SELECT p.pname 
FROM P p 
WHERE p.p_num NOT IN (SELECT spj.p_num FROM SPJ spj WHERE spj.j_num = 'j3');

--Q6: Which city has the most suppliers? (Use a nested query)
SELECT s.city 
FROM S s INNER JOIN SPJ spj ON s.s_num = spj.s_num 
WHERE spj.qty IN (SELECT MAX(spj.qty) FROM SPJ spj);

--Q7: Get supplier numbers and names for suppliers whose status is greater than status values of
--    all suppliers located in Paris.
SELECT s.s_num, s.s_name 
FROM S s 
WHERE s.city <> 'Paris' AND s.status > (SELECT MAX(s.status) FROM S WHERE s.city = 'Paris');

--Q8: Calculate each supplier's total sales quantity and get the sales person's name if the sales person
--    supplies parts more than 1000 units in total.
SELECT s.s_name
FROM S s INNER JOIN SPJ spj ON s.s_num = spj.s_num 
GROUP BY s.s_name 
HAVING SUM(spj.qty) > 1000;

--Q9: Get job numbers for jobs whose city is first in the alphabetical list of the job cities.
SELECT j_num 
FROM J
WHERE city = (SELECT TOP 1 city FROM J ORDER BY city ASC);

--Q10: Increase the status values of suppliers by 5 who are located in Paris.
UPDATE S 
SET status = status + 5 
WHERE city = 'Paris';

--Q11: Change the name to 'Hammer' of parts that are Red and located in London and whose name was Screw.
UPDATE P 
SET pname = 'Hammer' 
WHERE color = 'Red' AND city = 'London' AND pname = 'Screw';

--Q12: Delete all jobs in Rome and all corresponding part shipments. (Please use 2 queries)
DELETE FROM J WHERE city = 'Rome'; 
DELETE FROM SPJ WHERE j_num NOT IN (SELECT j_num FROM J);

--Q13: Please create a "view table" supplier_shipment that shows each supplier and its total shipment quantity.
CREATE VIEW SUPPLIER_SHIPMENT AS SELECT s.s_name, SUM(spj.qty) total_quantity 
FROM S s INNER JOIN SPJ spj ON s.s_num = spj.s_num
GROUP BY s.s_name;

--Q14: Please try to increase Smith's total shipment by 100 in the view table you created in Q13.
--     Then discuss what happens when you try to update the view table.
UPDATE SUPPLIER_SHIPMENT 
SET total_quantity = total_quantity + 100 
WHERE s_name = 'Smith';

--Q15: Please create a base table supplier_shipment that shows each supplier and its total shipment quantity.
SELECT s.s_name, SUM(spj.qty) total_quantity 
INTO SUPPLIER_SHIPMENT 
FROM S s INNER JOIN SPJ spj ON s.s_num = spj.s_num 
GROUP BY s.s_name;

--Q16: Please repeat A14 on the base table supplier_shipment and discuss the result.
UPDATE SUPPLIER_SHIPMENT 
SET total_quantity = total_quantity + 100 
WHERE s_name = 'Smith';

--Q17: Among parts taht are used in projects, find out the most used parts in each project.
WITH PART_COUNTS AS ( 
  SELECT j_num, p_num, SUM(qty) AS total_qty 
  FROM SPJ 
  GROUP BY j_num, p_num 
), 
  
MAX_PART AS (
  SELECT j_num, p_num, total_qty, ROW_NUMBER() 
  OVER (PARTITION BY j_num ORDER BY total_qty DESC) AS RANK 
  FROM PART_COUNTS 
) 
  
SELECT j.j_num, p.pname, mp.total_qty
FROM MAX_PART mp 
JOIN J j ON mp.j_num = j.j_num 
JOIN P p ON mp.p_num = p.p_num 
WHERE mp.RANK = 1;
