package com.sendMessagePartTwo;

import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Selenide.$;


public class SendMailTest {
    LoginPage loginPage = new LoginPage();
    MailClientPage mailClientPage = new MailClientPage();

    SelenideElement bodyOfOpenedMessage = $("div[id$='BODY']"); //первая строка div[id$='BODY']>div>div:nth-of-type(1)
    SelenideElement titleOfOpenedMessage = $(".thread__subject");


    @BeforeMethod
    protected void beforeTest() {
        loginPage.loginToMail(DataReader.getSenderLogin(), DataReader.getSenderPassword());
    }

    @AfterMethod
    protected void afterTest() {
        mailClientPage.logout();
    }

    //START TEST-------------------------------------------------

    @Test(dataProvider = "message", dataProviderClass = DataReader.class)
    public void test(String recipient, String title, String body, String id) {

        mailClientPage.writeMessage(recipient, title, body);
        mailClientPage.sendMessage();
        mailClientPage.findMessageById(id);

        SoftAssert softAssert = new SoftAssert();

        String actualTitle = titleOfOpenedMessage.getText();
        String expectedTitle = ": " + title;

        softAssert.assertEquals(actualTitle, title);
        System.out.println("1. Title" + "\n" + "Actual Result: " + actualTitle + "\n" + "Expected Result: " + expectedTitle);

        String actualBody = bodyOfOpenedMessage.getText();
        String expectedBody = body;

        softAssert.assertTrue(actualBody.contains(expectedBody));
        System.out.println("2. Body" + "\n" + "Actual Result: " + actualBody + "\n" + "Expected Result: " + expectedBody);

        softAssert.assertAll();
    }

}
