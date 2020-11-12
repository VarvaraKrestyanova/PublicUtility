package com.sendMessagePartTwo;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    SelenideElement loginField = $("[name='login']");
    SelenideElement passwordField = $("[name='password']");

    public void loginToMail(String anyLogin, String anyPassword) {
        open("https://mail.ru/");
        loginField.setValue(anyLogin).pressEnter();
        passwordField.setValue(anyPassword).pressEnter();
    }
}
