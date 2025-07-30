# Employee Manager API

A RESTful API for employee management built with Spring Boot, MySQL, and Docker.

---

## 📦 Technologies

- Java 17
- Spring Boot 3
- Spring Data JPA
- MySQL 8
- Docker & Docker Compose
- Maven

---

## 🚀 Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/eduardzc/employee-manager-api.git
cd employee-manager-api
```

## 2. Run the application with Docker

```bash
docker compose up --build
```

The API will be available at http://localhost:8080

---

## 🔁 API Endpoints

| Method   | Endpoint                 | Description         |
| -------- | --------                 | -----------         | 
| GET      | ```api/employees```      | Get all employees   |
| GET      | ```api/employees/{id}``` | Get employee by ID  |
| POST     | ```api/employees```      | Create new employee |
| PUT      | ```api/employees/{id}``` | Update employee     |
| DELETE   | ```api/employees/{id}``` | Delete employee     |

## ⚙️ Environment variables

Defined in docker-compose.yml:

```yaml
SPRING_DATASOURCE_URL=jdbc:mysql://db:3306/employees_db
SPRING_DATASOURCE_USERNAME=springstudent
SPRING_DATASOURCE_PASSWORD=springpwd
```

## 🗃️ Project Structure

```css
.
├── Dockerfile
├── README.md
├── docker-compose.yml
├── pom.xml
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.employee_api.employeemanager
│   │   │       ├── controller/
│   │   │       ├── exception/
│   │   │       ├── model/
│   │   │       ├── repository/
│   │   │       ├── service/
│   │   │       └── EmployeemanagerApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── static/
│   │       └── templates/
│   └── test/
│       └── java/com.employee_api.employeemanager/
│           └── EmployeemanagerApplicationTests.java
```

## 🧪 Testing the API

You can test the API using Postman or curl.

```bash
curl -X POST http://localhost:8080/api/employees \
  -H "Content-Type: application/json" \
  -d '{"name":"Ana","email":"ana@example.com","position":"Backend Developer"}'
```

## 📘 API Documentation (Swagger UI)

This project includes auto-generated API documentation using **OpenAPI 3.1** and **Swagger UI**.
After running the application, you can access the interactive API documentation at:

`http://localhost:8080/swagger-ui/index.html`

From there, you can:
- Explore all available endpoints
- View request/response schemas
- Test the API directly from your browser



## 👨‍💻 Author

* Enrique Eduardo Rodriguez Couoh [@eduardzc](https://github.com/eduardzc)