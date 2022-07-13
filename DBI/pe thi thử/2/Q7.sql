select * from(
select top 5 ProD.SubCategoryID, count(SubCate.SubCategoryName) as NumberOfProduct
from dbo.SubCategory as SubCate, dbo.Product as ProD
where SubCate.ID = ProD.SubCategoryID
group by ProD.SubCategoryID, SubCategoryName
order by NumberOfProduct desc) as S1
union
select * from(
select top 5 ProD.SubCategoryID, count(SubCate.SubCategoryName) as NumberOfProduct
from dbo.SubCategory as SubCate, dbo.Product as ProD
where SubCate.ID = ProD.SubCategoryID
group by ProD.SubCategoryID, SubCategoryName
order by NumberOfProduct asc
) as S2
