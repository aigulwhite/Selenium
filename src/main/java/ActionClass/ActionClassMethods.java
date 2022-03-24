package ActionClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class ActionClassMethods {

    @Test
    public void ContextClick() {    // contexclick means right click

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/");
        WebElement contextmenu = driver.findElement(By.partialLinkText("Context"));
        contextmenu.click();
        WebElement box = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        //  action class you must use perform at the end.
        actions.contextClick(box).perform();
    }

    @Test
    public void Hoverover() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/");
        WebElement Hover = driver.findElement(By.linkText("Hovers"));
        Hover.click();
        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        List<WebElement> names = driver.findElements(By.tagName("h5"));
        List<WebElement> pictures = driver.findElements(By.xpath("//div[@class='figure']/img"));
        List<String> expectedNames = Arrays.asList("name: user1", "name: user2", "name: user3");
        for (int i = 0; i < names.size(); i++) {
            Thread.sleep(2000);
            actions.moveToElement(pictures.get(i)).perform(); //hover over here
            Assert.assertEquals(BrowserUtils.getTextMethod(names.get(i)), expectedNames.get(i));
            System.out.println(BrowserUtils.getTextMethod(names.get(i))); //get text here
        }
    }

    @Test
    public void doubleclick() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://demo.guru99.com/test/simple_context_menu.html");
        driver.manage().window().maximize();

        WebElement doubleClickButton = driver.findElement(By.tagName("button"));
        Actions actions = new Actions(driver);
        //         actions.doubleClick(doubleClickButton).perform();
//          actions.doubleClick().perform();  // THIS WON'T WORK BCZ WE ARE NOT SHOWING WHERE TO DOUBLE-CLICK...
        // ...INSIDE THE PARANTHESIS
//          actions.doubleClick(driver.findElement(By.tagName("button"))).perform();
        // This is the same as line 61


        //     RIGHT CLICK PRACTICE
        WebElement rightClickButton = driver.findElement(By.xpath("//span[.='right click me']"));
        actions.contextClick(rightClickButton).perform();  // to see this block the line 60
        // to see the line 60 block this
    }

    //TASK FOR STUDENTS
        /*
1. Launch the Chrome web browser.
2. Open a URL "https://selenium08.blogspot.com/2019/11/double-click.html".
3. Locate the element "Double-click".
4.  click on the current location (i.e. on Double-click element).
5. Close the web browser.
         */
    @Test
    public void doubleclickpractice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://selenium08.blogspot.com/2019/11/double-click.html");
        driver.manage().window().maximize();

        WebElement doubleClickButton = driver.findElement(By.xpath("//button[@ondblclick=\"myFunction()\"]"));
        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClickButton).perform();
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void dragAndDrop() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://demos.telerik.com/kendo-ui/dragdrop/area");
        driver.manage().window().maximize();

//            WebElement acceptcookies= driver.findElement(By.id("onetrust-accept-btn-handler"));
//            Thread.sleep(3000);
//            acceptcookies.click();
//            Actions actions=new Actions(driver);
//            for (int i=0; i<5;i++){
//                actions.sendKeys(Keys.ARROW_DOWN).perform();
//            }
//            Thread.sleep(3000);

        WebElement dragable = driver.findElement(By.xpath("//div[@id='draggable']")); // the blue circle
        WebElement orangebox = driver.findElement(By.xpath("//div[@class='test2']")); // orange box where we drop the blue circle
        String actualmessage = BrowserUtils.getTextMethod(orangebox);
        // or this--- String actualmessage=orangebox.getText();
        String expectedmessage = "... Or here.";   //came from the inspection console
        Assert.assertEquals(actualmessage, expectedmessage);

        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragable, orangebox).perform(); // here we are dragging the circle to the box
        Thread.sleep(3000);
        // if this action fails when run, use the "acceptCookies" line 100-107

        orangebox = driver.findElement(By.xpath("//div[@class='test2']"));
        //reinitializing after change(after dragging it the element changes)
        //without reinitializing the code will fail, the element is dynamic
        String actualafterdraganddrop = BrowserUtils.getTextMethod(orangebox);
        String expectedafterdraganddrop = "You did great!";
        Assert.assertEquals(actualafterdraganddrop, expectedafterdraganddrop);

        String actualcssValue = orangebox.getCssValue("background-color");
        String expectedCssValue = "rgba(238, 111, 11, 1)";
        System.out.println(actualcssValue);
        Assert.assertEquals(actualcssValue, expectedCssValue);
    }

    @Test
    public void ClickAndHold() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");
        driver.manage().window().maximize();

        WebElement blueBox = driver.findElement(By.xpath("//div[@class='test1']"));
        String actualBlueBoxMessage = BrowserUtils.getTextMethod(blueBox);
        String expectedBlueBoxMessage = "Drag the small circle here ...";
        Assert.assertEquals(actualBlueBoxMessage, expectedBlueBoxMessage);

        WebElement draggable = driver.findElement(By.xpath("//div[@id='draggable']"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(draggable).moveToElement(blueBox).release().perform();
    }

    @Test
    public void DragAndDrop() throws InterruptedException {

      /*navigate to the website
      drag "drag me" box and drop it to "drop"box
      Validate the message is changed to "Dropped"
      Validate the css color is steel blue
      */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://demoqa.com/droppable");
        driver.manage().window().maximize();

        WebElement draggable = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement blueBox = driver.findElement(By.xpath("//div[@class='drop-box ui-droppable']"));
        Actions actions = new Actions(driver);

        String actualMessage = BrowserUtils.getTextMethod(blueBox);
        String expectedMessage = "Drop here";
        Assert.assertEquals(actualMessage, expectedMessage);
        actions.dragAndDrop(draggable, blueBox).perform();
        Thread.sleep(3000);
        blueBox = driver.findElement(By.xpath("//div[@class='drop-box ui-droppable ui-state-highlight']"));

        String actualAfterDragAndDrop = BrowserUtils.getTextMethod(blueBox);
        String expectedAfterDragAndDrop = "Dropped!";
        Assert.assertEquals(actualAfterDragAndDrop, expectedAfterDragAndDrop);
    }

    @Test
    public void ClickAndHoldPractice() {

      /* navigate to website https://demoqa.com/droppable
         click accept
         clickAndHold notAccepted box and release it to drop box
         validate the  message is still drop here
         clickAndHold acceptable box and release to drop box
         validate the background is blue and message is dropped
      */

    }

    @Test
    public void MoveByOffset() {  // X-horizontal Y-vertical

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");

        WebElement slider = driver.findElement(By.xpath("//input"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(slider).moveByOffset(-30, 0).perform();
    }

    @Test
    public void sliderShortCut() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");
        driver.manage().window().maximize();

        WebElement slider = driver.findElement(By.xpath("//input"));
        WebElement range = driver.findElement(By.xpath("//span[@id='range']"));

        String myrange = "5";  // the given range is 5
        while (!range.getText().trim().equals("3.5")) { // while my range doesn't equal 3.5...
            Thread.sleep(1000);
            slider.sendKeys(Keys.ARROW_RIGHT);    // .. the arrow must keep moving right
        }
        // TASK
         /*  Navigate to https://text-compare.com/
             Copy "Good Bye Keys" from one box to another
             validate if messages in both boxes are matching
          */
    }

    @Test
    public void GoodByeKeys() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://text-compare.com/");
        driver.manage().window().maximize();


        Actions actions = new Actions(driver);
        WebElement firstBox = driver.findElement(By.xpath("//textarea[@name='text1']"));
        WebElement secondBox = driver.findElement(By.xpath("//textarea[@name='text2']"));
        //     actions.moveToElement(firstBox)
//                .click().keyDown(Keys.SHIFT)
//                .sendKeys("g")
//                .keyUp(Keys.SHIFT)
//                .sendKeys("ood")                MUST BE COMPLETED
    }

    @Test
    public void MoveByOffSetPractice() {
        //TASK
        //By using move by off set and point class.
        //Click Contact Us

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.techtorialacademy.com/");
        WebElement contactUs = driver.findElement(By.xpath("//div[@class='navigation hidden-xs']//a[.='Contact Us']"));
        Point coordinatesOfContactUs = contactUs.getLocation();
        int xCoord = coordinatesOfContactUs.getX();
        int yCoord = coordinatesOfContactUs.getY();
        Actions actions = new Actions(driver);
        actions.moveByOffset(xCoord, yCoord).click().perform();

    }
}

