package day5;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;


public class HamcrestMatchersApiTest {

    @DisplayName("OneSpartan with hamcrest and chaining")
    @Test
    public void test1() {


        given().
                accept(ContentType.JSON)
                .and().pathParam("id", 15)
                .when()
                .get("http://54.226.81.182:8000/api/spartans/{id}")

                .then()

                .statusCode(200)
                .and()
                .contentType("application/json")
                .and()
                .body("id", equalTo(15),
                        "name", is("Meta"),
                        "gender", is("Female"),
                        "phone", is(1938695106));
    }

    @DisplayName("CBTtrainig Teacher request with chaining and matchers")
    @Test
    public void teacherData() {
        given().accept(ContentType.JSON)
                .and()
               .pathParam("id",10423)
                .when()
                .get("http://api.cybertektraining.com/teacher/{id}")

                .then()

                .statusCode(200)
                .and()
                .contentType("application/json;charset=UTF-8")
                .and()
                .header("Content-Length", is("236"))
                .and()
                .header("Date", notNullValue())
                .and().assertThat()
                .body("teachers[0].firstName", is("Alexander"))
                .body("teachers[0].lastName", is("Syrup"))
                .body("teachers[0].gender", equalTo("male"));


    }
    @DisplayName(" Get request to teacher/all and chaining")
    @Test
    public void teacherTest(){
         //verify Alexander, Darleen, Sean inside all teachers

        given().accept(ContentType.JSON)
                .and()
                                .when()
                .get("http://api.cybertektraining.com/teacher/all")
                .then()
                .statusCode(200)
                .and()
                .body("teachers.firstName",hasItems("Alexander", "Darleen", "Sean"));



    }
}
