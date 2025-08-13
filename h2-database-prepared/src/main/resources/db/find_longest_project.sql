SELECT id, MONTHS_BETWEEN(end_date, start_date) AS month_count
FROM project
ORDER BY month_count DESC
LIMIT 1;