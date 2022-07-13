select o.ProductID, p.ProductName, o.Quantity
from OrderDetails o join Product p
on o.ProductID = p.ID
where o.Quantity = 
(select Max(Quantity) from OrderDetails)
