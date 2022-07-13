with r as(select o.CustomerID, c.CustomerName, count(o.id) as NumberOfOrder
from Orders o join Customer c 
on o.CustomerID = c.ID
group by o.CustomerID, c.CustomerName)
select * from r 
where r.NumberOfOrder = (select max(r.NumberOfOrder) from r)