package SeleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumBasics {
    public static void main(String[] args) {

  // 1) we need to define the chrome driver into the project as a property.

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");  // NO exe for MAC

  // 2) we need to instantiate or declare our driver.

        WebDriver driver = new ChromeDriver();  // DRIVER is a reference name
                                                // WEBDRIVER= interface
                                                // new Chromedriver = object
        // INTERVIEW QUESTION:
   // 1) Where do you use polymorphism in your testing framework?
   // I use it to instantiate my driver like this ---> WebDriver driver = new ChromeDriver();
   // 2) can you instantiate your driver like this---> WebDriver driver = new ChromeDriver();
   // No

        // Get()  method:   navigates to the given url(website)

    driver.get("https://www.techtorialacademy.com/");
    String title = driver.getTitle();
        System.out.println(title);
        if(title.equals("Home Page - Techtorial")){  // this is positive testing. to see the negative
            System.out.println("your test is passed"); // make some changes. Ex add letters to see the fail
        }else{
            System.out.println("your test failed");
        }

      String actual = driver.getCurrentUrl();
        if(actual.equals("https://www.techtorialacademy.com/")){
            System.out.println("passed");
        }else{
            System.out.println("failed");
        }
    }


}
