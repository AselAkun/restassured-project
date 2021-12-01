package day7;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class Junit5featuresTest {

    /**
     * A class to explore more Junit5 features
     * Office doc : https://junit.org/junit5/docs/current/user-guide/#writing-tests
     * Junit 5 has more annotations to either help to make test result simplier or affect the way test runs
     *
     * @DIsplayName: declares a custom display name for the test class ot test method
     * @Disable: to ignore running sertain task or any reason it may have,   *  it can be at class level or method level
     * *  We can optionally add reason inside ("this is optional reason text")
     */
    @Disabled("ignored until defect 101 is fixed ")
    @DisplayName("Testing addition here")
    @Test
    public void testAdd() {

        assertEquals(10, 5 + 5);
    }

    @DisplayName("Testing Subtraction functionality here")
    @Test
    public void testSubstruct() {
        assertEquals(9, 10 - 1);
    }

    @DisplayName("Assert all together and then one result")
    @Test
    public void multipleAssertions() {
        //in this way if some assertion fail, will stop the test at line 34, and we will not know if the next line is failed too

        assertEquals(10, 5 + 5);
        //providing additional error message when assertion fail


        assertEquals(10, 5 + 7, "hey It was not 10!!!");
        assertTrue(10 > 11, "Salary was not greater than 130K");
        // assertEquals(12, 5 + 6);
        // assertEquals(20, 5 + 15);
        //but sometimes we want to assert all of the 3 results
        //assertAll
        //it accept one or more Executable is functional interface
        //and it can be easily created using lambda expression
        ///it hase single method theta accept no parameter and return nothing
        //sp it can be in this way ()-> the assertion you want to run
        assertAll(
                () -> assertEquals(11, 5 + 5),
                () -> assertEquals(12, 5 + 6),
                () -> assertEquals(21, 5 + 15)
        );
    }

    @DisplayName("Explore Junit5")

    @ParameterizedTest
    @ValueSource(ints = {11, 44, 33, 11, 12, 88})  //provide value for each iteration of test

    public void testNumberMoreThan10(int num) {
        //assume that we have these numbers
        // 11,44,33,5,6,88
        //assert that all these numb are more that 10
        System.out.println("Number in this iteration " + num);
        //int num=11;
        assertTrue(num > 10, "hey it was not more than 10");
    }
}
