package TESTNG;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;     //THIS CLASS IS CONNECTED TO THE "DATAFORNAMES" CLASS ===================

public class DataProviderPractice {

    //    @DataProvider(name = "FullNameTest")                  // Connecting with test which we are working on below.
//    public Object[][] getData(){
//        return new Object[][]{
//                {"ahmet", "baldir", "ahmet baldir"} ,         //this part must match  with test parameters below, line 24
//                {"eric", "eric2", "eric eric2"},
//                {"enes", "enes2", "enes enes2"},
//                {"olivia", "sharapova", "olivia sharapova"},
//                {"george", "sergei", "george sergei"},
//                {"ivan", "ivanova", "ivan ivanova"},
//        };
//    }

    @Test(dataProvider = "FullNameTest", dataProviderClass = DataForNames.class)
    //name information coming from DataForNames class.

    public void test1(String firstname, String lastname, String expectedFullName){
        String username= firstname;
        String lastName= lastname;
        String fullName=username + " " + lastName;
        Assert.assertEquals(fullName, expectedFullName);

   // THIS CLASS SHOULD HAVE ONLY @TEST AND LOOK NEAT. THAT IS WHY WE CREATED "DATAFORNAMES" CLASS AND
        //TRANSFERRED THE INFORMATION ABOVE TO THERE. 

    }
}
