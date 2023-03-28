package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pagesObject.InvetoryPage;
import pagesObject.StringParm;
import pagesObject.loginPage;

public class SortTest extends BaseTest{
    ChromeDriver driver;
    pagesObject.loginPage loginPage;
    InvetoryPage invetoryPage;

    @BeforeMethod
    public void Before(){
        driver=openWebDriver();
        loginPage=new loginPage(driver);
        invetoryPage=new InvetoryPage();

    }
    @Test
    public void SortByHighPrice(){
        loginPage.Login(StringParm.VALID_USERNAME,StringParm.VALID_PASS);
        invetoryPage.SortItemByText("Price(high to low)");
        Assert.assertEquals(invetoryPage.HighPrice,"49.99");
    }
    @AfterMethod
    public void After(){
        driver.quit();
    }

}
