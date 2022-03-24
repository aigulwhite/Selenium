package com.test.audi.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AudiMainPage {

    public  AudiMainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//li[@class=\"nm-model-band-stripe-item nm-model-band-stripe-types-item0\"]//span[contains(text(),'SUVs & Wagons')]")
    WebElement suvWagons;

    @FindBy(xpath = "//*[@id=\"nm-id-content\"]/div/div[2]/audi-model-band/div[3]/ul[2]/li[1]/div/ul/li[4]/div/a/span")

    WebElement Q5;

    public void clickSuvWagon(){
        suvWagons.click();
    }
    public void clickQ5() throws InterruptedException {
        suvWagons.click();
        Thread.sleep(5000);
        Q5.click();
    }
    public String getTextQ5() throws InterruptedException {
        suvWagons.click();
        Thread.sleep(5000);
        String actualName= Q5.getText().trim();
        return actualName;

    }

}
