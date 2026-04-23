package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage extends BasePage {

    @FindBy(css = "p.price_color")
    private WebElement price;

    @FindBy(css = "p.availability")
    private WebElement availability;

    @FindBy(xpath = "//button[contains(text(),'Add to basket')]")
    private WebElement addToBasketButton;

    @FindBy(css = "div.alert-success strong")
    private WebElement basketSuccessMessage;

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public String getPrice() {
        return price.getText();
    }

    public String getAvailabilityText() {
        return availability.getText().trim();
    }

    public void clickAddToBasket() {
        addToBasketButton.click();
    }

    public boolean isInStock() {
        return getAvailabilityText().contains("In stock");
    }
}