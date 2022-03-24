package SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.spec.PSSParameterSpec;
import java.util.List;

public class FINDELEMENTS {
    public static void main(String[] args) {

        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();


        List<WebElement> allLinks=driver.findElements(By.xpath("//li/a"));
        int counter=0;
        for(WebElement link:allLinks){               //find only links with a size less than & equal 12 and count
                                                     //how many we have >
            if(link.getText().length()<=12){
                System.out.println(link.getText());
                counter++;
            }
        }
        System.out.println(counter);

    }


    }

