package com.cydeo.day4;

import io.restassured.RestAssured;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CBTTrainingApiWithJsonPath {

    @BeforeAll

    //save base url inside this variable so we cal one time
    public static void init() {
        RestAssured.baseURI = "http://api.cybertektraining.com";
    }
    @DisplayName("GET  Request to individual student")
    @Test
    public void test1(){
        //send a get request to student  id 23401 as a path parameter
        // verify status code /content type/Content_Encoding = gzip
        //verify Date header exist
        //assert that
        /*
        FirstName Vera
        batch 14
        section 12
        emailAddress aaa@gmail.com
        companyName Cybertek
        state IL
        zipCode 60606

        using JsonPath
         */

    }
}
