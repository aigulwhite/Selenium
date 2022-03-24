package RecapSelenium;

public class InterviewQuestions {
    /*
 1) WHAT ARE THE ADVANTAGES AND DISADVANTAGES OF SELENIUM?
        -Advantages- free, supports multiple language(java, python, c++,c#), supports multiple browsers(chrome, safari, etc)
        - Disadvantages- can't automate captcha, pictures, mobile application, no support call, only automates web application.

  2)WHAT TYPE OF TESTING CAN WE AUTOMATE WITH SELENIUM?
        -smoke
        -regression
        -functional test(positive and negative)

  3) WHAT ARE THE TEST TYPES DO NOT AUTOMATE WITH SELENIUM?
        -performance testing
        -manual testing (captcha, pictures)
        -non-functional (performance, stress, load)
        -load testing
        -stress testing.

 4) LOCATOR. ITS TYPES.
        It is a way to find the elements from DOM (development tool/page) and manipulate data.
        -id
        -class name
        -xpath
        -tagName
        -linkedText
        -partialLinked text
        -css

 5) HOW DO WE HANDLE DYNAMIC ELEMENTS?  CVS
        -In my project I faced many dynamic elements. I used many ways to handle them.
        * I used parent-child relationship to locate the elements.
        * I used special element types like following siblings, preceding siblings, contains.

 6) DIFFERENCE BETWEEN
        *driver.navigate.to() -doesn't wait for the webElements(page) to be loaded.
                              -it has some methods(back(), refresh(), forward(), to() )
        *driver.get() -waits for all elements to be loaded.
                      - it does not have any elements.

 7) DIFFERENCE BETWEEN
        *close        - closes the window that we are working currently (where your driver is located)
        *quit         - closes all the windows (all browsers)

 8) WHAT IS XPATH? TYPES OF XPATH. WHICH ONE DO YOU USE IN YOUR JOB?
        * It is the way to find location of the elements on a web page by using html structure.
        * There are 2 types of xpath = Absolute- goes from top to bottom, parent to child step by step
                                     = Relative- it focuses directly on the child.
        * I mostly use relative xpath since it focuses directly on the child. shorter and easier.

 9) DIFFERENCE BETWEEN
       *Absolute xpath  -goes from parent to child
                        - single slash
                        -syntax is different
      * Relative xpath  -goes to child
                        - double slash
                        -syntax is different

 10) HOW DO WE HANDLE (STATIC) DROP-DOWN MENUS?
        - I handle it with different ways.
        - I would chek the tag og the location.
        **If the location has SELECT tag- I use select class--> Select select=new Select(WebElement)
        **If the location has no select tag- I use locators to locate my element (sendKeys())
        - I can also use Action class to hover over my element (moveToElement)

 11) WHAT ARE THE METHODS OF SELECT?
        -Select class is useful for my project. To be able to use select class, element must have select tag.
        I can locate elements with these select methods
        * SelectByVisibleText()
        * SelectByIndex()
        * SelectByValue()

 12) WHAT KIND OF EXCEPTIONS HAVE YOU FACED IN SELENIUM?
        *NoSuchElementException
        *NullPointerException
        *StaleElementExceptions
        *TimeOutException
        *NoSuchFrameException
        *StaleElementReferenceException

 13) MORE ABOUT StaleElementReferenceException.
        - Sometimes I had a hard time handle this type of exception.
        - For instance, when the element is not in the DOM because it was changed or removed
          * In this case, I navigate to another page and come back because element needs a little time to be loaded.
          * I handle this exception either by putting some time to be updated (thread.sleep)
          * or refresh my page.

 14) HOW DO WE HANDLE  ALERTS ?
        - There are different types of alerts I had to handle in my projects sometimes.
         * Operation System Alert: I cannot handle it directly. I need to use robot class.
         * HTML alert : I need to find the element and click/close
         * JavaScript alert: I handle this alert with ALERT class
                Alert alert=driver.switchTo().Alert().

 15) FOR THE ALERT INTERFACE, WHAT KIND OF METHODS DO YOU KNOW?
        - Alert is an interface, however, methods are coming from RemoteAlertClass.
        - We have 4 methods of Alert class:
                     Alert alert = driver. switchTo().Alert()
            1) alert.Accept()- clicks ok button
            2) alert.dismiss()- clicks the cancel
            3) alert.GetText()-gets the text from popups
            4) alert.SendKeys()-sends keys to popups

  16) WHAT DO YOU KNOW ABOUT SELENIUM IFRAME? TYPES YOU USED. HOW DO YOU HANDLE IT?
        - Iframe is html inside another html. The reason people use them is to get extra protection
         for their data like ads and videos.

  16 A) HERE IS THE SCENARIO. GET THE TEXT OF PRICE FROM PRODUCTS. ALL XPATH ARE CORRECT, AND NO PROBLEMS WITH ATTRIBUTES
        AND SWITCHING WINDOW. HOWEVER, WE CAN'T GET THE PRICE OF PRODUCTS. WHAT COULD WE DO?
        -The reason could be the iframe. I would go to the website and check if the html has an iframe by
        typing //iframe or frame. If there is an iframe on the html, I would check the element I am looking for is not
        under the iframe.
        I can deal with IFRAME ELEMENTS by switching my driver: driver.switchTo.frame()
        There are other METHODS of iframe such as :
        driver.switchto.ParentFrame()- takes to the parent frame
        drover.switchto.defaultContent()-takes to main html.

 17) ACTION CLASS.    Actions action=new Action(driver)
        -It is functionality between keyboard and a mouse. It is useful for projects to handle elements .
        -Methods action class have are:
                  == for Mouse
        ** doubleClick()
        ** sendKeys()
        ** ContextClick()
        ** DragAndDrop()
        ** ClickAndHold() and release
        ** moveToElement()   hover over
        ** MoveByOffset(x,y)
        ** perform() Action class won't work without this at the end.
                    == KeyBoard:
        ** Keys.Enter/return
        ** Keys.Arrow-up, arrow down, right, left.



 18) DIFFERENCE BETWEEN:
        ** FindElement()
           - returns the single werElement
           - once it fails it throws noSuchElement exception
        ** FindElements()
           - returns list of webElements
           - once it fails it throws Empty list of array

 19) WHAT ARE THE DRIVER AND WEBELEMENT METHODS?
        ** driver methods
             -get
             -navigate
             -gettitle
             -findElement
             -close
             -quit
             -getPageSource
         ** Webelement methods
             -sendKeys
             click
             -clear
             -submit
             -getAttributes

 20) DIFFERENCE BETWEEN
        ** check-box     --> clicks multiple button
        ** RadioButton   -->we can choose only one.

 21) DIFFERENCE BETWEEN (al of them return boolean)
        ** isDisplayed
                 - displays the element if it is visible or not
        ** isSelected
                 - checks if the element is selected or not ( check marks inside a box)
        ** isEnabled
                 - checks if the element is enabled ot not ( I use it to click the element to make sure it is not disabled)

 22) HOW DO WE SWITCH MULTIPLE WINDOWS?
        - We can use driver.WindowHandle or driver.WindowHandles methods to switch windows and handle
         elements from other websites.
        public static void switchByTitle(WebDriver driver, String title) {
           Set<String> allPages = driver.getWindowHandles();
               for (String id : allPages) {//internet-->new Window
               driver.switchTo().window(id);
               if (driver.getTitle().contains(title)) {
               break;
               }
       }
 23) HOW DO YOU SCROLL DOWN TO THE PAGE FROM WEB BROWSER?
        - I would use JavaScript with ScrollIntoView and Point class.
        Point point=new Point();
        point.getX()-coordination of x
        point.getY()-coordination of y
        MoveByOffset(x,y)

24) HOW DO YOU DOWNLOAD AND UPLOAD FILES ?
        - Find the elements triggers upload window. (choose button)
        - Find the path of the file we want to upload
        - Use driver.findElement(chooseButton).sendKEYS(location of the file)(//C://Users//.usa.png

 25) ASSERT
        ** they have similar logic in term os validation. There are however differences
           - it is a class that has some methods to validate actual and expected data
             with the methods like assert.assertEquals(), assert.assertTrue()
           - when it fails it throws exception and stop the execution
     SOFTASSERT
           - when it fails it does not throw exceptions then it keeps exceuting the next code.
           Softassert softassert=new Softassert();

 26) SINGLETON PATTERN.
        - Whenever I get NullPointer exception, I use singleton pattern design to make my drover safe and reliable.
        ** I need to have private WebDriver
        ** I need to have private construction since I don't want anyone creates an object from this class
        ** I create a public methods to be called by other classes
        ** I use IF condition (if driver==nul) and initialize my driver and return it.

 27) HOW TO PROVIDE PICTURE ONCE YOU FIND THE BUG?
        - One my test fails my system takes screenshot of them and store.

 28) DATAPROVIDER. WHAT DO YOU DO WITH THE SAME TEST WITH DIFFERENT SCENARIO?
        - Dataprovider executes different set of data with the same test.

         @DataProvider(name="test")
         @Test(dataprovider="test) names must match

 29) WAITTIMES
        ** ImplicitWait
              - waits for the specific time while locating the element.
              -when it doesn't find the element in a given time we provide, throws Nosuchelement exception
        ** ExplicitWait
              - waits for the particular webelement until the expected condition specified is met.
              WebDriverWait = new WebDriverWait(Duration.ofSecond(10))
              wait.until.(ExpectedContion.visibilityofelement(Webelement))

 30) WE HAVE DIFFERENT CUSTOMERS FOR THE SPECIFIC WEBSITE LOGIN. I WOULD LIKE YOU TO TEST IF ALL CUSTOMERS'
     LOGIN FUNCTIONALITY IS WORKING OR NOT. HOW WOULD YOU DO THIS?
            - tell about dataprovider and how it works.









     */
}
