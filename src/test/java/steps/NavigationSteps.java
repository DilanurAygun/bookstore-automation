package steps;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.CategoryPage;
import pages.HomePage;

public class NavigationSteps {

    private HomePage homePage;
    private CategoryPage categoryPage;

    @Given("the homepage is loaded")
    public void theHomepageIsLoaded() {
        homePage = new HomePage(DriverManager.getDriver());
        Assert.assertTrue(homePage.isLoaded(), "Homepage did not load correctly!");
    }

    @When("I click on {string} in the side menu")
    public void iClickOnCategory(String categoryName) {
        homePage.clickCategory(categoryName);
        categoryPage = new CategoryPage(DriverManager.getDriver());
    }

    @Then("the page header should be {string}")
    public void thePageHeaderShouldBe(String expectedHeader) {
        Assert.assertEquals(categoryPage.getPageHeader(), expectedHeader,
                "Page header does not match!");
    }

    @And("the URL should contain {string}")
    public void theUrlShouldContain(String urlPart) {
        String currentUrl = categoryPage.getCurrentUrl();
        Assert.assertTrue(
                currentUrl.contains("travel"),
                "URL does not contain travel! Current URL: " + currentUrl
        );
    }
}