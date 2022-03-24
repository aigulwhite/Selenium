package TESTNG;

import org.testng.annotations.*;


public class TestNGAnnotations {

    @BeforeSuite   //you can set up chrome-browser properties(delete cookies)
    public void beforeSuite(){
        System.out.println("before suite");
    }
    @BeforeTest //used to launch browser
    public void beforeTest(){
        System.out.println("before test");
    }

    @BeforeClass// navigate to website
    public void beforeClass(){
        System.out.println("Before Class");
    }

    @BeforeMethod//for logging in page (username/password)
    public void beforeMethod(){
        System.out.println("Before Method");
    }

    @Test
    public void test1(){
        System.out.println("test-1");
    }
    @Test
    public void test2(){
        System.out.println("test-2");
    }
    @AfterMethod //can take screenshot for failed test(driver.quit)
    public void afterMethod(){
        System.out.println("After Method");
    }
    @AfterClass//
    public void afterClass(){
        System.out.println("After Class");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("after test");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("after suite");
    }
}
