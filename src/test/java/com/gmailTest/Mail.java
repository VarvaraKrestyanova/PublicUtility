package com.gmailTest;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Mail {

    @BeforeMethod
    @Test(dataProvider = "dataForInput", dataProviderClass = DataManager.class)
    protected void beforePrecondition(){
        DataManager data = new DataManager();
        data.dataForInput("******@mail.ru", "******");
    }

    @AfterMethod
    protected void afterTest(){
        $(By.cssSelector("#PH_logoutLink"));
    }

    @Test(dataProvider = "jsonMessageParser", dataProviderClass = JsonMessageParser.class)
    public void validateInput() throws IOException {
        $(By.cssSelector(".compose-button__txt")).click();
        $(By.cssSelector("input[tabindex='100']")).click();
        $(By.cssSelector("div[data-test-id='letter-to-yourself'] > .text--1qkBf > .limiter--2XaNi")).click();

        JsonMessageParser message = new JsonMessageParser();
        Object[] data = message.jsonMessageParser();

        $(By.cssSelector("[name='Subject']")).setValue((String) data[0]);
        $(By.cssSelector("div.editable-fxkl > div:nth-of-type(2)")).setValue((String) data[1]);
        $(By.cssSelector("span[tabindex='570'] > .button2__txt")).click();

        open("https://e.mail.ru/inbox/");
        $(By.cssSelector("div._1lwCBvq0cmXim-ZbQkhI4Z > div:nth-of-type(2) > .LG-qpXXxvyWu6jdl5Gi7J")).click();
        $(By.cssSelector("a[data-id='16048637331798571974'] .llc__snippet .highlighter__item")).click();
        String title = $(By.cssSelector(".thread__subject")).getText();
        String body = $(By.cssSelector("pre > span")).getText();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(title, (String) data [0]);
        softAssert.assertEquals(body, (String) data [1]);

        softAssert.assertAll();
    }



}
