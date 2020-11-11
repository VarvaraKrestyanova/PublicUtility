package com.sendMessages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage extends DataReader{
    SelenideElement loginField = $("[name='login']");
    SelenideElement passwordField = $("[name='password']");

    DataReader dataReader = new DataReader();
    String login = (String) dataReader.sender()[0][0];
    String password = (String) dataReader.sender()[0][1];

    public void loginToMail(){
        open("https://mail.ru/");
        loginField.setValue(login).pressEnter();
        passwordField.setValue(password).pressEnter();
    }
}
