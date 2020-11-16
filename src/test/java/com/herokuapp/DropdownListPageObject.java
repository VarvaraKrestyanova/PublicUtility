package com.herokuapp;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DropdownListPageObject{
     //implements OnFooterVerifier ???
    /*@Override
    public String relativeUrl(){}    */

    SelenideElement dropdownBar = $("#dropdown");
    static ElementsCollection dropdownListValues = $$("[value]");
    SelenideElement disabledValue = $("[disabled]");

    //optionValue.has(Condition.not(Condition.text("Please select an option")))

    public List<String> chooseListValues(){
        List<String>listOfValues = null;
        dropdownBar.click();
        for (SelenideElement optionValue : dropdownListValues){
            listOfValues.add(optionValue.getText());
        }
        return listOfValues;
        }

}
