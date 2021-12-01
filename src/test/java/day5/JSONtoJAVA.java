package day5;

import utilities.SpartanTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utilities.HRTestBase;

import javax.lang.model.element.NestingKind;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class JSONtoJAVA extends SpartanTestBase {

    @DisplayName("get one spartan and deserialize to Map")
    @Test
    public void oneSpartanToMap() {

        Response response = given().pathParam("id", 15)
                .when().get("/api/spartans/{id}")
                .then().statusCode(200).extract().response();

        //get the json and convert in to map

        Map<String, Object> jsonMap = response.as(Map.class);
        System.out.println(jsonMap.toString());

        String actualName = (String) jsonMap.get("name");
        assertThat(actualName, is("Meta"));



    }

    @DisplayName("Get all spartans to JAVA dta structure ")
    @Test
    public void getAllSpartans() {

        //Response response =
        //we need to convert json to java which is deserialize

       // List<Map<String, Object>> jsonList = response
    }
}
