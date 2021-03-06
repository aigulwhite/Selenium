package SeleniumHW.SeleniumHomeWork3;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task3 {
    /*  Navigate to "https://demos.telerik.com/kendoui/websushi#"
Click picture of the Salmon Teriyaki
Click Add to cart button 2 times
Validate total price is $26
Validate item number is 1
Click > arrow button
Click add to cart for Gohan
Validate total price is $29
Validate total items 2

     */
    @Test
    public void PictureValidation() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://demos.telerik.com/kendo-ui/websushi#");
        driver.manage().window().maximize();

        WebElement salmonTeriyakiPicture= driver.findElement(By.xpath("//strong[.='Salmon Teriyaki']"));
        salmonTeriyakiPicture.click();

        WebElement addToCart= driver.findElement(By.xpath("//button[@data-bind='click: addToCart']"));
        BrowserUtils.ClickWithJS(driver,addToCart);
        BrowserUtils.ClickWithJS(driver,addToCart);
        Thread.sleep(3000);

        WebElement totalPrice= driver.findElement(By.xpath("//p[@class='total-price']"));
        String actualPrice=totalPrice.getText().trim().replace("$","");
        String expectedPrice="26.00";
        Assert.assertEquals(actualPrice,expectedPrice);

        WebElement cart=driver.findElement(By.xpath("//span[@data-bind='text: cart.contentsCount']"));
        String actualItem=cart.getText();
        String expectedItem="1";
        Assert.assertEquals(actualItem,expectedItem);

        WebElement arrowNext=driver.findElement(By.xpath("//a[@id='navigate-next']"));
        arrowNext.click();
        Thread.sleep(3000);

        WebElement addToCart2= driver.findElement(By.xpath("//button[@data-bind='click: addToCart']"));
        BrowserUtils.ClickWithJS(driver,addToCart2);
        Thread.sleep(3000);

        WebElement price1= driver.findElement(By.xpath("//p[@class='total-price']"));
        String actualPrice1=price1.getText().trim().replace("$","");
        String expectedPrice1="29.00";
        Assert.assertEquals(actualPrice1,expectedPrice1);

        WebElement cart1=driver.findElement(By.xpath("//span[@data-bind='text: cart.contentsCount']"));
        String actualItem1=cart.getText();
        String expectedItem1="2";
        Assert.assertEquals(actualItem1,expectedItem1);







    }
}
