package Iframe;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IframePractice {
    @Test
    public void iframeTest(){

        WebDriverManager.chromedriver();
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/iframe");
        driver.manage().window().maximize();

        driver.switchTo().frame("mce_0_ifr");  //this implementation MUST be created before we look
        //for the element. it means we need to first open the door to get to the iframe, since the box is inside iframe.

        WebElement box= driver.findElement(By.id("tinymce")); // to get to the box, clear the words and put my
        box.clear();                                        //own words, I would do this if I didn't know about switchTo();
        box.sendKeys("I love selenium");      // but it wouldn't work without the switch

        driver.switchTo().parentFrame(); // this will take out of the iframe since the header is outside the iframe

       WebElement headerText= driver.findElement(By.tagName("h3"));
       String actualHeader= BrowserUtils.getTextMethod(headerText);
       String expectedHeader="An iFrame containing the TinyMCE WYSIWYG Editor";
       Assert.assertEquals(actualHeader, expectedHeader);

    }
}
