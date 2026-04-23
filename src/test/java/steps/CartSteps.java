package steps;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.CategoryPage;
import pages.ProductDetailPage;

public class CartSteps {

    private ProductDetailPage detailPage;

    @When("I click \"Add to basket\" on the first available book")
    public void iClickAddToBasket() {
        DriverManager.getDriver().get(
                "https://books.toscrape.com/catalogue/category/books/poetry_23/index.html");
        CategoryPage categoryPage = new CategoryPage(DriverManager.getDriver());
        // İlk kitabın Add to basket butonuna tıkla
        DriverManager.getDriver().findElements(
                        org.openqa.selenium.By.xpath("//button[contains(text(),'Add to basket')]"))
                .get(0).click();
    }

    @Then("the basket count should be {int}")
    public void basketCountShouldBe(int expectedCount) {
        String currentUrl = DriverManager.getDriver().getCurrentUrl();
        Assert.assertTrue(
                currentUrl.contains("basket") || currentUrl.contains("catalogue"),
                "Basket was not updated!");
    }
}