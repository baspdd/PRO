select p.SubCategoryID,s.SubCategoryName, count(*) as NumberOfProducts
from Product p join SubCategory s on p.SubCategoryID= s.ID
group by p.SubCategoryID, s.SubCategoryName
having count(*) >100
order by count(*) desc