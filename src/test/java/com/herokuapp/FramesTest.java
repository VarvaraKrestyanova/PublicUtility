package com.herokuapp;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class FramesTest {

    MainPage mainPage = new MainPage();

    SelenideElement frameLink =  $("a[href='/iframe']");
    SelenideElement popupOkButton = $x("//button[.='Ok']");
    SelenideElement inputField = $("#tinymce");
    SelenideElement formatsButton = $("#mceu_2-open span");
    SelenideElement headingButton =$x("//span[.='Headings']");
    SelenideElement headingFirst = $("//span[.='Heading 1']");
    SelenideElement nameOfH = $(".mce-path-item");

    @BeforeMethod
    protected void beforeTest() {
        mainPage.openPageFromMain("Frames");
    }

    @Test
    public void boldTextCheck(){
        frameLink.click();
        popupOkButton.click();
        formatsButton.click();
        headingButton.click();
        headingFirst.click();
        nameOfH.shouldHave(Condition.exactText("h1"));
    }

    @Test
    public void iFrameInputCheck(){

        String message = "New message for the input!";

        frameLink.click();
        popupOkButton.click();
        inputField.clear();
        inputField.setValue(message);
        inputField.shouldHave(Condition.exactText(message));

        //WebDriver driver = new ChromeDriver();
        //driver.switchTo().frame(inputField);
    }

}
