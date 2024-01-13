this is backend for a customer database service in which you can :
register a admin
login as admin
get, edit, create and delete customer from database

it uses spring security and jwt authorization

and searching by executing a sql query through jpa 

it uses spring data jpa for mysql server

configure mysql server database and change it to your values in application.properties file

the properties are as follows : 
server.port = your_port
spring.jpa.generate-ddl=true
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto=update
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
spring.datasource.username=your_username
spring.datasource.password=your_pasasword
spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl


