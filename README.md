# TestForge

E-Commerce QA & API Automation Suite built as a portfolio project for Trainee QA roles.

## What This Project Demonstrates

| QA Skill | Evidence |
|----------|----------|
| Test planning | `docs/TEST_PLAN.md` — scope, strategy, entry/exit criteria |
| Test case design | `test-cases/TEST_CASES.md` — 30 cases with positive, negative, and boundary scenarios |
| Defect reporting | `bug-reports/BUG_REPORTS.md` — 5 bug reports with severity, steps, and evidence |
| API testing | `postman/collection.json` — importable Postman collection with test scripts |
| Automation | `automation/` — Java + JUnit 5 + Rest Assured automated API tests |
| CI/CD | `.github/workflows/tests.yml` — GitHub Actions workflow for automated test execution |

## Target Application

**FakeStore API** — `https://fakestoreapi.com`

A free REST API providing products, carts, users, and authentication endpoints for testing and prototyping.

## How to Run

### Automated Tests (Java)

```bash
cd automation
mvn test
```

### Postman Collection

1. Open Postman
2. Import `postman/collection.json`
3. Run the collection or individual requests

### CI/CD

Tests run automatically on push/PR to `main` via GitHub Actions.

## Project Structure

```
TestForge/
├── README.md
├── docs/
│   ├── TEST_PLAN.md
│   ├── TEST_SCENARIOS.md
│   └── TEST_SUMMARY.md
├── test-cases/
│   └── TEST_CASES.md
├── bug-reports/
│   └── BUG_REPORTS.md
├── postman/
│   └── collection.json
├── automation/
│   ├── pom.xml
│   └── src/test/java/com/testforge/
│       ├── AuthTests.java
│       ├── ProductTests.java
│       └── CartTests.java
└── .github/
    └── workflows/
        └── tests.yml
```

## Tools Used

- **Java 21** + **JUnit 5** + **Rest Assured** — API test automation
- **Maven** — build and dependency management
- **Postman** — manual API testing
- **GitHub Actions** — CI/CD pipeline
- **FakeStore API** — target application

## Author

Deepanshu Bisht — QA Trainee Portfolio Project
