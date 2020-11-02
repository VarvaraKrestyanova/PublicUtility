package com.publicUtility;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Test {

    @org.testng.annotations.Test
    public void eDostavka() {
        open("https://e-dostavka.by/");
        $(By.cssSelector("div.main_menu__inner > nav .fa")).click();
        $(By.cssSelector("#searchtext")).setValue("Кофе молотый «Dallmayr» classic, 250 г.").pressEnter();
        $(By.xpath("//a[contains(text(),'Кофе молотый «Dallmayr» classic, 250 г.')]")).click();
        $(By.xpath("//span[.='54.2']")).shouldHave(Condition.text("54.2"));
    }

}
