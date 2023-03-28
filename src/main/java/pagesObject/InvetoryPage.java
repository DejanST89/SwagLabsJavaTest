package pagesObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class InvetoryPage extends BasePage {
 @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement backpack;
 @FindBy(id="add-to-cart-sauce-labs-bike-light")
    WebElement bikeLight;
 @FindBy(css = "#shopping_cart_container span")
 WebElement cart;
 @FindBy(id = "checkout")
 WebElement checkout;
 //@FindBy(className = "product_sort_container");


         public InvetoryPage(ChromeDriver driver){
     this.driver=driver;
             PageFactory.initElements(driver,this);
         }
         public String Cart(){
             return cart.getText();
         }
         public void AddBackpack()
         {
     backpack.click();
         }
         public void AddBikeLight()
         {
        bikeLight.click();
         }
         public void ClickOnCart(){
             cart.click();


         }
         public void ClickOnCheckout(){
             checkout.click();
         }

         }
}
