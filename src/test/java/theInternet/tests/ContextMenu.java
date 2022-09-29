package theInternet.tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import theInternet.utilities.Driver;
import org.openqa.selenium.By;
import theInternet.utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class ContextMenu  {


    @BeforeMethod
    public void setUp() {

        Driver.getDriver().get("http://localhost:7080/context_menu");

    }

    @Test

    public void context_click(){


        WebElement box = Driver.getDriver().findElement(By.id("hot-spot"));
        Actions actions = new Actions(Driver.getDriver());
        actions.contextClick(box).perform();

        Alert alert = Driver.getDriver().switchTo().alert();
        //System.out.println("Alert menu is displayed?: "+alert.getText());
        // Assert.assertTrue(alert.getText().equals("You selected a context menu"));
        Assert.assertEquals("You selected a context menu",alert.getText());
        alert.accept();


    }

    @AfterMethod
    public void tearDownMethod() throws  InterruptedException{
        Thread.sleep(3000);
        Driver.closedDriver();
    }



}
