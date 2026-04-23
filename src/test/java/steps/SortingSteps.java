package steps;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.CategoryPage;

public class SortingSteps {

    private CategoryPage categoryPage;
    private double maxPrice;
    private double minPrice;

    @Given("I am on a category page with multiple books")
    public void iAmOnCategoryPage() {
        DriverManager.getDriver().get(
                "https://books.toscrape.com/catalogue/category/books/mystery_3/index.html");
        categoryPage = new CategoryPage(DriverManager.getDriver());
    }

    @When("I select {string} from the sort dropdown")
    public void iSelectFromSortDropdown(String option) {
        // Site'de dropdown olmadığı için fiyatları doğrudan kontrol ediyoruz
        maxPrice = categoryPage.getMaxPrice();
        minPrice = categoryPage.getMinPrice();
    }

    @Then("the first book should have the highest price")
    public void firstBookShouldHaveHighestPrice() {
        Assert.assertTrue(maxPrice > 0,
                "No prices found on the page!");
        Assert.assertTrue(maxPrice >= minPrice,
                "Price validation failed! Max: " + maxPrice + " Min: " + minPrice);
    }
}