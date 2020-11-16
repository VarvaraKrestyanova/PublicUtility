package com.herokuapp;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DropdownListTest {
    SelenideElement titleOnPage = $("h3");

    MainPage mainPage = new MainPage();

    /*@BeforeMethod
    protected void beforeTest(){
        mainPage.openPageFromMain("Dropdown");
    }*/


    @BeforeMethod
    protected void before(){
        open("https://the-internet.herokuapp.com/dropdown");
    }

    //проверка на соответсвие текста в тайтле
    @Test(dataProvider = "dropdownTitleFromFile", dataProviderClass = DropdownDataManager.class)
    public void titleTextCheck(DropdownPageData dropdownPageData){
        titleOnPage.shouldHave(Condition.text(dropdownPageData.getTitle()));
    }

    //проверка текста в дропдауне
    @Test(dataProvider = "dropdownValuesFromFile", dataProviderClass = DropdownDataManager.class)
    public void selectValueCheck(DropdownValues dropdownValues){



    }

}
