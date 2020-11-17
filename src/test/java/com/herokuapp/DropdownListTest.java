package com.herokuapp;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Selenide.$;

public class DropdownListTest extends FooterTest {
    SelenideElement titleOnPage = $("h3");

    MainPage mainPage = new MainPage();
    DropdownListPageObject dropdownListPageObject = new DropdownListPageObject();

    @BeforeMethod
    protected void beforeTest(){
        mainPage.openPageFromMain("Dropdown");
    }

    //проверка на соответсвие текста в тайтле
    @Test(dataProvider = "dropdownTitleFromFile", dataProviderClass = DropdownDataManager.class)
    public void titleTextCheck(DropdownPageData dropdownPageData){

        titleOnPage.shouldHave(Condition.text(dropdownPageData.title));
    }

    //проверка текста в дропдауне
    @Test(dataProvider = "dropdownValuesFromFile", dataProviderClass = DropdownDataManager.class)
    public void selectValueCheck(DropdownValues dropdownValues){

        SoftAssert softAssert = new SoftAssert();
        String actualName = dropdownListPageObject.chooseListValues();
        softAssert.assertTrue(actualName.contains(dropdownValues.name));
    }

}
