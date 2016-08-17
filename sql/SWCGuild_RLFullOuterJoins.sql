select City, LastName
from Employee
  right join Location
    on Location.LocationID = Employee.LocationID;

select City, LastName
From Employee
  left join Location
    on Location.LocationID = Employee.LocationID;

select City, LastName
From Employee
  left join Location
    on Location.LocationID = Employee.LocationID

union

select City, LastName
From Employee
  right join Location
    on Location.LocationID = Employee.LocationID;


