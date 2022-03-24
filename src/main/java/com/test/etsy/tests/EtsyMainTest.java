package com.test.etsy.tests;

import com.beust.jcommander.Parameter;
import com.test.etsy.pages.EtsyMainPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class EtsyMainTest extends EtsyTestBase{
    @Parameters("itemSearch")
    @Test
public void EtsySearchTest(String item){

        EtsyMainPage mainPage=new EtsyMainPage(driver);
      //  mainPage.searchItem("iphone 13 case");           this is the regular way,to call it not from here but to call it..
         mainPage.searchItem(item);                        //.. from the parameter, we need to create @Parameter, line 7
                                                           // .. add parameter "String item" in line 11, and do line 15
        Assert.assertTrue(mainPage.validateHeader());
    }

}
