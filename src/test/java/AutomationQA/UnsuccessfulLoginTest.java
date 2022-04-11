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

public class UnsuccessfulLoginTest extends TestUtil {

    @DataProvider(name = "WrongUserList")
    public static Object[][] readUsersFromCsvFile() throws IOException, CsvException{
        return CsvHelper.readCsvFile("src/test/resources/wrongUsers.csv");
    }

    @Test (dataProvider = "WrongUserList")
    public void unsuccesfullLoginTest(String userName, String password) {

        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.login(userName, password);

        WebElement errorMessage = driver.findElement(By.xpath("//*[text()='Epic sadface: Username and password do not match any user in this service']"));
        Assert.assertTrue(errorMessage.isDisplayed());
    }
}
