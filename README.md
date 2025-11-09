# TaskFlow API

TaskFlow is a RESTful task management API built with **Spring Boot** and **Docker**. It includes JWT-based user authentication, input validation, and Swagger UI documentation.

---

## 🚀 Features
- ✅ User registration and login with JWT authentication  
- ✅ Create, update, delete, and view tasks  
- ✅ Input validation and global exception handling  
- ✅ API documentation via Swagger UI  
- ✅ Containerized with Docker and Docker Compose  

---

## 🛠️ Tech Stack
- **Java 21**
- **Spring Boot 3**
- **Spring Security (JWT)**
- **Docker / Docker Compose**
- **SpringDoc OpenAPI (Swagger UI)**

---

## ⚙️ Configuration

### Environment Variables
Create a `.env` file in the project root with the following content:

```
DATASOURCE_URL= <full url to be read by spring.datasource.url>
DATASOURCE_USERNAME= <db username>
DATASOURCE_PASSWORD= <db password>
HIBERNATE_DDL_AUTO= <defaults to update>
HIBERNATE_DIALECT= <dialect for your DB engine>
JWT_SECRET= <key used for signing JWTs>
SERVER_PORT= <defaults to 8080>
APP_NAME= <deafults to TaskFlow-API>
```

### Application Properties

Values read from environment variables.

In src/main/resources/application.properties:

```
spring.datasource.url=${DATASOURCE_URL}
spring.datasource.username=${DATASOURCE_USERNAME}
spring.datasource.password=${DATASOURCE_PASSWORD}
spring.jpa.hibernate.ddl-auto=${HIBERNATE_DDL_AUTO:update}
spring.jpa.properties.hibernate.dialect=${HIBERNATE_DIALECT}
app.jwt.secret=${JWT_SECRET}
server.port=${SERVER_PORT:8080}
springdoc.api-docs.enabled=true
springdoc.swagger-ui.path=/swagger-ui.html
spring.application.name=${APP_NAME:TaskFlow-API}
```

## 🐳 Running with Docker

1️⃣ Build and start container:

```
docker-compose up --build
```

2️⃣ Verify services

- API: http://localhost:8080/swagger-ui.html

- Database: localhost:5432

3️⃣ Stopping container:

```
docker-compose down
```

## 🧩 Endpoints Overview

### Authentication

```
Method	Endpoint	            Description
POST	/api/auth/register	    Register a new user
POST	/api/auth/login	        Login and receive a JWT token
```

### Tasks

```
Method	Endpoint	        Description
GET	    /api/tasks	        Get all tasks
GET	    /api/tasks/{id}	    Get task by ID
POST	/api/tasks	        Create new task
PUT	    /api/tasks/{id}	    Update task
DELETE	/api/tasks/{id}	    Delete task
```

## 🔐 Authentication

Swagger UI supports JWT authorization:

1. Login via /api/auth/login

2. Copy the returned token

3. Click Authorize (🔒) in Swagger UI

4. Paste the token

## 🧰 Development Setup (Without Docker)

To run locally:

```
mvn clean spring-boot:run
```

Ensure DB is running and credentials match your .env or application.properties.

## 🧑‍💻 Author

```
Andrew Herubin
Plano, TX
andrewherubin@outlook.com
```