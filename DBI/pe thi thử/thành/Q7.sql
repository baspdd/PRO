select * from (select top 5 SubCategoryID,count(id) NumberOfProducts from Product
group by SubCategoryID
order by NumberOfProducts desc) t
union
select * from 
(select top 5 SubCategoryID,count(id) NumberOfProducts from Product
group by SubCategoryID
order by NumberOfProducts) c
order by NumberOfProducts desc