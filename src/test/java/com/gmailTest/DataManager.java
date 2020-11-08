package com.gmailTest;

import lombok.Data;
import lombok.experimental.Accessors;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Data
@Accessors(chain = true)
public class DataManager {

    @DataProvider
    public Object[] dataForInput(String login, String password){
        open("https://mail.ru/");
        $(By.cssSelector("[name='login']")).setValue(login).pressEnter();
        $(By.cssSelector("[name='password']")).setValue(password).pressEnter();
        return new Object[0];
    }

}
