package WindowHandle;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PracticeWindowHandling {
    /*  navigate to "https://www.hyrtutorials.com/p/window-handles-practice.html"
        click button "open multiple tabs" under the button 4
        switch to "basic controls" tab.
        validate the header "basic controls"
        fill all boxes, and click register
        validate the message "registration is successful"
        go to "alert demo"
        find first "click me" and click it
        close all the tabs
 */

    @Test
    public void MultipleTabs() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
        driver.manage().window().maximize();

        WebElement openMultipleTask=driver.findElement(By.xpath("//button[@id='newTabsBtn']"));
        openMultipleTask.click();
        // BrowserUtils.ClickWithJS(driver,openMultipleTask);
        BrowserUtils.switchByTitle(driver,"\n" +
                "Basic Controls - \n" +
                "                H Y R Tutorials");
        WebElement header = driver.findElement(By.xpath("//h1[@class='post-title entry-title']"));
        String actualHeader= BrowserUtils.getTextMethod(header);
        String expectedHeader= "Basic Controls";
        Assert.assertEquals(actualHeader,expectedHeader);

        WebElement firstName=driver.findElement(By.id("firstName"));
        firstName.sendKeys("Ahmet");

        WebElement lastname=driver.findElement(By.id("lastName"));
        lastname.sendKeys("Baldi");

        WebElement languageBox= driver.findElement(By.id("englishchbx"));
        languageBox.click();

        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("ahmet@gmail.com");

        WebElement password =driver.findElement(By.id("password"));
        password.sendKeys("12325");

        WebElement register=driver.findElement(By.id("registerbtn"));
        register.click();

        WebElement message= driver.findElement(By.id("msg"));
        String actualMessage=BrowserUtils.getTextMethod(message);
        String expectedMessage="Registration is Successful";
        Assert.assertEquals(actualMessage,expectedMessage);

        BrowserUtils.switchByTitle(driver,"AlertsDemo");

        WebElement clickme=driver.findElement(By.id("alertBox"));
        clickme.click();
        Thread.sleep(3000);
        driver.quit();

    }
}
