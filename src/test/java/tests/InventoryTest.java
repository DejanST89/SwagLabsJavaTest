package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pagesObject.CheckoutStepPage;
import pagesObject.InventoryPage;
import pagesObject.StringParm;
import pagesObject.loginPage;

public class InventoryTest extends BaseTest {
    ChromeDriver driver;
    loginPage loginPage;
    InventoryPage inventoryPage;

    CheckoutStepPage checkoutStepPage;

    @BeforeMethod
    public void Before() {
        driver = openWebDriver();
        loginPage = new loginPage(driver);
        inventoryPage = new InventoryPage(driver);
    }

    @Test
    public void Buy2Products() {
        loginPage.Login(StringParm.VALID_USERNAME, StringParm.VALID_PASS);
        inventoryPage.AddBackpack();
        inventoryPage.AddBikeLight();
        Assert.assertEquals(inventoryPage.Cart(), "2");
    }

    @Test
    public void Buy2ProductsEndProcess() {
        loginPage.Login(StringParm.VALID_USERNAME, StringParm.VALID_PASS);
        inventoryPage.AddBackpack();
        inventoryPage.AddBikeLight();
        inventoryPage.ClickOnCart();
        inventoryPage.ClickCheckout();
        checkoutStepPage.EnterFirstName("dejan");
        checkoutStepPage.EnterLastName("dejan");
        checkoutStepPage.EnterZipCode("11000");
        checkoutStepPage.ClickContinue();
        checkoutStepPage.ClickFinish();
        Assert.assertEquals(checkoutStepPage.OrderCompleted(),"Thank you for your order!");

    }
    @Test
    public void RemoveProduct() {
        loginPage.Login(StringParm.VALID_USERNAME, StringParm.VALID_PASS);
        inventoryPage.AddBackpack();
        inventoryPage.ClickOnCart();
        inventoryPage.RemoveBackpack();
        inventoryPage.ClickContinueShopping();
        Assert.assertEquals(inventoryPage.backpack.isDisplayed(), true);
        Assert.assertEquals(inventoryPage.backpack.isEnabled(), true);
    }

    @AfterMethod
    public void After(){
        driver.quit();
    }


}
