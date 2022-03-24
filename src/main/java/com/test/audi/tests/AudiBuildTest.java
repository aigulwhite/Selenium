package com.test.audi.tests;

import com.test.audi.AudiTestBase;
import com.test.audi.pages.AudiBuildPage;
import com.test.audi.pages.AudiMainPage;
import com.test.audi.pages.AudiQ5Page;
import org.testng.annotations.Test;

public class AudiBuildTest extends AudiTestBase {

    @Test

    public void ValidateStartingPrice() throws InterruptedException {

        AudiMainPage audiMainPage=new AudiMainPage(driver);
        audiMainPage.clickQ5();

        AudiQ5Page audiQ5Page=new AudiQ5Page(driver);
        audiQ5Page.clickBuildButton();

        AudiBuildPage audiBuildPage=new AudiBuildPage(driver);
        audiBuildPage.validatingStartingPrices();


    }

}
