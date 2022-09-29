package theInternet.tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import theInternet.utilities.Driver;
import theInternet.utilities.WebDriverFactory;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DropDown  {


    @BeforeMethod
    public void setUpMethod(){




        Driver.getDriver().get("http://localhost:7080/dropdown");
    }

    @Test
    public void dropdownTest(){

        Select simpleDropDown=new Select(Driver.getDriver().findElement(By.id("dropdown")));

        String actualSelectedOption= simpleDropDown.getFirstSelectedOption().getText();
        String expectedValue="Please select an option";

        Assert.assertEquals(actualSelectedOption,expectedValue);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        simpleDropDown.selectByVisibleText("Option 2");

    }

    @AfterMethod
    public void tearDownMethod() throws  InterruptedException{
        Thread.sleep(3000);
        Driver.closedDriver();
    }
}
