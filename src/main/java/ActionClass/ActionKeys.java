package ActionClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionKeys {
    @Test
    public void Keys(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();

    // Action below is for writing SeleniumSelenium on the google search bar

        Actions actions=new Actions(driver);
        WebElement googleSearchBox= driver.findElement(By.name("q"));
        actions.moveToElement(googleSearchBox)
                .click().keyDown(Keys.SHIFT)
                .sendKeys("s")
                .keyUp(Keys.SHIFT)
                .sendKeys("elenium")
                .doubleClick().keyDown(Keys.CONTROL)
                .sendKeys("c")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.ARROW_RIGHT)
                .keyDown(Keys.CONTROL)
                .sendKeys("v")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.RETURN).perform(); // OR Keys.ENTER

//             googleSearchBox.sendKeys("SeleniumSelenium")





    }
}
