package com.test.orangehrm;

import Utils.BrowserUtils;
import Utils.ConfigReader;
import Utils.DriverHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

public class TestBase {           // THIS CLASS WILL BE USED FOR ALL CODES TO AVOID REPEATING

    public WebDriver driver;
    @BeforeMethod
    public void setup() {
        driver=DriverHelper.getDriver();
        driver.get(ConfigReader.readProperty("urlorangehrm"));  // this is coming from "configuration.properties"
                                                                    // under the "test-output" package

    }

    @AfterMethod                                     // MAIN METHOD FOR SCREENSHOT AND CAN'T BE CHANGED EXCEPT THE NAME,30
    public void tearDown(ITestResult result){
        if(!result.isSuccess()){
            BrowserUtils.getScreenshot(driver,"OrangeHrmScreenShot");
        }
        DriverHelper.tearDown();
    }

}
