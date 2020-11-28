SELECT customerNumber, customerName, creditLimit
FROM customers
WHERE customerName LIKE '%Ltd%'
ORDER BY creditLimit DESC;