package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoToCartPage {
    protected WebDriver driver;

    @FindBy(xpath = "//*[contains(@class, 'shopping_cart_link')]")
    private WebElement openCartBtn;


    public GoToCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public GoToCheckoutPage open(){
        openCartBtn.click();
        return new GoToCheckoutPage(driver);
    }

}
