package day5;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utilities.HRTestBase;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

import utilities.SpartanTestBase;

import java.util.List;

public class SpartanHamcrestTest extends SpartanTestBase {

    @DisplayName("get spartan/search and chaining together")
    @Test
    public void test1(){

        List<String> names = given().accept(ContentType.JSON)
                .and()
                .queryParams("nameContains","j","gender","Male")
                .when()
                .get("/api/spartans/search")
                .then()
                .statusCode(200)
                .and()
                .body("totalElement", greaterThanOrEqualTo(3))
                .extract().response().jsonPath().getList("content.name");
        System.out.println(names);
    }
}
