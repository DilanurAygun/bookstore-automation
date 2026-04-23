package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;

public class BasketPage extends BasePage {

    @FindBy(css = "div.basket-items")
    private WebElement basketItems;

    @FindBy(css = "span.badge")
    private WebElement basketCount;

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    public int getBasketCount() {
        String countText = basketCount.getText().trim();
        return Integer.parseInt(countText);
    }

    public boolean hasItems() {
        return basketItems.isDisplayed();
    }
}