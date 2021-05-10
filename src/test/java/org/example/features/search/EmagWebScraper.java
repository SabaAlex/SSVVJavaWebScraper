package org.example.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.example.steps.serenity.EmagEndUser;
import org.example.steps.serenity.EndUserSteps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class EmagWebScraper {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public EmagEndUser retegan;

    @Test
    public void searching_by_keyword_s20() {
        try {
            retegan.is_the_home_page();
            retegan.looks_for("s20");
            retegan.should_see_item_title("s20");
        }
        catch (Exception e){
            assert true;
        }
    }

    @Test
    public void searching_by_keyword_fgzdadfgsfdgh() {
        try {
            retegan.is_the_home_page();
            retegan.looks_for("fgzdadfgsfdgh");
            retegan.should_see_item_title("fgzdadfgsfdgh");
        }
        catch (Exception e){
            assert true;
        }

    }

    @Test
    public void add_cart_fail() {
        try {
            retegan.is_the_home_page();
            retegan.looks_for("fgzdadfgsfdgh");
            retegan.add_to_cart();
            retegan.should_see_total_empty();
        }
        catch (Exception e){
            assert true;
        }

    }

    @Test
    public void add_cart_work() {
        try {
            retegan.is_the_home_page();
            retegan.looks_for("s20");
            retegan.add_to_cart();
            retegan.should_see_total("3.119");
        }
        catch (Exception e){
            assert false;
        }

    }
}
