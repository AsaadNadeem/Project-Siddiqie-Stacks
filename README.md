# Stacks (Spring Boot)

Login and signup web app built with Spring Boot, Thymeleaf, and MySQL.

## Stack

- Java 21
- Spring Boot
- Thymeleaf
- MySQL
- Maven Wrapper (`mvnw`)

## Run Locally

1. Create a MySQL database:
   - `stacks`
2. Set environment variables:
   - `SPRING_DATASOURCE_URL=jdbc:mysql://localhost:3306/stacks`
   - `SPRING_DATASOURCE_USERNAME=root`
   - `SPRING_DATASOURCE_PASSWORD=your_password`
3. Start the app:
   - Windows: `mvnw.cmd spring-boot:run`
   - Linux/macOS: `./mvnw spring-boot:run`
4. Open:
   - `http://localhost:8080`

## Deploy To Railway

### 1. Push to GitHub

```bash
git add .
git commit -m "Prepare app for Railway deployment"
git branch -M main
git remote add origin https://github.com/<your-username>/<your-repo>.git
git push -u origin main
```

### 2. Create Railway Project

1. Go to Railway and create a new project.
2. Select "Deploy from GitHub repo".
3. Pick this repository.

### 3. Add MySQL on Railway

1. In Railway project, add a MySQL service/plugin.
2. Copy DB connection values into the app service environment variables.

### 4. Set App Environment Variables (Railway)

Set these in the app service:

- `SPRING_DATASOURCE_URL`
- `SPRING_DATASOURCE_USERNAME`
- `SPRING_DATASOURCE_PASSWORD`
- Optional: `SPRING_JPA_HIBERNATE_DDL_AUTO=update`

`PORT` is injected automatically by Railway and is already mapped in `application.properties`.

### 5. Deploy

Railway will build and start using:

- Build: `mvn -DskipTests clean package`
- Start: `java -Dserver.port=$PORT -jar target/*.jar`

## Notes

- Do not commit secrets.
- `.gitignore` excludes build artifacts and IDE files.
- If deployment fails due to DB auth/network rules, regenerate DB credentials in Railway and redeploy.
