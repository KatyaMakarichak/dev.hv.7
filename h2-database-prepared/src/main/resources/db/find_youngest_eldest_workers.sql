SELECT 'YOUNGEST' AS type, name, birthday
FROM worker
ORDER BY birthday DESC
LIMIT 1
UNION ALL
SELECT 'ELDEST', name, birthday
FROM worker
ORDER BY birthday ASC
LIMIT 1;