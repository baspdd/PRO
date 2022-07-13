with r as(select top 5 *
from product
order by UnitPrice asc
union
select top 5 *
from product
order by UnitPrice desc)

select * from r
order by r.UnitPrice desc