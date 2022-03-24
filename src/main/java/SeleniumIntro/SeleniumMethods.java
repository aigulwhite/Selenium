package SeleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumMethods {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();

                // what is the difference btw
        //Driver.navigate.to()--->it navigates to the webpage
        //diver.getPageSource()--->gives the html source of the page

                // difference between..
        // 1) driver.quit--> I use it to make sure I close all tabs after the automation.
        // 2) driver.close--> It closes to current page or tabs

        // 1) driver.get()--> waits all elements to be loaded,
        // 2) driver.navigate--->does not wait for all elements to be loaded.
        //    has methods like forward, back, refresh

        driver.navigate().to("https://www.google.com/");   // 1
        driver.quit();
        driver.close();
       // Thread.sleep(3000);
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        //driver.getPageSource()         -->it gives the html source of the page.
        // System.out.println(driver.getPageSource());
        driver.navigate().to("https://www.techtorialacademy.com/");   // 2
       // Thread.sleep(3000);
        driver.navigate().back();//google          3
       // Thread.sleep(3000);
        driver.navigate().forward();//techtorial again     4
       // Thread.sleep(3000);
        driver.navigate().refresh();//refresh         5
        driver.close();                  // to try this, un-comment threads



    }
}
