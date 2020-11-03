package com.publicUtility;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class EDostavka {

    public void openSiteAndSearch(){
        open("https://e-dostavka.by/");
        $(By.cssSelector("div.main_menu__inner > nav .fa")).click();
    }

    @org.testng.annotations.Test
    //Кофе молотый
    public void coffeeDallmayr() {
        EDostavka openSiteAndSearch = new EDostavka();
        openSiteAndSearch.openSiteAndSearch();
        $(By.cssSelector("#searchtext")).setValue("Кофе молотый «Dallmayr» classic, 250 г.").pressEnter();
        $(By.xpath("//a[contains(text(),'Кофе молотый «Dallmayr» classic, 250 г.')]")).click();
        $(By.xpath("//span[.='54.2']")).shouldHave(Condition.text("54.2"));
        String actualResult = $(By.xpath("//span[.='54.2']")).getText();
        System.out.println("Test1. Ground coffee");
        System.out.println("Expected Result: " + "54.2" + "\n" + "Actual Result: " + actualResult);
    }


    @BeforeMethod
    public void greeting(){
        System.out.println("I'm king here. And then there will be new tests.");
    }

    @Test
    //сельдерей
    public void celery(){
        EDostavka openSiteAndSearch = new EDostavka();
        openSiteAndSearch.openSiteAndSearch();
        $(By.cssSelector("#searchtext")).setValue("Сельдерей стебель, 1 кг").pressEnter();
        $(By.xpath("//div[@class='img']//img[1]")).click();
        $(By.cssSelector("div[itemprop='offers']")).shouldHave(Condition.text("6р.69к."));
        String actualResult = $(By.cssSelector("div[itemprop='offers']")).getText();
        System.out.println("Test2. Celery");
        System.out.println("Expected Result: " + "6р.69к." + "\n" + "Actual Result: " + actualResult);
    }

    @Test
    //морожко
    public void iceCream() {
        EDostavka openSiteAndSearch = new EDostavka();
        openSiteAndSearch.openSiteAndSearch();
        $(By.cssSelector("#searchtext")).setValue("Мороженое «Jattis» трюфель бисквит").pressEnter();
        $(By.xpath("//img[@alt='Мороженое «Jattis» трюфель бисквит, 75 г.']")).click();
        $(By.cssSelector("div[itemprop='offers']")).shouldHave(Condition.text("1р.65к."));
        String actualResult = $(By.cssSelector("div[itemprop='offers']")).getText();
        System.out.println("Test3. Ice cream");
        System.out.println("Expected Result: " + "1р.65к." + "\n" + "Actual Result: " + actualResult);
    }

    @Test
    //кумкват
    public void kumquat() {
        EDostavka openSiteAndSearch = new EDostavka();
        openSiteAndSearch.openSiteAndSearch();
        $(By.cssSelector("#searchtext")).setValue("Кумкват «Равит» 250 г.").pressEnter();
        $(By.xpath("//img[@alt='Кумкват «Равит» 250 г.']")).click();
        $(By.cssSelector("div[itemprop='offers']")).shouldHave(Condition.text("10р.99к."));
        String actualResult = $(By.cssSelector("div[itemprop='offers']")).getText();
        System.out.println("Test4. Kumquat");
        System.out.println("Expected Result: " + "10р.99к." + "\n" + "Actual Result: " + actualResult);
    }

    @Test
    //тетрадь школьная
    public void notebook() {
        EDostavka openSiteAndSearch = new EDostavka();
        openSiteAndSearch.openSiteAndSearch();
        $(By.cssSelector("#searchtext")).setValue("Тетрадь школьная «Rikki» широкая клетка").pressEnter();
        $(By.xpath("//img[@alt='Тетрадь школьная «Rikki» широкая клетка, 12 листов.']")).click();
        $(By.cssSelector("div[itemprop='offers']")).shouldHave(Condition.text("0р.14к."));
        String actualResult = $(By.cssSelector("div[itemprop='offers']")).getText();
        System.out.println("Test5. Notebook");
        System.out.println("Expected Result: " + "0р.14к." + "\n" + "Actual Result: " + actualResult);
    }

    @Test
    //Артишок
    public void artichoke() {
        EDostavka openSiteAndSearch = new EDostavka();
        openSiteAndSearch.openSiteAndSearch();
        $(By.cssSelector("#searchtext")).setValue("Артишок, 1 кг").pressEnter();
        $(By.xpath("//div[@class='img']//img[1]")).click();
        $(By.cssSelector("div[itemprop='offers']")).shouldHave(Condition.text("14р.79к."));
        String actualResult = $(By.cssSelector("div[itemprop='offers']")).getText();
        System.out.println("Test6. Artichoke");
        System.out.println("Expected Result: " + "14р.79к." + "\n" + "Actual Result: " + actualResult);
    }

}
