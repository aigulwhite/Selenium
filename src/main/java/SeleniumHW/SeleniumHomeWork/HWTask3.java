package SeleniumHW.SeleniumHomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HWTask3 {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");

       WebElement username= driver.findElement(By.xpath("//input[@name='user-name']"));
       username.sendKeys("Java");

        WebElement password= driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("Selenium");

        WebElement yesButton= driver.findElement(By.xpath("//input[@id='login-button']"));
        yesButton.click();

        WebElement epicSadFaceValidation=driver.findElement(By.xpath("//h3"));
        System.out.println(epicSadFaceValidation.getText());
        String expectedValidation="Epic sadface: Username and password do not match any user in this service";
        String actualValidation=epicSadFaceValidation.getText();

        if (expectedValidation.equals(actualValidation)) {
            System.out.println("pass");
        }else{
            System.out.println("fail");
        }
    }
}
