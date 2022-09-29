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

import java.util.concurrent.TimeUnit;

public class DragAndDrop  {



    @BeforeMethod
    public void setUp() {

        Driver.getDriver().get("http://localhost:7080/drag_and_drop");

    }

    @Test
    public void drag_and_drop() throws InterruptedException {


        WebElement cubeA=Driver.getDriver().findElement(By.id("column-a"));
        WebElement cubeB =Driver.getDriver().findElement(By.id("column-b"));



        Actions actions = new Actions(Driver.getDriver());
        actions.dragAndDrop(cubeA,cubeB).build().perform();

        Thread.sleep(2000);



        Assert.assertEquals(cubeA,By.xpath("//header[.='B']"));
       Assert.assertEquals(cubeB,"A");





    }

    @AfterMethod
    public void tearDownMethod() throws  InterruptedException{
        Thread.sleep(3000);
        Driver.closedDriver();
    }


}
