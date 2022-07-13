select Customer.ID, CustomerName, City, State
from Customer, Orders
where Customer.ID=Orders.CustomerID and OrderDate between '20171205' and '20171210'
and ShipDate - OrderDate <3
order by State asc, City desc