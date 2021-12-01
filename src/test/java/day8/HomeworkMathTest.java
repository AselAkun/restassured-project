package day8;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class HomeworkMathTest {

    /* Task last

1. Create a csv file called math.csv under resource folder
2. add 3 columns num1 ,   num2 , expectedResult
3. add valid data for addition num1 + num2 = expectedResult
4. create a @ParameterizedTest with above CsvFileSource , skip the header
5. assert addition num1 + num2 = expectedResult
6. make sure to change the number and see failed tests.
*/
    @ParameterizedTest
    @CsvFileSource(resources = "/math.csv", numLinesToSkip = 1)
    public void testMath(int num1, int num2, int expectedResult) {

        System.out.println(num1 + "+" + num2 + " should be " + expectedResult);

        assertThat(num1 + num2, equalTo(expectedResult));
    }


    //Another way of providing sours for parametrized test is @MethodSours
    //It will allow you you to provide the return value from static method with no param
    //as the sours for your parametrized test


    //write a static method that return list ofInteger that contain 10 number
    @ParameterizedTest
    @MethodSource("get10NumberList")
    public void testWithMethodSoursDDT(int num) {
        System.out.println("num = " + num);

        // do some complicated assertion here


    }

    @ParameterizedTest
    @MethodSource("day8.MethodSoursUtil#getSomeNames")
    public void testNamesWithMethodSoursDDT(String name) {
        System.out.println("name = " + name);
    }

    public static List<Integer> get10NumberList() {
        //this list could have been the result of very long code here
        List<Integer> myList = Arrays.asList(11, 2, 3, 34, 15, 6, 7, 58, 9, 10);

        return myList;

    }
}
