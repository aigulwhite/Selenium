package SeleniumHW.SeleniumHomeWork2;

import Utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Task3 {

    /*  Navigate to "https://www.saucedemo.com/"
        Enter username "standard_user"
        Enter password "secret_sauce"
        Click Login button
        Find the cheapest two product on the page
        Add them to the cart
        Click cart button
        Validate these two products is added to the cart

     */

    @Test
    public void CheapestProduct() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.saucedemo.com/");

        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        WebElement loginbutton = driver.findElement(By.id("login-button"));
        loginbutton.click();
        Thread.sleep(2000);

        WebElement lowToHigh = driver.findElement(By.className("product_sort_container"));
        BrowserUtils.selectBy(lowToHigh, "lohi", "value");

        List<WebElement> allPrices = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        List<Double> twoCheapest=new ArrayList<>();
        for (int i = 0; i < allPrices.size(); i++) {
            twoCheapest.add(Double.parseDouble(allPrices.get(i).getText().trim().replace("$","")));
        }
        System.out.println(twoCheapest.get(0));
        System.out.println(twoCheapest.get(1));



    }


    }



