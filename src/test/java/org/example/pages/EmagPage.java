package org.example.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

@DefaultUrl("https://www.emag.ro/")
public class EmagPage extends PageObject {

    @FindBy(id="searchboxTrigger")
    private WebElementFacade searchTerms;

    @FindBy(className="searchbox-submit-button")
    private WebElementFacade lookupButton;

    @FindBy(id = "my_cart")
    private WebElementFacade myCartButton;

    public void enter_keywords(String keyword) {
        searchTerms.type(keyword);
    }

    public void lookup_terms() {
        lookupButton.click();
    }

    public void check_cart(){
        myCartButton.click();
    }

    public String getTitle(){
        WebElementFacade productList = find(By.id("card_grid"));

        return productList.findElements(By.className("card-item")).get(0).findElement(By.className("card-section-mid"))
                .findElement(By.className("product-title-zone")).findElement(By.tagName("a")).getAttribute("title");
    }

    public void addToCart(){
        WebElementFacade productList = find(By.id("card_grid"));

        productList.findElements(By.className("card-item")).get(0).findElement(By.className("yeahIWantThisProduct")).click();
    }

    public void closeModal(){
        find(By.className("modal-header")).findElement(By.cssSelector("close")).click();
    }

    public String getTotalCart(){
        return find(By.className("vendor-summary-total-price")).findElement(By.cssSelector("money-int")).getText();
    }
}