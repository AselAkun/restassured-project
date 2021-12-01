package day5;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestMatchersIntro {

    @DisplayName("")
    @Test
    public void simpleTest1(){

        //matchers has 2 overloaded version
        assertThat(5+5, is(10));  //actual 5+5,   accept actual value
        assertThat(5+5, equalTo(10)); //accept another matchers (equal to)
        assertThat(5+5, is(equalTo(10))); //accepting another matchers equal to make it readable

        assertThat(5+5, not(9));
        assertThat(5+5, is(not(9)));
        assertThat(5+5, is (not(equalTo(9))));

        //number comparison
        //greater than()
        //greaterThanOrEqualTo()
        //lessThan()
        //LessThanOrQualTo()

        assertThat(5+5, is(greaterThan(9)));



        }
        @DisplayName("Assertion with String")
        @Test
        public void stringHamster(){
        String text = "B22 is learning Hamcrest";
         //checking for equality is same as numbers

            assertThat(text, is("B22 is learning Hamcrest"));
            assertThat(text, equalTo("B22 is learning Hamcrest"));
            assertThat(text,is(equalTo("B22 is learning Hamcrest")));

            //check if this text starts with B22
            assertThat(text,startsWith("B22"));
            //now do it in case insesnsitive manner
            assertThat(text, startsWithIgnoringCase("b22"));
            //endwith
            assertThat(text, endsWith("rest"));

            //check if the text contain String "learning"
            assertThat(text, containsString("learning"));
            assertThat(text, containsStringIgnoringCase("LEARNING"));

            String str = " ";
            assertThat(str, blankString());
            //check if the trimmed str is empty string
            assertThat(str.trim(), emptyString());

    }
    @DisplayName("hamcrest for Collection")
    @Test
    public void testCollection(){

        List<Integer> listOfNumbers = Arrays.asList(1,4,5,6,32,54,66,77,45,23);

        //check size of the list
        assertThat(listOfNumbers,hasSize(10));
        //check if this list hasItem 77
        assertThat(listOfNumbers, hasSize(77));
        //chck if list has 77,54,23
        assertThat(listOfNumbers,hasItems(77,54,23));

        //check if all nubers greater than 0
        assertThat(listOfNumbers, everyItem(greaterThan(0)));
    }


}
