package theInternet.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import theInternet.utilities.Driver;
import theInternet.utilities.WebDriverFactory;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DynamicControls {



    @BeforeMethod
    public void setUp() {

        Driver.getDriver().get("http://localhost:7080/dynamic_controls");

    }

    @Test
    public void dynamic_controls() throws InterruptedException {


        By removeButton = By.xpath("//button[@onclick='swapCheckbox()']");
        By checkBox = By.id("checkbox");
        By inputBox = By.xpath("//input[@type='text']");
                By enableButton = By.xpath("//button[@onclick='swapInput()']");

        boolean displayed = Driver.getDriver().findElement(checkBox).isDisplayed();
        System.out.println("The checkbox displayed? "+ displayed );
        Driver.getDriver().findElement(removeButton).click();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(checkBox));


        try{
            Driver.getDriver().findElement(checkBox);

        }catch (Exception e){
            System.out.println("Checkbox is removed");
        }

        System.out.println("the Input form enabled: "+Driver.getDriver().findElement(inputBox).isEnabled());
        Driver.getDriver().findElement(enableButton).click();
        wait.until(ExpectedConditions.textToBe(enableButton," Disable"));
        System.out.println("Input form enabled: "+Driver.getDriver().findElement(inputBox).isEnabled());



    }
    @AfterMethod
    public void tearDownMethod() throws  InterruptedException{
        Thread.sleep(3000);
        Driver.closedDriver();
    }

}
