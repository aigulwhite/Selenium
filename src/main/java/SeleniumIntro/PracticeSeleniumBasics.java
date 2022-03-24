package SeleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeSeleniumBasics {
    public static void main(String[] args) throws InterruptedException {

  // go tho 3 websites
  // get the title, current url
  //forward them, refresh and quit.

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://www.linkedin.com/in/aigul-white-b38a92225/");
        Thread.sleep(3000);
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        driver.navigate().to("https://www.yahoo.com/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        driver.navigate().to("https://www.youtube.com/");
        Thread.sleep(3000);
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        driver.navigate().back();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.navigate().refresh();
        driver.close();



    }
}
