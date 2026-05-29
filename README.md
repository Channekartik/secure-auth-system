# 🔐 Secure Authentication System

A full-stack Secure Authentication System built using **React.js**, **Spring Boot**, **Spring Security**, **JWT Authentication**, and **MySQL**. The application provides secure user registration, login, role-based authorization, and protected routes for users and administrators.

## 🚀 Features

### Authentication & Security

* User Registration
* User Login
* Admin Login
* JWT (JSON Web Token) Authentication
* Password Encryption using BCrypt
* Spring Security Integration
* Protected API Endpoints

### Authorization

* Role-Based Access Control (RBAC)
* USER Role
* ADMIN Role
* Secure Route Protection

### Frontend

* React.js
* React Router DOM
* React Bootstrap
* Axios API Integration
* Responsive UI Design
* Authentication Context API

### Backend

* Spring Boot
* Spring Security
* Spring Data JPA
* JWT Token Generation & Validation
* RESTful APIs
* Global Exception Handling

### Database

* MySQL
* Hibernate ORM
* Automatic Table Creation using JPA

---

## 🛠️ Tech Stack

### Frontend

* React.js
* React Router DOM
* React Bootstrap
* Axios

### Backend

* Java 17
* Spring Boot 3
* Spring Security
* Spring Data JPA
* JWT (JJWT)

### Database

* MySQL 8

### Build Tools

* Maven
* npm

---

## 📂 Project Structure

```text
secure-auth-system
│
├── frontend
│   ├── src
│   ├── public
│   └── package.json
│
├── backend
│   ├── src
│   ├── pom.xml
│   └── application.properties
│
└── README.md
```

## ⚙️ Backend Setup

### Configure MySQL

Create a database:

```sql
CREATE DATABASE secure_auth_db;
```

Update application.properties:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/secure_auth_db
spring.datasource.username=root
spring.datasource.password=your_password
```

### Run Backend

```bash
cd backend
mvn spring-boot:run
```

Backend URL:

```text
http://localhost:8080
```

---

## ⚙️ Frontend Setup

Install dependencies:

```bash
cd frontend
npm install
```

Start frontend:

```bash
npm start
```

Frontend URL:

```text
http://localhost:3000
```

---

## 🔑 API Endpoints

### Register User

```http
POST /api/auth/register
```

### Login User

```http
POST /api/auth/login
```

### User APIs

```http
GET /api/user/**
```

### Admin APIs

```http
GET /api/admin/**
```

---

## 👥 Roles

### USER

* Login
* Access user dashboard
* Access user-specific resources

### ADMIN

* Login
* Access admin dashboard
* Manage protected admin resources

---

## 🔐 Authentication Flow

1. User registers an account.
2. Password is encrypted using BCrypt.
3. User logs in with email and password.
4. Backend generates JWT token.
5. Token is stored in browser localStorage.
6. Axios automatically attaches JWT token to requests.
7. Spring Security validates the token.
8. Access is granted based on user role.

---

## 📸 Screenshots

Add screenshots here:

* Login Page
* Registration Page
* User Dashboard
* Admin Dashboard

---

## 👨‍💻 Author

Kartik

Master of Computer Science (MCS)

Full Stack Java Developer

---

## ⭐ Future Enhancements

* Password Reset
* Email Verification
* Refresh Tokens
* User Profile Management
* Docker Deployment
* Swagger API Documentation
* Cloud Deployment

```
```
