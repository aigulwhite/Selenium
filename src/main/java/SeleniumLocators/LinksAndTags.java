package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinksAndTags {
    public static void main(String[] args) {

        WebDriver driver= new ChromeDriver();
        driver.get("file:///C:/Users/alena/Downloads/Techtorial%20(2).html");
        driver.manage().window().maximize();

        WebElement javalink = driver.findElement(By.linkText("Java")); // link tag is whatever clickable
        // when working with it, we use <a> tag for inspecting
        javalink.click();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());

        driver.navigate().back();

        WebElement seleniumlink = driver.findElement(By.linkText("Selenium"));
        seleniumlink.click();
        driver.navigate().back();
       // javalink.click(); this will give me an exception if I want to go back to java page
       // this is why I have to reassign it, line 28. More info in my note, StaleElementReferenceException
        javalink = driver.findElement(By.linkText("Java"));
        javalink.click();
        driver.navigate().back();

        WebElement restApi = driver.findElement(By.partialLinkText("Rest"));  // PARTIAL LINK
         // it works without a whole element. Ex., after Rest we don't have to copy the Api part
        restApi.click();

        driver.navigate().back();

        WebElement version = driver.findElement(By.tagName("u"));
        System.out.println(version.getText());




    }
}
