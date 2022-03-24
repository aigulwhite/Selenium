package SelectClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MultiSelect {
    @Test
    public void multipleSelectionAndFirstSelectionPractice() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("file:///C:/Users/alena/Downloads/Techtorial%20(2)%20(1).html");
        driver.manage().window().maximize();

        WebElement header = driver.findElement(By.id("techtorial1"));
        BrowserUtils.getTextMethod(header);
       //  header.getText().trim(); instead of this we use the line 23

        WebElement multiSelectBox= driver.findElement(By.xpath("//select[@class='select']"));
        BrowserUtils.selectBy(multiSelectBox, "Two", "text");
        BrowserUtils.selectBy(multiSelectBox, "3", "index");
        BrowserUtils.selectBy(multiSelectBox, "1", "value");

        Select select = new Select(multiSelectBox);
        Thread.sleep(2000);
        select.deselectByIndex(3);

        // TRIM removes spaces from both sides of a string.....

        WebElement cutryList = driver.findElement(By.name("country"));
        Select country=new Select(cutryList);
        //String actualFirstSelectedOption=country.getFirstSelectedOption().getText().trim();
        String actualFirstSelectedOption=BrowserUtils.getTextMethod(country.getFirstSelectedOption());
        String expectedFirstSelectedOption="UNITED STATES";
        Assert.assertEquals(actualFirstSelectedOption,expectedFirstSelectedOption);

    }
}
