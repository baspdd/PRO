select od.OrderID, o.OrderDate , sum(od.Quantity*od.SalePrice*(1-od.Discount)) as totalamount
from OrderDetails od, Orders o
where od.OrderID=o.ID 
group by od.OrderID , o.OrderDate
having sum(od.Quantity*od.SalePrice*(1-od.Discount)) >=8000
order by totalamount desc