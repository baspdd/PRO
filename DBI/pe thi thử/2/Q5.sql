SELECT * FROM Orders o
WHERE o.OrderDate=(SELECT MAX(OrderDate) FROM Orders)