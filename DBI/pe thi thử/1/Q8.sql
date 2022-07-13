create proc CountProduct @OrderID nvarchar(255), @NbProduct int output
as
begin
select @NbProduct = ( select count(OrderID)
from OrderDetails 
where OrderID=@OrderID
)
end

declare @t int
exec CountProduct 'CA-2014-100391', @t output 
print @t


--viet query hien ra tong so product cua orderID 
select count(OrderID)
from OrderDetails 
where OrderID='CA-2014-100391'
