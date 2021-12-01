package com.cydeo.day2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class SpartanNegativeGetTest {

    @BeforeAll
    public static void inti(){

        baseURI = "http://54.226.81.182:8000";

    }
    @DisplayName("GET request to /api/spartans/10")
    @Test
    public  void test1(){
        Response response= given()
                .accept(ContentType.XML)
        .when()
                .get("/api/spartans/10");

        assertEquals(406, response.statusCode());
        assertEquals("application/xml;charset=UTF-8", response.contentType());
    }
}
