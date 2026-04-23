package steps;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.HomePage;
import pages.ProductDetailPage;

public class PriceSteps {

    private HomePage homePage;
    private ProductDetailPage detailPage;
    private String catalogPrice;

    @When("I note the price of the first book on the catalog")
    public void iNoteThePriceOfFirstBook() {
        homePage = new HomePage(DriverManager.getDriver());
        catalogPrice = homePage.getFirstBookPrice();
    }

    @When("I click on the first book to open detail page")
    public void iClickOnFirstBook() {
        homePage.clickFirstBook();
        detailPage = new ProductDetailPage(DriverManager.getDriver());
    }

    @Then("the price on detail page should match the catalog price")
    public void thePriceShouldMatch() {
        String detailPrice = detailPage.getPrice();
        Assert.assertEquals(detailPrice, catalogPrice,
                "Prices do not match! Catalog: " + catalogPrice + " Detail: " + detailPrice);
    }
}