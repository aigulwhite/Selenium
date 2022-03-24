package com.test.audi.tests;

import com.test.audi.AudiTestBase;
import com.test.audi.pages.AudiMainPage;
import com.test.audi.pages.AudiQ5Page;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AudiMainTest extends AudiTestBase {
    @Test
    public void validateYear() throws InterruptedException {

        AudiMainPage audiMainPage=new AudiMainPage(driver);
        Assert.assertEquals(audiMainPage.getTextQ5(),"2022 Audi Q5");
    }
}
