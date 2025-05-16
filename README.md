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
├── HELP.md
├── README.md
├── docker-compose.yml
├── mvnw
├── mvnw.cmd
├── pom.xml
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── employee_api
│   │   │           └── employeemanager
│   │   │               ├── EmployeemanagerApplication.java
│   │   │               ├── controller
│   │   │               │   └── EmployeeController.java
│   │   │               ├── exception
│   │   │               │   ├── BadRequestException.java
│   │   │               │   ├── CustomErrorResponse.java
│   │   │               │   ├── GlobalExceptionHandler.java
│   │   │               │   └── ResourceNotFoundException.java
│   │   │               ├── model
│   │   │               │   └── Employee.java
│   │   │               ├── repository
│   │   │               │   └── EmployeeRepository.java
│   │   │               └── service
│   │   │                   ├── EmployeeService.java
│   │   │                   └── EmployeeServiceImpl.java
│   │   └── resources
│   │       ├── application.properties
│   │       ├── static
│   │       └── templates
│   └── test
│       └── java
│           └── com
│               └── employee_api
│                   └── employeemanager
│                       └── EmployeemanagerApplicationTests.java
└── target
    ├── classes
    │   ├── META-INF
    │   │   ├── MANIFEST.MF
    │   │   └── maven
    │   │       └── com.employee-api
    │   │           └── employeemanager
    │   │               ├── pom.properties
    │   │               └── pom.xml
    │   ├── application.properties
    │   └── com
    │       └── employee_api
    │           └── employeemanager
    │               ├── EmployeemanagerApplication.class
    │               ├── controller
    │               │   └── EmployeeController.class
    │               ├── exception
    │               │   ├── BadRequestException.class
    │               │   ├── CustomErrorResponse.class
    │               │   ├── GlobalExceptionHandler.class
    │               │   └── ResourceNotFoundException.class
    │               ├── model
    │               │   └── Employee.class
    │               ├── repository
    │               │   └── EmployeeRepository.class
    │               └── service
    │                   ├── EmployeeService.class
    │                   └── EmployeeServiceImpl.class
    └── test-classes
        └── com
            └── employee_api
                └── employeemanager
                    └── EmployeemanagerApplicationTests.class
```