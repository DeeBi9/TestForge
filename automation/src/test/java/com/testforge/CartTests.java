package com.testforge;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CartTests {

    private static final String BASE_URL = "https://fakestoreapi.com";

    @BeforeAll
    static void setup() {
        baseURI = BASE_URL;
    }

    @Test
    void testGetAllCarts() {
        given()
        .when()
            .get("/carts")
        .then()
            .statusCode(200)
            .body("$", not(empty()))
            .body("[0].id", notNullValue())
            .body("[0].userId", notNullValue())
            .body("[0].date", notNullValue())
            .body("[0].products", notNullValue());
    }

    @Test
    void testGetCartByUserId() {
        given()
        .when()
            .get("/carts/user/1")
        .then()
            .statusCode(200)
            .body("userId", everyItem(equalTo(1)));
    }

    @Test
    void testCreateCart() {
        String cartJson = """
                {
                    "userId": 1,
                    "date": "2024-01-15",
                    "products": [
                        {
                            "productId": 1,
                            "quantity": 2
                        }
                    ]
                }
                """;

        given()
            .contentType("application/json")
            .body(cartJson)
        .when()
            .post("/carts")
        .then()
            .statusCode(anyOf(is(200), is(201)))
            .body("id", notNullValue())
            .body("userId", equalTo(1));
    }
}
