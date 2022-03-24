package JavaScriptExecutor;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JSMethods {

    // whenever normal methods are not working, then last decision should be javaScript

    @Test
    public void TitleMehod(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://www.techtorialacademy.com/");
        driver.manage().window().maximize();

        System.out.println(driver.getTitle());  // old version

//        JavascriptExecutor javascriptExecutor= (JavascriptExecutor) driver;
//        String title=javascriptExecutor.executeScript("return document.title").toString();
//        System.out.println(title+"from javaScript");

        String actualTitle = BrowserUtils.GetTitleWithJS(driver);
        String expectedTitle = "Home Page - Techtorial";
        Assert.assertEquals(actualTitle, expectedTitle);

    }
    @Test
    public void ClickWithJS(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://www.techtorialacademy.com/");
        WebElement browserCourse= driver.findElement(By.xpath("//a[.='Browse Course']"));

//      JavascriptExecutor javascriptExecutor= (JavascriptExecutor) driver;
//      javascriptExecutor.executeScript("arguments[0].click()",browserCourse);    From BrowserUtils line 50-51
        BrowserUtils.ClickWithJS(driver, browserCourse);
    }
    @Test
    public void ClickWithJSPractice(){
      // Task: click the student login

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://www.techtorialacademy.com/");
        driver.manage().window().maximize();

        WebElement StudentLogin= driver.findElement(By.xpath("//div[@class='navigation hidden-xs']//a[.='Student login']"));
        BrowserUtils.ClickWithJS(driver, StudentLogin);
    }
    @Test
    public void ScrollIntoView(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://www.techtorialacademy.com/");

        WebElement copyright= driver.findElement(By.xpath("//p[contains(text(),' Copy')]"));

        JavascriptExecutor js=(JavascriptExecutor)driver;
     //   js.executeScript("arguments[0].scrollIntoView(true)",copyright);

        // this method is to scroll down to get to an element

    }
    @Test
    public void ScrollDown2Click(){

        //TASK

    /*  go to techtorial academy
        1st click "browse course"with java script
        scroll down to "get started" on campus
        2nd click "get started" with JavaScript
     */

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://www.techtorialacademy.com/");

        WebElement browseCoursebutton= driver.findElement(By.xpath("//a[contains(text(),'Browse Course')]"));
        BrowserUtils.ClickWithJS(driver,browseCoursebutton);

        WebElement GetStarted= driver.findElement(By.xpath("//h4[.='On-Campus Course']//..//a")); // NOTE
 //     JavascriptExecutor js = (JavascriptExecutor) driver;
//      js.executeScript("arguments[0].scrollIntoView(true)",GetStarted);
        BrowserUtils.ScrollWithJS(driver,GetStarted);
        BrowserUtils.ClickWithJS(driver,GetStarted);
    }
    @Test
    public void ScrollWithXandYCordinantTest(){
                                                    //This is an interview question(POINT CLASS)
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.techtorialacademy.com/");
        WebElement copyright=driver.findElement(By.xpath("//p[contains(text(),' Copy')]"));
///        JavascriptExecutor js= (JavascriptExecutor) driver;
//            Point location=copyright.getLocation();
//            System.out.println(location.getX());
//            System.out.println(location.getY());
//            int xCord=location.getX();
//            int yCord=location.getY();
//            js.executeScript("window.scrollTo("+xCord+","+yCord+")");
        BrowserUtils.ScrollWithXandYCord(driver,copyright);               // or this instead of 106-112


    }
}

