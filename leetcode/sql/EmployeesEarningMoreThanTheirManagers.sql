# Write your MySQL query statement below
SELECT e.name as Employee
FROM employee e
WHERE e.salary > (SELECT m.salary
                 FROM employee m
                 WHERE e.managerid = m.id);
