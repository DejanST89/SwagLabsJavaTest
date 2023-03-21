package pagesObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage extends BasePage {

    @FindBy(id = "user-name")
    WebElement username;
    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "login-button")
    WebElement loginButton;
    @FindBy(css=".error-message-container h3")
    WebElement erorMesage;


    public loginPage(ChromeDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }
    public String getTextMassage(){
        return erorMesage.getText();
    }
    public void Login(String user,String pass){
        username.sendKeys(user);
        password.sendKeys(pass);
        loginButton.click();
    }

}
