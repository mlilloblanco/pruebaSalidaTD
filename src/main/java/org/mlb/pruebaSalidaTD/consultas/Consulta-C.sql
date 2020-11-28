SELECT employeeNumber, firstName, lastName, count(*)
FROM employees
INNER JOIN customers
ON employees.employeeNumber = customers.salesRepEmployeeNumber
WHERE employees.jobTitle = 'Sales Rep'
GROUP BY employeeNumber, firstName, lastName
ORDER BY count(*) DESC;