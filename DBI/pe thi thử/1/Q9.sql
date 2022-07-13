create trigger InsertProduct on Product
after insert
as
begin 
select p.ProductName, sc.SubCategoryName 
from inserted p, SubCategory sc
where p.SubCategoryID=sc.ID 
end
drop trigger InsertProduct;
insert into Product(ProductName, UnitPrice, SubCategoryID)
values ('Craft paper', 0.5, 3)
