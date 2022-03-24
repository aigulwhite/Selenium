package SeleniumHW.SeleniumHomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HWTask1 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/text-box");
        driver.manage().window().maximize();

        WebElement fullNameBox = driver.findElement(By.xpath("//input[@id='userName']"));
        fullNameBox.sendKeys("Aigul White");

        WebElement email = driver.findElement(By.xpath("//input[@type='email']"));
        email.sendKeys("alena_14078@yahoo.com");

        WebElement currentAdr = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        currentAdr.sendKeys("999 Parkway");

        WebElement permAdr= driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        permAdr.sendKeys("100 Park Drive");

        WebElement button= driver.findElement(By.xpath("//button[@id='submit']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
        Thread.sleep(500);

        button.click();

        WebElement nameValidation=driver.findElement(By.xpath("//p[@id='name']"));
        System.out.println(nameValidation.getText());  // We need this to see it in console
        String expectedValidation="Name:Aigul White";  //copy it from the console
        String actualValidation=nameValidation.getText();

        if (expectedValidation.equals(actualValidation)) {
            System.out.println("pass");
        }else{
            System.out.println("fail");
        }






    }
}
