package com.herokuapp;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.FileNotFoundException;

import static com.codeborne.selenide.Selenide.$$;

public class FileDownloaderTest extends FooterTest {

    MainPage mainPage = new MainPage();

    ElementsCollection allFiles = $$(".example a[href]");

    @BeforeMethod
    protected void beforeTest() {

        mainPage.openPageFromMain("File Download");
    }


    @Test
    public void downloadFilesCheck() throws InterruptedException, FileNotFoundException {

        SoftAssert softAssert = new SoftAssert();

        for (SelenideElement oneFile : allFiles) {

            File file = oneFile.download();
            long expectedSize = file.length();

            File fileDownloaded = new File(file.getPath());
            long actualSize = fileDownloaded.length();

            Selenide.sleep(6000);

            softAssert.assertTrue(file.getPath().contains(oneFile.getText()));
            softAssert.assertEquals(expectedSize, actualSize);
            softAssert.assertAll();
        }
    }

}
