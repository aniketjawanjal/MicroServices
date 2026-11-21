# Enterprise Employee Management Microservices 🏢🌐

A distributed microservices architecture built with **Spring Boot 3**, **Spring Cloud**, **Netflix Eureka Discovery Server**, **Spring Cloud OpenFeign**, **Spring Data JPA**, and **MySQL**.

---

## 🏛️ Microservice Architecture

```text
                        ┌───────────────────────────────┐
                        │      Eureka Service Registry  │
                        │       (http://localhost:8761) │
                        └───────────────▲───────────────┘
                                        │ Register & Discover
            ┌───────────────────────────┼───────────────────────────┐
            │                           │                           │
            ▼                           ▼                           ▼
┌─────────────────────────┐ ┌─────────────────────────┐ ┌─────────────────────────┐
│    employee-service     │ │   department-service    │ │  organization-service   │
│       (Port: 8080)      │ │       (Port: 8081)      │ │       (Port: 8082)      │
│  - Aggregates employee, │ │  - Manages department   │ │  - Manages organization │
│    dept & org data      │ │    master data          │ │    master data          │
│  - OpenFeign Client     │ │                         │ │                         │
└───────────┬─────────────┘ └───────────┬─────────────┘ └───────────┬─────────────┘
            │                           │                           │
            ▼                           ▼                           ▼
   MySQL: employee_db          MySQL: department_db        MySQL: orgnization_db
```

---

## 🚀 Services Overview

| Service Name | Port | Database | Primary Responsibility |
|---|---|---|---|
| **employee-service** | `8080` | `employee_db` | Core employee entity CRUD, aggregates department & organization details via Feign Client into unified `ApiResponse` |
| **department-service** | `8081` | `department_db` | Department master catalog (department name, code, description) |
| **organization-service** | `8082` | `orgnization_db` | Organization entity records (organization name, code, created date) |

---

## 🛠️ Tech Stack & Patterns

- **Framework**: Spring Boot 3 & Spring Cloud
- **Service Discovery**: Spring Cloud Netflix Eureka Client
- **Inter-Service Communication**: Spring Cloud OpenFeign & WebClient / RestTemplate
- **Persistence**: Spring Data JPA / Hibernate
- **Database per Service Pattern**: Dedicated MySQL database per microservice
- **Validation & Exception Handling**: Centralized `GlobalExceptionHandler` returning `ErrorDetails`
- **Build Tool**: Maven

---

## 📋 API Endpoints

### 1. Employee Service (`http://localhost:8080`)
- `POST /api/employees` - Register a new employee with department & organization codes.
- `GET /api/employees/{id}` - Fetch composite response containing employee details + department details + organization details.

### 2. Department Service (`http://localhost:8081`)
- `POST /api/departments` - Create department.
- `GET /api/departments/{code}` - Fetch department by code.

### 3. Organization Service (`http://localhost:8082`)
- `POST /api/organizations` - Create organization.
- `GET /api/organizations/{code}` - Fetch organization by code.

---

## ⚙️ Setup & Execution

### 1. Prerequisites
- Java 17 or higher
- MySQL running locally on port `3306`
- Eureka Discovery Server running on port `8761`

### 2. Create Databases
```sql
CREATE DATABASE employee_db;
CREATE DATABASE department_db;
CREATE DATABASE orgnization_db;
```

### 3. Run Microservices
Start each service in a separate terminal:

```bash
# 1. Department Service
cd department-service
./mvnw clean spring-boot:run

# 2. Organization Service
cd organization-service
./mvnw clean spring-boot:run

# 3. Employee Service
cd employee-service
./mvnw clean spring-boot:run
```

---

## 📂 Project Structure

```
MicroServices/
├── department-service/       # Port 8081 - Department CRUD & Eureka Client
│   ├── src/
│   ├── pom.xml
│   └── mvnw / mvnw.cmd
├── employee-service/         # Port 8080 - Composite Employee Aggregator & Feign
│   ├── src/
│   ├── pom.xml
│   └── mvnw / mvnw.cmd
├── organization-service/     # Port 8082 - Organization CRUD & Eureka Client
│   ├── src/
│   ├── pom.xml
│   └── mvnw / mvnw.cmd
└── README.md
```

---

## 👤 Author
- **Aniket Jawanjal** - [GitHub Profile](https://github.com/aniketjawanjal)
