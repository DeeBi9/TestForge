# Bug Reports — TestForge

> Note: FakeStore API is a public mock API. The bugs below are realistic examples documented during testing to demonstrate the defect reporting format and workflow.

---

## BUG-001 — Product price accepts negative value via POST

| Field | Details |
|-------|---------|
| **Severity** | Medium |
| **Priority** | High |
| **Status** | Open |
| **Environment** | Postman / Ubuntu 24.04 / FakeStore API v2.1.11 |

### Steps to Reproduce
1. Send POST request to `https://fakestoreapi.com/products`
2. Set body: `{"title":"Test","price":-10.99,"description":"test","image":"https://i.pravatar.cc","category":"electronics"}`

### Expected
API should reject the request with a validation error (price must be positive).

### Actual
API returns HTTP 200 with the product created, including the negative price.

### Evidence
Response body shows `"price":-10.99` in the returned object.

---

## BUG-002 — Login accepts empty string credentials without proper error

| Field | Details |
|-------|---------|
| **Severity** | Low |
| **Priority** | Medium |
| **Status** | Open |
| **Environment** | Postman / Ubuntu 24.04 / FakeStore API v2.1.11 |

### Steps to Reproduce
1. Send POST request to `https://fakestoreapi.com/auth/login`
2. Set body: `{"username":"","password":""}`

### Expected
API should return a meaningful error message (e.g., "Username and password are required").

### Actual
API returns HTTP 401 with generic error, not distinguishing between invalid credentials and empty input.

### Evidence
Response: `{"error":"Invalid username and password"}`

---

## BUG-003 — GET /products/{id} returns 200 for non-existent product ID

| Field | Details |
|-------|---------|
| **Severity** | Medium |
| **Priority** | Medium |
| **Status** | Open |
| **Environment** | Postman / Ubuntu 24.04 / FakeStore API v2.1.11 |

### Steps to Reproduce
1. Send GET request to `https://fakestoreapi.com/products/99999`

### Expected
API should return HTTP 404 Not Found.

### Actual
API returns HTTP 200 with `null` body instead of a proper 404 status code.

### Evidence
Status code is 200, response body is `null`.

---

## BUG-004 — Cart creation does not validate userId existence

| Field | Details |
|-------|---------|
| **Severity** | Low |
| **Priority** | Low |
| **Status** | Open |
| **Environment** | Postman / Ubuntu 24.04 / FakeStore API v2.1.11 |

### Steps to Reproduce
1. Send POST request to `https://fakestoreapi.com/carts`
2. Set body: `{"userId":99999,"date":"2024-01-01","products":[{"productId":1,"quantity":1}]}`

### Expected
API should return an error indicating the user does not exist.

### Actual
API returns HTTP 200 with the cart created for a non-existent user.

### Evidence
Response includes `"userId":99999` with a generated cart id.

---

## BUG-005 — Products endpoint does not validate limit parameter type

| Field | Details |
|-------|---------|
| **Severity** | Low |
| **Priority** | Low |
| **Status** | Open |
| **Environment** | Postman / Ubuntu 24.04 / FakeStore API v2.1.11 |

### Steps to Reproduce
1. Send GET request to `https://fakestoreapi.com/products?limit=-5`
2. Also try: `https://fakestoreapi.com/products?limit=abc`

### Expected
API should return a 400 Bad Request or ignore invalid limit values.

### Actual
API returns HTTP 200 with the full product list, ignoring the invalid parameter.

### Evidence
Status code is 200, all 20 products returned regardless of invalid limit.
