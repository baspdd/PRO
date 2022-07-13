select * from Orders
where OrderDate =(select top 1 OrderDate from Orders order by OrderDate desc)