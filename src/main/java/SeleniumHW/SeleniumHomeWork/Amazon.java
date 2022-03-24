package SeleniumHW.SeleniumHomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {
    public static void main(String[] args) throws InterruptedException {

  /* 1-NAVIGATE TO THE WEBSITE https://www.amazon.com/
     2-Click Hello, Sign in Button
     3-Click Create your amazon account button
     4-Fill the information and click Continue Button
     5-If there is an error or message. Validate it, if not then you completed the task
  */
       WebDriver driver=new ChromeDriver();
       driver.get("https://www.amazon.com/");
       driver.manage().window().maximize();

//         WebElement locationBox= driver.findElement(By.name("glowDoneButton"));
//        locationBox.click();
//         WebElement signIn= driver.findElement(By.xpath("//span[@class='nav-line-1 nav-progressive-content']"));
//        signIn.click();

        WebElement signin= driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        signin.click();
        Thread.sleep(3000);

        WebElement create= driver.findElement(By.id("createAccountSubmit"));
        create.click();
        Thread.sleep(3000);

        WebElement name= driver.findElement(By.xpath("//input[@id='ap_customer_name' and @name='customerName']"));
        name.sendKeys("Someone Somebody");
        Thread.sleep(3000);

       WebElement emailpn= driver.findElement(By.xpath("//input[@id=\"ap_email\" and @name=\"email\"]"));   // ASK
       emailpn.sendKeys("myexample@gmail.com");
        Thread.sleep(3000);

       WebElement passwd= driver.findElement(By.xpath("//input[@type=\"password\" and @id=\"ap_password\"]"));
       passwd.sendKeys("Aamazonpasswd1");
        Thread.sleep(3000);

        WebElement passwdcheck= driver.findElement(By.xpath("//input[@type=\"password\" and @id=\"ap_password_check\"]"));
        passwdcheck.sendKeys("Aamazonpasswd1");
        WebElement verifyemnail= driver.findElement(By.xpath("//input[@id=\"continue\" and @type=\"submit\"]"));
        verifyemnail.click();



    }
}
