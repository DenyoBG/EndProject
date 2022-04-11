package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoToOverviewPage {
    protected WebDriver driver;

    @FindBy(xpath = "//*[contains(@id,'first-name')]")
    private WebElement firstNameInput;

    @FindBy(xpath = "//*[contains(@id,'last-name')]")
    private WebElement lastNameInput;

    @FindBy(xpath = "//*[contains(@id,'postal-code')]")
    private WebElement zipCodeInput;

    @FindBy(xpath = "//*[contains(@class,'submit-button btn btn_primary cart_button btn_action')]")
    private WebElement continuehBtn;

    public GoToOverviewPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public GoToCompletePage open(String username, String password, String zipcode){
        firstNameInput.click();
        firstNameInput.sendKeys(username);

        lastNameInput.click();
        lastNameInput.sendKeys(password);

        zipCodeInput.click();
        zipCodeInput.sendKeys(zipcode);

        continuehBtn.click();

        return new GoToCompletePage(driver);
    }
}



