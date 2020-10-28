package com.Bank;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class Solution {

    public static void main(String[] args) throws IOException {

        List<Double> professions = Arrays.asList(
                salaryAndTax("driver", 300, 200),
                salaryAndTax("teacher", 500, 100),
                salaryAndTax("doctor", 1000, 70)
        );

        double totalTax = 0;
        for (int i = 0; i < professions.size(); i++){
            totalTax += professions.get(i);
        }
        System.out.println("Total tax is " + totalTax + " BEL RUB" + "\n");
        System.out.println("CURRENCY CONVERTER FOR THE NATIONAL BANK" + "\n");
        //-------------------------------------------------------

        String json = given().get("https://www.nbrb.by/api/exrates/rates?periodicity=0").asString();

        ObjectMapper mapper = new ObjectMapper();
        BankData[] asArray = mapper.readValue(json, BankData[].class);

        for (int i = 0; i < asArray.length; i++){
            String abbreviation = asArray[i].cur_Abbreviation;
            double officialRate = asArray[i].cur_OfficialRate;
            double result = totalTax * officialRate;
            System.out.println(result + " " + abbreviation);
        }

    }

    public static double salaryAndTax(String profession, int salary, int count) {
        double tax = 0.10;  //10%
        double payrollTax = salary * count * tax;
        return payrollTax;
    }
}
