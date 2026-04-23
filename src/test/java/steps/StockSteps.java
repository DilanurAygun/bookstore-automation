package steps;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.ProductDetailPage;

public class StockSteps {

    private ProductDetailPage detailPage;

    @Given("I am on a product detail page")
    public void iAmOnProductDetailPage() {
        DriverManager.getDriver().get(
                "https://books.toscrape.com/catalogue/a-light-in-the-attic_1000/index.html");
        detailPage = new ProductDetailPage(DriverManager.getDriver());
    }

    @Then("the availability section should display {string}")
    public void availabilityShouldDisplay(String expectedText) {
        Assert.assertTrue(detailPage.isInStock(),
                "Stock status is not displayed correctly! Found: "
                        + detailPage.getAvailabilityText());
    }
}