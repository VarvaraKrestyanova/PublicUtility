/*package com.publicUtility;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;

public class testCoffeWithProviders {
    @Test
    public void coffeeWithProviders() {
        EDostavka openSiteAndSearch = new EDostavka();
        openSiteAndSearch.openSiteAndSearch();
        $(By.cssSelector("#searchtext")).setValue("Кофе молотый «Dallmayr» classic, 250 г.").pressEnter();
        $(By.xpath("//a[contains(text(),'Кофе молотый «Dallmayr» classic, 250 г.')]")).click();
        $(By.xpath("//span[.='54.2']")).shouldHave(Condition.text("54.2"));
        String actualResult = $(By.xpath("//span[.='54.2']")).getText();
        System.out.println("Test1. Ground coffee");
        System.out.println("Expected Result: " + "54.2" + "\n" + "Actual Result: " + actualResult);
    }

    @DataProvider
    public Object[][] dataForInput(){

    }
}*/
