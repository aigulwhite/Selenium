package SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPATHpractice {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver. get("file:///C:/Users/alena/Downloads/Techtorial%20(2).html");

        WebElement javalink = driver.findElement(By.xpath("//a[@href='https://www.oracle.com/java/']"));
        javalink.click();




    }
}
