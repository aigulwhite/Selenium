package com.test.audi;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class AudiTestBase {

    public WebDriver driver;
    @BeforeMethod
    public void setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.audiusa.com/us/web/en.html");
        driver.manage().window().maximize();
        Thread.sleep(2000);


        WebElement cookiebutton = driver.findElement(By.xpath("//div[@id=\"onetrust-close-btn-container\"]//button[@aria-label=\"Close\"]"));
        Thread.sleep(2000);
        cookiebutton.click();
    }

    @AfterMethod
    public void tearDown(){
     //   driver.quit();
    }

}
