# Quantity Measurement App — Microservices

Original monolith split into 2 backend services + 1 frontend. **Business logic ekdum unchanged hai** — sirf files re-organize aur `SecurityConfig` ko do hisso me split kiya gaya hai (kyunki ab do alag Spring Boot apps hain).

```
QuantityMeasurement-Microservices/
├── auth-service/        → port 8080  (Google OAuth2 login + JWT issue karta hai)
├── quantity-service/    → port 8081  (Quantity CRUD/history APIs, JWT verify karta hai)
└── frontend/             → port 5173  (React + Vite, UI unchanged)
```

## Kaam kaise karta hai

1. Frontend `GET /api/auth/login` → **auth-service (8080)** ko redirect karta hai.
2. Google login ke baad, auth-service JWT banata hai (`jwt.secret` use karke) aur browser ko
   `http://localhost:5173/oauth-success?token=...` par bhej deta hai — yeh **unchanged** hai.
3. Frontend token ko `localStorage` me save karta hai aur har request me `Authorization: Bearer <token>` header bhejta hai.
4. Quantity APIs (`/api/quantity/**`) ab **quantity-service (8081)** par hain. Yeh service wahi JWT
   ko apne `JwtAuthenticationFilter` se validate karta hai.

⚠️ **Important:** Dono services ka `jwt.secret` (application.properties me) **same** hona chahiye,
warna auth-service ka issue kiya token quantity-service par reject ho jayega. Maine values same rakhi hain.

## Run karne ka tareeka (3 terminals)

### 1. Auth Service (port 8080)
```bash
cd auth-service
# .env ya application-local.properties me apna GOOGLE_CLIENT_ID / GOOGLE_CLIENT_SECRET set karo
mvn spring-boot:run
```

### 2. Quantity Service (port 8081)
```bash
cd quantity-service
mvn spring-boot:run
```

### 3. Frontend (port 5173)
```bash
cd frontend
npm install
npm run dev
```

Frontend `vite.config.js` me dev-proxy split kiya gaya hai:
- `/api/auth`, `/oauth2`, `/login` → `localhost:8080` (auth-service)
- `/api/quantity` → `localhost:8081` (quantity-service)

Yeh sirf routing config hai — koi frontend logic/UI change nahi hui.

## Security note
`auth-service/src/main/resources/application-local.properties` me original repo ki tarah hi
Google OAuth client-id/secret hardcoded hain (jaisa original upload me tha). Production me inhe
env vars (`GOOGLE_CLIENT_ID`, `GOOGLE_CLIENT_SECRET`) se lena recommended hai, aur agar yeh secret
kahin public repo me gaya hai to Google Console se rotate kar lena best hoga.

## Ek existing quirk (jo maine chhua nahi, kyunki logic change nahi karna tha)
`QuantityMeasurementController.java` par `@CrossOrigin(origins = "http://localhost:8080")` already
laga hua tha original code me bhi — yeh dev me matter nahi karta kyunki Vite proxy se request
same-origin dikhti hai, lekin agar future me frontend ko kisi doosre origin se seedha quantity-service
(8081) par hit karwana ho (proxy ke bina), to yeh line update karni padegi. Chhua nahi hai kyunki
aapne bola tha backend logic same rakhna hai.

## Kya migrate NAHI kiya gaya
- `src/test/**` (unit/integration tests) — inhe split karne ke liye rework chahiye hota (mocking,
  test DB context alag-alag services ke liye). Agar chahiye to bata dena, alag se bana dunga.
- `target/`, `logs/`, `node_modules/`, `dist/` — build artifacts, dobara generate ho jayenge.
