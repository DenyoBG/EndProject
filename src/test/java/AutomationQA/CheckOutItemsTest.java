package AutomationQA;

import base.TestUtil;
import com.opencsv.exceptions.CsvException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;
import utils.CsvHelper;

import java.io.IOException;

public class CheckOutItemsTest extends TestUtil {

    @DataProvider(name = "SuccessfullUsersList")
    public static Object[][] readUsersFromCsvFile() throws IOException, CsvException {
        return CsvHelper.readCsvFile("src/test/resources/successfullUsers.csv");
    }

    @Test(dataProvider = "SuccessfullUsersList")
    public void checkOutItemsFromCart(String userName, String password){
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.login(userName, password);
        productsPage.addItemToTheCart("bolt-t-shirt");
        productsPage.addItemToTheCart("fleece-jacket");

        GoToCartPage goToCartPage = new GoToCartPage(driver);
        goToCartPage.open();

        GoToCheckoutPage goToCheckoutPage = new GoToCheckoutPage(driver);
        goToCheckoutPage.open();

        GoToOverviewPage goToOverviewPage = new GoToOverviewPage(driver);
        goToOverviewPage.open("Donal", "Trump", String.valueOf(2020));

        GoToCompletePage goToCompletePage = new GoToCompletePage(driver);
        goToCompletePage.open();

        WebElement thankYouMessage = driver.findElement(By.xpath("//*[contains(@class,'complete-header')]"));
        Assert.assertTrue(thankYouMessage.isDisplayed());
    }
}
