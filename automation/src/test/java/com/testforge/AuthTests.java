package com.testforge;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AuthTests {

    private static final String BASE_URL = "https://fakestoreapi.com";

    @BeforeAll
    static void setup() {
        baseURI = BASE_URL;
    }

    @Test
    void testLoginSuccess() {
        given()
            .contentType("application/json")
            .body("{\"username\":\"mor_2314\",\"password\":\"83r5^_\"}")
        .when()
            .post("/auth/login")
        .then()
            .statusCode(anyOf(is(200), is(201)))
            .body("token", notNullValue())
            .body("token", instanceOf(String.class));
    }

    @Test
    void testLoginInvalidPassword() {
        given()
            .contentType("application/json")
            .body("{\"username\":\"mor_2314\",\"password\":\"wrongpassword\"}")
        .when()
            .post("/auth/login")
        .then()
            .statusCode(401);
    }

    @Test
    void testLoginEmptyCredentials() {
        given()
            .contentType("application/json")
            .body("{}")
        .when()
            .post("/auth/login")
        .then()
            .statusCode(anyOf(is(400), is(401)));
    }
}
