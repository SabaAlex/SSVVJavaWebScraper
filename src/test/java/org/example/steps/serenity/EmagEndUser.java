package org.example.steps.serenity;

import net.thucydides.core.annotations.Step;
import org.example.pages.EmagPage;

import java.util.ArrayList;
import java.util.Locale;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class EmagEndUser {

    private EmagPage emagPage;

    @Step
    public void enters(String keyword) {
        emagPage.enter_keywords(keyword);
    }

    @Step
    public void starts_search() {
        emagPage.lookup_terms();
    }

    @Step
    public void add_to_cart(){
        emagPage.addToCart();
    }

    @Step
    public void should_see_total(String price) {
        String asdqasd = emagPage.getTotalCart();

        assertThat(asdqasd, containsString(price));
    }

    @Step
    public void should_see_total_empty() {
        String asdqasd = emagPage.getTotalCart();

        assertThat(asdqasd, isEmptyOrNullString());
    }

    @Step
    public void should_see_item_title(String item) {
        String asdqasd = emagPage.getTitle();

        assert asdqasd.toLowerCase(Locale.ROOT).contains(item);
    }

    @Step
    public void is_the_home_page() {
        emagPage.open();
    }

    @Step
    public void looks_for(String term) {
        enters(term);
        starts_search();
    }
}
