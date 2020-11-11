package com.sendMessages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.testng.asserts.SoftAssert;

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
    SelenideElement bodyOfOpenedMessage = $("div[id$='BODY']"); //первая строка div[id$='BODY']>div>div:nth-of-type(1)
    SelenideElement titleOfOpenedMessage = $(".thread__subject");
    SelenideElement searchButton = $(".search-panel-button__text");
    SelenideElement searchOpenedField = $("._1BEp2b6vqOez8I6Rw9SpK6");
    SelenideElement messageInSearchPage = $(".highlighter__item_light");


    public void writeAndSendMail(String anyRecipient, String anyTitle, String anyBody) {
        writeMessageButton.click();
        toWhomField.setValue(anyRecipient);
        topicButton.setValue(anyTitle);
        firstFieldBody.setValue(anyBody);
        sendMailButton.click();
        sendMessagePopupCloseButton.click();
    }

    public void sentMessagesCheck(String anyTitle, String anyBody, String id) {
        sentMessagesButton.click();
        searchButton.click();
        searchOpenedField.setValue(id).pressEnter();

        messageInSearchPage.waitUntil(Condition.appears, 5000);
        messageInSearchPage.click();

        SoftAssert softAssert = new SoftAssert();

        String actualTitle = titleOfOpenedMessage.getText();
        String expectedTitle = ": " + anyTitle;

        softAssert.assertEquals(actualTitle, anyTitle);
        System.out.println("1. Title" + "\n" + "Actual Result: " + actualTitle + "\n" + "Expected Result: " + expectedTitle);

        String actualBody = bodyOfOpenedMessage.getText();
        String expectedBody = anyBody;

        softAssert.assertTrue(actualBody.contains(expectedBody));
        System.out.println("2. Body" + "\n" + "Actual Result: " + actualBody + "\n" + "Expected Result: " + expectedBody);

        softAssert.assertAll();
    }

    public void logout(){
        logoutButtonOnHeader.click();
    }
}
