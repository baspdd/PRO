SELECT Product.ID as ProductID,Product.ProductName,count(*) as NumberOfOrders  FROM dbo.Product, dbo.OrderDetails
where Product.ID=OrderDetails.ProductID
group by Product.ID,Product.ProductName having count(*) <= all
(
	select count(*) as NumberOfOrders 
	from dbo.Customer, dbo.Orders
	where Customer.ID=Orders.CustomerID
	group by Customer.ID, Orders.CustomerID
-----
select  od.ProductID , p.ProductName , (COUNT(od.OrderID)) as Num
from OrderDetails od , Product p
where od.ProductID=p.ID 
group by od.ProductID , p.ProductName
having (COUNT(od.OrderID)) = (
 select top 1 (COUNT(o.OrderID)) as total
from OrderDetails o , Product p
where o.ProductID=p.ID
group by o.ProductID , p.ProductName
order by total asc )
order by od.ProductID 