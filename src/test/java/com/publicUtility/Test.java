package com.publicUtility;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Test {
  /* @org.testng.annotations.Test
    public void userCanLoginByUsername() {
        open("https://e-dostavka.by/");
        $(By.name("user.name")).setValue("johny");
        $("#submit").click();
        $(".loading_progress").should(disappear); // Waits until element disappears
        $("#username").shouldHave(text("Hello, Johny!")); // Waits until element gets text
    }*/

    @org.testng.annotations.Test
    public void eDostavka() {
        open("https://e-dostavka.by/");
        $(By.cssSelector("body.direction_1.section_1.not_authorized:nth-child(2) div.main__wrap div.main:nth-child(4) div.main_menu:nth-child(2) div.main_menu__inner nav:nth-child(1) ul:nth-child(1) li:nth-child(9) a:nth-child(1) > i.fa.fa-search")).click();
        $(By.cssSelector("#searchtext")).setValue("Кофе молотый «Dallmayr» classic, 250 г.").pressEnter();
        $(By.xpath("//a[contains(text(),'Кофе молотый «Dallmayr» classic, 250 г.')]")).click();
        $(By.xpath("//form[@name=‘product_order’]//meta[@itemprod=‘price’]")).shouldHave(Condition.text("13.55"));
        //$(By.xpath("//body/div[@id='body']/noindex[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/meta[1]")).shouldHave(Condition.text("13.55"));
        //$(By.xpath("//body/div[@id='body']/noindex[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]")).shouldHave(Condition.text("54.2"));
        //$(By.xpath("//body/div[@id='body']/noindex[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/div[1]/dгорт iv[1]/div[1]/meta[1]")).shouldHave(text("13.55"));
        //$(By.cssSelector("body.direction_1.section_10.not_authorized.search_block__showed:nth-child(2) div.main__wrap:nth-child(5) div.main:nth-child(4) div.wrapper:nth-child(3) div.template_1_columns div.content:nth-child(4) div.products_catalog.filter_left div.products_block__wrapper.products_4_columns.vertical div.products_card.products_card_444796.trademark_7907 div.form_wrapper form:nth-child(1) div.img:nth-child(4) a.fancy_ajax > img.retina_redy")).click();
        //$(By.cssSelector("body.direction_1.section_10.not_authorized.search_block__showed:nth-child(2) div.mfp-wrap.mfp-close-btn-in.mfp-auto-cursor.mfp-zoom-in.dialog.mfp-ready div.mfp-container.mfp-ajax-holder.mfp-s-ready div.mfp-content div.product_card div.products_card div.product_card__inner:nth-child(3) div.right:nth-child(5) form.forms div.services_wrap:nth-child(3) div.prices_block div.price_byn div.price > meta:nth-child(4)")).shouldHave(Condition.attribute("13.55"));
    }

}
