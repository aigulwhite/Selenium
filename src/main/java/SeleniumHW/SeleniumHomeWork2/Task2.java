package SeleniumHW.SeleniumHomeWork2;

import Utils.BrowserUtils;
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

public class Task2 {

    /*
Navigate to "https://www.saucedemo.com/"
Enter username "standard_user"
Enter password "secret_sauce"
Click Login button
Select Price (low-high) from drop down box
Validate the products are displayed according to their price
and they are displayed low price to high price

     */

    @Test
    public void validatePrice() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.saucedemo.com/");

        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        WebElement loginbutton = driver.findElement(By.id("login-button"));
        loginbutton.click();
        Thread.sleep(2000);

        WebElement sortingchoise = driver.findElement(By.className("product_sort_container"));
        BrowserUtils.selectBy(sortingchoise, "lohi", "value");
        List<Double> twoCheapest=new ArrayList<>();

        List<WebElement> allprices= driver.findElements(By.className("inventory_item_price")); // shows prices for all products
        List<Double> actualpricesOrder= new LinkedList<>();   // why linked list
        List<Double> expectedpricesOrder= new ArrayList<>();  // why arraylist
        for (int i=0; i<allprices.size(); i++){   // checks all prices 1 by 1
            actualpricesOrder.add(Double.parseDouble(allprices.get(i).getText().substring(1))); // ?
            expectedpricesOrder.add(Double.parseDouble(allprices.get(i).getText().substring(1))); // ?
            Collections.sort(expectedpricesOrder);
        }
        System.out.println(actualpricesOrder);
        System.out.println(expectedpricesOrder);
        Assert.assertEquals(actualpricesOrder,expectedpricesOrder);


    }
}
