package com.herokuapp;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Footer {
    SelenideElement gitHubButton = $("//img[@alt='Fork me on GitHub']");
    //SelenideElement h1Title = $("h1");
    //SelenideElement h2Title = $("h2");
    //SelenideElement h3Title = $("h3");
    ElementsCollection footer = $$("#page-footer"); //составить лист с 3мя элементами и прогонять проверку на наличие
    //хз, понадобятлся ли элементы футера поотдельности
    SelenideElement footerLine = $("hr");
    SelenideElement footerText = $("#page-footer>div>div");
    SelenideElement footerLink = $("a[target='_blank']");

    public void verifyOnFooter() {
        footerText.shouldHave(Condition.exactText("Powered by Elemental Selenium"));

    }
}
