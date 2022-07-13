create trigger InsertSubCategory 
on SubCategory
for insert
as
begin
	select SubCategoryName, Category.CategoryName from inserted, Category where inserted.CategoryID=Category.ID
end