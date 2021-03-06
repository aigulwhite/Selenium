package Iframe;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NestedFrame {
    @Test
    public void NestedFrameValidation(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.manage().window().maximize();

// this is the example of using index to switch frame. It works but not reliable

        driver.switchTo().frame(0); // "top" frame

// this is the example of using webElement to switch frame

        WebElement middleFrame= driver.findElement(By.name("frame-middle"));
        driver.switchTo().frame(middleFrame);   // I am now in the "middle" frame

        WebElement textbox = driver.findElement(By.xpath("//div[@id='content']"));  // getting the text in the box
        String actualName= BrowserUtils.getTextMethod(textbox);
        String expectedName="MIDDLE";
        Assert.assertEquals(actualName,expectedName);

        driver.switchTo().parentFrame();         //top
        driver.switchTo().frame("frame-left");   //left
        WebElement leftbox = driver.findElement(By.xpath("//body[contains(text(),'LEFT')]"));
        String actualtext=leftbox.getText().trim();
        String expectedText="LEFT";
        Assert.assertEquals(actualtext,expectedText);

//        driver.switchTo().parentFrame();//top
//        driver.switchTo().parentFrame();//html
        driver.switchTo().defaultContent();//means it directly goes to the HTML
        driver.switchTo().frame("frame-bottom");
        WebElement bottombox= driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]"));
        String actualtextBottom=BrowserUtils.getTextMethod(bottombox);
        String expectedtextBottom="BOTTOM";
        Assert.assertEquals(actualtextBottom,expectedtextBottom);
    }

}

