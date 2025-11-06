# TaskFlow API

TaskFlow is a RESTful task management API built with **Spring Boot**, **PostgreSQL**, and **Docker**. It includes JWT-based user authentication, input validation, and Swagger UI documentation.

---

## 🚀 Features
- ✅ User registration and login with JWT authentication  
- ✅ Create, update, delete, and view tasks  
- ✅ Input validation and global exception handling  
- ✅ API documentation via Swagger UI  
- ✅ Containerized with Docker and Docker Compose  

---

## 🛠️ Tech Stack
- **Java 17**
- **Spring Boot 3**
- **Spring Security (JWT)**
- **PostgreSQL**
- **Docker / Docker Compose**
- **SpringDoc OpenAPI (Swagger UI)**

---

## ⚙️ Configuration

### Environment Variables
Create a `.env` file in the project root with the following content:

```
POSTGRES_DB=taskflow_db
POSTGRES_USER=taskflow_user
POSTGRES_PASSWORD=taskflow_pass
POSTGRES_PORT=5432
SPRING_DATASOURCE_URL=jdbc:postgresql://db:${POSTGRES_PORT}/${POSTGRES_DB}
SPRING_DATASOURCE_USERNAME=${POSTGRES_USER}
SPRING_DATASOURCE_PASSWORD=${POSTGRES_PASSWORD}
```

### Application Properties

In src/main/resources/application.properties:

```
spring.application.name=taskflow
spring.datasource.url=${SPRING_DATASOURCE_URL}
spring.datasource.username=${SPRING_DATASOURCE_USERNAME}
spring.datasource.password=${SPRING_DATASOURCE_PASSWORD}
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
springdoc.api-docs.path=/api-docs
springdoc.swagger-ui.path=/swagger-ui.html
jwt.secret=${JWT_SECRET}
```

## 🐳 Running with Docker

1️⃣ Build and start containers:

```
docker-compose up --build
```

2️⃣ Verify services

- API: http://localhost:8080/swagger-ui.html

- Database: localhost:5432

3️⃣ Stopping containers:

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

Ensure PostgreSQL is running and credentials match your .env or application.properties.

## 🧑‍💻 Author

```
Andrew Herubin
Plano, TX
andrewherubin@outlook.com
```