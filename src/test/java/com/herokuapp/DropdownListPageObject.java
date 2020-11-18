package com.herokuapp;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DropdownListPageObject{

    public SelenideElement getTitleOnPage() {
        return titleOnPage;
    }

    SelenideElement titleOnPage = $("h3");
    SelenideElement dropdownBar = $("#dropdown");
    ElementsCollection dropdownListValues = $$("[value]");

    public List<String> getActualDropdownValues(){
        List<String>listOfValues = new ArrayList<>();
        dropdownBar.click();
        for (SelenideElement optionValue : dropdownListValues){
            listOfValues.add(optionValue.getText());
        }
        return listOfValues;
        }

}
