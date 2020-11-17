package com.herokuapp;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;

public class FooterTest {
    SelenideElement footerText = $("#page-footer>div>div");

    @Test
    public void verifyOnFooter() {
        footerText.shouldHave(Condition.exactText("Powered by Elemental Selenium"));

    }
}
