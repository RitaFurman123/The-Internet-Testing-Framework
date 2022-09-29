package theInternet.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import theInternet.utilities.Driver;
import theInternet.utilities.WebDriverFactory;
import theInternet.utilities.wait;

import java.util.concurrent.TimeUnit;

public class FileUpload {



    @BeforeMethod
    public void setUp() {

        Driver.getDriver().get("http://localhost:7080/upload");

    }
    @Test
    public void fileUpload (){



            String path = "file:\\Users\\uguraydemir\\Desktop\\flower.jpeg";

            WebElement uploadInput= Driver.getDriver().findElement(By.id("file-upload"));
            wait.wait(2);
            uploadInput.sendKeys(path);

            WebElement uploadButton= Driver.getDriver().findElement(By.id("file-submit"));
            uploadButton.click();
        }







    @AfterMethod
    public void tearDownMethod() throws  InterruptedException{
        Thread.sleep(3000);
        Driver.closedDriver();
    }
}
