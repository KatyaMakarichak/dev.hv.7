SELECT project_id, SUM(price) AS price
FROM project_worker
GROUP BY project_id;