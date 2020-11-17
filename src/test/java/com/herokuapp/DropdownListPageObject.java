package com.herokuapp;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DropdownListPageObject{

    SelenideElement dropdownBar = $("#dropdown");
    ElementsCollection dropdownListValues = $$("[value]");

    public String chooseListValues(){
        List<String>listOfValues = new ArrayList<>();
        dropdownBar.click();
        for (SelenideElement optionValue : dropdownListValues){
            listOfValues.add(optionValue.getText());
        }
        String list = String.valueOf(listOfValues);
        return list;
        }

}
