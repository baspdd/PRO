insert into Category(CategoryName)
values('Sports')

insert into SubCategory(CategoryID, SubCategoryName)
values((select Category.ID from Category where Category.CategoryName = 'Sports'),'Tennis'), 
((select Category.ID from Category where Category.CategoryName = 'Sports' ),'Football')