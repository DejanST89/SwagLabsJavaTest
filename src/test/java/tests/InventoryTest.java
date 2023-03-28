package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pagesObject.CheckoutStepPage;
import pagesObject.InvetoryPage;
import pagesObject.StringParm;
import pagesObject.loginPage;

public class InventoryTest extends BaseTest {
    ChromeDriver driver;
    loginPage loginPage;
    InvetoryPage invetoryPage;

    CheckoutStepPage checkoutStepPage;

    @BeforeMethod
    public void Before() {
        driver = openWebDriver();
        loginPage = new loginPage(driver);
        invetoryPage = new InvetoryPage(driver);
    }

    @Test
    public void Buy2Products() {
        loginPage.Login(StringParm.VALID_USERNAME, StringParm.VALID_PASS);
        invetoryPage.AddBackpack();
        invetoryPage.AddBikeLight();
        Assert.assertEquals(invetoryPage.Cart(), "2");
    }

    @Test
    public void Buy2ProductsEndProcess() {
        loginPage.Login(StringParm.VALID_USERNAME, StringParm.VALID_PASS);
        invetoryPage.AddBackpack();
        invetoryPage.AddBikeLight();
        invetoryPage.ClickOnCart();
        invetoryPage.ClickOnCheckout();
        checkoutStepPage.EnterFirstName("dejan");
        checkoutStepPage.EnterLastName("dejan");
        checkoutStepPage.EnterZipCode("11000");
        checkoutStepPage.ClickContinue();
        checkoutStepPage.ClickFinish();

    }

    @AfterMethod
    public void After() {
        driver.quit();
    }


}
