package com.testforge;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ProductTests {

    private static final String BASE_URL = "https://fakestoreapi.com";

    @BeforeAll
    static void setup() {
        baseURI = BASE_URL;
    }

    @Test
    void testGetAllProducts() {
        given()
        .when()
            .get("/products")
        .then()
            .statusCode(200)
            .body("$", hasSize(20))
            .body("[0].id", notNullValue())
            .body("[0].title", notNullValue())
            .body("[0].price", notNullValue())
            .body("[0].category", notNullValue())
            .body("[0].rating", notNullValue());
    }

    @Test
    void testGetProductById() {
        given()
        .when()
            .get("/products/1")
        .then()
            .statusCode(200)
            .body("id", equalTo(1))
            .body("title", notNullValue())
            .body("price", instanceOf(Float.class))
            .body("description", notNullValue())
            .body("category", notNullValue())
            .body("image", notNullValue())
            .body("rating.rate", notNullValue())
            .body("rating.count", notNullValue());
    }

    @Test
    void testGetProductsByCategory() {
        given()
        .when()
            .get("/products/category/electronics")
        .then()
            .statusCode(200)
            .body("category", everyItem(equalTo("electronics")));
    }

    @Test
    void testGetNonExistentProduct() {
        given()
        .when()
            .get("/products/99999")
        .then()
            .statusCode(anyOf(is(200), is(404)));
    }
}
