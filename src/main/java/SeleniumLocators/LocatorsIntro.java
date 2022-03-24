package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsIntro {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("file:///C:/Users/alena/Downloads/Techtorial%20(2).html");

        //ID gives more accurate location.
        //getText()--> it gives you the text of the element.

        WebElement header = driver.findElement(By.id("techtorial1"));
        String actualText= header.getText(); //coming from the system
        String expectedText="Techtorial Academy"; //coming from the business requirement

        if(actualText.equals(expectedText)){
            System.out.println("passed");
        }else{
            System.out.println("failed");
        }

        WebElement paragraph = driver.findElement(By.id("details2"));
        System.out.println(paragraph.getText());

        //LOCATOR ClassName

        WebElement tools=driver.findElement(By.className("group_checkbox"));
        System.out.println(tools.getText());  //If we provide a wrong path for a web element, it will throw
        // an exception which is called “NoSuchElementExecption”

        //LOCATOR: NAME

        WebElement firstName = driver.findElement(By.name("firstName"));
        firstName.sendKeys("Aigul");
        WebElement lastName = driver.findElement(By.name("lastName"));
        lastName.sendKeys("White");
        WebElement email = driver.findElement(By.name("userName"));
        email.sendKeys("alena_14078@yahoo.com");
        WebElement phone = driver.findElement(By.name("phone"));
        phone.sendKeys("38756");

        WebElement javaBox = driver.findElement(By.id("cond1"));
        javaBox.click();
        System.out.println(javaBox.isDisplayed()); // means it is there or not, returns true
        System.out.println(javaBox.isSelected()); // if it is checked or not,  true

        WebElement testng = driver.findElement(By.id("cond3"));
        testng.click();
        System.out.println(testng.isDisplayed());
        System.out.println(testng.isSelected());

        WebElement cucumber = driver.findElement(By.id("cond4"));
        cucumber.click();
        System.out.println(cucumber.isDisplayed());
        System.out.println(cucumber.isSelected());
    }
}
