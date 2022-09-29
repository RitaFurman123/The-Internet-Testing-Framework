package theInternet.tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import theInternet.utilities.Driver;
import theInternet.utilities.WebDriverFactory;
import theInternet.utilities.wait;

import java.util.concurrent.TimeUnit;

public class JSAlert {


    @BeforeMethod
    public void setUp() {

        Driver.getDriver().get("http://localhost:7080/javascript_alerts");

    }

    @Test
    public void p1_information_alert_practice() {

        WebElement jsAlert = Driver.getDriver().findElement(By.xpath("//button[@onclick='jsAlert()']"));
        jsAlert.click();

        wait.wait(2);

        Alert alert = Driver.getDriver().switchTo().alert();

        alert.accept();

        WebElement resultText = Driver.getDriver().findElement(By.xpath("//p[@id='result']"));

        Assert.assertTrue(resultText.isDisplayed(), "Result text is NOT displayed. Varification FAILED!!!");

    }

    @Test
    public void p2_confirmation_alert() {

        WebElement jsConfirm = Driver.getDriver().findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        jsConfirm.click();

        wait.wait(2);

        Alert alert = Driver.getDriver().switchTo().alert();
        alert.dismiss();

        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//p[@id='result']")).isDisplayed(), "Result text is NOT displayed. Varification FAILED!!!");

    }
    @Test

    public void p3_information_alert_practice() {
        WebElement jsPromt = Driver.getDriver().findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        jsPromt.click();

        wait.wait(2);

        Alert alert = Driver.getDriver().switchTo().alert();
        alert.sendKeys("Hi");

        alert.accept();

        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//p[@id='result']")).isDisplayed(), "Result text is NOT displayed. Varification FAILED!!!");
    }

    @AfterMethod

    public void tearDown(){
        Driver.closedDriver();
       System.out.println("End of test execution");
    }

}
