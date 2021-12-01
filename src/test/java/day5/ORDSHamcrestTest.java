package day5;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utilities.HRTestBase;
import utilities.HRTestBase;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class ORDSHamcrestTest extends HRTestBase {

    @DisplayName("get request to Employees IT_PROG endpoint and chaining")
    @Test
    public void regionTest() {
        //send a get request to employees endpoint with query parameters job_id IT_PROG
        //verify each job_id is IT_PROG
        //verify first names are ....(find proper method to check list against list
        //verify emails without checking order(provide emails in different order, just make sure it has emails

        given().accept(ContentType.JSON)
                .and()
                .queryParam("q", "{\"job_id\":\"IT_PROG\"}")
                .when()
                .get("/employees")
                .then()
                .statusCode(200)
                .body("items.job_id", everyItem(equalTo("IT_PROG")))
                .body("items.first_name", containsInRelativeOrder("Alexander", "Bruce", "David", "Valli", "Diana"))//orders should be same
                .body("items.email", containsInAnyOrder("VPATABAL", "DAUSTIN", "BERNST", "AHUNOLD", "DLORENTZ"));


    }

    @Test
    public void regionTest2() {
        //we want to chain and also get response object
        Response response = given().accept(ContentType.JSON)
                .and().queryParam("q", "{\"job_id\":\"IT_PROG\"}")
                .when()
                .get("/employees")
                .then()
                .statusCode(200)
                .body("items.job_id", everyItem(equalTo("IT_PROG")))
                .extract().response();
       // EXTRACT METHOD==>method that allow us to get response object after we use THEN()method
        response.prettyPrint();






    }
}