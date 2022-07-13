select c.*
from Customer c join Orders o
on c.id = o.CustomerID
where c.CustomerName like 'B%' 
and month(o.OrderDate) = '12' and year(o.OrderDate) = '2017'
order by c.Segment desc, c.CustomerName asc

select distinct Customer.* from Customer join Orders
on Customer.ID=Orders.CustomerID
where CustomerName like 'B%'
and month(OrderDate) = '12' and year(OrderDate) = '2017'
order by Customer.Segment desc, Customer.CustomerName asc