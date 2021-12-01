package com.cydeo.day3;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class ORDSApiTestsWithParameters {

    //beforeAll runs scenario before each scenario
    @BeforeAll
    public static void init() {
        baseURI = "http://54.226.81.182:1000/ords/hr";

    }

    @DisplayName("GET request to /countries with Query Param")
    @Test
    public void test1() {
        Response response = given().accept(ContentType.JSON)
                .and().queryParam("q", "{\"region_id\":2}")
                .log().all()
                .when()
                .get("/countries");

        assertEquals(200, response.statusCode());
        assertEquals("application/json", response.header("Content-Type"));

        assertTrue(response.body().asString().contains("United States of America"));
        response.prettyPrint();
    }


    //Send a GET request to employees and get only employees who works as a IT_PROG

    @DisplayName("GET request to /employees with Query Param ")
    @Test
    public void test2() {
        Response response = given().accept(ContentType.JSON)
                .and().queryParam("q", "{\"job_id\": \"IT_PROG\"}")
                //.log().all()
                .when()
                .get("/employees");

        assertEquals(200, response.statusCode());
        assertEquals("application/json", response.header("Content-Type"));

        assertTrue(response.body().asString().contains("IT_PROG"));
        response.prettyPrint();
    }
}