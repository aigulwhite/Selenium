package SeleniumHW.SeleniumHomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HWTask4 {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.saucedemo.com/");

        WebElement userName= driver.findElement(By.xpath("//input[@id='user-name']"));
        userName.sendKeys("standard_user");

        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("secret_sauce");

        WebElement LoginButton= driver.findElement(By.xpath("//input[@id='login-button']"));
        LoginButton.getText();
        LoginButton.click();

        String actualUrl= driver.getCurrentUrl();
        String expectedUrl="https://www.saucedemo.com/inventory.html";  // copied it from the website
        if(expectedUrl.equals(actualUrl)){
            System.out.println("passed");
        }else{
            System.out.println("failed");
        }





    }
}
