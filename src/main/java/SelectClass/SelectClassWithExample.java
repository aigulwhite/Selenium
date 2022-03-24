package SelectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SelectClassWithExample {
    @Test
    public void ValidationTripButton(){    // THIS IS MY VERSION  SELECTCLASSWTIHEXAMPLEAHMETSVERSION

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://demo.guru99.com/test/newtours/reservation.php");

        WebElement onewayButton= driver.findElement(By.xpath("//input[@value='oneway']"));
        onewayButton.click();
        Assert.assertTrue(onewayButton.isDisplayed());   // must be true to pass the assertion
        Assert.assertTrue(onewayButton.isSelected());

        WebElement roundTripButton=driver.findElement(By.xpath("//input[@value='roundtrip']"));
        Assert.assertFalse(roundTripButton.isSelected());
        Assert.assertTrue(roundTripButton.isDisplayed());
    }

    @Test
    public void SelectMethods(){

        WebDriverManager.chromedriver().setup();       //please get used to this process
        WebDriver driver=new ChromeDriver();
        driver.get("https://demo.guru99.com/test/newtours/reservation.php");

        WebElement onewayButton=driver.findElement(By.xpath("//input[@value='oneway']"));
        onewayButton.click();

        WebElement passengerCount=driver.findElement(By.name("passCount"));
        Select psnger= new Select(passengerCount);    // WE NEED SELECT CLASS FOR EVERY NEW BOX
        psnger.selectByIndex(1);

        WebElement departfrom = driver.findElement(By.name("fromPort"));
        Select depart= new Select(departfrom);
        depart.selectByValue("Sydney");

        WebElement month=driver.findElement(By.name("fromMonth"));
        Select mnth=new Select(month);
        mnth.selectByVisibleText("April");

        WebElement dateButton=driver.findElement(By.xpath("//select[@name='toDay']"));
        Select date=new Select(dateButton);
        date.selectByValue("14");

   }
   @Test
    public void ValidationServiceClassButton(){

       WebDriverManager.chromedriver().setup();
       WebDriver driver=new ChromeDriver();
       driver.get("https://demo.guru99.com/test/newtours/reservation.php");

       WebElement dateButton=driver.findElement(By.xpath("//select[@name='toDay']"));
       Select date=new Select(dateButton);
       date.selectByValue("14");

       WebElement EconomyClassButton= driver.findElement(By.xpath("//input[@value='Coach']"));
       EconomyClassButton.click();
       Assert.assertTrue(EconomyClassButton.isDisplayed());
       Assert.assertTrue(EconomyClassButton.isSelected());

       WebElement BusinessClassButton=driver.findElement(By.xpath("//input[@value='Business']"));
       BusinessClassButton.click();
    }
    @Test
    public void Airline(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://demo.guru99.com/test/newtours/reservation.php");

        WebElement EconomyClassButton= driver.findElement(By.xpath("//input[@value='Coach']"));
        EconomyClassButton.click();
        Assert.assertTrue(EconomyClassButton.isDisplayed());
        Assert.assertTrue(EconomyClassButton.isSelected());

        WebElement BusinessClassButton=driver.findElement(By.xpath("//input[@value='Business']"));
        BusinessClassButton.click();

        WebElement airline = driver.findElement(By.xpath("//select[@name='airline']"));
        Select airl= new Select(airline);
        airl.selectByVisibleText("Unified Airlines");

        WebElement continueButton= driver.findElement(By.name("findFlights"));
        continueButton.click();





    }

}
