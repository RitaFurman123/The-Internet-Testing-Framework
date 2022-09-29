package theInternet.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import theInternet.utilities.Driver;
import theInternet.utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class CheckBox {


    @BeforeMethod
    public void setUp() {

        Driver.getDriver().get("http://localhost:7080/checkboxes");

    }
@Test
    public void checkbox (){

        WebElement checkbox1=Driver.getDriver().findElement(By.xpath("//input[@type='checkbox'][1]"));
        checkbox1.click();
        System.out.println("checkbox1 is selected?: "+checkbox1.isSelected());
        checkbox1.click();
        System.out.println("checkbox1 is not selected?: "+checkbox1.isEnabled());

        WebElement checkbox2=Driver.getDriver().findElement(By.xpath("//input[@type='checkbox'][2]"));
        checkbox2.click();
        checkbox2.click();
        System.out.println("checkbox2 is selected?: "+checkbox2.isSelected());
        checkbox2.click();
        System.out.println("checkbox2 is not selected?: "+checkbox2.isEnabled());

    }

    @AfterMethod
    public void tearDownMethod() throws  InterruptedException{
        Thread.sleep(3000);
        Driver.closedDriver();
    }


}
