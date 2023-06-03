# Backend Social Network

This is a Backend application of a social network project used in my Youtube
videos.

https://www.youtube.com/playlist?list=PLab_if3UBk9-TuyqwMy3JvNHeCh7Ll9Wz


## Chapter 1

In the first video, I've created the Maven project with Intellij and described
the folder structure and the pom.xml of the empty Maven project.

Then, I've converted the empty project to a Spring Boot project by adding the
Spring Boot dependency as the parent project. This way, my project will inherit
all the architecture and configuration of a Spring Boot project. After that,
I've also added a Spring Boot Web dependency letting know that this project
will use the Web layer.

Finally, I've created the main method, run the project and saw that the Tomcat
web server is ready to accept requests.

https://www.youtube.com/watch?v=6Q0R8ftz7yY&list=PLab_if3UBk9-TuyqwMy3JvNHeCh7Ll9Wz&index=3&t=0s


## Chapter 2

In the second video of this playlist, I've created the packages to have a 3-tiers
architecture, having: a presentation layer where the controllers will be located,
the logic layer where the services will be located, and the data layer will the data
structure of the database will be located. 

I've also created the controllers to accept the HTTP requests from the frontend 
application, created the requests mapping to map each URL to a method. And I've created 
the services where all the business logic will be placed, but leave it empty as I'm
missing the database configuration to fetch the data, so I will complete the services
in another video.

I've also injected the services into the controllers using the dependency injection
of Spring.

I've created a package DTO, Data Transfer Object, where are placed the objects which
will be sent to and from the frontend. This avoids me so send the objects which represents
the database structure, hiding the database structure to the Internet and only showing
what I want. I will need to map the data objects to the dto objects, but we will handle
this later with some useful libraries.

https://www.youtube.com/watch?v=0WaPVWspqBE&list=PLab_if3UBk9-TuyqwMy3JvNHeCh7Ll9Wz&index=4&t=0s


## Chapter 3

In this third video, I've added the authentication using JWT. The authentication was divided
in three steps: the HTTP filter, the provider and the entry point. The HTTP filter will intercept
the HTTP requests to read the credentials from the sign endpoint or read the Bearer token from
the rest of the endpoints. The provider will search for the user information giving the credentials
or token from the previous step. And the entry point will return a custom error when an authentication
problems occurs.

There is two way to authentication: with the credentials, login and password; or with the Bearer token.
The credentials are only sent at the signIn or singUp endpoints and will return the user information
with a created Bearer token. For the rest of the requests, the previously obtained token will be sent
in the Authorization header to authenticate the user.

The advantage of the JWT is that it is stateless. The token itself contains the information about the
user and the validity of the token. I only need the user to be stored in the database, the rest of
the information comes inside the token.


## Chapter 4

In this fourth video, I've configured the database connexion with JPA. I've used the initialization-mode
to always to build the database everytime the application starts. This may be a problem unless you
write your SQL queries taking into account that the file was already executed.

I've created the Java entities to be mapped against the database. I've mapped each column and created
the one-to-many, many-to-one relationships between the tables. There was also a table that is connected
with itself in a many-to-many relationship. The many-to-many relationships require an intermediary table
to make the connection.

And finally, I've created the Spring JPA repositories to read the data from the database. I've created
those repository with methods which build the database just with the method naming, and I've also
created other methods with custom queries.

https://www.youtube.com/watch?v=-MNfy4eWvK8&list=PLab_if3UBk9-TuyqwMy3JvNHeCh7Ll9Wz&index=6&t=0s


## Chapter 5

In this fifth video I've added two useful libraries: Lombok and Mapstruct.

Lombok is used to generate getters, setters, constructors, builders and more with some annotations at the
class level. This will reduce writting the POJO more quickly, only specifying the fields and the annotations.
The rest will be automatically generated by Lombok.

Mapstruct is used to map two objects field by field. I use Mapstruct to map the entity objects to the DTO
objects. As I don't want entity objects to be returned by the controllers to manage the privacy, I use
DTOs instead. Mapstruct, with some annotations, map field by field the incoming object to the outgoing
object.

https://www.youtube.com/watch?v=7UC3ZjQnric&list=PLab_if3UBk9-TuyqwMy3JvNHeCh7Ll9Wz&index=7&t=0s
