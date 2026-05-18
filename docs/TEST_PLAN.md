# Test Plan — TestForge

## 1. Objective

To verify the functionality, reliability, and error handling of the FakeStore API (`https://fakestoreapi.com`) — a RESTful e-commerce backend — through manual API testing, defect reporting, and automated regression tests.

## 2. Scope

### In Scope
- **Authentication**: Login endpoint with valid/invalid credentials
- **Products**: Listing, filtering by category, single product retrieval, create/update/delete
- **Carts**: Listing, retrieval by user, create/update/delete
- **Users**: Listing, single user retrieval
- **API Response Validation**: Status codes, JSON structure, required fields, error handling

### Out of Scope
- Frontend/UI testing (no frontend application — API only)
- Performance/load testing
- Database persistence verification (API is mocked — changes do not persist)
- Payment gateway integration

## 3. Features Under Test

| Feature | Endpoints | Methods |
|---------|-----------|---------|
| Authentication | `/auth/login` | POST |
| Products | `/products`, `/products/{id}`, `/products/categories`, `/products/category/{name}` | GET, POST, PUT, DELETE |
| Carts | `/carts`, `/carts/{id}`, `/carts/user/{userId}` | GET, POST, PUT, DELETE |
| Users | `/users`, `/users/{id}` | GET, POST, PUT |

## 4. Testing Types

| Type | Description |
|------|-------------|
| Functional Testing | Verify each endpoint returns correct data for valid inputs |
| Negative Testing | Verify API handles invalid inputs gracefully (wrong IDs, missing fields, bad auth) |
| Boundary Testing | Test edge cases like limit=0, limit=-1, non-numeric IDs |
| API Response Validation | Validate JSON structure, required fields, data types, status codes |
| Regression Testing | Automated tests to ensure core functionality works after changes |

## 5. Test Environment

| Component | Details |
|-----------|---------|
| API Base URL | `https://fakestoreapi.com` |
| Protocol | HTTPS |
| Request Format | JSON |
| Response Format | JSON |
| Testing Tools | Postman (manual), Java + Rest Assured (automated) |
| OS | Ubuntu (for automation) |
| Java Version | OpenJDK 21 |
| Maven Version | 3.9.16 |

## 6. Test Data

| Data Type | Source |
|-----------|--------|
| Valid Products | Pre-existing in API (20 products) |
| Valid Users | Pre-existing in API (10 users) |
| Valid Carts | Pre-existing in API (20 carts) |
| Login Credentials | `mor_2314` / `83r5^_` (valid user from API) |
| Invalid Credentials | Fabricated invalid username/password |
| New Product | JSON payload with title, price, description, image, category |
| New Cart | JSON payload with userId, date, products array |

## 7. Entry Criteria

- API base URL is accessible and responding
- Postman is installed for manual testing
- Java 21 and Maven are installed for automation
- Test data (users, products) exist in the API

## 8. Exit Criteria

- All planned test cases have been executed
- All critical and high-severity defects have been documented
- Automated test suite compiles and runs successfully
- Test summary report has been generated

## 9. Assumptions

- FakeStore API is a free mock API — POST/PUT/DELETE do not persist changes
- The API is stable and available during testing
- Authentication token from `/auth/login` is valid for the session
- All responses are in JSON format

## 10. Risks

| Risk | Impact | Mitigation |
|------|--------|------------|
| API downtime | Cannot execute tests | Re-test when API is available; use cached responses for automation |
| Mocked write operations | Cannot verify data persistence | Focus on response validation rather than database state |
| Rate limiting | Tests may be throttled | Add delays between requests if needed |
| API schema changes | Tests may break | Pin to specific API version; validate response structure in tests |
