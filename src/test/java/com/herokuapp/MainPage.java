package com.herokuapp;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    ElementsCollection pagesList = $$("li a");

    public void openPageFromMain(String pageName) {
        open("https://the-internet.herokuapp.com/");
        for (SelenideElement pageToOpen : pagesList) {
            if (pageToOpen.has(Condition.text(pageName))) {
                pageToOpen.click();
            }
        }
    }
}

