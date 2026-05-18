# Test Scenarios — TestForge

## Authentication Scenarios

| ID | Scenario | Priority |
|----|----------|----------|
| S01 | User logs in with valid username and password | High |
| S02 | User attempts login with invalid password | High |
| S03 | User attempts login with invalid username | High |
| S04 | User attempts login with empty username | Medium |
| S05 | User attempts login with empty password | Medium |
| S06 | User attempts login with missing request body | Medium |

## Product Scenarios

| ID | Scenario | Priority |
|----|----------|----------|
| S07 | Retrieve list of all products | High |
| S08 | Retrieve a single product by valid ID | High |
| S09 | Retrieve a product with non-existent ID | High |
| S10 | Retrieve all product categories | Medium |
| S11 | Filter products by a specific category | Medium |
| S12 | Filter products by non-existent category | Medium |
| S13 | Create a new product with valid data | Medium |
| S14 | Create a product with missing required fields | Medium |
| S15 | Update an existing product | Medium |
| S16 | Delete a product | Low |
| S17 | Retrieve products with limit parameter | Low |
| S18 | Retrieve products with sort parameter | Low |

## Cart Scenarios

| ID | Scenario | Priority |
|----|----------|----------|
| S19 | Retrieve all carts | High |
| S20 | Retrieve a single cart by ID | High |
| S21 | Retrieve carts for a specific user | High |
| S22 | Retrieve carts for non-existent user | Medium |
| S23 | Create a new cart with valid data | Medium |
| S24 | Update an existing cart | Low |
| S25 | Delete a cart | Low |

## User Scenarios

| ID | Scenario | Priority |
|----|----------|----------|
| S26 | Retrieve all users | Medium |
| S27 | Retrieve a single user by ID | Medium |
| S28 | Retrieve a user with non-existent ID | Medium |

## Edge Case Scenarios

| ID | Scenario | Priority |
|----|----------|----------|
| S29 | Request with invalid HTTP method | Medium |
| S30 | Request to non-existent endpoint | Low |
