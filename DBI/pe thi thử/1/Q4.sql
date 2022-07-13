select p.SubCategoryID, c.SubCategoryName , count(p.ID)as NumberOfProduct
from product p join SubCategory c 
on p.SubCategoryID = c.ID
group by p.SubCategoryID, c.SubCategoryName, SubCategoryID
having count(p.id) > 100
order by NumberOfProduct desc