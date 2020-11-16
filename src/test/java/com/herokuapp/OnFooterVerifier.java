package com.herokuapp;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public interface OnFooterVerifier {

    String relativeUrl();

    default void open() {
        Selenide.open(relativeUrl());
    }

    default void verifyElementPresents(SelenideElement element) {
        element.should(Condition.visible);
    }
}
