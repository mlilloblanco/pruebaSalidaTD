SELECT customers.customerName, SUM(orderDetails.quantityOrdered*orderDetails.priceEach) as SumaMontoOrdenes
FROM customers
INNER JOIN orders
ON customers.customerNumber = orders.customerNumber
INNER JOIN orderDetails
ON orders.orderNumber = orderDetails.orderNumber
WHERE EXTRACT(YEAR FROM orders.orderDate) = 2004
GROUP BY customers.customerName
ORDER BY SUM(quantityOrdered*priceEach) DESC;
