package com.cydeo.day2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class HrGetRequests {

    //beforeAll runs scenario before each scenario
    @BeforeAll

    //save base url inside this variable so we cal one time
    public static void init(){
        RestAssured.baseURI="http://54.226.81.182:1000/ords/hr";


    }
    @DisplayName("GET request to /regions")
    @Test
    public void test1() {
        Response response = RestAssured.get("/regions");
        //print the status code
        System.out.println(response.statusCode());
    }
    @DisplayName("GET request to/regions/2")
    @Test

    public void test2(){
        Response response= given().accept(ContentType.JSON)
                .when()
                .get("/regions/2");
        assertEquals(200, response.statusCode());
        assertEquals("application/json", response.contentType());
        response.prettyPrint();
        assertTrue(response.body().asString().contains("Americas"));
    }
}
