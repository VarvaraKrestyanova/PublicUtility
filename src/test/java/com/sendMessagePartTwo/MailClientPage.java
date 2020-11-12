package com.sendMessagePartTwo;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class MailClientPage {
    SelenideElement logoutButtonOnHeader = $("#PH_logoutLink");
    SelenideElement writeMessageButton = $(".compose-button__wrapper");
    SelenideElement toWhomField = $("div[class^='inputContainer'] input:nth-of-type(1)");
    SelenideElement topicButton = $("[name='Subject']");
    SelenideElement firstFieldBody = $("div[class*=cke_editable_inline]>div:nth-of-type(1)");
    SelenideElement sendMailButton = $("span[data-title-shortcut='Ctrl+Enter']");
    SelenideElement sendMessagePopupCloseButton = $(".ico_16-close");
    SelenideElement sentMessagesButton = $("a[href='/sent/']");
    SelenideElement searchButton = $(".search-panel-button__text");
    SelenideElement searchOpenedField = $("div[class='react-async search-panel__layer'] input");
    SelenideElement messageInSearchPage = $(".highlighter__item_light");


    public void writeMessage(String anyRecipient, String anyTitle, String anyBody) {
        writeMessageButton.click();
        toWhomField.setValue(anyRecipient);
        topicButton.setValue(anyTitle);
        firstFieldBody.setValue(anyBody);
    }

    public void sendMessage() {
        sendMailButton.click();
        sendMessagePopupCloseButton.click();
    }

    public void findMessageById(String id) {
        sentMessagesButton.click();
        searchButton.click();
        searchOpenedField.setValue(id).pressEnter();
        messageInSearchPage.waitUntil(Condition.appears, 5000);
        messageInSearchPage.click();
    }

    public void logout() {
        logoutButtonOnHeader.click();
    }
}
