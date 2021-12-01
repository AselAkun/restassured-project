package day7;

import groovy.grape.GrapeIvy;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import static io.restassured.RestAssured.*;

public class ZipcodeAPI_Test {

    @BeforeAll
    public static void setup() {
        baseURI = "https://api.zippopotam.us";
        basePath = "/us";
    }

    @AfterAll
    public static void teardown() {
        reset();
    }

    @Test
    public void testZipToCity() {


        //https://api.zippopotam.us/us/22030
        // log your request , provide 22030 as path variable
        // send get request and assert status is 200
        // assert response is in json format
        // assert "country": "United States",
        // assert "state": "Virginia"

        given()
                .log().all()
                .pathParam("zip", 22030)
                .when().get("/{zip}")
                .then().log().all()
                .statusCode(is(200))
                .contentType(ContentType.JSON)
                .body("country", is("United States"))
                .body("places[0].state", is("Virginia"))
                .body("'post code'", equalTo("22030"))
                .body("places[0].'place name'", is("Fairfax"));

    }
    /*
    *Create a parametrized test to check
    * using given zipcode 22030,10019,12345,10000,19152
    * send our request to API
    * Get:http//api/zipopotam.us/us/{zip}
    * test the status code
     */
@ParameterizedTest
@ValueSource(ints = {22030 , 10019 , 12345 , 10000, 19152})

    public void testZipToCityDDT(int zipParam){
    System.out.println("zipParam = " + zipParam);

    given()
            .log().all()
            .pathParam("zip",zipParam)
            .when()
            .get("{zip}")
            .then()
            .statusCode(200);

    }

}