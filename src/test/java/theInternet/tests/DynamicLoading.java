package theInternet.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import theInternet.utilities.Driver;
import theInternet.utilities.WebDriverFactory;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DynamicLoading {



    @BeforeMethod
    public void setUp() {

        Driver.getDriver().get("http://localhost:7080/dynamic_loading/2");

    }

    @Test
    public void dynamic_loading(){


        WebElement startButton = Driver.getDriver().findElement(By.xpath("//button[.='Start']"));
        startButton.click();

        WebElement helloWorld = Driver.getDriver().findElement(By.xpath("//h4[.='Hello World!']"));

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOf(helloWorld));

        Assert.assertTrue(helloWorld.isDisplayed());



    }

    @AfterMethod
    public void tearDownMethod() throws  InterruptedException{
        Thread.sleep(3000);
       Driver.closedDriver();
    }

}
