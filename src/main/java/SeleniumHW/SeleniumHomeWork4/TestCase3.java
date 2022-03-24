package SeleniumHW.SeleniumHomeWork4;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase3 {
    /*  navigate to  https://www.cars.com/
        select "certified cars" from the drop-down menu
        select "toyota" from all makes
        select "corolla" from drop-down
        select max price is $30000
        select 40 miles from drop-down box
        insert 60018 as zip code
        click search button
        validate title has certified  used
        validate "certified used toyota corolla for sale" is displayed
*/
    @Test
    public void cars() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.cars.com/");
        driver.manage().window().maximize();

        WebElement new_used = driver.findElement(By.xpath("//select[@id='make-model-search-stocktype']"));
        BrowserUtils.selectBy(new_used,"cpo","value");
        Thread.sleep(500);

        WebElement make = driver.findElement(By.xpath("//select[@id='makes']"));
        BrowserUtils.selectBy(make,"toyota","value");
        Thread.sleep(400);

        WebElement model = driver.findElement(By.xpath("//select[@id='models']"));
        BrowserUtils.selectBy(model,"Corolla","text");
        Thread.sleep(400);

        WebElement MaxPrice= driver.findElement(By.xpath("//select[@id='make-model-max-price']"));
        BrowserUtils.selectBy(MaxPrice, "30000", "value");
        Thread.sleep(4000);

        WebElement distance = driver.findElement(By.xpath("//select[@id='make-model-maximum-distance']"));
        BrowserUtils.selectBy(distance,"40","value");
        Thread.sleep(400);

        WebElement zipCode= driver.findElement(By.xpath("//input[@id='make-model-zip']"));
        zipCode.clear();
        zipCode.sendKeys("60018");

        WebElement searchButton = driver.findElement(By.xpath("//button[@data-linkname='search-cpo-make']"));
        searchButton.click();
        Thread.sleep(400);

        boolean HasCertifiedUsed= driver.getTitle().startsWith("Certified used");
        Assert.assertTrue(HasCertifiedUsed);

        WebElement validateHeader= driver.findElement(By.xpath("//h1[.='Certified used Toyota Corolla for sale']"));
        boolean isdisplayed=validateHeader.isDisplayed();
        Assert.assertTrue(isdisplayed);


        // PART 2

    /* validate 40 miles selected in dropdown once you click search button
      validate certified pre-owned selected in radio button                 didn't do this part since there was no radio button
      validate toyota is selected in checkbox
      validate corolla is selected in dropdown
    */
        WebElement validateDistance= driver.findElement(By.xpath("//select[@id='location-distance']//option[.='40 miles']"));
        String actualText=BrowserUtils.getTextMethod(validateDistance);
        String expectedText="40 miles";
        Assert.assertEquals(actualText,expectedText);

        WebElement validateCarName= driver.findElement(By.xpath("//select[@id='make_select']//option[. ='Toyota']"));
        String actualCarName=BrowserUtils.getTextMethod(validateDistance);
        String expectedCarName="Toyota";
        Assert.assertEquals(actualText,expectedText);

        WebElement validateCarModel= driver.findElement(By.xpath("//label[@for='active_filter_tags-models-toyota-corolla']"));
        String actualCarModel=BrowserUtils.getTextMethod(validateDistance);
        String expectedCarModel="Corolla";
        Assert.assertEquals(actualText,expectedText);


    }
}
