# Booth Survey Management System
Built with Spring Boot, JWT, and H2.

### Roles
- **admin** / **password** (ADMIN)
- **volunteer1** / **password** (VOLUNTEER)

### How to Run in IntelliJ IDEA
1. Open IntelliJ IDEA.
2. Select 'Open' and choose the `booth-survey-system` folder.
3. Wait for Maven to download dependencies.
4. Open `src/main/java/com/example/boothsurvey/BoothSurveyApplication.java`.
5. Click the green 'Run' button.

### API Usage
1. **Login**: POST `/api/auth/login` with `{"username":"volunteer1","password":"password"}`. Copy the token.
2. **Submit Survey**: POST `/api/surveys` with Bearer Token.
3. **Approve**: POST `/api/surveys/{id}/approve` (Use Admin token).
4. **Analytics**: GET `/api/analytics/booths?from=2024-01-01&to=2026-12-31` (Use Admin token).
"# Booth-Servey-System" 
