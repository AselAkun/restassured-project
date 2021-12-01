package com.cydeo.day3;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utilities.SpartanTestBase;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;


public class SpartanTestWithParameters extends SpartanTestBase { //extended TestBase class to call @BEFORE ALL



    @DisplayName("GET request to api/spartans/{id}with ID 5")
    @Test
    public void test1(){
      Response response = given().accept(ContentType.JSON)
              .and().pathParam("id",5)
              .when().get("/api/spartans/{id}");

        //verify status code
        assertEquals(200, response.statusCode());

        //verify content type
        assertEquals("application/json", response.contentType());

        //verify Blythe in the json playload/body
        assertTrue(response.body().asString().contains("Blythe"));
    }

    @DisplayName("GET request to api/spartans/{id} Negative Test")
            @Test
            public void test2(){
      Response response = given().accept(ContentType.JSON)
              .and().pathParam("id",500)
        .when().get("/api/spartans/{id}");

      assertEquals(404,response.statusCode());
        //verify status code

      assertEquals("application/json", response.contentType());
        //verify content type

      assertTrue(response.body().asString().contains("Not Found"));
        //verify Blythe in the json payload/body

            }

    @DisplayName("GET request to api/spartans/search with Query Params")
    @Test
    public void test3(){

      Response response = given().log().all() //this method gives us all the request info on the console
              .accept(ContentType.JSON)
              .and().queryParam("nameContains","e")
              .and().queryParam("gender", "Female")
              .when()
              .get("api/spartans/search");


      //verify status code
        assertEquals(200,response.statusCode());

      //verify content type
        assertEquals("application/json", response.contentType());

        //verify Janette and Female contains in the body
        assertTrue(response.body().asString().contains("Female"));
        assertTrue(response.body().asString().contains("Janette"));
    }

  @DisplayName("GET request to api/spartans/search with Query Params")
  @Test
  public void test4(){

    Map<String, Object> queryMap = new HashMap<>();
    queryMap.put("nameContains","e");
    queryMap.put("gender","Female");

    Response response = given().
            log().all()
            .accept(ContentType.JSON)
            .and().queryParams(queryMap)
            .when()
            .get("/api/spartans/search");

    //verify status code
    assertEquals(200,response.statusCode());

    //verify content type
    assertEquals("application/json", response.contentType());

    //verify Janette and Female contains in the body
    assertTrue(response.body().asString().contains("Female"));
    assertTrue(response.body().asString().contains("Janette"));
  }

  }


