# Write your MySQL query statement below
SELECT c.id, c.movie, c.description, c.rating
FROM cinema c
WHERE c.description != 'boring' AND c.id IN (SELECT c1.id
                                            FROM cinema c1
                                            WHERE (c1.id % 2) = 1)
ORDER BY c.rating DESC;
