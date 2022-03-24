package SeleniumHW.SeleniumHomeWork2;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Task1 {
    /*  Navigate to "https://www.saucedemo.com/"
    Enter username "standard_user"
    Enter password "secret_sauce"
    Click Login button
    Select Name (Z-A) from drop down box
    Validate the products are displayed in descending order
     */
    @Test
    public void UsernameValidation() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        WebElement usernamebutton= driver.findElement(By.id("user-name"));
        usernamebutton.sendKeys("standard_user");

        WebElement passwordbutton= driver.findElement(By.xpath("//input[@id='password']"));
        passwordbutton.sendKeys("secret_sauce");

        WebElement loginButton= driver.findElement(By.id("login-button"));
        loginButton.click();

        WebElement NameList = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        Thread.sleep(2000);
        //Select names = new Select(NameList);
        //names.selectByValue("za");
        BrowserUtils.selectBy(NameList, "za", "value");

        List<WebElement> descendingname= driver.findElements(By.className("inventory_item_name"));
        List<String> actualDescendingOrder= new LinkedList<>();
        List<String> expectedDescendingOrder= new ArrayList<>();
        for (int i=0; i<descendingname.size(); i++){
            actualDescendingOrder.add(descendingname.get(i).getText().trim());
            expectedDescendingOrder.add(descendingname.get(i).getText().trim());
            Collections.sort(expectedDescendingOrder);
            Collections.reverse(expectedDescendingOrder);
            //  Assert.assertEquals(actualDescendingOrder,expectedDescendingOrder);
        }
        Assert.assertEquals(actualDescendingOrder,expectedDescendingOrder);

    }
}
