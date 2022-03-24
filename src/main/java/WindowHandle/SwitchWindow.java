package WindowHandle;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.layertree.model.StickyPositionConstraint;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class SwitchWindow {
    @Test
    public void SwitchWindow() {

        //Task   : click on "click here" then get "new window" text on the next tab

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");

        WebElement ClickButton = driver.findElement(By.xpath("//a[.='Click Here']"));
        ClickButton.click();

        WebElement NewWindowHeader = driver.findElement(By.xpath("//h3[.='New Window']"));
        System.out.println(NewWindowHeader.getText());

        // it is failing because my driver is still pointing at the last tab.
        // following @Test is the right way
    }

    @Test
    public void switchingWindow() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");
        System.out.println(driver.getWindowHandle());
        WebElement ClickButton = driver.findElement(By.xpath("//a[.='Click Here']"));
        ClickButton.click();
        System.out.println(driver.getWindowHandles());
        //  WebElement NewWindowHeader= driver.findElement(By.xpath("//h3[.='New Window']"));

        String mainPageId = driver.getWindowHandle();  // for instance the id for this tab is 123
        Set<String> allPagesId = driver.getWindowHandles(); // .. and for this 123, 563

        //this implementation is for       ===== ONLY 2 TABS =====  Switching between 2 tabs

        for (String id : allPagesId) {
            System.out.println(id);
            if (!id.equals(mainPageId)) { //if my previous window(123) is not equal to current window (563),
                driver.switchTo().window(id);  //....then switch the tab (or window)
            }
        }
        WebElement NewWindowHeader = driver.findElement(By.xpath("//h3[.='New Window']"));
        System.out.println(NewWindowHeader.getText());
        String actualText = NewWindowHeader.getText();
        String expectedText = "New Window";
        Assert.assertEquals(actualText, expectedText);
    }
    @Test
    public void HyrTutorialWindowHandle() {

        // TASK  : navigate to https://www.hyrtutorials.com/p/window-handles-practice.html
        // :click on "open new tab". Once it opens a new tab...
        // validate the AlertDemo header on the new tab
        //..then click "click me" button

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html"); // Main page
        String mainPageId= driver.getWindowHandle();                              // main page id

        WebElement button2= driver.findElement(By.id("newTabBtn"));
        button2.click();                                                           // new tab opens
        Set<String>allPagesId= driver.getWindowHandles();                     // ..and here i get 2 pages ids

        for (String id : allPagesId) {
            if (!id.equals(mainPageId)) {
                driver.switchTo().window(id);
            }
        }
          WebElement AlertsDemoHeader=driver.findElement(By.xpath(" //h1[contains(text(),'AlertsDemo')]"));
          String actualAlertHeader=BrowserUtils.getTextMethod(AlertsDemoHeader);
          String expectedAlertHeader= "AlertsDemo";
          Assert.assertEquals(actualAlertHeader,expectedAlertHeader);

          WebElement click1= driver.findElement(By.id("alertBox"));
          click1.click();





    }
}
