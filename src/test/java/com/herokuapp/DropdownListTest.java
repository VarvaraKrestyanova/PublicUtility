package com.herokuapp;

import com.codeborne.selenide.Condition;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class DropdownListTest extends FooterTest {

    MainPage mainPage = new MainPage();
    DropdownListPageObject dropdownListPageObject = new DropdownListPageObject();

    @BeforeMethod
    protected void beforeTest(){
        mainPage.openPageFromMain("Dropdown");
    }

    //проверка на соответсвие текста в тайтле
    @Test(dataProvider = "dropdownTitleFromFile", dataProviderClass = DropdownDataManager.class)
    public void titleTextCheck(DropdownPageData dropdownPageData){

        dropdownListPageObject.getTitleOnPage().shouldHave(Condition.text(dropdownPageData.getTitle()));
    }

    //проверка текста в дропдауне
    @Test(dataProvider = "dropdownValuesFromFile", dataProviderClass = DropdownDataManager.class)
    public void selectValueCheck(DropdownValues dropdownValues){

        SoftAssert softAssert = new SoftAssert();
        List actualName = dropdownListPageObject.getActualDropdownValues();
        softAssert.assertTrue(actualName.contains(dropdownValues.getName()));
        softAssert.assertAll();
    }

}
