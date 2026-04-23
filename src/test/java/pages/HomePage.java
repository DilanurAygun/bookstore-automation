package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import java.util.List;

public class HomePage extends BasePage {

    @FindBy(css = "article.product_pod")
    private List<WebElement> productList;

    @FindBy(css = "article.product_pod h3 a")
    private List<WebElement> productLinks;

    @FindBy(css = "article.product_pod .price_color")
    private List<WebElement> productPrices;

    @FindBy(css = ".side_categories a")
    private List<WebElement> categoryLinks;

    public HomePage(WebDriver driver) {
        super(driver);
        driver.get("https://books.toscrape.com/");
    }

    public String getFirstBookPrice() {
        return productPrices.get(0).getText();
    }

    public void clickFirstBook() {
        productLinks.get(0).click();
    }

    public void clickCategory(String categoryName) {
        for (WebElement link : categoryLinks) {
            if (link.getText().trim().equalsIgnoreCase(categoryName)) {
                link.click();
                break;
            }
        }
    }

    public boolean isLoaded() {
        return !productList.isEmpty();
    }
}