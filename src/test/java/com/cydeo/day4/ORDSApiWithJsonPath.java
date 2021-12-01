package com.cydeo.day4;

import com.cydeo.day2.HrGetRequests;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.RepeatedTest;
import utilities.SpartanTestBase;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class ORDSApiWithJsonPath extends HrGetRequests {

    @DisplayName("GET  request to countries")
    @Test
    public void test1() {

        Response response =get("/countries") ;
        //get the second country name with the json path

        //to use json path we assign response to json path
        JsonPath jsonPath = response.jsonPath();

        String secondCountryName = jsonPath.getString("items[1].country_name");


        //get all country id
        //items.country_id will get you all the countries

        List<String> allCountryIds = jsonPath.getList("items.country_id");
        System.out.println(allCountryIds);

        //get all country names where their regions id is equal to 2

        List<String> countryNameWithRegionId2 = jsonPath.getList("items.findAll{it.region_id==2}.country_name");
        System.out.println(countryNameWithRegionId2);

        //"items.findAll{it.region_id==2}.country_name")==>means find all countries then if the region id equals to 2 then give me them
        //it.region_id==2}==> like a if condition


        }
        @DisplayName("GET request/ emp;oyees  with query param")
        @Test
        public void test2(){

        //we added limit query param to get 107 employees
            Response response = given().queryParam("limit",107)
            .when().get("employees");

            JsonPath jsonPath = response.jsonPath();
            //get me all email of employees who is working as IT_PROG
            List<String> employeeITProg = jsonPath.getList("items.findAll {it.job_id==\"IT_PROG\"}.email");
            System.out.println(employeeITProg);

            //get me first name of employees who is making more than 10000

            List<String> employeesNames = jsonPath.getList("items.findAll{it.salary>10000}.first.name");
            System.out.println(employeesNames);

            //get the max salary first_name
            String kingFirstName = jsonPath.getString("items.max{it.salary}.first_name");
            System.out.println("kingFirstName = " + kingFirstName);
            }
}
