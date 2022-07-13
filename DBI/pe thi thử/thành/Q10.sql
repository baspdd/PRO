insert into Category (CategoryName) values ('Sports')
go 
insert into SubCategory (SubCategoryName) values ('Tennis'), ('Football')
go
update SubCategory 
set CategoryID = (select Category.ID from Category where Category.CategoryName='Sports')
where SubCategoryName in ('Tennis', 'Football')
