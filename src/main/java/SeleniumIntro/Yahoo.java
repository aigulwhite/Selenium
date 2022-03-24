package SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Yahoo {
    public static void main(String[] args) {

/*  - navigate to "yahoo.com"
    - click news
    - get all news headers
    - print out only headers that has "COVID"
*/
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.yahoo.com/");
        driver.manage().window().maximize();

        WebElement news=driver.findElement(By.id("root_2"));
        news.click();

        List<WebElement> headers= driver.findElements(By.xpath("//h3")); //--> tagName("h3")
                                                       //if it is by tagName we don't need //
                                                       //because tagName comes with //
        int counter=0;
        for (int i=0; i<headers.size();i++){
            headers.get(i).getText();
            //   System.out.println(headers.get(i).getText());
            if(headers.get(i).getText().toUpperCase().contains("COVID")){
                System.out.println(headers.get(i).getText());
                counter++;
            }
        }
        System.out.println(counter);

    }
}
