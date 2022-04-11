package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class ProductsPage {
    protected WebDriver driver;
    private static final String ADD_TO_CART_LOCATOR = "//*[contains(@id,'add-to-cart-sauce-labs-%s')]";

    @FindBy (xpath = "//*[contains(@class, 'shopping_cart_link')]")
    private WebElement shoppingCart;

    @FindBy (xpath = "//*[contains(@class, 'shopping_cart_badge')]")
    private WebElement shoppingCartCounter;

    public ProductsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addItemToTheCart(String productName){
        String xpathOfElementToBeAdded = String.format(ADD_TO_CART_LOCATOR, productName);
        FluentWait fluentWait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(3));
        WebElement addToCartButton = driver.findElement(By.xpath(xpathOfElementToBeAdded));
        fluentWait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addToCartButton.click();
    }

    public int itemsInTheCart(){
        return Integer.parseInt(shoppingCartCounter.getText());
    }

}
