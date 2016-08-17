select * from Employees;
select * from EmployeeTerritories;
select * from Territories;

select FirstName, LastName, TerritoryDescription
from Employees
  inner join EmployeeTerritories
    on Employees.EmployeeID = EmployeeTerritories.EmployeeID
  inner join Territories
    on Territories.TerritoryID = EmployeeTerritories.TerritoryID;

select * from Customers;
select * from Order_Details;
select * from Orders;
select * from Products;

select ContactName, OrderDate, ProductName
from Customers
  inner join Orders
    on Customers.CustomerID = Orders.CustomerID
  inner join Order_Details
    on Orders.OrderID = Order_Details.OrderID
  inner join Products
    on Products.ProductID = Order_Details.ProductID
where Customers.Country = 'USA';

select Order.*
from Orders
  inner join Order_Details
    on Orders.OrderID = Order_Details.OrderID
  inner join Products
    on Order_Details.ProductID = Products.ProductID
where ProductName = 'Chai';

select OrderID, CustomerID, Orders.EmployeeID, LastName, FirstName
from Orders
  left join Employees
    on Orders.EmployeeID = Employees.EmployeeID
where Orders.EmployeeID is null or LastName like 'S%';