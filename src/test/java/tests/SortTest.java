package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pagesObject.InventoryPage;
import pagesObject.StringParm;
import pagesObject.loginPage;

public class SortTest extends BaseTest{
    ChromeDriver driver;

    loginPage loginPage;
    InventoryPage inventoryPage;

    @BeforeMethod
    public void Before() {
        driver = openWebDriver();
        loginPage = new loginPage(driver);
        inventoryPage = new InventoryPage(driver);
    }

    @Test
    public void SortByHighPrice() {
        loginPage.Login(StringParm.VALID_USERNAME, StringParm.VALID_PASS);
        inventoryPage.SortItemByText("Price (high to low)");
        Assert.assertEquals(inventoryPage.Price(),"$49.99");
    }

    @Test
    public void SortByLowPrice() {
        loginPage.Login(StringParm.VALID_USERNAME,StringParm.VALID_PASS);
        inventoryPage.SortItemByText("Price (low to high)");
        Assert.assertEquals(inventoryPage.Price(),"$7.99");
    }

    @Test
    public void SortByZtoAprice() {
        loginPage.Login(StringParm.VALID_USERNAME,StringParm.VALID_PASS);
        inventoryPage.SortItemByText("Name (Z to A)");
        Assert.assertEquals(inventoryPage.Price(),"$15.99");
    }

    @AfterMethod
    public void After() {
        driver.quit();
    }
}
