# Backend Deploy on Coolify (`kstoreb`)

## 1. Create MySQL service first

Use a dedicated database and user, for example:

- DB name: `latiendadekelly`
- User: `latienda_app`
- Strong password

The DB user must have:

```sql
GRANT SELECT, INSERT, UPDATE, DELETE, CREATE, ALTER, DROP, INDEX ON latiendadekelly.* TO 'latienda_app'@'%';
FLUSH PRIVILEGES;
```

## 2. Create backend service from repo

- Repository: `paem2025/kstoreb`
- Branch: `main`
- Build type: `Dockerfile`
- Port: `8080`

## 3. Required environment variables

Set these in Coolify backend service:

```env
PORT=8080
SPRING_DATASOURCE_URL=jdbc:mysql://<mysql-host>:3306/latiendadekelly?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
SPRING_DATASOURCE_USERNAME=latienda_app
SPRING_DATASOURCE_PASSWORD=<strong-db-password>
APP_ADMIN_TOKEN=<strong-random-admin-token>
APP_CORS_ALLOWED_ORIGINS=https://<frontend-domain>
```

Notes:

- `APP_ADMIN_TOKEN` is required for create/update/delete endpoints.
- `APP_CORS_ALLOWED_ORIGINS` should include your frontend domain (comma-separated if multiple).
- If frontend uses only its own `/api/*` proxy routes, CORS is less critical but still recommended.

## 4. Health check

Use:

- Path: `/api/health`
- Expected status: `200`

## 5. First boot verification

After deploy:

1. Check logs for Flyway migration success.
2. Call `GET /api/health`.
3. Call `GET /api/products` and `GET /api/landing`.

## Optional: H2 single-container mode (no MySQL)

If you want a lightweight setup with very little data and no separate DB service,
you can run with profile `h2`.

Use these environment variables:

```env
PORT=8080
SPRING_PROFILES_ACTIVE=h2
APP_ADMIN_TOKEN=<strong-random-admin-token>
APP_CORS_ALLOWED_ORIGINS=https://<frontend-domain>,https://www.<frontend-domain>
```

Recommended in Coolify:

- Add a persistent volume mounted at `/app/data` to keep H2 file data between restarts.
- Keep health check at `/api/health`.
