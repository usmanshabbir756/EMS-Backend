Crud Operation using Spring boot RestApi 
make mysql ems database and set database name as root and password root you can use these api

// create post request
http://localhost:8080/api/employees
  json 
    {
    "firstName":"Usman",
    "lastName" : "Shabbir"
    "email" : "usman@gmail.com"
}

// Get by id get request
http://localhost:8080/api/employees/6

//Get All Employee get request
http://localhost:8080/api/employees

//Update Employee put request
http://localhost:8080/api/employees
json 
  {
    "firstName":"Usman",
    "lastName":"Shabbir",
    "email":"Usman@gmail.com"
}

//Delete By id
http://localhost:8080/api/employees/1

