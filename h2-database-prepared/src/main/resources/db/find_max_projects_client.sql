SELECT name, COUNT(*) as project_count
FROM test_table
GROUP BY name;