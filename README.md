# Job Portal (Spring Boot + AngularJS)

## Run locally
1. Ensure Java 11+, Maven, and PostgreSQL are installed.
2. Create local DB: `createdb jobportal_db` (or use pgAdmin).
3. Edit `src/main/resources/application.properties` if you need custom credentials.
4. Build and run:
   ```bash
   mvn clean package
   java -jar target/job-portal-0.0.1-SNAPSHOT.jar
   ```
5. Open `http://localhost:8080`.

## Deploy on Render (recommended)
1. Create a GitHub repository and push the project.
2. Create a new **PostgreSQL** database on Render (Render dashboard -> Databases -> New Database).
3. Create a new **Web Service** on Render, connect it to your GitHub repo.
4. In the Web Service settings, set environment variables (from the database connection info):
   - `SPRING_DATASOURCE_URL` -> JDBC URL like `jdbc:postgresql://host:port/dbname`
   - `SPRING_DATASOURCE_USERNAME`
   - `SPRING_DATASOURCE_PASSWORD`
   - `PORT` (Render sets this automatically; default 8080 works)
5. Render will build with `mvn -B -e -DskipTests package` (default). After deploy you get a public URL.
