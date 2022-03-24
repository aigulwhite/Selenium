package Waits;

import Utils.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class FluentlyWait {

    @Test
    public void validateWait() {
        WebDriver driver = DriverHelper.getDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        WebElement removeButton= driver.findElement(By.xpath("//button[.='Remove']"));
        removeButton.click();

        Wait<WebDriver>fluentWait=new FluentWait<>(driver)  //polymorphism
                .pollingEvery(Duration.ofSeconds(1))
                .withMessage("Text on the page")
                .withTimeout(Duration.ofSeconds(1))
                .ignoring(Exception.class);

        WebElement message= fluentWait.until(myDriver->driver.findElement(By.xpath("//p[@id='message']")));
        Assert.assertEquals(message.getText().trim(),"It's gone!");
    }
}
