package AutomationQA;

import base.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class ProblemUserTest extends TestUtil {

    @Test
    public void checkOutItemsFromCart(){
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.login("problem_user", "secret_sauce");
        productsPage.addItemToTheCart("bike-light");
        productsPage.addItemToTheCart("backpack");

        GoToCartPage goToCartPage = new GoToCartPage(driver);
        goToCartPage.open();

        GoToCheckoutPage goToCheckoutPage = new GoToCheckoutPage(driver);
        goToCheckoutPage.open();

        GoToOverviewPage goToOverviewPage = new GoToOverviewPage(driver);
        goToOverviewPage.open("Joe", "Biden", String.valueOf(2020));

        GoToCompletePage goToCompletePage = new GoToCompletePage(driver);
        goToCompletePage.open();

        WebElement thankYouMessage = driver.findElement(By.xpath("//*[contains(@class,'complete-header')]"));
        Assert.assertTrue(thankYouMessage.isDisplayed());
    }
}
