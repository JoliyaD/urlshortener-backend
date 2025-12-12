# Build Stage
FROM maven:3.9.5-eclipse-temurin-17 AS build
WORKDIR /app

# Copy everything
COPY . .

# Build the project
RUN mvn -DskipTests clean package

# Runtime Stage
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Copy the JAR from build stage
COPY --from=build /app/target/*.jar app.jar

# Run the app
ENTRYPOINT ["java","-jar","/app/app.jar"]
