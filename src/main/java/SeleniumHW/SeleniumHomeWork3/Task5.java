package SeleniumHW.SeleniumHomeWork3;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Task5 {
    /*  Navigate to "https://demos.telerik.com/kendoui/websushi#"
        Add 3 items to your cart
        Click X button on the top added items
        Validate items number is 2
 */
    @Test
    public void ValidateThreeItems() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://demos.telerik.com/kendo-ui/websushi#");
        driver.manage().window().maximize();

        WebElement addToCart= driver.findElement(By.xpath("//li[1]/button"));
        addToCart.click();
        Thread.sleep(2000);

        WebElement addToCart1= driver.findElement(By.xpath("//li[7]/button"));
        addToCart1.click();
//        Thread.sleep(2000);

        WebElement addToCart2= driver.findElement(By.xpath("//li[9]/button"));
        addToCart2.click();
//        Thread.sleep(2000);
        WebElement removeItem= driver.findElement(By.xpath("//a[@data-bind='click: removeFromCart']"));
        removeItem.click();

        WebElement cart1=driver.findElement(By.xpath("//span[@data-bind='text: cart.contentsCount']"));
        String actualItem1=cart1.getText();
        String expectedItem1="2";
        Assert.assertEquals(actualItem1,expectedItem1);




    }
}
