select ProductID, LocationID, Quantity
from ProductInventory
where LocationID = 7 and Quantity>250
order by Quantity desc