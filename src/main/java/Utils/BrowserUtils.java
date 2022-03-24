package Utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.util.Set;

public class BrowserUtils {

    //WE CREATE BROWSERUTILS TO BE ABLE TO CALL REUSABLE METHODS FROM HERE TO REDUCE AMOUNT OF THE CODES

    // to use this method in another class use this syntax:
    // BrowserUtils.selectBy(passengerCount, "2", "value");

    public static void selectBy(WebElement element, String value, String methodName) {
        Select select = new Select(element);

        switch (methodName) {

            case "text":
                select.selectByVisibleText(value);
                break;

            case "index":
                select.selectByIndex(Integer.parseInt(value)); // select by index works with integer. but our value..
                break;                                      //is string. that's why we used parse method.

            case "value":
                select.selectByValue(value);
                break;

            default:
                System.out.println("Method name is not available, use text value or index for ");
        }
    }

    public static String getTextMethod(WebElement element) {
        return element.getText().trim();

    }

    public static String GetTitleWithJS(WebDriver driver) {

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        String title = javascriptExecutor.executeScript("return document.title").toString();

        return title;
    }

    public static void ClickWithJS(WebDriver driver, WebElement element) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].click()", element);
    }

    public static void ScrollWithJS(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", element);
    }

    public static void ScrollWithXandYCord(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Point location = element.getLocation();
        int xCoord = location.getX();
        int yCoord = location.getY();
        js.executeScript("window.scrollTo(" + xCoord + "," + yCoord + ")");
    }

    public static void SwitchOnlyForTwoTabs(WebDriver driver, String mainPageId) {  // testing TWO windows
        Set<String> allPageIds = driver.getWindowHandles();
        for (String id : allPageIds) {
            if (!id.equals(mainPageId)) {
                driver.switchTo().window(id);
            }
        }
    }

    public static void switchByTitle(WebDriver driver, String title) {   // for testing different tabs or windows
        Set<String> allPagesId = driver.getWindowHandles();
        for (String id : allPagesId) {
            driver.switchTo().window(id);
            if (driver.getTitle().contains(title)) {
                break;
            }
        }
    }
    public static void getScreenshot(WebDriver driver,String packageName){

        File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String location=System.getProperty("user.dir")+"/src/java/screenshot"+packageName;

        try {
            FileUtils.copyFile(file,new File(location+System.currentTimeMillis()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}