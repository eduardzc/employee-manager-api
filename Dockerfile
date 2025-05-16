#Step 1. Build JAR with Maven
FROM maven:3.9.4-eclipse-temurin-17 AS Build
#this image contains Maven and Java 17

WORKDIR /app
#create work directory inside the container

COPY pom.xml .
COPY src ./src
#Copy POM and source code files

RUN mvn clean package -DskipTests
#Execute Maven to compile and package app (without executing tests)

#Step 2. Lighter image to execute the application
FROM eclipse-temurin:17-jdk
#Image with only JDK to run the JAR

WORKDIR /app
#directory where the app will run

COPY --from=build /app/target/employeemanager-0.0.1-SNAPSHOT.jar app.jar
#copy JAR from step 1 (build JAR)

EXPOSE 8080
#Expose port where the app runs (Spring Boot default port)

ENTRYPOINT ["java", "-jar", "app.jar"]
#command to run app when container begins
