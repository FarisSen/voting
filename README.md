# Eurovision Voting System API Design

This project is designed to provide REST APIs for eurovision voting system.

## Built With

- Spring Boot
- Spring Data JPA
- H2 - Database
- Lombok 
- Gradle
- JUnit/Mockito
- Swagger

## Getting Started

Once the application is started, navigate to the URL http://localhost:8080/swagger-ui/index.html to check out the Swagger UI.

#### Post a vote 

```java
localhost:8080/votes/{yearNum}
Request Body 
{
  "countryFrom": <countryFrom>,
  "votedFor": <votedFor>
}
```

#### Get top three countries for the specified year

```java
localhost:8080/votes/{yearNum}
```

#### Get the top three favorite songs for the specified year and country

```java
localhost:8080/votes/{yearNum}/{countryName}
```



