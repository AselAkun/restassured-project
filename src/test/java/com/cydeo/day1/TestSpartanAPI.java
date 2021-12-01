package com.cydeo.day1;
import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class TestSpartanAPI {

    @Test
    public void testHello(){

        System.out.println("Hello world");


         //send a request to the bellow url
        // GET http://54.226.81.182:8000/v3/api-doc
        //RestAssured.get("http://54.226.81.182:8000/api/spartans");
        Response response = get("http://54.226.81.182:8000/api/spartans");
        System.out.println("response.getStatusCode() = " + response.getStatusCode());

        System.out.println("response.prettyPrint() = " + response.prettyPrint());
    }

    @Test
    public void viewSpartanTest1(){
        String spartanBaseUrl= "http://54.226.81.182:8000";
        Response response = RestAssured.get(spartanBaseUrl+ "/api/spartans");
        //Print the status code
        System.out.println("response.statusCode() = " + response.statusCode());
        //print the body
        System.out.println(response.getBody().prettyPrint());


    }



}
