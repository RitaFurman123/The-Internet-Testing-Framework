package theInternet.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import theInternet.utilities.Driver;
import theInternet.utilities.WebDriverFactory;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class NewTab {


    @BeforeMethod
    public void setUp() {

        Driver.getDriver().get("http://localhost:7080/windows");

}

@Test
public void newTab (){

    WebElement clickHere= Driver.getDriver().findElement(By.linkText("Click Here"));
    clickHere.click();

    String titleAfterClick=Driver.getDriver().getTitle();
    System.out.println(titleAfterClick);

    String mainWindowHandle=Driver.getDriver().getWindowHandle();
    System.out.println(mainWindowHandle);

    Set<String> windowHandles=Driver.getDriver().getWindowHandles();

    for (String each : windowHandles) {
        Driver.getDriver().switchTo().window(each);
        System.out.println("current title: "+Driver.getDriver().getTitle());

    }
    Assert.assertTrue(Driver.getDriver().getTitle().equals("New Window"));
    Driver.getDriver().close();

    Driver.getDriver().switchTo().window(mainWindowHandle);
    }
    @AfterMethod

    public void tearDown(){
       Driver.closedDriver();
        System.out.println("End of test execution");
    }

}
