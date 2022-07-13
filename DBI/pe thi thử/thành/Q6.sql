select c.ID,c.CustomerName, count(o.id) as number
from Customer c join Orders o
on c.ID = o.CustomerID
group by c.ID,c.CustomerName, o.CustomerID
having count(o.id)
= 
(select max(total) as total1
from 
(select count(id) total
from orders
group by CustomerID) as rs)