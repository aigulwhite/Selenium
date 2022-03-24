package com.test.etsy.tests;

import Utils.DriverHelper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

public class EtsyTestBase {

    public WebDriver driver; //This info is coming from Utils--> DriverHelper

    public EtsyTestBase()  {             // Ahmet didn't have this
    }

    @BeforeMethod
    public void setup(){
        driver.get("https://www.etsy.com/");

    }

    @AfterMethod
    public void tearDown(){

    DriverHelper.tearDown();    }


}

