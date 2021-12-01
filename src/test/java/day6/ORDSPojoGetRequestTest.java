package day6;

import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utilities.HRTestBase;
import utilities.HRTestBase;

import javax.swing.plaf.synth.Region;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonAnyGetter;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class ORDSPojoGetRequestTest extends HRTestBase {

    @Test
    public void regionTest() {

        JsonPath jsonPath = get("/regions").then().statusCode(200).log().body().extract().jsonPath();

        Region region1 = jsonPath.getObject("items[0]",Region.class
        );

        System.out.println(region1);
        System.out.println("region1.getName() = " + region1.getName());


    }

}