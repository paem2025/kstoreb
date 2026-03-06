# Database Setup

## 1. Create application user (recommended)

Run as MySQL admin:

```sql
CREATE USER IF NOT EXISTS 'latienda_app'@'localhost' IDENTIFIED BY 'change_this_password';
GRANT SELECT, INSERT, UPDATE, DELETE, CREATE, ALTER, DROP, INDEX ON latiendadekelly.* TO 'latienda_app'@'localhost';
FLUSH PRIVILEGES;
```

`CREATE/ALTER/DROP` are required for first deploy with Flyway migrations.

Set environment variables before starting the backend:

```powershell
$env:SPRING_DATASOURCE_USERNAME="latienda_app"
$env:SPRING_DATASOURCE_PASSWORD="change_this_password"
$env:APP_ADMIN_TOKEN="change_this_admin_token"
```

## 2. Local dev quickstart

If you want to keep using local root defaults, run with:

```powershell
$env:SPRING_PROFILES_ACTIVE="local"
```

This uses `src/main/resources/application-local.properties`.

## 3. Schema management

- Flyway migrations live in `src/main/resources/db/migration`.
- Hibernate runs with `spring.jpa.hibernate.ddl-auto=validate`.
- The legacy `mysql-schema.sql` file is kept as a reference copy.
- A health endpoint is available at `GET /api/health`.

## 4. Frontend admin integration

For admin writes through the Next.js frontend proxy:

```powershell
$env:ADMIN_API_TOKEN="change_this_admin_token"
$env:BACKEND_API_BASE_URL="http://localhost:8080"
```

`ADMIN_API_TOKEN` must match backend `APP_ADMIN_TOKEN`.
