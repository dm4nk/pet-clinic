[![CircleCI](https://circleci.com/gh/dm4nk/pet-clinic/tree/master.svg?style=svg&circle-token=786fd38fd00c2d100bf2203ea074a897e365dbe4)](https://circleci.com/gh/dm4nk/pet-clinic/tree/master)

# pet-clinic

This application was built using
[Java 11](https://jdk.java.net/11/),
[Spring](https://spring.io/),
[Spring Boot](https://spring.io/projects/spring-boot),
[Hibernate ORM](https://hibernate.org/),
[H2 Database](https://www.h2database.com/html/main.html)
with [Thymeleaf](https://www.thymeleaf.org/)
for rendering the UI.

It represents Pet clinic, providing users with CRUD operations with 
[Owners](https://github.com/dm4nk/pet-clinic/blob/master/pet-clinic-data/src/main/java/com/dm4nk/petclinic/model/Owner.java), their 
[Pets](https://github.com/dm4nk/pet-clinic/blob/master/pet-clinic-data/src/main/java/com/dm4nk/petclinic/model/Pet.java) and 
[Visits](https://github.com/dm4nk/pet-clinic/blob/master/pet-clinic-data/src/main/java/com/dm4nk/petclinic/model/Visit.java) to certain
[Veterinarian](https://github.com/dm4nk/pet-clinic/blob/master/pet-clinic-data/src/main/java/com/dm4nk/petclinic/model/Vet.java)

It is copy of [spring-petclinic](https://github.com/spring-projects/spring-petclinic)
rewritten for educational purpose, helping with understanding basic principles and syntax of Spring, JPA, MVC pattern,
Maven plugins, Caching, Validation, Tests, HTML and CSS

## Running Application Process on your computer

1. Download the application by clicking [here](https://github.com/dm4nk/pet-clinic/archive/master.zip)
2. Unzip the application
3. Dowload and Install [Java 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
4. Set the environment variable `JAVA_HOME` to the root of your Java 11 jdk
5. Download and Install [Maven](https://maven.apache.org/download.cgi)
6. Open a terminal
7. Move to the root of the application
8. Run `mvn spring-boot:run`
9. Navigate to http://localhost:8080 with your browser

### Index

![Pet Clinic Index](https://user-images.githubusercontent.com/80630476/149615604-642abfe1-a10f-48bf-8d41-3bc097e315eb.png)

### Find Owners

![Pet Clinic Find Owners](https://user-images.githubusercontent.com/80630476/149615592-c810cf11-7668-441b-8bb4-ada745c39325.png)

### Owner Info

![Pet Clinic Show Owner](https://user-images.githubusercontent.com/80630476/149615505-b56d1995-dc65-44c5-987d-2899e087aefe.png)

### Pet Clinic New Owner

![Pet Clinic Add Owner](https://user-images.githubusercontent.com/80630476/149615632-7f821101-361c-428d-b1f4-3c0c0a1ad314.png)

### Pet Clinic Veterinarians

![Pet Clinic List Veterinarians](https://user-images.githubusercontent.com/80630476/149615621-d63854c0-8581-4ac2-9ed4-2b889dad0481.png)

Full update history available at [Issues](https://github.com/dm4nk/pet-clinic/issues)
