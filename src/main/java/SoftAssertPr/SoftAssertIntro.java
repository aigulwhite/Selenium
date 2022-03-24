package SoftAssertPr;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertIntro {

    public int getSum(int num1, int num2){
        return num1+num2;
    }

@Test
    public void test(){

        Assert.assertEquals(getSum(2,6),8);       //HARD ASSERT
    System.out.println("test1");
    Assert.assertEquals(getSum(0,0),1); //it fails here, so we won't see the results for next lines
    System.out.println("test2");                // output: test1     test2, test3 won't show up
    Assert.assertEquals(getSum(-6,-7),-13);
    System.out.println("test3");

    }
@Test
        public void test2(){

        SoftAssert softAssert=new SoftAssert();          //SOFT ASSERT
        softAssert.assertEquals(getSum(2,6),8);
        System.out.println("test1");
        softAssert.assertEquals(getSum(0,0),1); //it fails here, but it will keep running the next lines
    System.out.println("test2");                        // output: test1, test2, test3
    softAssert.assertEquals(getSum(-6,-7),-13);
    System.out.println("test3");

    softAssert.assertAll();     // without this all test will run even though there are some that might fail.




    }
        }