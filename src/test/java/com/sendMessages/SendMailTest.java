package com.sendMessages;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


public class SendMailTest {

    LoginPage loginPage = new LoginPage();
    MailClientPage mailClientPage = new MailClientPage();

    @AfterMethod
    protected void afterTest(){
        mailClientPage.logout();
    }

    //START TEST-------------------------------------------------

    @Test(dataProvider = "message", dataProviderClass = DataReader.class)
    public void test(String recipient, String title, String body, String id) {

        loginPage.loginToMail();
        mailClientPage.writeAndSendMail(recipient, title, body);
        mailClientPage.sentMessagesCheck(title, body, id);
    }

}
