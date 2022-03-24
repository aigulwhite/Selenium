package SeleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RealTestCaseExample {
    //Test Case - Open Godaddy.com and validate it's Page title and the url.
//    Steps to Automate:
//            1. Launch browser of your choice say., Firefox, chrome etc.
//            2. Open this URL - https://www.godaddy.com/
//            3. Maximize or set size of browser window.
//            4. Get Title of page and validate it.
//            4. Get URL of current page and validate it.
//            5. Close browser.
    public static void main(String[] args) {

       // System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://www.godaddy.com/");  // or driver.get
        driver.manage().window().maximize();
        String actualTitle= driver.getTitle();   //  4
        String expectedTitle="Domain Names, Websites, Hosting & Online Marketing Tools - GoDaddy";
        String actualUrl= driver.getCurrentUrl();
        String expectedUrl="https://www.godaddy.com/";

        if(actualTitle.equals(expectedTitle)){
            System.out.println("passed");
        }else{
            System.out.println("failed");
        }

        if(actualUrl.equals(expectedUrl)){
            System.out.println("passed");
        }else{
            System.out.println("failed");
        }
        driver.close();



    }
}
