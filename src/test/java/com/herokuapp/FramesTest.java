package com.herokuapp;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Selenide.*;

public class FramesTest {

    MainPage mainPage = new MainPage();

    SelenideElement frameLink =  $("a[href='/iframe']");
    SelenideElement popupOkButton = $x("//button[.='Ok']");
    SelenideElement frameElement = $("#mce_0_ifr");
    SelenideElement frameInputField = $("#tinymce p");

    @BeforeMethod
    protected void beforeTest() {
        mainPage.openPageFromMain("Frames");
    }

    @Test
    public void iFrameTextCheck(){

        String expectedMessage = "Your content goes here.";

        frameLink.click();
        popupOkButton.click();
        Selenide.switchTo().frame(frameElement);
        String actualMessage = frameInputField.getText();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(expectedMessage, actualMessage);
        softAssert.assertAll();
    }

    @Test
    public void iFrameInputTextCheck(){

        String messageForInput = "Let's check this frame!";

        frameLink.click();
        popupOkButton.click();
        Selenide.switchTo().frame(frameElement);
        frameInputField.clear();
        frameInputField.sendKeys(messageForInput);
        frameInputField.shouldHave(Condition.exactText(messageForInput));
    }

}
