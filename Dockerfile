# Step 1: Use an official Maven image to build the app
FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /app

# Copy the pom.xml and source code
COPY pom.xml .
COPY src ./src

# Build the project
RUN mvn clean package -DskipTests

# Step 2: Use a lightweight JDK image to run the app
FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app

# Copy the built JAR from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose port 8080
EXPOSE ${SERVER_PORT}

# Run the Spring Boot app
ENTRYPOINT ["java","-jar","app.jar"]