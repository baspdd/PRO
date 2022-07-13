create proc TotalAmount @OrderID nvarchar(255), @TotalAmount float output
as
begin
	set @TotalAmount = 
	(select sum((od.Quantity*od.SalePrice*(1-od.Discount))) as TotalAmount
	from OrderDetails od
	where od.OrderID=@OrderID
	group by OrderID)
end


create proc TotalAmount @OrderID nvarchar(255), @TotalAmount float output
as
begin 
 select @TotalAmount = (select  sum(OrderDetails.Quantity*OrderDetails.SalePrice*(1-OrderDetails.Discount)) as TotalAmount
	from OrderDetails 
	where OrderDetails.OrderID=@OrderID)
end

declare @t float
exec TotalAMount 'CA-2014-100006', @t output 
print @t

select sum(OrderDetails.Quantity*OrderDetails.SalePrice*(1-OrderDetails.Discount)) as TotalAmount
	from OrderDetails 
	group by OrderDetails.OrderID