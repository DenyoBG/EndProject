package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoToCompletePage {
    protected WebDriver driver;

    @FindBy(xpath = "//*[contains(@class,'btn btn_action btn_medium cart_button')]")
    private WebElement finishBtn;

    public GoToCompletePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public GoToOverviewPage open() {
        finishBtn.click();
        return new GoToOverviewPage(driver);
    }
}
