package com.gmailTest;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Mail {

    @BeforeMethod
    protected void beforePrecondition(){
        open("https://mail.ru/");
        $(By.cssSelector("[name='login']")).click();
    }

    @AfterMethod
    protected void afterTest(){
        $(By.cssSelector("#PH_logoutLink"));
    }

    @Test(dataProvider = "dataForInput", dataProviderClass = DataManager.class)
    public void validateInput(String value){
        System.out.println(value + "---");
       // Assert.assertEquals(value, result);
    }



}
