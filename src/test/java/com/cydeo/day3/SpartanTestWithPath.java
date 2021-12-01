package com.cydeo.day3;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;


public class SpartanTestWithPath {

    //beforeAll runs scenario before each scenario
    @BeforeAll
    public static void init() {
        baseURI = "http://54.226.81.182:8000";

    }

    /*
    Given accept spartan json
    When user send a GET request to "/api/spartans/{id}"
    then status code is 200
    And content type is "application/json
    And response value is match with following
    is is 10
    name is "Lorenza"
    gender is "Female"
    phone is 3312820936
     */
    @DisplayName("GET one spartan with Path Param")
    @Test
    public void test1() {

        Response response = given().accept(ContentType.JSON)
                .and().pathParam("id",10)
                .when().get("/api/spartans/{id}");

        assertEquals(200, response.statusCode());
        assertEquals("application/json",response.contentType());

        //verify eacj json key has specific value
        //like getting key and value attributes PATH METHOD
        System.out.println(response.path("id").toString());
        System.out.println(response.path("name").toString());
        System.out.println(response.path("gender").toString());
        System.out.println(response.path("phone").toString());

        int id=response.path("id");
        String name=response.path("name");
        String gender= response.path("gender");
        long phone=response.path("phone");

        System.out.println("id = " + id);
        System.out.println("name = " + name);
        System.out.println("gender = " + gender);
        System.out.println("gender = " + gender);

        //assert the value

        assertEquals(10,id);
        assertEquals("Lorenza", name);
        assertEquals("Female", gender);
        assertEquals(3312820936l, phone);

    }
    @DisplayName("GET all spartan and navigate with Path()")//path method
    @Test
    public void test2() {
        Response response = given().accept(ContentType.JSON)
                .when().get("/api/spartans");

       // response.prettyPrint();
        int firstId= response.path("id[2]");//provide index number to know the which id
                System.out.println("firstId = " + firstId);

        String name= response.path("name[0]");
        System.out.println("name = " + name);

        String lastFirstName= response.path("name[-5]");//to get the name from the end 5th
        System.out.println("lastFirstName = " + lastFirstName);

        List<String> names= response.path("name");//gives you the LIST of strings, all the names in the list
        System.out.println("names = " + names);

        //print each name one by one
        for(String n:names){
           System.out.println(n);
        }
    }
}
