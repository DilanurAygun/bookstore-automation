package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import java.util.List;

public class CategoryPage extends BasePage {

    @FindBy(css = "div.page-header.action h1")
    private WebElement pageHeader;

    @FindBy(css = "article.product_pod .price_color")
    private List<WebElement> productPrices;

    public CategoryPage(WebDriver driver) {
        super(driver);
    }

    public String getPageHeader() {
        return pageHeader.getText().trim();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public double getMaxPrice() {
        return productPrices.stream()
                .mapToDouble(e -> Double.parseDouble(
                        e.getText().replace("£", "").trim()))
                .max()
                .orElse(0);
    }

    public double getMinPrice() {
        return productPrices.stream()
                .mapToDouble(e -> Double.parseDouble(
                        e.getText().replace("£", "").trim()))
                .min()
                .orElse(0);
    }

    public int getProductCount() {
        return productPrices.size();
    }
}