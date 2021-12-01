package day8;

import java.util.Arrays;
import java.util.List;

/*
The only purpose of this clas to demonstrait how to provide method sours for a parametrized test
and the method exist outside of the Test class
 */
public class MethodSoursUtil {

    //create a static method that return list of names
    //so we can use return value as data sourse for our parametrized test

    public static List<String> getSomeNames(){
        List <String> myList = Arrays.asList("Furkan", "Abbos", "Yevheniia" , "Shazia" ,"Tugba" , "Mohamed" , "Kimberley");

        return myList ;
    }
}
