package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoToCheckoutPage {
    protected WebDriver driver;

    @FindBy(xpath = "//*[contains(@class,'btn btn_action btn_medium checkout_button')]")
    private WebElement checkoutBtn;

    public GoToCheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public GoToOverviewPage open() {
        checkoutBtn.click();
        return new GoToOverviewPage(driver);
    }
}
