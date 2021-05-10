package org.example.steps.serenity;

import net.thucydides.core.annotations.Step;
import org.example.pages.EmagPage;

import java.util.ArrayList;

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

        emagPage.closeModal();

        emagPage.check_cart();
    }

    @Step
    public void should_see_total_empty() {
        ArrayList<String> asdqasd = new ArrayList<String>();
        asdqasd.add(emagPage.getTotalCart());
        assertThat(asdqasd, hasItem(contains("")));
    }

    @Step
    public void should_see_item_title(String item) {
        String asdqasd = emagPage.getTitle();
        assertThat(asdqasd, hasItem(item));
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
