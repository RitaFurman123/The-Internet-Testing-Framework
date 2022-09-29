package theInternet.pages;

import org.openqa.selenium.support.PageFactory;
import theInternet.utilities.Driver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }



    @FindBy(id="username")
    public WebElement usernameInput;

    @FindBy(id="password")
    public WebElement passwordInput;

    @FindBy(className="radius")
    public WebElement loginButton;



    @FindBy(xpath="//h4[.='Welcome to the Secure Area. When you are done click logout below.']")
    public WebElement loggedIn;

    @FindBy(id="flash")
    public WebElement logOUT;

    @FindBy(xpath="//div[@class='flash error']")
    public WebElement InvalidUsername;



    public  void login(String username, String password){
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }




}
