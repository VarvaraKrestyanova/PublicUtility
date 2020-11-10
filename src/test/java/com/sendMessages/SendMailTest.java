package com.sendMessages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class SendMailTest {
    SelenideElement writeMessageButton = $(".compose-button__txt");
    SelenideElement toWhomField = $(".NHKrFD6");
    SelenideElement topicButton = $("label--2gJqH");
    SelenideElement firstFieldBody = $x("//div[@class='editable-iunl cke_editable cke_editable_inline cke_contents_true cke_show_borders']");

    String anyLogin = "";
    String anyPassword = "";
    String anyTitle = "";
    String anyBody = "";

    public void writeMessage(){
        writeMessageButton.click();
        toWhomField.setValue(anyLogin);
        topicButton.setValue(anyTitle);
        firstFieldBody.setValue(anyBody);
    }

    //START TESTS-------------------------------------------------

    @BeforeMethod
    @Test(dataProvider = "sender", dataProviderClass = DataReader.class)
    public void login(String login, String password){
        open("https://mail.ru/");
        $(By.cssSelector("[name='login']")).setValue(login).pressEnter();
        $(By.cssSelector("[name='password']")).setValue(password).pressEnter();
    }

    @AfterMethod
    protected void afterTest(){
        $(By.cssSelector("#PH_logoutLink")).click();
    }

}
