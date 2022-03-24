package com.test.orangehrm.tests;

import TESTNG.DataForNames;
import Utils.ConfigReader;
import com.test.orangehrm.TestBase;       // == In Test Class we store METHODS and do ASSERTION ======
import com.test.orangehrm.pages.AdminPage;
import com.test.orangehrm.pages.LoginPage;
import com.test.orangehrm.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AdminTest extends TestBase {

    // Here we need WebDriverManger.chromedriver, but it is coming from the "TestBase"class where we stored

    // to log in, I need to call methods from the "LoginPage"
    // so to call those methods from that class, I create an object above, line17
    @Test
    public void validateTheCreationOfEmployeeMessage() throws InterruptedException {
        LoginPage loginPage=new LoginPage(driver);
        loginPage.login("Admin","admin123");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickAdminButton();
        AdminPage adminPage = new AdminPage(driver);
        adminPage.sendingAllInformationForEmployee();
        Assert.assertTrue(adminPage.ValidationTheEmployeeIsCreated("Mikie123"));
    }

    //================================================================================================

    // info below crated to practice DataProvider class with AdminPage class Line 73-75

//    @DataProvider(name = "UserRoles")                 // this part is put in the DataForNames class keep our Test class neat
//    public Object[][] getUsersRoleData(){
//        return new Object[][]{
//                {"Admin"},
//                {"ESS"}
//        };
//    }

    @Test(dataProvider = "UserRoles",dataProviderClass = DataForNames.class)
    public void ValidateTheSelectRoleFunctions(String roleName){

        LoginPage loginPage=new LoginPage(driver);  // = we logged in
        loginPage.login(ConfigReader.readProperty("orangehrmusername"),ConfigReader.readProperty("orangehrmpassword"));

        MainPage mainPage=new MainPage(driver);
        mainPage.clickAdminButton();                        // we clicked on "Admin" button on the main page

        AdminPage adminPage=new AdminPage(driver);
        adminPage.SelectUserRole(roleName,driver);         //choose Admin here.. // choose ESS
        Assert.assertTrue(adminPage.validateRoleText(roleName)); //.. and validate Admin // and validate ESS

    }

    // since those two @Test are almost following the same steps except 1(ESS & Admin) will can create
    //... DataProvider to avoid repeating.
    // Also, to make them dynamic, We commented out the last @Test
    // added parameter, line 31,change Admin to-roleName(51-52)



//    @Test
//    public void ValidateTheSelectRoleFunctions2(){
//
//        LoginPage loginPage=new LoginPage(driver);
//        loginPage.login(ConfigReader.readProperty("orangehrmusername"),ConfigReader.readProperty("orangehrmpassword"));
//
//        MainPage mainPage=new MainPage(driver);
//        mainPage.clickAdminButton();
//
//        AdminPage adminPage=new AdminPage(driver);
//        adminPage.SelectUserRole("ESS",driver);
//        Assert.assertTrue(adminPage.validateRoleText("ESS"));  // we made it to fail for the negative test.
//    }

    // to see the passed pages go to "DriverHelper" under "Utils" and comment out "quit" "null" !!!!!





}

