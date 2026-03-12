# 🗳️ Booth Survey Management System

A production-ready **Survey Management REST API** built with **Java Spring Boot**, 
featuring JWT-based authentication, role-based access control (Admin & Volunteer), 
survey submission, approval workflow, and booth analytics.

---

## ✨ Features

- 🔐 JWT Authentication — secure login with token-based access
- 👥 Role-Based Access Control — ADMIN and VOLUNTEER roles
- 📋 Survey Submission — volunteers submit booth surveys
- ✅ Admin Approval — admin reviews and approves surveys
- 📊 Booth Analytics — date-range based analytics for admins
- 💾 H2 In-Memory Database — easy setup, no external DB needed
- 📄 Clean REST API — structured endpoints, easy to test with Postman

---

## 🛠️ Tech Stack

| Technology     | Usage                        |
|----------------|------------------------------|
| Java 17+       | Core Language                |
| Spring Boot    | Backend Framework            |
| Spring Security| Authentication & RBAC        |
| JWT            | Token-based Auth             |
| H2 Database    | In-Memory Database           |
| Maven          | Build & Dependency Manager   |
| IntelliJ IDEA  | Development IDE              |

---

## 👤 Default Users / Roles

| Username    | Password  | Role      |
|-------------|-----------|-----------|
| admin       | password  | ADMIN     |
| volunteer1  | password  | VOLUNTEER |

---

## 🚀 How to Run (IntelliJ IDEA)

1. Open **IntelliJ IDEA**
2. Select **Open** and choose the `booth-survey-system` folder
3. Wait for **Maven** to download all dependencies
4. Open `src/main/java/com/example/boothsurvey/BoothSurveyApplication.java`
5. Click the green **Run** button ▶️

---

## 📡 API Endpoints

### 🔑 Authentication
```
POST /api/auth/login
Body: {"username":"volunteer1","password":"password"}
→ Returns: Bearer Token
```

### 📋 Survey
```
POST /api/surveys              → Submit survey (Volunteer token)
POST /api/surveys/{id}/approve → Approve survey (Admin token)
```

### 📊 Analytics
```
GET /api/analytics/booths?from=2024-01-01&to=2026-12-31
→ Booth-wise analytics (Admin token)
```

---

## 📁 Project Structure
```
booth-survey-system/
├── src/main/java/com/example/boothsurvey/
│   ├── controller/      # REST Controllers
│   ├── service/         # Business Logic
│   ├── repository/      # Data Access Layer
│   ├── model/           # Entity Classes
│   ├── security/        # JWT + Spring Security Config
│   └── BoothSurveyApplication.java
├── src/main/resources/
│   └── application.properties
├── pom.xml
└── README.md
```

---

## 👤 Author

**Pratham Rathod**  
📍 Pune, Maharashtra, India  
🔗 [github.com/mrprathm](https://github.com/mrprathm)

---

> Built with ❤️ using Java Spring Boot | mrprathm @ GitHub
```

---

**LinkedIn Project Description:**
```
Built a Booth Survey Management System — a production-ready REST API 
using Java Spring Boot with JWT authentication and role-based access 
control (Admin & Volunteer). Features include survey submission, admin 
approval workflow, and date-range booth analytics. 
Secured with Spring Security and backed by H2 in-memory database.

Tech: Java | Spring Boot | Spring Security | JWT | H2 | Maven | REST API
