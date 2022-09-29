package theInternet.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import theInternet.utilities.Driver;
import theInternet.utilities.WebDriverFactory;
import theInternet.utilities.wait;

import java.util.concurrent.TimeUnit;

public class Hovers {


    @BeforeMethod
    public void setUp() {

        Driver.getDriver().get("http://localhost:7080/hovers");

    }

    @Test
    public void hover_over_test(){


        WebElement img1 = Driver.getDriver().findElement(By.xpath("(//div[@class='figure'])[1]"));
        WebElement img2 = Driver.getDriver().findElement(By.xpath("(//div[@class='figure'])[2]"));
        WebElement img3 = Driver.getDriver().findElement(By.xpath("(//div[@class='figure'])[3]"));

        WebElement user1 = Driver.getDriver().findElement(By.xpath("//h5[.='name: user1']"));
        WebElement user2 = Driver.getDriver().findElement(By.xpath("//h5[.='name: user2']"));
        WebElement user3 = Driver.getDriver().findElement(By.xpath("//h5[.='name: user3']"));


        Actions actions = new Actions(Driver.getDriver());


        wait.wait(2);
        actions.moveToElement(img1).perform();
        Assert.assertTrue(user1.isDisplayed(), "Image 1 is NOT displayed! Verification failed!!!");



        actions.moveToElement(img2).perform();
        Assert.assertTrue(user2.isDisplayed(),"Image 2 is NOT displayed! Verification failed!!!");

        wait.wait(2);
        actions.moveToElement(img3).perform();
        Assert.assertTrue(user3.isDisplayed(), "Image 3 is NOT displayed! Verification failed!!!");



    }


    @AfterMethod
    public void tearDownMethod() throws  InterruptedException{
        Thread.sleep(3000);
        Driver.closedDriver();
    }


}
