package org.example.features.search;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.example.steps.serenity.EmagEndUser;
import org.example.steps.serenity.EndUserSteps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("src/test/resources.csvData.csv")
public class EmagWebScraper {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages(defaultUrl="https://www.emag.ro/")
    public Pages pages;

    @Steps
    public EmagEndUser endUser;

    public String name;

    public String price;

    @Qualifier
    public String getQualifier() {
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


    @Test
    public void searching_by_keyword() {
            endUser.is_the_home_page();
            endUser.looks_for(getName());
            endUser.should_see_item_title(getName());
    }

    @Test
    public void searching_by_keyword_fgzdadfgsfdgh() {
        try {
            endUser.is_the_home_page();
            endUser.looks_for("fgzdadfgsfdgh");
            endUser.should_see_item_title("fgzdadfgsfdgh");
        }
        catch (Exception e){
            assert true;
        }

    }

    @Test
    public void add_cart_fail() {
        try {
            endUser.is_the_home_page();
            endUser.looks_for("fgzdadfgsfdgh");
            endUser.add_to_cart();
            endUser.should_see_total_empty();
        }
        catch (Exception e){
            assert true;
        }

    }

    @Test
    public void add_cart_work() {
        endUser.is_the_home_page();
        endUser.looks_for(getName());
        endUser.add_to_cart();
        endUser.should_see_total(getPrice());
    }
}
