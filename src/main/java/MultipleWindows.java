import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindows {
    @Test
    public void MultipleWindows() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");

        WebElement clickhere = driver.findElement(By.xpath("//a[.='Click Here']"));
        clickhere.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('https://www.techtorialacademy.com/')");
        js.executeScript("window.open('https://www.techtorialacademy.com/about-us')");
        js.executeScript("window.open('https://www.techtorialacademy.com/programs')");

        //5 windows open. The last one is "programs", but I want to go to "about us". To switch, we do following

//        Set<String> allPagesId = driver.getWindowHandles();
//        for (String id : allPagesId) {
//            driver.switchTo().window(id);
//            if (driver.getTitle().contains("About Us - Techtorial")) {
//                break;
//            }
  //      }

        // or i can substitute those 6 lines with 1 following line.

        BrowserUtils.switchByTitle(driver,"Home Page - Techtorial");
    }
}
