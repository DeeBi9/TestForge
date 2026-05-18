# Test Cases — TestForge

> 30 test cases covering Authentication, Products, Carts, and Edge Cases using the FakeStore API.
> Executed on: 21 Sep 2026 against `https://fakestoreapi.com`

## Authentication Test Cases

| TC ID | Title | Precondition | Steps | Expected Result | Actual | Status |
|-------|-------|--------------|-------|-----------------|--------|--------|
| TC001 | Successful login with valid credentials | User `mor_2314` exists | 1. POST `/auth/login` with `{"username":"mor_2314","password":"83r5^_"}` | HTTP 200, token returned | HTTP 201, JWT token returned | Pass |
| TC002 | Login fails with wrong password | User `mor_2314` exists | 1. POST `/auth/login` with `{"username":"mor_2314","password":"wrongpass"}` | HTTP 401, error message | HTTP 401, "username or password is incorrect" | Pass |
| TC003 | Login fails with non-existent username | No user `ghost_user` exists | 1. POST `/auth/login` with `{"username":"ghost_user","password":"pass123"}` | HTTP 401, error message | HTTP 401, "username or password is incorrect" | Pass |
| TC004 | Login fails with empty username | None | 1. POST `/auth/login` with `{"username":"","password":"83r5^_"}` | HTTP 401 or 400, appropriate error | HTTP 400, "username and password are not provided in JSON format" | Pass |
| TC005 | Login fails with empty password | None | 1. POST `/auth/login` with `{"username":"mor_2314","password":""}` | HTTP 401 or 400, appropriate error | HTTP 400, "username and password are not provided in JSON format" | Pass |
| TC006 | Login fails with empty request body | None | 1. POST `/auth/login` with `{}` | HTTP 401 or 400, appropriate error | HTTP 400, "username and password are not provided in JSON format" | Pass |

## Product Test Cases

| TC ID | Title | Precondition | Steps | Expected Result | Actual | Status |
|-------|-------|--------------|-------|-----------------|--------|--------|
| TC007 | Get all products | None | 1. GET `/products` | HTTP 200, array of 20 products | HTTP 200, array of 20 products with id, title, price, description, category, image, rating | Pass |
| TC008 | Get single product by valid ID | Product ID 1 exists | 1. GET `/products/1` | HTTP 200, product with all fields | HTTP 200, product id=1 with title, price, description, category, image, rating | Pass |
| TC009 | Get product with non-existent ID | No product ID 99999 | 1. GET `/products/99999` | HTTP 404 or null response | HTTP 200 with null body | Pass |
| TC010 | Get all product categories | None | 1. GET `/products/categories` | HTTP 200, array of categories | HTTP 200, ["electronics","jewelery","men's clothing","women's clothing"] | Pass |
| TC011 | Get products by valid category | Category `electronics` exists | 1. GET `/products/category/electronics` | HTTP 200, all products in category | HTTP 200, 6 products all with category="electronics" | Pass |
| TC012 | Get products by non-existent category | No category `xyz123` | 1. GET `/products/category/xyz123` | HTTP 404 or empty array | HTTP 200 with empty array `[]` | Pass |
| TC013 | Get products with limit parameter | None | 1. GET `/products?limit=5` | HTTP 200, exactly 5 products | HTTP 200, 5 products returned | Pass |
| TC014 | Get products with sort parameter | None | 1. GET `/products?sort=desc` | HTTP 200, descending order | HTTP 200, ids [20,19,18,...,1] in descending order | Pass |
| TC015 | Create new product with valid data | None | 1. POST `/products` with valid JSON body | HTTP 200, product created with id | HTTP 201, product created with id=21 | Pass |
| TC016 | Create product with missing title field | None | 1. POST `/products` without title field | HTTP 400 or error for missing field | HTTP 201, product created without title — no validation | Fail |

## Cart Test Cases

| TC ID | Title | Precondition | Steps | Expected Result | Actual | Status |
|-------|-------|--------------|-------|-----------------|--------|--------|
| TC017 | Get all carts | None | 1. GET `/carts` | HTTP 200, array of carts | HTTP 200, 7 carts with id, userId, date, products | Pass |
| TC018 | Get single cart by valid ID | Cart ID 1 exists | 1. GET `/carts/1` | HTTP 200, cart with required fields | HTTP 200, cart id=1 with userId, date, products array | Pass |
| TC019 | Get carts by valid user ID | User ID 1 exists | 1. GET `/carts/user/1` | HTTP 200, carts for user 1 | HTTP 200, all carts have userId=1 | Pass |
| TC020 | Get carts by non-existent user | No user 99999 | 1. GET `/carts/user/99999` | HTTP 404 or empty array | HTTP 200 with empty array `[]` | Pass |
| TC021 | Create new cart with valid data | None | 1. POST `/cart` with valid JSON body | HTTP 200, cart created with id | HTTP 201, cart created with id and userId=1 | Pass |
| TC022 | Update existing cart | Cart ID 1 exists | 1. PUT `/carts/1` with updated body | HTTP 200, updated cart | HTTP 200, cart updated with products [{productId:1,quantity:5}] | Pass |
| TC023 | Delete a cart | Cart ID 1 exists | 1. DELETE `/carts/1` | HTTP 200, confirmation | HTTP 200, deleted cart returned with full details | Pass |
| TC024 | Get single cart with non-existent ID | No cart 99999 | 1. GET `/carts/99999` | HTTP 404 or null response | HTTP 200 with null body | Pass |

## User Test Cases

| TC ID | Title | Precondition | Steps | Expected Result | Actual | Status |
|-------|-------|--------------|-------|-----------------|--------|--------|
| TC025 | Get all users | None | 1. GET `/users` | HTTP 200, array of 10 users | HTTP 200, 10 users returned | Pass |
| TC026 | Get single user by valid ID | User ID 1 exists | 1. GET `/users/1` | HTTP 200, user with email, name, address | HTTP 200, user id=1 with email, name, address | Pass |
| TC027 | Get user with non-existent ID | No user 99999 | 1. GET `/users/99999` | HTTP 404 or null response | HTTP 200 with null body | Pass |

## Edge Case & Negative Test Cases

| TC ID | Title | Precondition | Steps | Expected Result | Actual | Status |
|-------|-------|--------------|-------|-----------------|--------|--------|
| TC028 | Request with invalid HTTP method | None | 1. PATCH `/products` | HTTP 405 or appropriate error | HTTP 404, "Cannot PATCH /products" | Pass |
| TC029 | Request to non-existent endpoint | None | 1. GET `/nonexistent` | HTTP 404 Not Found | HTTP 404, "Cannot GET /nonexistent" | Pass |
| TC030 | Product response has all required fields | None | 1. GET `/products/1` | Response has id, title, price, description, category, image, rating (with rate, count) | HTTP 200, all 7 required fields present, rating has rate and count | Pass |
