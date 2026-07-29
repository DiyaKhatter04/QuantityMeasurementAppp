# Quantity Measurement App — Microservices

The original monolithic application has been split into two backend services and one frontend application. The business logic remains completely unchanged—only the files have been reorganized, and `SecurityConfig` has been divided into two parts because there are now two separate Spring Boot applications.

```text
QuantityMeasurement-Microservices/
├── auth-service/        → Port 8080 (Handles Google OAuth2 login and issues JWT tokens)
├── quantity-service/    → Port 8081 (Handles Quantity CRUD/History APIs and validates JWT tokens)
└── frontend/            → Port 5173 (React + Vite, UI remains unchanged)
```

## How It Works

1. The frontend redirects `GET /api/auth/login` requests to `auth-service` (port 8080).

2. After a successful Google login, `auth-service` generates a JWT using `jwt.secret` and redirects the browser to:

   `http://localhost:5173/oauth-success?token=...`

   This behavior remains unchanged from the original implementation.

3. The frontend stores the token in `localStorage` and sends it with every request using the following header:

   `Authorization: Bearer <token>`

4. The Quantity APIs (`/api/quantity/**`) are now hosted on `quantity-service` (port 8081). This service validates the same JWT using its `JwtAuthenticationFilter`.

> **Important:** Both services must use the same `jwt.secret` value in their respective `application.properties` files. Otherwise, tokens issued by `auth-service` will be rejected by `quantity-service`. The same value has been configured in both services.

## How to Run the Application (3 Terminals)

### 1. Auth Service (Port 8080)

```bash
cd auth-service

# Set your GOOGLE_CLIENT_ID and GOOGLE_CLIENT_SECRET
# in .env or application-local.properties

mvn spring-boot:run
```

### 2. Quantity Service (Port 8081)

```bash
cd quantity-service

mvn spring-boot:run
```

### 3. Frontend (Port 5173)

```bash
cd frontend

npm install
npm run dev
```

The `vite.config.js` file has been updated to split the development proxy configuration as follows:

* `/api/auth`, `/oauth2`, `/login` → `localhost:8080` (`auth-service`)
* `/api/quantity` → `localhost:8081` (`quantity-service`)

This is purely a routing configuration change—no frontend logic or UI has been modified.

## Security Note

`auth-service/src/main/resources/application-local.properties` contains hardcoded Google OAuth Client ID and Client Secret, similar to the original repository upload.

For production environments, it is recommended to load these values from environment variables:

* `GOOGLE_CLIENT_ID`
* `GOOGLE_CLIENT_SECRET`

Additionally, if these credentials have ever been pushed to a public repository, it is strongly recommended to rotate them using Google Cloud Console.

## Existing Behavior (Intentionally Left Unchanged)

`QuantityMeasurementController.java` already contains the following annotation in the original codebase:

```java
@CrossOrigin(origins = "http://localhost:8080")
```

This does not affect development because Vite's proxy makes the requests appear as same-origin.

However, if the frontend is ever configured to communicate directly with `quantity-service` (port 8081) without using the Vite proxy, this annotation will need to be updated accordingly.

No changes were made here to preserve the original backend behavior, as requested.

## What Was NOT Migrated

The following items were intentionally not migrated:

* `src/test/**` (unit and integration tests) — Splitting these would require additional rework, including separate mocking strategies and test database configurations for each microservice. These can be migrated separately if needed.
* `target/`
* `logs/`
* `node_modules/`
* `dist/`

These are build artifacts and can be regenerated as needed.
 rework chahiye hota (mocking,
  test DB context alag-alag services ke liye). Agar chahiye to bata dena, alag se bana dunga.
- `target/`, `logs/`, `node_modules/`, `dist/` — build artifacts, dobara generate ho jayenge.
