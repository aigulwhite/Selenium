package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");

        WebElement title= driver.findElement(By.xpath("//h3"));
        System.out.println(title.getText());

        WebElement paragraph = driver.findElement(By.xpath("//h4[@class='subheader']"));
        System.out.println(paragraph.getText());

        //CONTAINS ---> works with text, and looks for a PIECE
           // syntax--->    // tagname[contains(text(), 'HorizontalLine')]

        WebElement contains = driver.findElement(By.xpath("//h3[contains(text(),'Horizontal Slider')]"));
        System.out.println(contains.getText());

        //TEXT  ---> works with a text as well. Looks for the exact text
           // syntax--->  //h3[.='text']

        WebElement text = driver.findElement(By.xpath("//h3[.='Horizontal Slider']"));
        System.out.println(text.getText());










    }
}
