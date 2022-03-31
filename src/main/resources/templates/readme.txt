OVERVIEW : 
Since every company has its own assets so it would like to keep the record of each category of asset with the users.
Where  I have used spring boot , spring Jpa , H2 database

How to Run the Project : 
-All the relevant information has already been put up in the application.properties , one has to enter 

-the port on which the application is running is 9091

The name of the database is assignment as shown as below:
spring.datasource.url=jdbc:h2:mem:testdb

-In this each user will be able to create his account and can add name and the designation
by hitting the "/user"- Post mapping.
-He/she can also add delete his account by hitting the "/user/{id}" - delete mapping.
-we can also see the number of users "/users" GET mapping.

Similarly we have for asset where we can add asset  Post Mapping "/asset".
-update asset "/asset/{id} PUT mapping.
-delete asset by /asset/{id} DELETE mapping.
-get all assets by "/assets" GET mapping.
-get an asset by name "/asset/{name}" - GET mapping 
-assign an asset to a user "/assign/asset" - GET mapping
-delete an asset from a user "/delete/user" - DELETE mapping

-We can add category also by "/category" POST mapping
- update category "/category/{id}" - PUT mapping
- get list of all categories "/categories" - GET mapping
-delete a particular category "/category/{id}" - DELETE mapping

I hope you like my project.
Thank you!
