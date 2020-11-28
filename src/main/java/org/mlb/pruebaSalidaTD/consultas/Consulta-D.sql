SELECT offices.country, offices.city, count(*)
FROM offices
INNER JOIN employees
ON offices.officeCode = employees.officeCode
INNER JOIN customers
ON employees.employeeNumber = customers.salesRepEmployeeNumber
INNER JOIN orders
ON customers.customerNumber = orders.customerNumber
GROUP BY offices.country, offices.city
ORDER BY count(*) DESC;