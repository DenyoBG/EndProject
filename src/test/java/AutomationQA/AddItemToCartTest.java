package AutomationQA;

import pages.LoginPage;
import pages.ProductsPage;
import base.TestUtil;
import com.opencsv.exceptions.CsvException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.CsvHelper;

import java.io.IOException;

public class AddItemToCartTest extends TestUtil {

    @DataProvider(name = "SuccessfullUsersList")
    public static Object[][] readUsersFromCsvFile() throws IOException, CsvException {
        return CsvHelper.readCsvFile("src/test/resources/successfullUsers.csv");
    }

    @Test(dataProvider = "SuccessfullUsersList")
    public void addItemsToCart(String userName, String password){
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.login(userName, password);
        productsPage.addItemToTheCart("bike-light");
        productsPage.addItemToTheCart("backpack");

        Assert.assertEquals(productsPage.itemsInTheCart(),2);
    }
}
