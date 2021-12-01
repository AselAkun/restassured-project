package com.cydeo.day4;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utilities.HRTestBase;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ORDSApiTestWithPath extends HRTestBase {

    @DisplayName("GET request to /countries with Query Param")
    @Test
    public void test1() {
        Response response = given().accept(ContentType.JSON)
                .queryParam("q", "{\"region_id\":2}")
                .when()
                .get("/countries");

        assertEquals(200, response.statusCode());

        //print limit result
        System.out.println("response.path(\"limit\") = " + response.path("limit"));

        //print hasMore
        System.out.println("response.path(\"hasMore\") = " + response.path("hasMore"));

        //print first CountryId
        String firstCountryId = response.path("items[0].country_id");
        System.out.println("firstCountryId = " + firstCountryId);

        //print second country name
        String secondCountryName = response.path("items[1].country_name");
        System.out.println("secondCountryName = " + secondCountryName);

        //print the URL http://54.226.81.182:1000/ords/hr/countries/CA
        String Thirdhref = response.path("items[2].links[0].href");
        System.out.println("Thirdhref = " + Thirdhref);

        // String Thirdhref = response.path("items[2].links[1].href");   IF YOU CHANGE THE INDEX 0 TO 1 IN LINKS , WILL GIVE YOU A NULL
        // System.out.println("Thirdhref = " + Thirdhref);

        //get me all country names
        List<String> countryNames = response.path("items.country_name");// if you put []index to items will give ypu exact countryName
        System.out.println("countryNames = " + countryNames);


        //assert that all reagions ids equals to 2
        List<Integer> allRegionsIDs = response.path("items.region_id");

        for (Integer regionsID : allRegionsIDs) {
            System.out.println("regionsID = " + regionsID);
            assertEquals(2, regionsID);

        }


    }

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

        //make sure we have only IT_PROG  as a job_ID
        List<String> allJobIDs = response.path("items.job_id");

        for (String jobID : allJobIDs) {
            System.out.println("jobID = " + jobID);
            assertEquals("IT_PROG", jobID);
        }

    }
}