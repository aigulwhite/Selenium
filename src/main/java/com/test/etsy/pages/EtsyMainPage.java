package com.test.etsy.pages;

import com.test.etsy.tests.EtsyTestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Locale;

public class EtsyMainPage {

    public EtsyMainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//input[@id='global-enhancements-search-query']")
    WebElement searchBox;

    @FindBy(xpath = "//li//h3")
    List<WebElement> allHeaders;

    public void searchItem(String searchItem){
        searchBox.sendKeys(searchItem, Keys.ENTER); // Keys.ENTER clicks on the search sign after entering the iphone case
        //.. without ENTER we will have to find the element for the search sign and click on it.Takes longer time

    }
    public boolean validateHeader(){
        for (WebElement header : allHeaders){

            String headr=header.getText().trim().toLowerCase();
            if(!(headr.contains("iphone")||headr.contains("13")|| headr.contains("case"))){

                return false;
            }


//            if(header.getText().trim().toLowerCase().contains("iphone")
//                    ||header.getText().trim().toLowerCase().contains("13")  // line 34-36 can become line 31-32
//                    ||header.getText().trim().toLowerCase().contains("case"));
        }
            return true;
    }
}
