package theInternet.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import theInternet.utilities.Driver;
import theInternet.utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class iFrame  {



    @BeforeMethod
    public void setUp() {

        Driver.getDriver().get("http://localhost:7080/iframe");

    }
    @Test
    public void p4_iframe_Practice(){

        WebElement iframe = Driver.getDriver().findElement(By.id("mce_0_ifr"));
        Driver.getDriver().switchTo().frame(iframe);

        WebElement yourContentGoesHereText = Driver.getDriver().findElement(By.xpath("//p"));

        Assert.assertTrue(yourContentGoesHereText.isDisplayed(),"Text is not displayed. Verificationn FAILED!!!");

        WebElement headerText=Driver.getDriver().findElement(By.xpath("//h3"));



        // Assert.assertTrue(headerText.isDisplayed(), "Header text is not displayed. Verification FAILED!!!");
    }
    @AfterMethod
    public void tearDownMethod() throws  InterruptedException{
        Thread.sleep(3000);
        Driver.closedDriver();
    }
}

