package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    protected WebDriver driver;

    @FindBy(xpath = "//*[contains(@id,'user-name')]")
    private WebElement userNameInput;

    @FindBy(xpath = "//*[contains(@id,'password')]")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[contains(@id,'login-button')]")
    private WebElement loginBtn;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ProductsPage login(String username, String password){
        userNameInput.click();
        userNameInput.sendKeys(username);

        passwordInput.click();
        passwordInput.sendKeys(password);

        loginBtn.click();

        return new ProductsPage(driver);
    }
}
