package pagesObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutStepPage extends BasePage{
        @FindBy(id = "first-name")
        WebElement Firstname;

        @FindBy(id = "last-name")
        WebElement lastName;

        @FindBy(id = "postal-code")
            WebElement zipCode;
        @FindBy(id = "continue")
        WebElement ContinueButton

                @FindBy(id = "finish")
                WebElement FinishButton;

            public void CheckoutStepPage(ChromeDriver driver){
                this.driver=driver;
                PageFactory.initElements(driver,this);
            }
            public void EnterFirstName(String name){
                Firstname.sendKeys(name);
            }
            public void EnterLastName(String last){
                lastName.sendKeys();
            }
            public void EnterZipCode(String zip){
                zipCode.sendKeys(zip);
            }
                public void ClickContinue(){
                ContinueButton.click();
                }
                public void ClickFinish(){
                FinishButton.click();

                }
}
