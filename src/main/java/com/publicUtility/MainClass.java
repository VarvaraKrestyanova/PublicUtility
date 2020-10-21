package com.publicUtility;

import java.util.Arrays;
import java.util.List;



public class MainClass {
    public static void main(String[] args) {

        FiveStoryHouse fiveStoryHouse = new FiveStoryHouse();
        fiveStoryHouse.countUtilityFiveStoryHouse(
                15,
                5,
                2,
                3,
                35,
                55);

        TwoStoryHouse twoStoryHouse = new TwoStoryHouse();
        twoStoryHouse.countUtilityTwoStoryHouse(
                4,
                4,
                1,
                3,
                30,
                55);

        DetachedHouse detachedHouse = new DetachedHouse();
        detachedHouse.countUtilityDetachedHouse(
                1,
                0,
                5,
                0,
                250,
                0);

        System.out.println("\n" + "--------------------------------------------");

        List<Float> street = Arrays.asList(detachedHouse.publicUtilityValue, twoStoryHouse.publicUtilityValue, twoStoryHouse.publicUtilityValue, fiveStoryHouse.publicUtilityValue, fiveStoryHouse.publicUtilityValue);
        float streetPublicUnity = 0;
        for (int i = 0; i < street.size(); i++) {
            streetPublicUnity += street.get(i);
        }
        System.out.println("\n" + "Public utility of the street per month is " + streetPublicUnity + " rub.");



        //List<House> street = Arrays.asList(detachedHouse, twoStoryHouse, twoStoryHouse, fiveStoryHouse, fiveStoryHouse);
        //почему просит в ковычки поставить не тип значений, а название класса? потому что не примитивы?
        //System.out.println(new StringBuilder().append("\n").append("Public utility of the street per month is ").append(street).append(" rub.").toString());
        /*
        House fiveStoryHouse = new FiveStoryHouse();
        House detachedHouse = new DetachedHouse();
        House twoStoryHouse = new TwoStoryHouse();
        List<House> street = Arrays.asList(fiveStoryHouse, detachedHouse, twoStoryHouse);
        for(House house: street){
            house.countUtilityValue();
        }*/


    }
}