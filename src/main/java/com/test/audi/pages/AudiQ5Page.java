package com.test.audi.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AudiQ5Page {
    public  AudiQ5Page(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
 @FindBy(xpath = "//a[contains(text(),'Starting at $43,300.')]")
    WebElement price;

    @FindBy(xpath = "//*[@id=\"audi:stage-large-feature-app:2453c579\"]/div/div/div/div/div[3]/div/div/div[2]/a[1]/span")
    WebElement buildbutton;

    public void getPriceText(){
        price.getText().trim();
        System.out.println(price.getText().trim().substring(12,20));
    }
    public void clickBuildButton(){
        buildbutton.click();
    }

}
