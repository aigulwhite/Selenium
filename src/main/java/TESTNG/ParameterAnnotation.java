package TESTNG;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/* parameter annotation is used to hide things from others. Example, passwords. To be able to provide a parameter
I would like to hide from others, I need to create a parameter.xml file. Those hidden information will be saved in there but
I will be able to run it here, and change if I want to in the future. @Parameters in line 13 is the connection
between the parameter.xml file and this test class. I get my data from xml.file (parameter.xml). Use any name(aigul.xml or cat.xml)
 */

public class ParameterAnnotation {
    @Parameters("FirstName")   // this parameter must match with parameter name in the parameter.xml. Avoid typing, but copy it
    @Test(priority = 1, invocationCount = 10) // it runs 10X
    public void test(String name){
        System.out.println(name);
    }
// BY LOOKING AT MY CODE NO ONE KNOWS WHAT I PROVIDED AS FIRSTNAME, CITY AND STATE. THEY ARE HIDDEN IN MY XML.FILE

    @Parameters({"City", "State"})                   // curly braces if more than one parameter
    @Test(priority = 2, invocationTimeOut = 2000)  // it will wait for 2 sec and fails
    public void test1(String city, String state){
        System.out.println(city);
        System.out.println(state);
    }
}
