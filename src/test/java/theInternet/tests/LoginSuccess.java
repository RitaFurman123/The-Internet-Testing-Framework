package theInternet.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import theInternet.pages.LoginPage;
import theInternet.utilities.ConfigurationReader;
import theInternet.utilities.Driver;
import theInternet.utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class LoginSuccess  {



    @BeforeMethod
    public void setUp() {

        Driver.getDriver().get("http://localhost:7080/login");

    }




    @Test
     public void openPage()  {
         String url = ConfigurationReader.getProperty("loginPageURL");
        Driver.getDriver().get(url);
         LoginPage loginPage = new LoginPage();

         loginPage.usernameInput.sendKeys(ConfigurationReader.getProperty("username"));
         loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
         loginPage.loginButton.click();


        Assert.assertTrue(loginPage.loggedIn.isDisplayed());
        System.out.println("You are successfully logged in ");




     }

    @AfterMethod
    public void tearDownMethod() throws  InterruptedException{
        Thread.sleep(3000);
        Driver.closedDriver();
    }



}
