package com.test.orangehrm.tests;

import Utils.ConfigReader;
import com.test.orangehrm.TestBase;
import com.test.orangehrm.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest extends TestBase {

                                        //   WebDriver driver;   ==== 15-24 is removed from here to TestBase ====

//    @BeforeMethod
//    public void setup(){ //we need it to avoid repeating parts(commented out below)
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
//        driver.manage().window().maximize();
//        System.out.println("i am running before every test annotation");
//    }

    @Test
    public void validateLoginPositive() {
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
//        driver.manage().window().maximize();

        LoginPage loginPage = new LoginPage(driver); //CREATING NEW OBJECT TO CALL METHODS from LoginPage
        loginPage.login(ConfigReader.readProperty("orangehrmusername"), ConfigReader.readProperty("orangehrmpassword"));
//        String actualURL= driver.getCurrentUrl();
//        String expectedUL="https://opensource-demo.orangehrmlive.com/index.php/dashboard";
        Assert.assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/index.php/dashboard");
        //USE THIS instead of 35-36
    }
    @Test
    public void validateLoginNegative1(){      // negative testing(valid username,wrong password)
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
//        driver.manage().window().maximize();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin","ahmet");
        String actualErrorMessage=loginPage.getErrorMessage();
        String expectedErrorMessage="Invalid credentials";
        Assert.assertEquals(actualErrorMessage,expectedErrorMessage);
    }
    @Test
    public void validateLoginNegative2(){   // negative testing(empty username)
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
//        driver.manage().window().maximize();


        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("","");
        String actualErrorMessage=loginPage.getErrorMessage();
        String expectedErrorMessage="Username cannot be empty here";
        Assert.assertEquals(actualErrorMessage,expectedErrorMessage);
        String actualColorOfErrorMessage=loginPage.getColorOfTheErrorMessage();
        String expectedColorOfErrorMessage="rgba(221, 119, 0, 1)";
        Assert.assertEquals(actualColorOfErrorMessage,expectedColorOfErrorMessage);
    }
//    @AfterMethod             == moved to TestBase  because we need it for every test
//    public void tearDown(){
//        driver.quit();
//        System.out.println("i am running after each test annotation");
//    }
}

