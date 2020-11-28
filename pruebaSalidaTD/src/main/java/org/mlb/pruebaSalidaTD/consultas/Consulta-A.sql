SELECT offices.country, offices.city, employees.firstName, employees.lastName, employees.email
FROM employees 
INNER JOIN offices
ON offices.officeCode = employees.officeCode
WHERE employees.jobTitle = 'Sales Rep'
ORDER BY offices.country, offices.city, employees.firstName;