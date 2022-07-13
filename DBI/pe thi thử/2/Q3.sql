select c.ID, c.CustomerName,c.City,c.[State]
from dbo.Customer  c join dbo.Orders o
on c.ID=o.CustomerID
where o.OrderDate between '2017/12/05' and '2017/12/10' 
and DAY(o.ShipDate)- DAY(o.OrderDate) < 3
order by c.State asc, c.City desc
