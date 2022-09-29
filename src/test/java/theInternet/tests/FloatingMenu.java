package theInternet.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class FloatingMenu {


    @BeforeMethod
    public void setUp() {

        Driver.getDriver().get("http://localhost:7080/floating_menu");

    }

    @Test
    public void floating_menu() {

        WebElement home = Driver.getDriver().findElement(By.xpath("//a[@href='#home']"));
        WebElement news = Driver.getDriver().findElement(By.xpath("//a[.='News']"));
        WebElement contact = Driver.getDriver().findElement(By.xpath("//a[.='Contact']"));
        WebElement about = Driver.getDriver().findElement(By.xpath("//a[.='About']"));

        WebElement endOfPage = Driver.getDriver().findElement(By.xpath("//a[.='Elemental Selenium']"));

        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();

       // wait.wait(2);


        jse.executeScript("arguments[0].scrollIntoView();", endOfPage);

        Assert.assertTrue(home.isDisplayed());
        System.out.println("Home button is displayed!");

        Assert.assertTrue(news.isDisplayed());
        System.out.println("News button is displayed!");

        Assert.assertTrue(contact.isDisplayed());
        System.out.println("Contact button is displayed!");

        Assert.assertTrue(about.isDisplayed());
        System.out.println("About button is displayed!");

    }


    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(3000);
        Driver.closedDriver();
    }
}
