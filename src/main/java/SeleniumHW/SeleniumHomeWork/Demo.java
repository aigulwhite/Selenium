package SeleniumHW.SeleniumHomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {
    public static void main(String[] args) {

  /*  1-NAVIGATE TO THE WEBSITE https://demo.nopcommerce.com/
    2-Click Register
    3-Fill the information
    4-Newsletter box should be left unclicked
    5-Click Register
    6-Validate “Your registration completed”
    7-Click Continue (edited)
  */
        WebDriver driver=new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();

        WebElement register= driver.findElement(By.xpath("//a[@class='ico-register']"));
        register.click();
        WebElement gender= driver.findElement(By.xpath("//label[@for='gender']"));
        System.out.println(gender.getText());
        WebElement genderInput= driver.findElement(By.xpath("//input[@id='gender-female']"));
        genderInput.click();
        WebElement firstName= driver.findElement(By.xpath("//input[@id='FirstName']"));
        firstName.sendKeys("Somebody");
        WebElement lastName= driver.findElement(By.xpath("//input[@id='LastName']"));
        lastName.sendKeys("Somebody1");
        WebElement day=driver.findElement(By.xpath("//select[@name='DateOfBirthDay']"));
        day.sendKeys("14");
        WebElement month= driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']"));
        month.sendKeys("June");
        WebElement  year = driver.findElement(By.xpath("//select[@name='DateOfBirthYear']"));
        year.sendKeys("1900");
        WebElement email= driver.findElement(By.xpath("//input[@name='Email']"));
        email.sendKeys("somebody@yahoo.com");
        WebElement companyName= driver.findElement(By.xpath("//input[@name='Company']"));
        companyName.sendKeys("something");

        WebElement box= driver.findElement(By.xpath("//input[@id='Newsletter']"));
        System.out.println(box.isDisplayed());
        // box.click(); // this will un-click the button because it is already click
                     // or don't use this, so it stays clicked

        WebElement passwd= driver.findElement(By.xpath("//input[@type=\"password\" and @name=\"Password\"]"));
        passwd.sendKeys("somepasswd1");



    }
}
