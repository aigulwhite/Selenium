package com.test.sentrifugo.tests;

import com.test.sentrifugo.pages.LoginPageSntr;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTestSntr {

    //    @Test                                  ==== OLD WAY ======
//    public void ValidateSupperAdmin(){
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        driver.navigate().to("http://demo.sentrifugo.com/index.php/");
//
//       WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
//        username.sendKeys("EM01");
//
//        WebElement pass= driver.findElement(By.xpath("//input[@id='password']"));
//        pass.sendKeys("sentrifugo");
//
//        WebElement loginButton = driver.findElement(By.id("loginsubmit"));
//        loginButton.submit();
//    String actualURL = driver.getCurrentUrl();
//    String expectedURL = "http://demo.sentrifugo.com/index.php/";
//        Assert.assertEquals(actualURL,expectedURL);
//    }


                                           // =====   NEW WAY=========
    @Test
    public void ValidateSuperAdmin() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://demo.sentrifugo.com/index.php/");
        driver.manage().window().maximize();

        //// to CALL METHODS from other classes, we create an object
        LoginPageSntr loginPage = new LoginPageSntr(driver);
        loginPage.DynamicLogin("EM05", "sentrifugo");
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "http://demo.sentrifugo.com/index.php/index/welcome";
        Assert.assertEquals(actualURL, expectedURL);

    }

    @Test
    public void ValidateManagement(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://demo.sentrifugo.com/index.php/");
        driver.manage().window().maximize();

        LoginPageSntr loginPage = new LoginPageSntr(driver);
        loginPage.DynamicLogin("EM02", "sentrifugo");
        String actualTitle = driver.getTitle();
        String expectedTitle= "Sentrifugo- Open Source HRMS";
        Assert.assertEquals(actualTitle, expectedTitle);

    }


}
