package com.gmailTest;

import lombok.Data;
import lombok.experimental.Accessors;
import org.testng.annotations.DataProvider;

@Data
@Accessors(chain = true)
public class DataManager {

    /*public User getValidUser(){
        User t = (User) readFromFile("yyy");
        return null;
    }*/

    @DataProvider
    public Object[][] dataForInput(){

        Object[][] data = new Object[3][1];
        data[0][0] = "***@mail.ru";
        data[1][0] = "123qwe";
        data[2][0] = "Hi! How are u doing?";

        /*
        Object[][] data = new Object[3][2];
        data[0][0] = "***@mail.ru";
        data[0][1] = true;

        data[1][0] = "123qwe";
        data[1][1] = true;

        data[2][0] = "Hi! How are u doing?";
        data[2][1] = true;*/

        return data;
    }

}
