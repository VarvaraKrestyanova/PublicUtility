package com.herokuapp;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;

public class KeyPressesTest {

    MainPage mainPage = new MainPage();
    SelenideElement inputField = $("#target");
    SelenideElement pageBody = $("body");
    SelenideElement resultOnScreen = $("#result");

    @BeforeMethod
    protected void beforeTest() {
        mainPage.openPageFromMain("Key Presses");
    }

    @Test
    public void enteredLettersCheck(){

        String valueForInput = "Key presses test";
        inputField.setValue(valueForInput);
        String lastLetter = valueForInput.substring(valueForInput.length() - 1);
        resultOnScreen.shouldHave(Condition.exactText("You entered: " + lastLetter));
    }

    @Test
    public void pressedKeyCheck(){

        Keys key = Keys.ENTER;
        pageBody.sendKeys(Keys.chord(key));
        resultOnScreen.shouldHave(Condition.exactText("You entered: " + key.name()));
    }
}
