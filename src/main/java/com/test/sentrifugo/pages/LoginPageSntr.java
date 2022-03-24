package com.test.sentrifugo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageSntr {

    public LoginPageSntr(WebDriver driver){
        PageFactory.initElements(driver, this);

    }  //to be able to initialize the elements which are below, we need this specific method.
       // instead of driver.find element(By).... we use line 10-11 for all

    // WE ARE GOING TO STORE OUR ELEMENT LOCATIONS AND METHODS HERE ======

    @FindBy(xpath = "//input[@id='username']")
    WebElement username;

    @FindBy(xpath = "//input[@id='password']")
    WebElement password;

    @FindBy(id = "loginsubmit")
    WebElement loginButton;

//    public  void login(){                     // === REGULAR WAY ====
//        username.sendKeys("EM01");
//        password.sendKeys("sentrifugo");
//        loginButton.click();
//    }


                       //=== DYNAMIC WAY ==== so we will not have to change info each time.

    public void DynamicLogin(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        this.loginButton.submit();
    }



}
