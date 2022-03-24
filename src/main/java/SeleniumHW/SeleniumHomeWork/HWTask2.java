package SeleniumHW.SeleniumHomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HWTask2 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/radio-button");

        WebElement radiobutton = driver.findElement(By.id("yesRadio"));
        // radiobutton.click();
        //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",radiobutton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()",radiobutton);

       Thread.sleep(3000);

        WebElement radiobutton2 = driver.findElement(By.id("impressiveRadio"));
        //radiobutton2.click(); this does not work
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()",radiobutton2);

        // MORE INFO IN MY Selenium NOTE about SCRIPT, page 2


    }
}
