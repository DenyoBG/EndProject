package AutomationQA;

import base.TestUtil;
import com.opencsv.exceptions.CsvException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;
import utils.CsvHelper;

import java.io.IOException;

public class SuccessfulLoginTest extends TestUtil{

    @DataProvider(name = "SuccessfulUsersList")
    public static Object[][] readUsersFromCsvFile() throws IOException, CsvException{
        return CsvHelper.readCsvFile("src/test/resources/successfullUsers.csv");
    }

    @Test(dataProvider = "SuccessfulUsersList")
    public void successfulLoginTest(String userName, String password){

        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.login(userName, password);

        WebElement burgerMenu = driver.findElement(By.xpath("//*[contains(@id, 'react-burger-menu-btn')]"));
        Assert.assertTrue(burgerMenu.isDisplayed());
    }
}
