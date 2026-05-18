# Test Summary — TestForge

## Overview

| Metric | Value |
|--------|-------|
| **Project** | TestForge — E-Commerce QA & API Automation Suite |
| **Target API** | FakeStore API (`https://fakestoreapi.com`) |
| **Testing Period** | 21 Sep 2026 |
| **Tester** | deebi9 |

## Test Execution Summary

### Manual Test Cases

| Status | Count |
|--------|-------|
| Total Test Cases | 30 |
| Passed | 29 |
| Failed | 1 |
| Blocked | 0 |
| Not Run | 0 |

### Automated Test Cases

| Status | Count |
|--------|-------|
| Total Automated Tests | 10 |
| Passed | 10 |
| Failed | 0 |
| Skipped | 0 |

## Defect Summary

| Severity | Count | Details |
|----------|-------|---------|
| Critical | 0 | — |
| High | 0 | — |
| Medium | 1 | TC016 — API accepts product creation without required `title` field |
| Low | 0 | — |
| **Total** | **1** | |

### Observations (not filed as bugs — API design choices)
- API returns HTTP 200 with `null` body for non-existent resources (TC009, TC024, TC027) instead of 404
- API returns HTTP 201 for POST operations like login and cart creation (TC001, TC015, TC021)
- Non-existent categories return HTTP 200 with empty array instead of 404 (TC012)

## Coverage by Feature

| Feature | Manual Cases | Passed | Failed | Automated Tests |
|---------|-------------|--------|--------|-----------------|
| Authentication | 6 | 6 | 0 | 3 |
| Products | 10 | 9 | 1 | 4 |
| Carts | 8 | 8 | 0 | 3 |
| Users | 3 | 3 | 0 | 0 |
| Edge Cases | 3 | 3 | 0 | 0 |
| **Total** | **30** | **29** | **1** | **10** |

## Automation Coverage

- **Automated**: 10 tests covering API response validation, status codes, JSON structure, and error handling
- **Manual only**: 20 tests covering authentication flow, boundary values, edge cases, and CRUD operations
- **Automation percentage**: ~33% (10 of 30 manual cases have automated equivalents)

## Failed Test Case Detail

| TC ID | Issue | Root Cause |
|-------|-------|------------|
| TC016 | API accepts product creation without `title` field | API does not validate required fields on POST `/products` — returns 201 with id but no title |

## Major Risks

1. **No input validation on POST endpoints** — API accepts incomplete data without errors (TC016)
2. **Mocked API** — POST/PUT/DELETE changes do not persist; cannot verify data integrity
3. **No rate limiting documentation** — Automated tests may be throttled under heavy use
4. **Static data** — Product and user data is fixed — limited test data variety

## Release Recommendation

**Status**: PASS with observations

- 29/30 manual tests pass (96.7% pass rate)
- 10/10 automated tests pass (100% pass rate)
- 1 medium-severity defect identified (missing field validation on product creation)
- Core API functionality (products, carts, users, auth) works reliably
- Recommended for portfolio demonstration — not production use
