package Alert;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.Browser;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertTest {

    @Test
    public void JSAlert() throws InterruptedException {

        /*(ALERT CLASS)
    1)Navigate to "https://sweetalert.js.org/"
    2)Click first preview(which is on the bottom left one)
    3)Validate the text on pop-up
    4)Handle the pop up
 */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://sweetalert.js.org/");
        driver.manage().window().maximize();

        WebElement firstPreiew= driver.findElement(By.xpath("//h5[contains(text(),'Normal alert')]//..//button"));
        firstPreiew.click();

        Thread.sleep(3000);  //sometimes it might not get the text. In this case ues Thread
        Alert alert= driver.switchTo().alert();
        String actualMessage=alert.getText();
        System.out.println(actualMessage);
        String expectedMessage="Oops, something went wrong!";
        Assert.assertEquals(actualMessage,expectedMessage);
        alert.accept();

    }
      @Test
      public void TrialForAlertToHandleHTMLpopup(){
    /* TASK 2 (ALERT CLASS)
     1)Navigate to "https://sweetalert.js.org/"
    2)Click first preview(which is on the bottom right one)
    3)Validate the text on pop-up
    4)Handle the popup
     */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://sweetalert.js.org/");
        driver.manage().window().maximize();

        WebElement preiewHTML= driver.findElement(By.xpath("//button[contains(@onclick,'swal')]"));  //practice elements
        preiewHTML.click();

        Alert alert=driver.switchTo().alert();                       // this part is failing as it should
        alert.accept();                              // it is failing because we can't handle HTML POPUS with Alert class
    }
@Test
public void HTMLALERT () throws InterruptedException {
    /*
    TASK 3 (HTML ALERT)
    1)Navigate to "https://sweetalert.js.org/"
    2)Click first preview(which is on the bottom right one)
    3)Validate the text on pop-up
    4)Handle the pop up (the "ok" button"
     */

    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.get("https://sweetalert.js.org/");
    driver.manage().window().maximize();

    WebElement preiewHTML= driver.findElement(By.xpath("//button[contains(@onclick,'swal')]"));  //practice elements
    preiewHTML.click();

    Thread.sleep(3000);
    WebElement text= driver.findElement(By.xpath("//div[@class='swal-text']"));
    text.click();
    String actualText= BrowserUtils.getTextMethod(text);
    String expectedText="Something went wrong!";
    Assert.assertEquals(actualText,expectedText);

    WebElement okButton= driver.findElement(By.xpath("//button[@class='swal-button swal-button--confirm']"));
    okButton.click();


    }

}
