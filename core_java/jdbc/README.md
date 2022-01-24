# Introduction
This app uses JDBC for accessing relational database from the relational database management system. JDBC in java lets us get data in and out of any
application using any RDBMS. The tools used include maven (for dependency management), Java, and Docker. Docker is used to run a container with postgresql. The database we are using
is PostgreSQL, and we need the client side library psql to baseline the database. Furthermore, the java.sql package was used to make changes to the database with the JDBC driver.

# Implementation
We add the JDBC driver dependency into our pom so maven can include it in the classpath. A data access object and data transfer object are the base class and interface to model relationships.
This follows the DAO design pattern. On instantionation of each table's data access object, it is passed a connection. Each DAO is coupled with a class for the object represented. This object
implements the data transfer object interface to make it eligible for generic typing in its accompanying DAO. Within our DAO, we form prepared statements to execute SQL code. The methods that
execute our SQL commands with a `PreparedStatement.execute` will perform CRUD operations and are capable of returning the object that is coupled with the DAO.


## ER Diagram
![alt text](https://github.com/jarviscanada/jarvis_data_eng_SiddarthKrishnan/blob/develop/core_java/jdbc/dao.drawio.png "Mock DAO")

## Design Patterns

The design patterns we learned about were mainly the Data Access Object pattern. We also visited the Repository pattern which operates at a higher level using a Collection, pertaining to one table in
most cases. Both patterns provide a layer of abstraction between JDBC and code.

# Test
The app was test with a demo docker container running postgres. We throw an SQLException for any cases that might stop out code from running.
If there was an error with something updated in our database, we manually removed these entries and repeated our process to execute a query or SQL statement.