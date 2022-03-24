package TESTNG;

import org.testng.annotations.DataProvider;  // THIS IS CONNECTED TO "DATAPROVIDERPRACTICE"  ===============

public class DataForNames {
    @DataProvider(name = "FullNameTest")
    public Object[][] getData(){
        return new Object[][]{
                {"ahmet", "baldir", "ahmet baldir"} ,
                {"eric", "eric2", "eric eric2"},
                {"enes", "enes2", "enes enes2"},
                {"olivia", "sharapova", "olivia sharapova"},
                {"george", "sergei", "george sergei"},
                {"ivan", "ivanova", "ivan ivanova"},
        };


    }
    @DataProvider(name = "UserRoles")                 // look at AdminTest to understand this part
    public Object[][] getUsersRoleData(){
        return new Object[][]{
                {"Admin"},
                {"ESS"}
        };
    }
}
