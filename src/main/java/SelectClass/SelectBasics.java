package SelectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class SelectBasics {

    @Test
    public void practice1() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");

        WebElement dropdown = driver.findElement(By.linkText("Dropdown"));
        dropdown.click();

        WebElement optionsBox = driver.findElement(By.id("dropdown"));

        Select option = new Select(optionsBox);//provides webelement location
                          //     ...... this allows me to select all options from a drop-down menu.

        Thread.sleep(1000);
        option.selectByIndex(1);    // .... and pick one of them.
        Thread.sleep(1000);
        option.selectByValue("2");
        Thread.sleep(1000);
        option.selectByVisibleText("Option 1");

        List<WebElement> options = option.getOptions();
        for (WebElement optn : options) {
            System.out.println(optn.getText().trim());

        }

    }

}
