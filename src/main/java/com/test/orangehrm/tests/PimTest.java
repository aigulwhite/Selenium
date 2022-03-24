package com.test.orangehrm.tests;

import com.test.orangehrm.TestBase;
import com.test.orangehrm.pages.LoginPage;
import com.test.orangehrm.pages.MainPage;
import com.test.orangehrm.pages.PimPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PimTest extends TestBase {
    LoginPage loginPage;
    MainPage mainPage;
    PimPage pimPage;

    @BeforeMethod
    public void initializingPages(){
       loginPage=new LoginPage(driver);  //These came from the lines:26,29,32
       mainPage=new MainPage(driver);    //.. then separated to the top lines 12,13,14
       pimPage=new PimPage(driver);
    }

    @Test
    public void ValidateTheCreationOfEmployee() throws InterruptedException {

       // LoginPage loginPage=new LoginPage(driver);                 // I created this because first we need to log in
        loginPage.login("Admin","admin123");        // to get to the main page

       // MainPage mainPage=new MainPage(driver);   // now I am on the main page where PIM category is
        mainPage.clickPimButton();

       // PimPage pimPage=new PimPage(driver);
        pimPage.addEmployeeForPIM("ahmet","Baldird","1991","C:\\Users\\alena\\OneDrive\\Desktop\\flag.png");
        Assert.assertEquals(pimPage.validateFirstName(),"ahmet");
        Assert.assertEquals(pimPage.validateLastName(),"Baldird");
        Thread.sleep(1000);
        Assert.assertTrue(pimPage.validateEmployeeId("1991"));

    }
     @Test
    public void ValidatePersonalDetailElements() throws InterruptedException {

        loginPage.login("Admin", "admin123");
        mainPage.clickAdminButton();
        pimPage.addEmployeeForPIM("ahmet","Baldird","1991","C:\\Users\\alena\\OneDrive\\Desktop\\flag.png");
        pimPage.editPersonalDetails("Turkish","1991-08-13","Single");
        Assert.assertEquals(pimPage.validateTheNationality(),"Turkish");



     }
}
