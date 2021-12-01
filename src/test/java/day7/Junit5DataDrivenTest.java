package day7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Junit5DataDrivenTest {

    //Given string data:
    //
    //write a test to check the length of these  all more than 5 characters

    @DisplayName("is number greater than 10")
    @ParameterizedTest
    @ValueSource(strings = {"Abbos", "Yevheniia ", "Shazia", "Tugba", "Mohamed", "Kimberly"})
    public void testNumberMoreThan10(String EachName) {

        System.out.println("EachName = " + EachName);

        assertTrue(EachName.length() > 3);
    }
}