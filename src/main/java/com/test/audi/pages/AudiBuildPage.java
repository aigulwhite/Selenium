package com.test.audi.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AudiBuildPage {
    public AudiBuildPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//div[@class='audi-copy-m nm-module-trimline-engine-headline-sub']")
    List<WebElement> StartingPriceForThree;

    public void validatingStartingPrices(){
        for(int i=0; i<StartingPriceForThree.size(); i++){

            System.out.println(StartingPriceForThree.get(i).getText());
        }

    }
}
